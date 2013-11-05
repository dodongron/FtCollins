package ft.appointment;

import java.util.Calendar;
import java.util.Date;

import mvsp.api.MVBase;
import mvsp.api.System_Variables;

import com.opensymphony.xwork2.ActionSupport;

import ft.patient.Patient;
import ft.patient.PatientAction;
import ft.util.DateType;

public class SetAppointmentAction extends ActionSupport {

	private String date_time;
	private String date;
	private String time;
	private String message;

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String execute() throws Exception {
		Patient p=PatientAction.patientobj;
		String user_id = p.getPatient_id();
		String doctor_id =System_Variables.Appointments.getDoctor_id();	
		Date cal = DateType.MMMMM_dd_yy_time.parse(getDate_time());	
		String date = DateType.MM_dd_yy.format(cal);//DateType.sf.format(cal);
		setDate(date);
		String time =DateType.time1.format(cal);
		setTime(time);
		String session_id = p.getSession_id();
		String msg = MVBase.SETAPPOINTMENT(user_id,doctor_id, date, time, session_id);
		setMessage(msg);
		return SUCCESS;
	}
}
