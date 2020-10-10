<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Customer</title>
</head>
<body>
	<div align="center">
		<h2>Thêm Bác Sĩ</h2>
		<form:form action="save_bacsi" method="post" modelAttribute="bacsi">
			<table border="0" cellpadding="5">
				<tr>
					<td>ID Bác sĩ: </td>
					<td><form:input path="id_BS" /></td>
				</tr>
				<tr>
					<td>Họ Tên: </td>
					<td><form:input path="hoten" /></td>
				</tr>
				<tr>
					<td>Số điện thoại: </td>
					<td><form:input path="sdt" /></td>
				</tr>		
					<tr>
					<td>Email: </td>
					<td><form:input path="email" /></td>
				</tr>		
					<tr>
					<td>Chuyên Khoa: </td>
					<td><form:input path="chuyenkhoa" /></td>
				</tr>		
					<tr>
					<td>Trạng Thái: </td>
					<td>	<form:input path="trangthai" /></td>
				</tr>		
					<tr>
					<td>Địa Chỉ: </td>
					<td><form:input path="diachi" /></td>
				</tr>		
					<tr>
					<td>Hình: </td>
					<td><form:input path="hinh" /></td>
				</tr>		
					<tr>
					<td>ID_TK: </td>
					<td><form:input path="id_TK" /></td>
				</tr>		
				
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>						
			</table>
		</form:form>
	</div>
</body>
</html>