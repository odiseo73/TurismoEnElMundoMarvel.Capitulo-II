<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

		<c:if test="${Usuario != null && !usuario.esValido()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al crear el usuario.</p>
			</div>
		</c:if>

		<form action="/TurismoEnElMundoMarvel_Webapp/users/create.do" method="post">
			<jsp:include page="/views/users/form.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>
