<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/Fakebook/css/stylesheet.css" />
<script src="/Fakebook/js/jquery-3.2.1.js"></script>
<script src="/Fakebook/js/search_script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Fakebook</title>
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
		<div class="search-banner">
			<h1>You searched for "${sessionScope.query}"</h1>
		</div>

		<div class="users">
			<h1 id="title">Search results for users</h1>
			<div id="user-list"></div>

			<button type="button" id="see-more-users">See more</button>
		</div>

		<div class="public-photos">
			<h1 id="title">Search results for public photos</h1>
			<div id="public-grid"></div>

			<button type="button" onclick="onClickPublic()"
				id="see-more-public-photos">See more</button>
		</div>

		<c:if test="${sessionScope.un != null}">
			<div class="shared-photos">
				<h1 id="title">Search results for shared photos</h1>
				<div id="shared-grid"></div>

				<button type="button" onclick="onClickShared()"
					id="see-more-shared-photos">See more</button>
			</div>
		</c:if>
	</div>
</body>
</html>