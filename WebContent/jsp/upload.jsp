<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/Fakebook/css/stylesheet.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload a photo</title>
</head>
<body>
	<div class="nav">
		<nav>
			<ul>
				<li><a href="/Fakebook/jsp/index.jsp" id="logo">fakebook</a></li>
				<li><form action="/Fakebook/se" method="GET">
						<input type="text" placeholder="Search" name="searchbox"
							id="searchbox" /> <input type="submit" value=" " id="search" />
					</form></li>
				<c:choose>
					<c:when test="${sessionScope.un == null}">
						<li><a href="/Fakebook/html/login.html" id="login">login</a></li>
						<li><a href="/Fakebook/html/register.html" id="register">register</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/Fakebook/jsp/profile.jsp" id="profile">profile</a></li>
						<li><a href="/Fakebook/upr" id="upload">upload</a></li>
						<li><a href="/Fakebook/out" id="logout">logout</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>

	<div id="wrapper">
		<c:choose>
			<c:when test="${sessionScope.un != null}">
				<div class="upload">
					<h1>Upload a photo</h1>
					<form action="/Fakebook/up" method="POST"
						enctype="multipart/form-data">
						<input type="file" accept=".jpg,.png,.tiff" name="file" /> <br />
						<br /> <label for="description">Description: </label><input
							type="text" id="description" name="description" /> <br /> <br />
						<label for="privacy">Share with everyone?</label><input
							type="checkbox" name="privacy" value="privacy" id="privacy" /> <br />
						<br /> <input type="submit" value="Submit">
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<div id="denied">
					<h1>Denied!</h1>
					<p>You aren't supposed to be in this page.</p>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>