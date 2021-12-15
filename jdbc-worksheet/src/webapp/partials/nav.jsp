<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
	<div class="container">
		<a class="navbar-brand"
			href="/TurismoEnElMundoMarvel_Webapp/index.jsp">Turismo en el
			Mundo Marvel</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav me-auto mb-2 mb-md-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page"
					href="/TurismoEnElMundoMarvel_Webapp/attractions/index.do">Atracciones</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page"
					href="/TurismoEnElMundoMarvel_Webapp/promotions/index.do">Promociones</a></li>
				<c:if test="${usuario.esAdmin()}">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="/TurismoEnElMundoMarvel_Webapp/users/index.do">Usuarios</a></li>
							<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="/TurismoEnElMundoMarvel_Webapp/itineraries/index.do">Itinerarios</a></li>
				</c:if>
				<c:if test="${!usuario.esAdmin()}">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page"
					href="/TurismoEnElMundoMarvel_Webapp/itinerary/index.do">Itinerario</a></li>
					</c:if>
			</ul>

			<ul class="navbar-nav">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<c:out value="${usuario.getUsername()}"></c:out>
				</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item disabled" style="color: black;">
								<i title="monedas" style="color: gold;" class="bi bi-coin"></i>
								<c:out value="${usuario.getDinero()}"></c:out>
						</a></li>
						<li><a class="dropdown-item disabled" style="color: black;">
								<i title="tiempo" style="color: blue;" class="bi bi-clock-fill"></i>
								<c:out value="${usuario.getTiempoEnHoras()}h"></c:out>
						</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a href="/TurismoEnElMundoMarvel_Webapp/logout"
							class="dropdown-item">Salir</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>
