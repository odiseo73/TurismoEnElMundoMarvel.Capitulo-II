<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<jsp:include page="/partials/nav.jsp"></jsp:include>
<link rel="stylesheet"
	href="/TurismoEnElMundoMarvel_Webapp/assets/stylesheets/viewStyle.css">
	 <title>Itinerario</title>
</head>
<body class="body_iti">
	<main class="container">

		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errores != null}">
						<ul>
							<c:forEach items="${errores}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>

		<div class="bg-dark p-1 mb-1 rounded">
			<p class="subtitle_text">Itinerario</p>
		</div>

		<table class="table table-dark table-stripped table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Productos Comprados</th>
					<th>Horas necesarias para realizar el itinerario</th>
					<th>Puntos gastados para realizar el itinerario</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td><strong><c:out
								value="${itinerario.getUsername()}"></c:out></strong></td>
					<td><c:out value="${itinerario.getProductos()}"></c:out></td>
					<td><c:out value="${itinerario.getHorasNecesarias()}"></c:out></td>
					<td><c:out value="${itinerario.getPuntos()}"></c:out></td>
				</tr>

			</tbody>
		</table>

	</main>

</body>
</html>