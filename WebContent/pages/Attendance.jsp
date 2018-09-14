<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.VO.ClassSessionVO" %>
<%@ page buffer="24kb"%>  
  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Education Board | Style Demo</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="../layout/styles/layout.css" type="text/css" />
<link rel="stylesheet" href="../layout/styles/jquery-ui.css" type="text/css" />
<script type="text/javascript" src="../layout/scripts/jquery.min.js"></script>
<script type="text/javascript" src="../layout/scripts/jquery.ui.min.js"></script>
<style type="text/css">
        .required{
      color:red;
}
      </style>
</head>
<body id="top">
<div class="wrapper row1">
  <div id="header" class="clear">
    <div class="fl_left">
      <h1><a href="../index.html">Stephanos Club</a></h1>
      
    </div>
    <div id="topnav">
      <ul>
         <li ><a href="../index.html">Home</a></li>
     <li><a href="newstudent.jsp">REGISTER</a></li>
        <li><a href="StudentInfo.jsp"> GET INFO</a></li>
        <li class="active"><a href="Attend">TimeSheet</a></li>
        <li ><a href="Fees.jsp">Payment</a></li>
         <li><a href="PurposeOfFees.jsp">Add Payment Type</a></li>
      <li><a href="a.jsp">Upgrade Rank</a></li>
        <li><a href="ab.jsp">Add Rank</a></li>
       <li ><a href="rep.jsp">Reports</a></li>
       <li><a href="logout.jsp">logout</a></li>
      </ul>
    </div>
  </div>
</div>
 <%String message =  (String)request.getAttribute("message");
 String message1 =  (String)request.getAttribute("message1");

 %> 

<!-- ####################################################################################################### -->
<div class="wrapper row3">
  <div id="container" class="clear"> 
    <!-- ####################################################################################################### -->
  
 
  
    <div id="content">
   
     
    <h2>Add Class Timings</h2>
      
      <div id="studentdiv">
      <div id="result" style="color:green"><% if(message1 != null){%> <%=message1%> <%}%></div>
        <form id="levelForm" action="addlevel" method="GET">
        <div id= "addLevel">
        <table>
        <tr>
         	<td ><label for="levelname">Level Name <span class="required">*</span></label></td>
            <td ><input type="text" name="levelname" id="levelname" value="" size="22" required/></td>
          </tr>
          <tr>
            <td><label for="classStarttime">Start Time <span class="required">*</span></label></td>
            <td ><input type="text" name="classStarttime" id="classStarttime" value="" size="22" required/></td>
          </tr>
          <tr>
            <td><label for="classEndtime">End Time <span class="required">*</span></label></td>
            <td ><input type="text" name="classEndtime" id="classEndtime" value="" size="22" required/></td>
          </tr>
          <tr>
          <td></td>
           
            <td><input name="submit" type="submit" id="submit" value="Add Class" /></td>
          </tr>
          </table>
          </div>
        </form>
      </div>


    
      <h2>Student TimeSheet</h2>
       
      <div id="studentdiv">
      <div id="result" style="color:green"><% if(message != null){%> <%=message%> <%}%></div>
        <form id="studentForm" action="ADDAttendance" method="GET">
        <div id= "studentInfo">
        <table>
        <tr>
         	<td ><label for="studentID">Student No. <span class="required">*</span></label></td>
            <td ><input type="text" name="studentID" id="studentID" value="" size="22" required/></td>
          </tr>
          <tr>
            <td><label for="classLevel">Select Level</label></td>
            <td>
            
             	<select name="classSession" id="classSession"> <!-- data-rule-required="true" -->
				<c:forEach items="${levelList}" var="list1">
					<option value="${list1.level_Name}">${list1.level_Name} + ${list1.start_at} + ${list1.end_at}</option>
					</c:forEach>
				</select>
				<c:remove var="list1" scope="session"/>
            	
            </td>
          </tr>
<!--          <tr>
            <td><label for="classTime">Class Time</label></td>
            <td><select name="classTime" id="classTime" value="10AM-11AM" required>
            		<option value = "10AM-11AM">10AM-11AM</option>
            		<option value="11AM-12PM">11AM-12PM</option>
            		<option value="12PM-1PM">12PM-1PM</option>
            	</select>
            </td>
          </tr> -->
          <tr>
            <td><label for="attendanceDate">Date <span class="required">*</span></label></td>
			<td><input type="text" name="attendanceDate" id="attendanceDate" value="" required/></td>
         </tr>
          <tr>
          <td></td>
           
            <td><input name="submit" type="submit" id="submit" value="Submit Timesheet" /></td>
          </tr>
          </table>
          </div>
        </form>
      </div>
    </div>

    <!-- ####################################################################################################### --> 
  </div>
</div>
<div class="wrapper">
  <div id="copyright" class="clear">
    <p class="fl_left">Copyright &copy; 2018 <a href="#">Stephanos Club</a></p>
    <p class="fl_right">Website by <a target="_blank" href="#" title="">Sanchit,Gautam</a></p>
  </div>
</div>

<script>
$(function () {
	
	 $('#attendanceDate').datepicker();
	
	 
   
});
// Attach a submit handler to the form
/* $("#classLevel" ).change(function( event ) {
	if($("#classLevel").val() == 'Beginner' ){
		$("#classTime option:first-child").text("10AM-11AM").val("10AM-11AM");
		$("#classTime option:nth-child(2)").text("11AM-12PM").val("11AM-12PM");
		$("#classTime option:nth-child(3)").text("12PM-1PM").val("12PM-1PM");
	}else if($("#classLevel").val() == 'Intermediate'){
		$("#classTime option:first-child").text("2PM-3PM").val("2PM-3PM");
		$("#classTime option:nth-child(2)").text("3PM-4PM").val("3PM-4PM");
		$("#classTime option:nth-child(3)").text("4PM-5PM").val("4PM-5PM");
	}else if($("#classLevel").val() == 'Advanced'){
		$("#classTime option:first-child").text("5PM-6PM").val("5PM-6PM");
		$("#classTime option:nth-child(2)").text("6PM-7PM").val("6PM-7PM");
		$("#classTime option:nth-child(3)").text("7PM-8PM").val("7PM-8PM");
	}
}); */


</script>

</body>
</html>