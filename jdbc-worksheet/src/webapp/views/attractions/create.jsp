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

		<c:if test="${atraccion != null && !atraccion.esValida()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al crear la atracción.</p>
			</div>
		</c:if>
<c:if test="${success != null}">
				<div class="alert alert-success">
					<p>
						<c:out value="${success}" />
					</p>
				</div>
			</c:if>
		<form action="/TurismoEnElMundoMarvel_Webapp/attractions/create.do" method="post">
			<jsp:include page="/views/attractions/form.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>
