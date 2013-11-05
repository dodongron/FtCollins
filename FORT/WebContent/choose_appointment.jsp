<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page import="ft.patient.PatientAction"%>
<%@ page import="ft.patient.Patient"%>
<%@ page import="ft.appointment.Appointment"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="ft.util.MyCalendar"%>
<%@ page import="ft.util.DateType"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href='css/main.css' />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SET APPOINTMENT</title>
</head>
<body>
	<% 
	Patient p=PatientAction.patientobj;	
	%>	
	<s:label value="Patient Id: "/><%=p.getPatient_id() %><br>
	<s:label value="First Name: "/><%=p.getFirst_name() %><br>
	<s:label value="last Name : "/><%=p.getLast_name() %><br>
	<s:label value="Birth Date: "/><%=p.getBirth_date() %><br>
	<s:label value="Passphrase: "/><%=p.getPassphrase() %><br>
	
	<s:label value="Clinic Id: "/><s:property value="clinic_name"/><br>
	<s:label value="Doctor Id: "/><s:property value="doctor_name"/>
	<s:form action="setAppointment" namespace="/" method="post" name="myForm"
					theme="xhtml" class="box" >	
		<TABLE BORDER=3 CELLSPACING=3 CELLPADDING=3>		
		</TABLE>
		<div>
   			 <div style="width:360px;float:left;display:inline-block;">
   			 	<TABLE BORDER=3 CELLSPACING=3 CELLPADDING=3 width=400 height=320px>
   			 		<TR>
			<TD COLSPAN="7" ALIGN=center><B>Appointments</B></TD>
		</TR>
		<TR>
			<TD COLSPAN="7" ALIGN=left>			      
			       <% List<String> months = DateType.monthNames();
			       String monthNow=DateType.m.format(new Date());
			       %>
			       Month: <select name="dateMonth" id="cbDoctorTime" STYLE="width: 150px">  
			         <% for(String s:months){%>			        	
			        	 <% if(s.equalsIgnoreCase(monthNow)){%>
			        	  <option value="<%=s%>" selected><%=s%></option>
			        	 <% }else{%>
			        	  <option value="<%=s%>"><%=s%></option>
			        	 <%}%>
			         <% }%>
			       </select>
			       
			        <% List<String> years = DateType.years();%>
			      Year: <select name="dateYear" id="cbYears" STYLE="width: 100px">  
			         <% for(String s:years){%>
			        	 <option value="<%=s%>"><%=s%></option>
			         <% }%>
			       </select>			       
			</TD>
		</TR>
		<TR>
			<TD ALIGN=center>Sun</TD>
			<TD ALIGN=center>Mon</TD>
			<TD ALIGN=center>Tue</TD>
			<TD ALIGN=center>Wed</TD>
			<TD ALIGN=center>Thu</TD>
			<TD ALIGN=center>Fri</TD>
			<TD ALIGN=center>Sat</TD>
		</TR>
		
		<%		
		String month="October";//DateType.m.format(new Date());
		String year=DateType.y.format(new Date());
		List<MyCalendar.days_of_month> datas = MyCalendar.list(month,year); 
			String dayNow=DateType.d.format(new Date());
			dayNow=MyCalendar.twoDigit(Integer.parseInt(dayNow));			
		%>
		<% int i = 0;%>
		<TR height=20 width=100>	
		<% for (MyCalendar.days_of_month dm : datas) {
		%>
		<%	if (i == 7 || i == 14 || i == 21 || i == 28 || i == 35 || i == 42) {%>
			<tr></tr>
		<%	} 	i++; %>
		<TD ALIGN=center height=20 ><%=dm.day%>
		<% if(dm.day.equalsIgnoreCase("")||dm.day.equals("   ")){			
			}else{ %>									
						<% if(dm.day.equals("  "+dayNow)){  %>							 						
			        	  <INPUT TYPE="radio" NAME="date" id="cbDay" value=<%=dm.day%> checked> 			        	 
			        	 <% }else{%>	
			        	 		<% if(dm.day.equals("  ")||dm.day.isEmpty()){  %>							 									        	 			        	 
			        			 <% }else{%>				        	 		        	
			        	 		 <INPUT TYPE="radio" NAME="date" id="cbDay" value=<%=dm.day%> > 
			        			 <%}%>        				        	  
			        	 <%}%>		
			<%}%>			
		<%  }%></TD>								
		</TR>				
   			 	</TABLE>     		
   		   </div>
   		   <div id="time_list">
      			<TABLE BORDER=3 CELLSPACING=3 CELLPADDING=3 width=200 height=320>
      			<th>TIME</th>		
   			 	<tr align=center>    
   			 		 	
   			 	<% 
   			 	String doctor_id=request.getParameter("doctor");
   			 	String date_of_appointment=DateType.sf.format(new Date());
   			 	List<Appointment> timeList = Appointment.get_patientAppointments("", ""); %>
   			 	<td>
   			 	<label style="align:center">TIME</label> <br> 	
   			 	<% 
   			 	int start=0;
   			 	for(Appointment tdts:timeList){   			 
   			 	%> 			 	  			 	   			 	
   				 
   				 <% if(start==0){%>
   				 <label style="width:250px"><%= tdts.getTime() +"----------"%></label>     
   			     <INPUT TYPE="radio" NAME="time" id="cbDay" value=<%=tdts.getTime()%> CHECKED><br>
   				<% }else{%>
   				 <label style="width:250px"><%= tdts.getTime() +"----------"%></label>     
			 	 <INPUT TYPE="radio" NAME="time" id="cbDay" value=<%=tdts.getTime()%> ><br>	
   			 	<%} start++;}%> 		   			 	
   			 	</td>
   			 	</tr>
   			 	</TABLE>
   		    </div>
   		     <div style="margin-left:0px;">
      			<TABLE BORDER=3  width=600 height=50>
   			 		<TR align=center >
   			 		<td style="width:390px">
					</td>	
			   		  <td><button STYLE="width: 120px ">SAVE</button> </td>			     	       
					</TR>
   			 	</TABLE>
   		    </div>
		</div>		
					
	</s:form>	
</body>
</html>