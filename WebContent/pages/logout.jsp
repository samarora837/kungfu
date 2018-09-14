<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<script language="JavaScript" type="text/javascript">
window.history.forward(1);
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Logout</title>

</head>

<body>

	<%
		if (request.getSession(false) != null) {
			session.invalidate();
		}
	%>

	<c:redirect url="/login.html" />
</body>

</html>