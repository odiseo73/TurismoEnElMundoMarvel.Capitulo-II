<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="partials/head.jsp"></jsp:include>
<link rel="stylesheet" href="/TurismoEnElMundoMarvel_Webapp/assets/stylesheets/loginStyle.css">
 <title>Iniciar Sesión</title>
</head>
<body>
		<main>
			
			<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
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

			<form action="login" method="post">
  <h3>Iniciar sesión</h3>
				<div>
					<label for="username" class="form-label">Usuario</label> 
					<input class="form-control" type="text" name="username" placeholder="Usuario">
				</div>

				<div>
					<label for="password" class="form-label">Contraseña</label> 
					<input type="password" class="form-control" name="password" placeholder="Contraseña" >
				</div>

				<div>
					<button type="submit" class="btn btn-danger">Ingresar</button>
				</div>
			</form>

		</main>
</body>
</html>