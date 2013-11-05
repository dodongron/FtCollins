package mvsp.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.tigr.mvapi.MVConnection;
import com.tigr.mvapi.MVStatement;
import com.tigr.mvapi.ResultSet.MVResultSet;
import com.tigr.mvapi.exceptions.MVException;

import ft.appointment.Appointment;
import ft.patient.Patient;
import ft.providers.Clinics;
import ft.providers.Doctors;
import ft.util.DateType;
import ft.util.group.doctor;

public class MVBase extends ActionSupport {
	private static MVConnection _mvConnection;

	public static void main(String[] args) {
		System.out.println("=================== LOGIN ");
		String log = LOGIN("1129");
		System.out.println(log);
		System.out.println();
		// ////
		Patient patient = ENTER_PORTAL("1129", "WILLIAM", "MITCHELL",
				"2/17/69", "3173");
		System.out.println(patient.getPatient_id() + " id");
		System.out.println(patient.getFirst_name());
		System.out.println(patient.getLast_name());
		System.out.println(patient.getBirth_date());
		System.out.println(patient.getPassphrase());
		System.out.println(patient.getSession_id());
		System.out.println();
		// //
		System.out.println("=================== PROVIDERS ");
		List<Doctors> providers = GET_PROVIDERS("1129");
		for (Doctors doc : providers) {
			System.out.println(doc.getClinic_id() + " " + doc.getClinic_name()
					+ " " + doc.getDoctor_id() + " " + doc.getDoctor_name());
		}
		System.out.println();
		//

		System.out.println("=================== GETAPPOINTMENTS ");
		List<Appointment> appointment = GET_APPOINTMENTS("1129", "1");
		for (Appointment app : appointment) {
			System.out.println(app.getDate());
		}

		System.out.println();
		System.out.println("=================== SETAPPOINTMENT ");
		String set_app = SETAPPOINTMENT("ABC", "1", "11/11/13", "8:30", "1129");
		System.out.println(set_app);
	}

	public static void main2(String[] args) {

		System.out.println("=================== LOGIN ");
		String log = LOGIN("1129");
		System.out.println(log);
		System.out.println();

		System.out.println(exec_query(""));

	}

	public static boolean mvspConnect() {
		boolean connected = false;
		String user = "PORTAL";
		String pwd = "ZOOPZOOP9";
		String host = "72.54.227.125";
		String port = "2020";
		try {
			_mvConnection = new MVConnection(host, Integer.parseInt(port),
					user, pwd);
			connected = true;
			return connected;
		} catch (MVException e) {
			connected = false;
			return connected;
		}
	}

	private static String exec_query(String query) {
		query = "PTPORTAL GETPROVIDERS 1129";
		String htmlString = "";
		if (mvspConnect()) {
			try {
				MVStatement mvStatement = _mvConnection.createStatement();
				MVResultSet mvResults = mvStatement.executeQuery(query);
				while (mvResults.next()) {
					String myRow = mvResults.getCurrentRow();
					htmlString += myRow + "\n";
				}
				System.out.println(htmlString + " asdasd");
				_mvConnection.close();
			} catch (MVException e) {
				throw new RuntimeException(e);
			}
		}
		return htmlString;
	}

