<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page import="ft.util.DateType"%>
<%@ page import="ft.util.MyTimer"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href='css/main.css' />

<style type="text/css">
.errors {
	background-color: #FFCCCC;
	border: 1px solid #CC0000;
	width: 345px;
	height: 20px;
	margin-top: -14px;
	margin-bottom: 5px;
}

.errors li {
	list-style: none;
	margin-top: -14px;
	font-family: new century schoolbook;
	font-size: 15px;
	margin-left: 60px;
}

.loginbox {
	position: absolute;
	margin: auto;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	width: 400px;
	height: 290px;
	-moz-border-radius: 1px;
	-khtml-border-radius: 1px;
	-webkit-border-radius: 1px;
	border-radius: 1px;
	overflow: hidden;
	border: 1px solid black;
	font-family: Verdana, Geneva, sans-serif;
}

.logindetails {
	margin-top: 25px;
	margin-left: 15px;
}

.logintitle {
	background-color: #8D96A8;
	color: #FFFFFF;
}
</style>


<title>Login</title>
<script>
	function sivamtime() {
		now = new Date();
		hour = now.getHours();
		min = now.getMinutes();
		sec = now.getSeconds();

		if (min <= 9) {
			min = "0" + min;
		}
		if (sec <= 9) {
			sec = "0" + sec;
		}
		if (hour > 12) {
			hour = hour - 12;
			add = "pm";
		} else {
			hour = hour;
			add = "am";
		}
		if (hour == 12) {
			add = "pm";
		}

		time = ((hour <= 9) ? "0" + hour : hour) + ":" + min + ":" + sec + " "
				+ add;

		if (document.getElementById) {
			document.getElementById('myText').innerHTML = time;
		} else if (document.layers) {
			document.layers.theTime.document.write(time);
			document.layers.theTime.document.close();
		}

		setTimeout("sivamtime()", 1000);
	}
	window.onload = sivamtime;
</script>

</head>
<body>
	<span id="theTime" style="position:absolute; left:10; top:10; font-family: arial; font-size: 9pt"></span>
	<div class="loginbox">
		<div class="logintitle">
			<label
				style="font-family: new century schoolbook; font-size: 30px; margin-left: 15px;">LOGIN</label>
		</div>
		<s:form action="login" namespace="/" method="post" name="myForm"
			theme="xhtml" class="box">

			<div class="logindetails">
				<s:if test="hasActionMessages()">
					<div class="errors">
						<s:actionmessage />
					</div>
				</s:if>

				
				
				
				<table width="350px" height="10px" border=0
					style="margin-left: 15px;">
					<tr style="height: 30px;">
						<td
							style="width: 33%; font-family: new century schoolbook; font-size: 15px;">First
							Name:</td>
						<td><input type="text" name="patientobj.first_name"
							style="width: 240px; height: 25px;"></td>
					</tr>

					<tr style="height: 30px;">
						<td
							style="width: 20%; height: 10px; font-family: new century schoolbook; font-size: 15px;">Last
							Name:</td>
						<td><input type="text" name="patientobj.last_name"
							style="width: 240px; height: 25px;"></td>
					</tr>

					<tr style="height: 30px;">
						<td
							style="width: 20%; height: 10px; font-family: new century schoolbook; font-size: 15px;">Birth
							Date:</td>
						<td><select name="patientobj.month"
							style="width: 120px; height: 35px;">
								<%
									List<String> months = DateType.monthNames();
										for (String s : months) {
								%>
								<option value="<%=s%>"><%=s%></option>
								<%
									}
								%>
						</select> <select name="patientobj.day" style="height: 35px;">
								<%
									List<String> day = DateType.days();
										for (String s : day) {
								%>
								<option value="<%=s%>"><%=s%></option>
								<%
									}
								%>
						</select> <input type="text" name="patientobj.year"
							style="width: 60px; height: 28px;"
							onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')">
							<br></td>
					</tr>
					<tr style="height: 30px;">
						<td
							style="width: 20%; height: 10px; font-family: new century schoolbook; font-size: 15px;">Passphrase:</td>
						<td><input type="text" name="patientobj.passphrase"
							style="width: 240px; height: 25px;"></td>
					</tr>
				</table>
				<table width="350px" height="30px" border=0
					style="margin-left: 17px;">
					<tr style="height: 10px;">
						<td style="width: 100px; height: 30px;"></td>
						<td><input type="submit" value="Login"
							style="width: 244px; height: 30px;"></td>
					</tr>
				</table>
			</div>
		</s:form>
	</div>


</body>
</html>