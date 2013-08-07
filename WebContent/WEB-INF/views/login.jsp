<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
</head>
<body>
	
	<form action="login" method="POST">
		<table align="center">
			<tr>
				<td colspan="3" style="color:red"><c:out value="${error_msg}"></c:out></td>
			</tr>
			<tr>
				<td>User Name  </td>
				<td colspan="2"><input type="text" name="uname"/></td>
			</tr>
			<tr>
				<td>Password  </td>
				<td colspan="2"><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"/></td>
				<td><input type="reset" value="Cancel"/></td>				
				<td>&nbsp;&nbsp;&nbsp;<a href="login">Register me...</a></td>
			</tr>
		</table>
	</form>
	
</body>
</html>