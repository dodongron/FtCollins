package ft.calendar;

import java.util.ArrayList;
import java.util.List;

import mvsp.api.MVBase;
import mvsp.api.System_Variables;

import com.opensymphony.xwork2.ActionSupport;

import ft.appointment.Appointment;

public class Calendar extends ActionSupport{

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
		List<Appointment> datas = MVBase.GET_APPOINTMENTS("1", "1129");
		
		String json=System_Variables.Appointments.getJson_datetime();
		json.replace("\n{\ntitle", "{\ntitle");
		System.out.println("START");
		System.out.println(json);
		System.out.println("END");
//		setJson_datetime(json);
		// TODO Auto-generated method stub
		List<String> str=new ArrayList();
		
		
		
		return SUCCESS;
	}
}
