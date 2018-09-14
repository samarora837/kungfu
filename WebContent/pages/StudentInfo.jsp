<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
     <%@ page import="com.VO.StudentVO" %>
    <%-- <%@ page import="com.handler.StudentVO" %> --%>
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
      <li><a href="../index.html">Home</a></li>
     <li><a href="newstudent.jsp">REGISTER</a></li>
        <li class="active"><a href="StudentInfo.jsp">GET INFO</a></li>
        <li><a href="Attend">TimeSheet</a></li>
        <li ><a href="Fees.jsp">Payment</a></li>
         <li><a href="PurposeOfFees.jsp">Add Payment Type</a></li>
      <li ><a href="a.jsp">Upgrade Rank</a></li>
        <li><a href="ab.jsp">Add Rank</a></li>
        <li ><a href="rep.jsp">Reports</a></li>
        <li><a href="logout.jsp">logout</a></li>
      </ul>
    </div>
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper row3">
  <div id="container" class="clear"> 
    <!-- ####################################################################################################### -->
    <div id="content">
    <%String message =  (String)request.getAttribute("message"); %>
     <%StudentVO studentData = (StudentVO)request.getAttribute("studentDetails"); %> 
     
      <h2>Enter Student Number</h2>
      
      <div id="studentdiv">
      <div id="result" style="color:green"><% if(message != null){%> <%=message%> <%}%></div>
        <form id="studentForm" action="StudentInfo" method="GET">
        <div id= " GET INFO">
        <table>
        <tr>
         	<td ><label for="studentID">Student No.<span class="required">*</span></label></td>
            <td ><input type="text" name="studentID" id="studentID" value="" size="22" required/></td>
          </tr>
          <tr>
          <td></td>
           
            <td><input name="submit" type="submit" id="submit" value="Search" /></td>
          </tr>
          </table>
         <%--  
        <table>
        <thead>
			<tr>
				<th>Student ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Street</th>
				<th>City</th>
				<th>Province</th>
				<th>Country</th>
				<th>Postal Code</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Date of Birth</th>
				<th>Joining Date</th>
				<th>Father Name</th>
				<th>Father Email</th>
				<th>Father Mobile</th>
				<th>Mother Name</th>
				<th>Mother Email</th>
				<th>Mother Mobile</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sessionScope.search}" var="se">
				<tr>
					<td>${se.Student_Number}</td>
					<td>${se.first_Name}</td>
					<td>${se.last_Name}</td>
					<td>${se.mobile}</td>
					
				</tr>
			</c:forEach>
			<c:remove var="se" scope="session"/>
		</tbody>
        
      
          </table> --%> 
          </div>
        </form>
      </div>
      <div id="studentdetails">
