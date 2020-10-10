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
		<h2>Insert Marketing</h2>
	
			<form:form action="save" method="post" modelAttribute="marketing">
			<table border="0" cellpadding="5">
				<tr>
					<td>ID Marketing:</td>
					<td>
				
					<form:input path="id_mkt" /></td>
				</tr>
				<tr>
					<td>Bản tin:</td>
					<td><form:input path="bantin" /></td>
				</tr>
				<tr>
					<td>Mô tả</td>
					<td><form:input path="mota" /></td>
				</tr>
				<tr>
					<td>Trạng thái</td>
					<td><form:input path="trangthai" /></td>
				</tr>
				<tr>
					<td>Mã tài khoản</td>
					<td><form:input path="id_tk" /></td>
				
				<tr>
					<td colspan="2"><input type="submit" value="Insert"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>