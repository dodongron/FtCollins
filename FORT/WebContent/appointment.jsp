<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page import="ft.patient.PatientAction"%>
<%@ page import="ft.patient.Patient"%>
<%@ page import="ft.providers.Clinics"%>
<%@ page import="ft.providers.Doctors"%>
<%@ page import="mvsp.api.MVBase"%>
<%@ page import="ft.appointment.Appointment"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href='css/main.css' />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>APPOINTMENT</title>

</head>
<body>
	<%
		Patient p = PatientAction.patientobj;
	%>
	
	<s:label value="Patient Id: " /><%=p.getPatient_id()%><br>
	<s:label value="First Name: " /><%=p.getFirst_name()%><br>
	<s:label value="last Name : " /><%=p.getLast_name()%><br>
	<s:label value="Birth Date: " /><%=p.getBirth_date()%><br>
	<br>
	<table border=1 style="width: 725px;  valign:left;">
	<tr><th align="center">APPOINTMENTS</th></tr>
	</table>
	
	<table border=1 style="width: 725px;  valign:left;">
	<tr>
	<th style="width:200px;">DATE/TIME</th>
	<th style="width:150px;">CLINIC</th>
	<th style="width:160px;">DOCTOR</th>	
	<th  style="width:80px;">ACTION</th>
	<th  style="width:6px; border:1px solid white;"></th>		
	</tr>
	</table>
	
	<div id="div_Appointments">	
	<table border=1 style="width: 725px;  valign:left;" >	
		
	<%
	String session_ids=p.getSession_id();
	String patient_id=p.getPatient_id();
	List<Appointment> appointment=MVBase.SHOW_APPOINTMENTS(session_ids,patient_id);
	
	for(Appointment app:appointment ){	
	%>
		<tr>
		<td style="width:200px;"><%=app.getDate() %> <%=app.getTime() %></td>	
		<td style="width:150px;"><%=app.getClinic_name() %></td>	  
		<td style="width:150px;"><%=app.getDoctor_name() %></td>   
		<td style="width:90px;" align='center'><input type=submit value="x" ></td>		
		</tr>
	<%} %>
	</table>
	</div>
	<div id="providers">
		<div id="column1">
		<s:form action="chooseAppointment" namespace="/" method="post" name="myForm"
		theme="xhtml" class="box">			
		PROVIDERS		
		<table BORDER=0  width=720px height=30 id="tblMessages">
					<colgroup>
      			 		 <col span="1" style="width:50%;">
      					 <col span="2" style="width: 50%;">
   		 			</colgroup> 
   		 			
   		 			<tr>			
   		 				<th>Clinic:</th>
   		 				<td>	  		 					
							<%
							List<Doctors> doctors = MVBase.GET_PROVIDERS(session_ids);
							List<Clinics> clinics = MVBase.GET_CLINICS();%>	
							<select name="clinic_name" id="slcClinic" style="width:240px">
							<%for (Clinics t : clinics) {%>		
							<option value="<%=t.getClinic_id()%>">
							<%=t.getClinic_name()%>
							</option>
							<%}%>					
							</select>	
   		 					</td>   		 					
   		 					<th>Doctor: </th>
   		 				<td>	 								
								
							 <select name="doctor_name" id="slcDoctor" style="width:240px">
							<%for (Doctors d : doctors) {%>						
							<option value="<%=d.getDoctor_id()%>" clinic_id="<%=d.getClinic_id()%>">
							<%=d.getDoctor_name()%>
							</option>
							<%}%>						
							</select> <br> 
   		 				</td>
   		 				<td>
   		 				<input type="submit" name="btnChooseAppointment"
						value="Choose Provider" >	
   		 				</td>
   		 				</tr>   		 				 		 			
					</table>
		</s:form>
		</div>
	</div>
	
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>		
	<script type="text/javascript">
		jQuery(function($) {
			$("#slcClinic").change(
					function() {
						var clinic_id = $(this).val();						
						var doctor_id;
						$("#slcDoctor").find("option").each(function() {
							if ($(this).attr("clinic_id") == clinic_id) {
								$(this).show();
								doctor_id = $(this).val();
							} else {
								$(this).hide();
							}
						})
						$("#slcDoctor").val(doctor_id);
					});
			$("#slcClinic").change();
		});
	</script>
	

</body>
</html>