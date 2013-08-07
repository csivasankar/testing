<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

	<h2 align = "center"> <u>User Registration </u></h2>
	
	<form action="register" method="POST">
		<table align="center">
			<tr>
				<td colspan="3"><font color="red">*</font><font size="2">Mandatory fields</font></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"/></td>
				<td style="color:red">*</td>
			</tr>
			<tr>
				<td>User Name  </td>
				<td><input type="text" name="userName"/></td>
				<td style="color:red">*</td>
			</tr>
			<tr>
				<td>Password  </td>
				<td><input type="password" name="password"/></td>
				<td style="color:red">*</td>
			</tr>
			<tr>
				<td>E-mail  </td>
				<td><input type="text" name="email"/></td>
				<td style="color:red">*</td>
			</tr>
			<tr>
				<td>Location  </td>
				<td><input type="text" name="location"/></td>
				<td style="color:red">*</td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"/></td>
				<td colspan="2"><input type="reset" value="Cancel"/>
				<font color="red" size="2"><c:out value="${message}"/></font></td>
			</tr>
		</table>
	</form>
	
</body>
</html>
