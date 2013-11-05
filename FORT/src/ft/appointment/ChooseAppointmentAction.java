package ft.appointment;

import mvsp.api.System_Variables;

import com.opensymphony.xwork2.ActionSupport;

public class ChooseAppointmentAction extends ActionSupport {

	private String clinic_id;
	private String clinic_name;
	private String doctor_id;
	private String doctor_name;
	private String json_datetime;
	
	public String getClinic_id() {
		return clinic_id;
	}

	public void setClinic_id(String clinic_id) {
		this.clinic_id = clinic_id;
	}

	public String getClinic_name() {
		return clinic_name;
	}

	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}

	public String getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getJson_datetime() {
		return json_datetime;
	}
	public void setJson_datetime(String json_datetime) {
		this.json_datetime = json_datetime;
	}

	@Override
	public String execute() throws Exception {
		
		// TODO Auto-generated method stub
		System_Variables.Appointments.setDoctor_id(getDoctor_id());
		
		return SUCCESS;
	}

}
