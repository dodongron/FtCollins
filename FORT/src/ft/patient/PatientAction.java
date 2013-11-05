package ft.patient;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mvsp.api.MVBase;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ft.util.DateType;

public class PatientAction extends ActionSupport {
	
	public static Patient patientobj;	
	public Patient getPatientobj() {
		return patientobj;
	}
	public void setPatientobj(Patient patientobj) {
		PatientAction.patientobj = patientobj;
	}

	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpServletResponse response = ServletActionContext.getResponse();
		request.getSession().invalidate();
		HttpSession session = request.getSession(true);
		session.setAttribute("AUTHENTICATED", new Boolean(true));	
		
		String session_id=request.getSession().getId();
			
		Patient p = getPatientobj();					
		if(p.getFirst_name().isEmpty() || p.getLast_name().isEmpty() || p.getMonth().isEmpty() || p.getPassphrase().isEmpty()
				|| p.getYear().isEmpty()){
			addActionMessage("Fill Up empty Field");
			return INPUT;
		}		
		MVBase.LOGIN(session_id); // LOGIN
	    String first_name=p.getFirst_name().toUpperCase();
		String last_name= p.getLast_name().toUpperCase();
		Date d=DateType.month_date.parse(p.getMonth()+" "+p.getDay()+", "+p.getYear());
		String bday=DateType.MM_dd_yy.format(d);
		String passphrase=p.getPassphrase();			
		Patient patient = MVBase.ENTER_PORTAL(session_id, first_name, last_name,bday, passphrase); //ENTER PORTAL
		String patient_id=patient.getPatient_id();
		System.out.println(patient_id+ " patient_id");
		if(patient_id.isEmpty() ||patient.getPatient_id().equals("") ){
			addActionMessage("PATIENT NOT REGISTERED");
			return INPUT;
		}
		p.setBirth_date(bday);
		p.setSession_id(session_id);
		p.setPatient_id(patient_id);
		
		
		return SUCCESS;
	}
	
}
