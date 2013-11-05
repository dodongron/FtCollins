package test.src;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

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
				
		Patient p = getPatientobj();
		if(p.getFirst_name().isEmpty() || p.getLast_name().isEmpty() || p.getBirth_date().isEmpty() || p.getPassphrase().isEmpty()){
			addActionMessage("Fill Up empty Field");
//			addFieldError("patientobj.first_name", getText("patientobj.first_name.required")); 
			return INPUT;
		}
		p.setPatient_id("111");
		p.setSession_id(session.getId());
		
		return SUCCESS;
	}
	

}
