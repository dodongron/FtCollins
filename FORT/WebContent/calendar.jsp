<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="mvsp.api.System_Variables"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='css/cupertino/jquery-ui.min.css' />
<link href='fullcalendar/fullcalendar.css' rel='stylesheet' />
<link href='fullcalendar/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='lib/jquery.min.js'></script>
<script src='lib/jquery-ui.custom.min.js'></script>
<script src='fullcalendar/fullcalendar.min.js'></script>
<script src='fullcalendar/date.js'></script>
<%@ taglib prefix="s" uri="/struts-tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHOOSE APPOINTMENT</title>
<script>
	$(document).ready(function() {
		var response = <%=System_Variables.Appointments.getJson_datetime()%>;
		var events_array = new Array();
		for(var i = 0; i < response.result.length; i++){
			
			var response_event = response.result[i];

			var event_item = new Object();
			event_item.start = Date.parse($.trim(response_event.date_time));
			event_item.date_time = response_event.date_time;

			var minutes = event_item.start.getMinutes();
			if(minutes == 0) { minutes = "00"; }

			event_item.title = event_item.start.getHours() + ":" + minutes;
			events_array.push(event_item);
		}
	
		var date = new Date();
// 		var d = date.getDate();
// 		var m = date.getMonth();
// 		var y = date.getFullYear();
		
		$('#calendar').fullCalendar({
			theme: true,
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			editable: true,
			events: events_array,
			eventRender: function (event, element) {
				$(element).append("<input type='radio' name='date_time' value='" + event.date_time + "' />")
				$(element).click(function(){
					$(this).find("input").prop("checked", true);
				});
			} 
		});
		
	});

</script>
<style>
	body {
		margin-top: 40px;
		text-align: center;
		font-size: 13px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		}
	#calendar {
		width: 900px;
		margin: 0 auto;
		}
</style>
</head>
<body>
<s:form action="setAppointment" namespace="/" method="post" name="myForm"
		theme="xhtml" class="box">			
	<div id='calendar'></div>
	<s:submit key="submit" style="width:205px;" value="SUBMIT"/>
</s:form>
</body>
</html>