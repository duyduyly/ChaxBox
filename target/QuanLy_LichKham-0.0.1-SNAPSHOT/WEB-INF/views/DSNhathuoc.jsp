<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<base href="${pageContext.servletContext.contextPath}/">
<script src="js/layout.js"></script>
<script src="js/KhambenhCtrl.js"></script>
<script src="js/HomeCtrl.js"></script>
<script src="js/DSDKKCBCtrl.js"></script>
<script src="js/DSCSKCBCtrl.js"></script>
<script src="js/DCNhaThuocCtrl.js"></script>
<script src="js/Hethong.js"></script>

<title>Quản lý Bệnh viện</title>
<style>
body {
	margin: 0;
	padding: 0px;
	background-color: lightgray;
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
	background-color: DodgerBlue;;
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

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	color: white;
	border: 1px solid #dddddd;
	text-align: center;
	padding: 10px;
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
a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: red;
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
			<a>ID Login:</a></br> <a>Họ tên:</a>
			<div>

				<a style="float: right"> <img
					src="https://img.icons8.com/fluent/48/000000/bell.png" />
				</a> <a style="float: right">
					<button class="button button1">Logout</button>

				</a>
			</div>

		</div>


		<div class="topnav">
			<a class="active" href="Home.html">Trang chủ</a> <a
				href="DSDKKCB.html">DS DK Khám Bệnh</a> <a href="Khambenh.html">Khám
				bệnh</a> <a href="#">DS Bác Sỹ</a> <a href="#">DS bênh nhân</a> <a
				href="DSNhaThuoc.html">DS nhà thuốc</a> <a href="DSCSKCB.html">DS
				CS. KB</a> <a href="#">Marketing</a> <a href="#">Bản tin</a> <a
				href="Hethong.html">Hệ thống</a>
		</div>

		<article>
		<div class="row">
			<Center>
				<h1>Danh sách nhà thuốc</h1>
			</center>
			<table>
				<tr style="background-color: DodgerBlue">
					<th>ID</th>
					<th>Tên cơ sở</th>
					<th>Địa chỉ</th>
					<th>GPS</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${listNhathuoc}"  var="nhathuoc">
					<tr style="background-color: #80b380">
						<td>${nhathuoc.id_NT}</td>
						<td>${nhathuoc.tencoso}</td>
						<td>${nhathuoc.diachi}</td>
						<td>${nhathuoc.gps}</td>
						<td><a href="edit?id=${nhathuoc.id_NT}">Edit</a>
							&nbsp;&nbsp;&nbsp; <a href="delete?id=${nhathuoc.id_NT}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</article>


		<footer>
		<p>Coby right @ 2020</p>
		</footer>
	</div>
</body>
</html>