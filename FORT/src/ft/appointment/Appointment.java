package ft.appointment;

import java.util.ArrayList;
import java.util.List;

import mvsp.api.MVBase;

public  class Appointment {
	private  int id;
	private  String session_id;
	private  String date;
	private  String time;
	private  String clinic_id;
	private  String clinic_name;
	private  String doctor_id;
	private  String doctor_name;

	public Appointment() {
		super();
	}

	public  Appointment(int id, String session_id, String date, String time,
			String clinic_id, String clinic_name, String doctor_id,
			String doctor_name) {
		super();
		this.id = id;
		this.session_id = session_id;
		this.date = date;
		this.time = time;
		this.clinic_id = clinic_id;
		this.clinic_name = clinic_name;
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public  String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public  String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public  String getClinic_id() {
		return clinic_id;
	}

	public void setClinic_id(String clinic_id) {
		this.clinic_id = clinic_id;
	}

	public  String getClinic_name() {
		return clinic_name;
	}

	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}

	public  String getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}

	public  String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public static List<Appointment> get_patientAppointments(String patient_id,
			String session_ids) {
		List<Appointment> datas = MVBase.GET_APPOINTMENTS(patient_id, session_ids);
		return datas;
	}
}