	public static String LOGIN(String session_id) {

		String query = "PTPORTAL LOGIN " + session_id;
		String htmlString = "DISCONNECTED";
		if (mvspConnect()) {
			try {
				try {
					_mvConnection.setHoldability(100000);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				MVStatement mvStatement = _mvConnection.createStatement();
				MVResultSet mvResults = mvStatement.executeQuery(query);
				while (mvResults.next()) {
					htmlString = "CONNECTED";
					// String myRow = mvResults.getCurrentRow();
					// htmlString += myRow + "\n";
				}
				System.out.println(htmlString);
				if (!htmlString.startsWith("B10")) {

				}
				_mvConnection.close();

			} catch (MVException e) {
				throw new RuntimeException(e);
			}
		}
		return htmlString;
	}

	public static Patient ENTER_PORTAL(String session_id, String first_name,
			String last_name, String bday, String passphrase) {
		Patient p = new Patient("", first_name, last_name, bday, passphrase,
				session_id);
		String htmlString = "";
		String query = "PTPORTAL ENTERPORTAL " + session_id + " " + first_name
				+ " " + last_name + " " + bday + " " + passphrase;
		System.out.println(query);
		if (mvspConnect()) {
			try {
				MVStatement mvStatement = _mvConnection.createStatement();
				MVResultSet mvResults = mvStatement.executeQuery(query);
				while (mvResults.next()) {
					String myRow = mvResults.getCurrentRow();
					htmlString += myRow + "\n";
				}
				System.out.println(htmlString);
				// if(!htmlString.startsWith("B10")){
				// String strjson = htmlString;
				// JSONObject json_data;
				// try {
				// json_data = new JSONObject(strjson);
				// String patient_id = ""
				// + json_data.getJSONObject("result").get(
				// "patient_id");
				// p.setPatient_id(patient_id);
				// } catch (JSONException e) {
				// e.printStackTrace();
				// }
				// }

				_mvConnection.close();
			} catch (MVException e) {
				throw new RuntimeException(e);
			}
		}
		return p;
	}

	public static List<Appointment> SHOW_APPOINTMENTS(String session_ids,
			String patient_id) {
		List<Appointment> datas = new ArrayList<Appointment>();

		String htmlString = "";
		String query = "PTPORTAL SHOWAPPOINTMENTS " + patient_id + " "
				+ session_ids;
		if (mvspConnect()) {
			try {
				MVStatement mvStatement = _mvConnection.createStatement();
				MVResultSet mvResults = mvStatement.executeQuery(query);
				while (mvResults.next()) {
					String myRow = mvResults.getCurrentRow();
					htmlString += myRow + "\n";
				}
				if (!htmlString.startsWith("B10")) {
					String strjson = htmlString;
					JSONObject json_data;

					try {
						json_data = new JSONObject(strjson);
						try {
							List<JSONObject> list = getNodeJsonObjects(
									"result", json_data);
							for (JSONObject obj : list) {
								int id = 0;
								String session_id = session_ids;
								Date d = DateType.slash.parse(obj.get(
										"date_time").toString());
								String date = DateType.w_day.format(d);
								String time = DateType.time_am_pm.format(d);
								String clinic_id = "";
								String clinic_name = "";
								String doctor_id = "";
								String doctor_name = "";
								Appointment app = new Appointment(id,
										session_id, date, time, clinic_id,
										clinic_name, doctor_id, doctor_name);
								datas.add(app);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}

				_mvConnection.close();
			} catch (MVException e) {
				throw new RuntimeException(e);
			}
		}
		return datas;
	}

	public static List<Appointment> GET_APPOINTMENTS(String patient_id,
			String session_ids) {

		List<Appointment> datas = new ArrayList<Appointment>();

		String htmlString = "";
		String query = "PTPORTAL GETAPPOINTMENTS " + patient_id + " "
				+ session_ids;
		if (mvspConnect()) {
			try {
				MVStatement mvStatement = _mvConnection.createStatement();
				MVResultSet mvResults = mvStatement.executeQuery(query);
				while (mvResults.next()) {
					String myRow = mvResults.getCurrentRow();
					htmlString += myRow + "\n";
				}
				System_Variables.Appointments.setJson_datetime(htmlString);
				String strjson = htmlString;
				if (!htmlString.startsWith("B10")) {

					JSONObject json_data;
					try {
						json_data = new JSONObject(strjson);
						try {
							List<JSONObject> list = getNodeJsonObjects(
									"result", json_data);
							for (JSONObject obj : list) {
								int id = 0;
								String session_id = session_ids;
								Date d = DateType.slash.parse(obj.get(
										"date_time").toString());
								String date = DateType.w_day2.format(d);
								String time = DateType.time_am_pm.format(d);
								String clinic_id = "";
								String clinic_name = "";
								String doctor_id = "";
								String doctor_name = "";
								Appointment app = new Appointment(id,
										session_id, date, time, clinic_id,
										clinic_name, doctor_id, doctor_name);
								datas.add(app);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}

				_mvConnection.close();
			} catch (MVException e) {
				throw new RuntimeException(e);
			}
		}
		return datas;
	}

	public static List<Clinics> clinic_list = new ArrayList<Clinics>();

	public static List<Clinics> GET_CLINICS() {
		return clinic_list;
	}

	public static List<Doctors> GET_PROVIDERS(String session_ids) {
		clinic_list.clear();
		List<Doctors> datas = new ArrayList<Doctors>();
		String htmlString = "";
		String query = "PTPORTAL GETPROVIDERS " + session_ids;
		if (mvspConnect()) {
			try {
				MVStatement mvStatement = _mvConnection.createStatement();
				MVResultSet mvResults = mvStatement.executeQuery(query);
				while (mvResults.next()) {
					String myRow = mvResults.getCurrentRow();
					htmlString += myRow + "\n";
				}
				System.out.println(htmlString);
				if (!htmlString.startsWith("B10")) {
					String strjson = htmlString;
					JSONObject json_data;
					try {
						json_data = new JSONObject(strjson);
						try {
							List<JSONObject> list = getNodeJsonObjects(
									"result", json_data);
							for (JSONObject obj : list) {
								// obj.get("date_time").toString()
								String doctor_id = obj.get("doctor_id")
										.toString();
								String doctor_name = obj.get("doctor_name")
										.toString();
								String clinic_id = obj.get("clinic_id")
										.toString();
								String clinic_name = obj.get("clinic_name")
										.toString();
								Doctors app = new Doctors(doctor_id,
										doctor_name, clinic_id, clinic_name);

								datas.add(app);
							}

							List<Clinics> new_list = new ArrayList<Clinics>();
							int i = 0;
							for (Doctors d : datas) {
								if (i == 0) {

									Clinics cl = new Clinics(d.getClinic_id(),
											d.getClinic_name());
									clinic_list.add(cl);
								} else {
									Iterator<Clinics> itr = new_list.iterator();
									int exists = 0;
									while (itr.hasNext()) {
										Clinics doc = itr.next();
										if (d.getClinic_id().equals(
												doc.getClinic_id())) {
											exists = 1;
											break;
										}
									}
									if (exists == 0) {
										Clinics cl = new Clinics(
												d.getClinic_id(),
												d.getClinic_name());
										clinic_list.add(cl);
									}
								}

								i++;
							}

						} catch (Exception e) {

							e.printStackTrace();
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}

				_mvConnection.close();
			} catch (MVException e) {
				throw new RuntimeException(e);
			}
		}
		return datas;
	}

	private static List<JSONObject> getNodeJsonObjects(String node,
			JSONObject parentObject) throws Exception {
		List<JSONObject> nodeJsonObjects = new ArrayList<JSONObject>();
		Object object = parentObject.get(node);
		if (object instanceof JSONObject)
			nodeJsonObjects.add((JSONObject) object);
		else {
			JSONArray jsonArray = (JSONArray) object;
			for (int i = 0; i < jsonArray.length(); i++) {
				nodeJsonObjects.add((JSONObject) jsonArray.get(i));
			}
		}
		return nodeJsonObjects;
	}

	public static String SETAPPOINTMENT(String user_id, String doctor_id,
			String date, String time, String session_id) {

		String htmlString = "";
		String message = "";
		String query = "PTPORTAL SETAPPOINTMENT " + user_id + " " + doctor_id
				+ " " + date + " " + time + " " + session_id;
		if (mvspConnect()) {
			try {
				MVStatement mvStatement = _mvConnection.createStatement();
				MVResultSet mvResults = mvStatement.executeQuery(query);
				while (mvResults.next()) {
					String myRow = mvResults.getCurrentRow();
					htmlString += myRow + "\n";
				}
				if (!htmlString.startsWith("B10")) {
					String strjson = htmlString;
					JSONObject json_data;
					try {
						json_data = new JSONObject(strjson);
						message = ""
								+ json_data.getJSONObject("result").get(
										"message");
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}

				_mvConnection.close();
			} catch (MVException e) {
				throw new RuntimeException(e);
			}
		}
		return message;
	}
}
