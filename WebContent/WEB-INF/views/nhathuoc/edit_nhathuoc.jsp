<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>
	<div align="center">
		<h2>Edit Nha Thuoc</h2>
		<form:form action="nhathuoc/save_nhathuoc" method="post" modelAttribute="nhathuocr">
			<table border="0" cellpadding="5">
			
				<tr>
					<td>ID: </td>
					<td>${nhathuoc.id}
						<form:input path="id_NT"/>
					</td>
				</tr>		
				<tr>
					<td>TenCoSo: </td>
					<td><form:input path="tencoso" /></td>
				</tr>
				<tr>
					<td>DiaChi: </td>
					<td><form:input path="diachi" /></td>
				</tr>
				<tr>
					<td>GPS: </td>
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