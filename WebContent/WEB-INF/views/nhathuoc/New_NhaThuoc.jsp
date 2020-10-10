<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Customer</title>
</head>
<body>
	<div align="center">
		<h2>New Nha Thuoc</h2>
		<form:form action="nhathuoc/save_nhathuoc" method="post" modelAttribute="nhathuoc">
			<table border="0" cellpadding="5">
				<tr>
					<td>id_NT: </td>
					<td><form:input path="id_NT" /></td>
				</tr>
				<tr>
					<td>tencoso: </td>
					<td><form:input path="tencoso" /></td>
				</tr>
				<tr>
					<td>diachi: </td>
					<td><form:input path="diachi" /></td>
				</tr>
				<tr>
					<td>gps: </td>
					<td><form:input path="gps" /></td>
				</tr>		
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>						
			</table>
		</form:form>
	</div>
</body>
</html>