<!--       <form action="update GET INFO" method="get">
 -->      	<%if(studentData != null ){ %>
  		<table  style="color:purple;border-style:groove; height:150px;width:350px" background="3.jpg">
        
        <tr>
            <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Student ID:</td>
            <td class="auto-style4">
                <input id="Text1" type="text" name="studentID" readonly value="<%=studentData.getStudent_Number() %>"/></td>
        </tr>
        <tr>
            <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">First Name:</td>
            <td class="auto-style4">
                <input id="Text2" type="text" name="fname" readonly value="<%=studentData.getFirst_Name()%>"/></td>
        </tr>
        <tr>
            <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Last Name:</td>
            <td class="auto-style4">
                <input id="Text11" type="text" name="lname" readonly value="<%=studentData.getLast_Name()%>"/></td>
        </tr>
        <tr>
             <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Address:</td>
            <td class="auto-style4">
                <input id="Text3" type="text" name="addressl1" readonly value="<%=studentData.getStreet()%>" /></td>
        </tr>
        <tr>
             <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">City:</td>
            <td class="auto-style4">
                <input id="Text12" type="text" name="city" readonly value="<%=studentData.getCity()%>" /></td>
        </tr>
        <tr>
             <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Province:</td>
            <td class="auto-style4">
                <input id="Text13" type="text" name="province" readonly value="<%=studentData.getProvince()%>" /></td>
        </tr>
        <tr>
             <td style="color:black;background-color:#c5c6c9;" class="auto-style3">Country:</td>
            <td class="auto-style4">
                <input id="Text14" type="text" name="country" readonly value="<%=studentData.getCountry()%>" /></td>
        </tr>
        <tr>
             <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Postal Code:</td>
            <td class="auto-style4">
                <input id="Text15" type="text" name="postalcode" readonly value="<%=studentData.getPostal_Code()%>" /></td>
        </tr>
        <tr>
             <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Email:</td>
            <td class="auto-style4">
                <input id="Text4" type="email" name="email" readonly value="<%=studentData.getEmail() %>" /></td>
        </tr>
        <tr>
            <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Mobile:</td>
            <td class="auto-style4">
                <input id="Text5" type="number" name="mobile" readonly value="<%=studentData.getMobile() %>" /></td>
        </tr>
        <tr>
           <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Date of Birth:</td>
            <td class="auto-style4">
                <input id="Text6" type="text" name="dateofbirth" readonly value="<%=studentData.getDateofbirth() %>" ></td>
        </tr>
        <tr>
             <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Joining Date:</td>
            <td class="auto-style4">
                <input id="Text7" type="text" name="joiningDate" readonly value="<%=studentData.getDateofjoining() %>"/></td>
        </tr>
        <tr>
             <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Rank:</td>
            <td class="auto-style4">
                <input id="Text7" type="text" name="joiningDate" readonly value="<%=studentData.getRank()%>"/></td>
        </tr>
        <%if(studentData.getFather_Name() != null && !"".equals(studentData.getFather_Name().trim())) {%>
        <tr>
             <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Father Name:</td>
            <td class="auto-style4">
                <input id="Text8" type="text" name="fathername" readonly value="<%=studentData.getFather_Name() %>" /></td>
        </tr>
        <tr>
             <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Father Email:</td>
            <td class="auto-style4">
                <input id="Text9" type="emails" name="fatheremail" readonly value="<%=studentData.getFather_Email() %>"/></td>
        </tr>
        <tr>
             <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Father Mobile:</td>
            <td class="auto-style4">
                <input id="Text10" type="number" name="fathermobile" readonly value="<%=studentData.getFather_Mobile() %>"/></td>
        </tr>
        <%} if(studentData.getMother_Name() != null && !"".equals(studentData.getMother_Name().trim())){ %>
        <tr>
             <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Mother Name:</td>
            <td class="auto-style4">
                <input id="Text8" type="text" name="mothername" readonly value="<%=studentData.getMother_Name()%>" /></td>
        </tr>
        <tr>
             <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Mother Email:</td>
            <td class="auto-style4">
                <input id="Text9" type="email" name="motheremail" readonly  value="<%=studentData.getMother_Email() %>"/></td>
        </tr>
        <tr>
             <td style="color:black;background-color:#c5c6c9;;" class="auto-style3">Mother Mobile:</td>
            <td class="auto-style4">
                <input id="Text10" name="mothermobile" type="number" readonly value="<%=studentData.getMother_Mobile() %>"/></td>
        </tr>
        <%} %>
       <!-- <tr><td></td><td>
       <input name="submit" type="submit" id="submit" value="Update" />
       </td></tr> -->
       
       <%} %>
    	</table>
    	<!-- </form> -->
      </div>
      
    </div>

    <!-- ####################################################################################################### --> 
  </div>
</div>
<!-- ####################################################################################################### -->
<!-- ####################################################################################################### -->
<div class="wrapper">
  <div id="copyright" class="clear">
    <p class="fl_left">Copyright &copy; 2018 <a href="#">Stephanos Club</a></p>
    <p class="fl_right">Website by <a target="_blank" href="#" title="">Sanchit,Gautam</a></p>
  </div>
</div>

<script>
$(function () {
	
	 //$('#Text6').datepicker();
	// $('#Text7').datepicker();
	 
	 
   
});
// Attach a submit handler to the form



</script>

</body>
</html>