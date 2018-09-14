<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Education Board | Style Demo</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="../layout/styles/layout.css"
	type="text/css" />
<link rel="stylesheet" href="../layout/styles/jquery-ui.css"
	type="text/css" />
<link rel="stylesheet" href="../layout/styles/tables.css"
	type="text/css" />
<script type="text/javascript" src="../layout/scripts/jquery.min.js"></script>
<script type="text/javascript" src="../layout/scripts/jquery.ui.min.js"></script>
</head>
<body id="top">
	<div class="wrapper row1">
		<div id="header" class="clear">
			<div class="fl_left">
				<h1>
					<a href="../index.html">Stephanos Club</a>
				</h1>

			</div>
			<div id="topnav">
				<ul>
					<li><a href="../index.html">Home</a></li>
					<li><a href="newstudent.jsp">REGISTER</a></li>
					<li><a href="StudentInfo.jsp">GET INFO</a></li>
					<li ><a href="Attend">TimeSheet</a></li>
					<li><a href="Fees.jsp">Payment</a></li>
					<li><a href="PurposeOfFees.jsp">Add Payment Type</a></li>
					<li><a href="a.jsp">Upgrade Rank</a></li>
					<li><a href="ab.jsp">Add Rank</a></li>
					<li class="active"><a href="rep.jsp">Reports</a></li>
					<li><a href="logout.jsp">logout</a></li>
				</ul>
			</div>
		</div>
	</div>

	<!-- ####################################################################################################### -->
	<div class="wrapper row3">
		<div id="container" class="clear" style="height:400px;">
			<!-- ####################################################################################################### -->



			<div id="">

				
				<h2>Get Details</h2>
					<input type="hidden" id="tabToOpen" value='${openTab}' >
				<div id="studentdiv">
					<div id="result" style="color: green"></div>
					<div class="tab">
						<button class="tablinks" onclick="openCity(event, 'Attendance')">Attendance</button>
						<button class="tablinks" onclick="openCity(event, 'Rank')">Rank</button>
						<button class="tablinks" onclick="openCity(event, 'Fees')">Payment</button>
					</div>

					<div id="Attendance" class="tabcontent">
						<form action="serachAttendance" method="post">
							<div id="searchOption" style="display: inline-block;">
								<label for="student_num">Student Number</label> 
								<input id="student_num" type="text" name="student_num" /> 
								<label for="start_date">Attendance Date</label> 
								<input id="start_date" type="text" name="start_date" /> 
								<label for="level">Level</label> 
								<select id="level" name="level">
									<option value="">Select</option>
									<c:forEach items="${levelList}" var="list1">
										<option value="${list1.level_Name}">${list1.level_Name}</option>
									</c:forEach>
								</select>
								<button type="submit" id="searchButton">Search</button>

							</div>
						</form>
						<table>
							<thead>
								<tr>
									<th>Student Number</th>
									<th>Class</th>
									<th>TimeSheet</th>
								</tr>
							</thead>
							<tbody>
								
								<c:forEach items="${attendanceList}" var="attlist">
										<tr><td >${attlist.student_Num}</td><td >${attlist.csvo}</td><td >${attlist.attendance_date}</td></tr>
									</c:forEach>
									
							
							</tbody>
						</table>
						<div style="color:green">${messgaeAttendance}</div>
					</div>

					<div id="Rank" class="tabcontent">
						<form action="serachRank" method="post">
							<div id="searchOption" style="display: inline-block;">
								<label for="student_num">Student Number</label> 
								<input id="student_num" type="text" name="student_num" /> 
								<label for="rank">Rank</label> 
								<select name="rank"  >
									<option value="">Select</option>
                					<c:forEach var="rank" items="${ranks}">
           	         					<option value="${rank}"><c:out value="${rank}"/></option>
                					</c:forEach>           
								</select>
								<button type="submit" id="searchButton">Search</button>
							</div>
						</form>
						<table>
							<thead>
								<tr>
									<th>Student Number</th>
									<th>Rank</th>
									<th>Assigned Date</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${rankList}" var="rnklist">
										<tr><td >${rnklist.student_NUM}</td><td >${rnklist.rankName}</td><td >${rnklist.assign_rank_date}</td></tr>
									</c:forEach>
							</tbody>
						</table>
						<div style="color:green">${messgaeAttendance}</div>
					</div>

					<div id="Fees" class="tabcontent">
						<form action="serachFees" method="post">
							<div id="searchOption" style="display: inline-block;">
								<label for="student_num">Student Number</label> 
								<input id="student_num" required type="text" name="student_num" /> 
								<label for="start_date">Fee Date</label> 
								<input id="fee_date" type="text" name="fee_date" />
								<button type="submit" id="searchButton">Search</button>

							</div>
						</form>
						<table>
							<thead>
								<tr>
									<th>Payment Type</th>
									<th>Submission Date</th>
									<th>Amount Paid</th>
									<th>Comments</th>
								</tr>
							</thead>
							<tbody>
									<c:forEach items="${fees}" var="feelist">
								<tr><td>${feelist.item_Name}</td><td >${feelist.payment_Date}</td><td>${feelist.paid_Fees}</td><td>${feelist.comment}</td></tr>
									</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- ####################################################################################################### -->
		</div>
	</div>
<!-- ####################################################################################################### -->
		<div class="wrapper">
  <div id="copyright" class="clear">
    <p class="fl_left">Copyright &copy; 2018 <a href="#">Stephanos Club</a></p>
    <p class="fl_right">Website by <a target="_blank" href="#" title="">Sanchit,Gautam</a></p>
  </div>
</div>
	<script>
		function openCity(evt, cityName) {
			// Declare all variables
			var i, tabcontent, tablinks;

			// Get all elements with class="tabcontent" and hide them
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}

			// Get all elements with class="tablinks" and remove the class "active"
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}

			// Show the current tab, and add an "active" class to the button that opened the tab
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}

$(function () {
	$('#start_date').datepicker();
	$('#fee_date').datepicker();

	 //$('#start_date').datepicker('setDate', new Date()); 
	 if($("#tabToOpen").val() == "Attendance"){
		 $("#Attendance").css("display","block");
	 }
	 if($("#tabToOpen").val() == "Rank"){
		 $("#Rank").css("display","block");
	 }
	 if($("#tabToOpen").val() == "Fees"){
		 $("#Fees").css("display","block");
	 }
	 
});
</script>
</body>
</html>