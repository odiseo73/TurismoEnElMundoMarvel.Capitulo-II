<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<link rel="stylesheet"
	href="/TurismoEnElMundoMarvel_Webapp/assets/stylesheets/viewStyle.css">
	 <title>Atracciones</title>
</head>
<body class="body_atr">
<jsp:include page="/partials/nav.jsp"></jsp:include>
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
		<c:if test="${success != null}">
				<div class="alert alert-success">
					<p>
						<c:out value="${success}" />
					</p>
				</div>
			</c:if>
		<div class="bg-dark p-1 mb-1 rounded">
			<p class="subtitle_text">Atracciones</p>
		</div>

		<c:if test="${usuario.esAdmin()}">
			<div class="mb-3">
				<a href="/TurismoEnElMundoMarvel_Webapp/attractions/create.do"
					class="btn btn-primary" role="button"> <i class="bi bi-plus-lg"></i>
					Nueva Atracción
				</a>
			</div>
		</c:if>
		<table class="table table-dark table-stripped table-hover" style=opacity:90%>
			<thead>
				<tr>
					<th>Atracci&oacute;n</th>
					<th>Costo</th>
					<th>Duraci&oacute;n</th>
					<th>Cupo Disponible</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${atracciones}" var="atraccion">
					<tr>
						<td><strong><c:out value="${atraccion.getNombre()}"></c:out></strong>
							<p><c:out value="${atraccion.getDescripcion()}"></c:out></p></td>
						<td><c:out value="${atraccion.getPrecio()}"></c:out></td>
						<td><c:out value="${atraccion.getTiempoEnHoras()}"></c:out></td>
						<td><c:out value="${atraccion.getCupoDisponible()}"></c:out></td>

						<td><c:if test="${usuario.esAdmin()}">
								<a
									href="/TurismoEnElMundoMarvel_Webapp/attractions/edit.do?id=${atraccion.getId()}"
									class="btn btn-light rounded-0" role="button"><i
									class="bi bi-pencil-fill"></i></a>
								<a
									href="/TurismoEnElMundoMarvel_Webapp/attractions/delete.do?id=${atraccion.getId()}"
									class="btn btn-danger rounded" role="button"><i
									class="bi bi-x-circle-fill"></i></a>
							</c:if> <c:choose>

								<c:when
									test="${usuario.tieneDinero(atraccion)	&& usuario.tieneTiempo(atraccion) && !usuario.tieneComprado(atraccion) &&
									 atraccion.verificarCupo()}">
									<a
										href="/TurismoEnElMundoMarvel_Webapp/attractions/buy.do?id=${atraccion.getId()}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button">Comprar</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</main>

</body>
</html>