<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/Fakebook/css/stylesheet.css" />
<script src="/Fakebook/js/jquery-3.2.1.js"></script>
<script src="/Fakebook/js/view_script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View a photo</title>
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
		<div class="photo">
			<button type="button" class="inline" id="go-back">Go back</button>

			<br /> <span id="uploader"></span><span id="album"></span><span
				id="tags"></span>
			<h1 id="title"></h1>
			<div id="img"></div>

			<c:if test="${sessionScope.un != null}">
				<div class="tag">
					<h1>Add tags</h1>
					<form action="tag" method="POST">
						<label for="tags">Tags (separate with commas): </label> <input
							type="text" id="tags" /> <br /> <br /> <input type="submit"
							value="Save tags">
					</form>
				</div>

				<div class="share">
					<h1>Or share it with someone!</h1>
					<form action="share" method="POST">
						<label for="list">List of people (separate with commas): </label><input type="text"
							id="list" /> <br /> <br /> <input type="submit"
							value="Share photo">
					</form>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>