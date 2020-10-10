<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="ctay"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.servletContext.contextPath}/">


<title>Quản lý Bệnh viện</title>
<style>
body {
	font-family: Tahoma;
	font-size: 14px;
	width: 1400px;
	margin: 0px auto;
}

.container {
	max-width: 1900px;
	margin: 0 auto;
	background-color: white;
}

* {
	box-sizing: border-box;
}

/* Style the header */
.header {
	overflow: hidden;
	background-color: palevioletred;
	padding: 30px;
	font-size: 35px;
	color: white;
}

.header>h2 {
	padding: 10px;
}

.header a {
	color: white;
	padding: 12px;
	text-decoration: none;
	font-size: 25px;
	line-height: 25px;
	border-radius: 4px;
}

.header a.logo {
	font-size: 50px;
	font-weight: bold;
}

.header-right {
	float: right;
}

.header-right {
	float: none;
}

/* Style the navigation menu */
.topnav {
	overflow: hidden;
	background-color: blue;
}

footer {
	font-size: 25px;
	background-color: orangered;
	border-top: 5px double gray;
	clear: both;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 21px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}
/* Style the content */
article {
	-webkit-flex: 3;
	-ms-flex: 3;
	flex: 3;
	background-color: #f1f1f1;
	padding: 10px;
	height: 430px;
}

.column {
	float: left;
	width: 50%;
	padding: 10px;
	height: 400px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

.button {
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 10px;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

.button1 {
	background-color: #008CBA;
} /* Blue */
/* Style the footer */

footer {
	background-color: palevioletred;
	padding: 10px;
	text-align: center;
	color: white;
}

/* Responsive layout - makes the menu and the content (inside the section) sit on top of each other instead of next to each other */
@media ( max-width : 600px) {
	section {
		-webkit-flex-direction: column;
		flex-direction: column;
	}
}
</style>
</head>
<body>
	<div class="container">
		<div class="header">
			<div style="float: left">
				<a>ID:</a></br> <a>CS KCB:</a></br> <a>Địa chỉ:</a>
			</div>
			<div>
				<Center style="color: yellow">
					<h2>Ứng Dụng Điều Phối Khám Chữa Bệnh</h2>
				</center>
			</div>
			<a>ID Login:</a> <a>Họ tên:</a>
			<div>

				<a style="float: right"> <img
					src="https://img.icons8.com/fluent/48/000000/bell.png" />
				</a> <a style="float: right">
					<button class="button button1">Logout</button>

				</a>
			</div>

		</div>


		<div class="topnav">
			<a class="active" href="Home.jsp">Trang chủ</a> <a href="DSDKKCB.jsp">DS
				DK Khám Bệnh</a> <a href="Khambenh.jsp">Khám bệnh</a> <a href="DSBacsi">DS
				Bác Sỹ</a> <a href="DSBenhnhan.jsp">DS bênh nhân</a> <a
				href="DSNhathuoc.jsp">DS nhà thuốc</a> <a href="DSCSKCB.jsp">DS
				CS. KB</a> <a href="Marketing.jsp">Marketing</a> <a href="Bantin.jsp">Bản
				tin</a> <a href="Hethong.jsp">Hệ thống</a>
		</div>

		<article>
			<center>
				<h1 style="color: black">Marketing</h1>
			</center>
		
      
			<table class="table">
				<tr style="background-color: #66ccff">
					<th>ID</th>
					<th>Bảng tin</th>
					<th>Mô tả</th>
					<th>Trạng thái</th>
					<th>Mã tài khoản</th>
				</tr>
				<ctay:forEach var="mar" items="${listMarketings}">
					<tr style="background-color: #33cc66">
						<td>${mar.id_mkt}</td>
						<td>${mar.bantin}</td>
						<td>${mar.mota}</td>
						<td>${mar.trangthai}</td>
						<td>${mar.id_tk}</td>
						<td>
							
							<a type="submit" href="insertmarketing.htm">Thêm </a>
							&nbsp;&nbsp;&nbsp;
							<a type="submit" href="edit?id=${mar.id_mkt}">Cập nhật</a>

						</td>
					</tr>
				</ctay:forEach>

			
			</table>
			
		</article>


		<footer>
			<p>Coby right @ 2020</p>
		</footer>
	</div>

</body>
</html>