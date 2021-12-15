<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<link rel="stylesheet" href="/TurismoEnElMundoMarvel_Webapp/assets/stylesheets/IndexStylesheet.css">
</head>

<body>

	<jsp:include page="partials/nav.jsp"></jsp:include>
		<main class="container">
		<div class="bg-dark p-2 rounded"> 
	<h1 class="basic_text" style=font-size:2rem>
				¡Bienvenido,
				<c:out value="${usuario.getUsername()}" />
				!
			</h1>
			</div>
			</main>
	<jsp:include page="/PreLogin.jsp"></jsp:include>
</body>
</html>