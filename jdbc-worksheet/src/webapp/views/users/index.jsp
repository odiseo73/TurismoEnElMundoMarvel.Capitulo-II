<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<link rel="stylesheet" href="/TurismoEnElMundoMarvel_Webapp/assets/stylesheets/viewStyle.css">
 <title>Usuarios</title>
</head>
<body class="body_users">

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

		<div class="bg-dark p-1 mb-1 rounded">
			<p class="subtitle_text">Usuarios</p>
		</div>

		<c:if test="${usuario.esAdmin()}">
			<div class="mb-3">
				<a href="/TurismoEnElMundoMarvel_Webapp/users/create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nuevo Usuario
				</a>
			</div>
		</c:if>
		<table class="table table-dark table-stripped table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Monedas</th>
					<th>Tiempo</th>
					<th>Rol</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="tmp_user">
					<tr>
						<td><strong><c:out value="${tmp_user.getUsername()}"></c:out></strong></td>
						<td><c:out value="${tmp_user.getDinero()}"></c:out></td>
						<td><c:out value="${tmp_user.getTiempoEnHoras()}"></c:out></td>
						<td>
							<c:choose>
								<c:when test="${tmp_user.esAdmin()}">
									Admin
								</c:when>
								<c:otherwise>
									Normal
								</c:otherwise>
							</c:choose>						
						</td>
						<td><c:if test="${usuario.esAdmin() && (!tmp_user.esAdmin() || tmp_user.getId() == usuario.getId())}">
								<a href="/TurismoEnElMundoMarvel_Webapp/users/edit.do?id=${tmp_user.getId()}"
									class="btn btn-light rounded-0" role="button"><i
									class="bi bi-pencil-fill"></i></a>
								<a href="/TurismoEnElMundoMarvel_Webapp/users/delete.do?id=${tmp_user.getId()}"
									class="btn btn-danger rounded" role="button"><i
									class="bi bi-x-circle-fill"></i></a>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</main>

</body>
</html>