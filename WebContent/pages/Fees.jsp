<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Stephanos Club | REGISTER STUDENT</title>
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
        <li><a href=" GET INFO.jsp"> GET INFO</a></li>
       <li><a href="Attend">TimeSheet</a></li>
        <li class="active"><a href="Fees.jsp">Fees</a></li>
         <li><a href="PurposeOfFees.jsp">Add Payment Type</a></li>
      	<li ><a href="a.jsp">Upgrade Rank</a></li>
        <li><a href="ab.jsp">Add Rank</a></li>
        <li ><a href="rep.jsp">Reports</a></li>
        <li><a href="pages/logout.jsp">logout</a></li>
      </ul>
    </div>
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper row3">
  <div id="container" class="clear"> 
    <!-- ####################################################################################################### -->
    <div id="content">
    <%String message =  (String)request.getAttribute("message");%>
     
      <h2>Please complete below form and Submit to add fees record of student</h2>
      <div id="studentdiv">
     <div id="result" style="color:green"><% if(message != null){%> <%=message%> <%}%></div>
        <form id="studentForm" action="Fees" method="POST">
        <div id= " GET INFO">
        <table>
        <tr>
         	<td ><label for="studentID">Student ID<span class="required">*</span></label></td>
            <td ><input type="text" name="studentID" id="studentID" value="" size="22" required/></td>
          </tr>
          <tr>
            <td><label for="paymentDate">Paaaayment Date</label></td>
			<td><input type="text" name="paymentDate" id="paymentDate" value="" required/></td>
         </tr>
          <tr>
            <td><label for="purposeOfPayment">Purpose Of Payment</label></td>
            <td><select name="purposeOfPayment" id="purposeOfPayment" value="Membership" required >
            		<option value = "Membership">Membership</option>
            		<option value="Test">Test</option>
            		<option value="ProductPurchase">Product Purchase</option>
            	</select>
            </td>
          </tr>
           <tr>
         	<td ><label for="amount">Amount</label></td>
            <td ><input type="number" name="amount" id="amount" value="" size="22" required/>
            <label for="CAD">CAD</label></td>
          </tr>
           <tr>
         	<td ><label for="Comment">Comment</label></td>
            <td ><input type="text" name="comment" id="comment" value="" size="22" required/>
            </td>
          </tr>
          <tr>
          <td></td>
           
            <td><input name="submit" type="submit" id="submit" value="Submit Form" /></td>
          </tr>
          </table>
          </div>
        </form>
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
$(function () {	
	 $('#paymentDate').datepicker(); 
});



</script>

</body>
