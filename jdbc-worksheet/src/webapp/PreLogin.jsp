<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/TurismoEnElMundoMarvel_Webapp/assets/stylesheets/IndexStylesheet.css">
<title>Inicio</title>
</head>
<body>
	<div id="mainCarousel" class="carousel slide" data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#mainCarousel"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#mainCarousel"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#mainCarousel"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active" data-bs-interval="3000">
				<img src="/TurismoEnElMundoMarvel_Webapp/assets/img/Inicio/img1.png"
					class="rounded mx-auto d-block" alt="Mundo Marvel">
				<div class="carousel-caption d-none d-md-block">
					<h5 class="phrase_text">Todo lo que soñaste, en un solo lugar</h5>
				</div>
			</div>
			<div class="carousel-item" data-bs-interval="3000">
				<img src="/TurismoEnElMundoMarvel_Webapp/assets/img/Inicio/pic4.png"
					class="rounded mx-auto d-block" alt="Mundo Marvel">
				<div class="carousel-caption d-none d-md-block"></div>
			</div>
			<div class="carousel-item" data-bs-interval="3000">
				<img src="/TurismoEnElMundoMarvel_Webapp/assets/img/Inicio/spider.png"
					class="rounded mx-auto d-block" alt="Mundo Marvel">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#mainCarousel" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#mainCarousel" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>


	<div class="container">

		<h1 class="title_text">Explora los diferentes paquetes</h1>
		<div id="carouselExampleControls" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active" data-bs-interval="2000">
					<a target="_self"
						href="/TurismoEnElMundoMarvel_Webapp/promotions/index.do"><img
						src="/TurismoEnElMundoMarvel_Webapp/assets/img/Promos/packinfinity.png"
						class="w3-hover-opacity"></a>
				</div>
				<div class="carousel-item" data-bs-interval="2000">
					<a target="_self"
						href="/TurismoEnElMundoMarvel_Webapp/promotions/index.do"><img
						src="/TurismoEnElMundoMarvel_Webapp/assets/img/Promos/packdark.png"
						class="w3-hover-opacity" alt="Infinity War Pack"></a>
				</div>
				<div class="carousel-item" data-bs-interval="2000">
					<a target="_self"
						href="/TurismoEnElMundoMarvel_Webapp/promotions/index.do"><img
						src="/TurismoEnElMundoMarvel_Webapp/assets/img/Promos/packcivil.png"
						class="w3-hover-opacity" alt="Civil War Pack"></a>

				</div>
				<div class="carousel-item" data-bs-interval="2000">
					<a target="_self"
						href="/TurismoEnElMundoMarvel_Webapp/promotions/index.do"><img
						src="/TurismoEnElMundoMarvel_Webapp/assets/img/Promos/packragnarok.png"
						class="w3-hover-opacity" alt="Ragnarok Pack"></a>

				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>

		<h1 class="title_text">Visita nuestras atracciones principales</h1>


		<hr class="featurette-divider">

		<div class="row featurette" style="background: #00695c">
			<div class="col-md-7">
				<h2 class="subtitle_text">Wakanda</h2>
				<p class="sub_phrase">"La Montaña de la Pantera"</p>
			 <p class="basic_text">Prepárate para recorrer la enorme Montaña
					de la Pantera en esta alucinante atracción acuática llena de
					emoción. En el camino te encontrarás con el mismo Pantera Negra y
					con los miembros de los distintos cultos de Wakanda. Pero tendrás
					que escapar de la furia de los secuaces de Thanos, además de otras
					criaturas de otra dimensión que se interpondrán en tu camino de
					regreso.</p>
			</div>
			<div class="col-md-5">
				<a target="_self"
					href="/TurismoEnElMundoMarvel_Webapp/attractions/index.do">
					<img class="w3-hover-opacity"
					src="/TurismoEnElMundoMarvel_Webapp/assets/img/Atracciones/wakanda.png"
					alt="Wakanda" width="400" height="300">
				</a>
			</div>

		</div>

		<hr class="featurette-divider">

		<div class="row featurette" style="background: #2d5466">
			<div class="col-md-7 order-md-2">
				<h2 class="subtitle_text">Reino Cuántico</h2>
				<p class="sub_phrase">"Viaje en el tiempo"</p>
				<p class="basic_text">Con la ayuda del Doctor Henry Pym deberás
					trabajar en su laboratorio y entrar en el Reino Cuántico para
					salvar a Ant-Man, que se encuentra perdido en el tiempo y el
					espacio. En este entretenido viaje de realidad aumentada podrás
					visitar distintas épocas y encontrarte con algunos de los
					vengadores a lo largo del tiempo.</p>
			</div>
			<div class="col-md-5 order-md-1">
			<a target="_self"
					href="/TurismoEnElMundoMarvel_Webapp/attractions/index.do">
				<img class="rounded"
					src="/TurismoEnElMundoMarvel_Webapp/assets/img/Atracciones/reinoCuantico.png"
					alt="Reino Cuántico" width="400" height="300">
					</a>
			</div>
		</div>

		<hr class="featurette-divider">


		<div class="row featurette" style="background: #1d4570">
			<div class="col-md-7">
				<h2 class="subtitle_text">Jotunheim</h2>
				<p class="sub_phrase">"El Reino de Hielo"</p>
				<p class="basic_text">Infíltrate en el mundo congelado, la
					tierra de los gigantes de hielo. Junto a Thor y Loki, deberás
					recorrer los túneles de la ciudad a alta velocidad, sin ser visto
					por los gigantes y llegar al palacio para ver la lucha final del
					rey de Jotunheim y los héroes asgardianos. ¡Ten cuidado con los
					ataques de las criaturas del reino!</p>
			</div>
			<div class="col-md-5">
			<a target="_self"
					href="/TurismoEnElMundoMarvel_Webapp/attractions/index.do">
				<img class="rounded"
					src="/TurismoEnElMundoMarvel_Webapp/assets/img/Atracciones/Jotunheim.png"
					alt="Asgard" width="400" height="300">
					</a>
			</div>
		</div>

		<h1 class="title_text1">Fundadores</h1>

		<div class="row">

			<div class="col-lg-4">
				<div class="w3-card-4" style="background: #616161">

					<header class="w3-container w3-light-grey">
						<h3>Fabaro Carolina</h3>
					</header>

					<div class="w3-container">
						<hr>
						<img src="/TurismoEnElMundoMarvel_Webapp/assets/img/Fundadores/Caro.jpg"
							alt="Avatar" class="rounded_image">
						<p class="basic_text">Curiosa del mundo informático. Docente.
							Autodidacta y terminando la Licenciatura en Música Popular en
							Canto. Mamá primeriza.</p>
					</div>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="w3-card-4" style="background: #616161">

					<header class="w3-container w3-light-grey">
						<h3>Mercado Luciano</h3>
					</header>

					<div class="w3-container">
						<hr>
						<img src="/TurismoEnElMundoMarvel_Webapp/assets/img/Fundadores/Luciano.jfif"
							alt="Avatar" class="rounded_image">
						<p class="basic_text">El crack del grupo, el pibe del pueblo
							que pide la gente</p>
					</div>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="w3-card-4" style="background: #616161">

					<header class="w3-container w3-light-grey">
						<h3>Vargas Emiliano</h3>
					</header>

					<div class="w3-container">
						<hr>
						<img src="/TurismoEnElMundoMarvel_Webapp/assets/img/Fundadores/Emi.png"
							alt="Avatar" class="rounded_image">
						<p class="basic_text">Intento de deportista y futuro profesor
							de Educación Física. Reciente ingreso al mundo de la
							programación.</p>
					</div>
				</div>
			</div>
			<hr>
			<div class="col-lg-4">
				<div class="w3-card-4" style="background: #616161">

					<header class="w3-container w3-light-grey">
						<h3>Miadosqui Martín</h3>
					</header>

					<div class="w3-container">
						<hr>
						<img src="/TurismoEnElMundoMarvel_Webapp/assets/img/Fundadores/Martin.jpeg"
							alt="Avatar" class="rounded_image">
						<p class="basic_text">Añadir descripción</p>
					</div>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="w3-card-4" style="background: #616161">

					<header class="w3-container w3-light-grey">
						<h3>Paladino Marcelo</h3>
					</header>

					<div class="w3-container">
						<hr>
						<img src="/TurismoEnElMundoMarvel_Webapp/assets/img/Fundadores/Marce.png"
							alt="Avatar" class="rounded_image">
						<p class="basic_text">Añadir descripción</p>
					</div>
				</div>
			</div>

			<div class="col-lg-4" style="margin-bottom: 12rem">
				<div class="w3-card-4" style="background: #616161">

					<header class="w3-container w3-light-grey">
						<h3>Druze Guillermo</h3>
					</header>

					<div class="w3-container">
						<hr>
						<img src="/TurismoEnElMundoMarvel_Webapp/assets/img/Fundadores/Guille.png"
							alt="Avatar" class="rounded_image">
						<p class="basic_text">Añadir descripción</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer class="container">
		<div class="d-flex justify-content-between py-4 my-4 border-top">
			<p style="color: white">&copy; 2021 Marvel World, Inc. Todos los
				derechos reservados.</p>
			<ul class="list-unstyled d-flex">
				<li class="ms-3"><a class="link-light"
					href="https://twitter.com/marvel_worldd?t=SGeQzTUgTq0NoHXDA8f1Ew&s=08"><svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-twitter" viewBox="0 0 16 16">
  <path
								d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z" />
</svg></a></li>
				<li class="ms-3"><a class="link-light"
					href="https://instagram.com/marvelworld.in?utm_medium=copy_link"><svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-instagram" viewBox="0 0 16 16">
  <path
								d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z" />
</svg></a></li>
				<li class="ms-3"><a class="link-light"
					href="https://www.facebook.com/MarvelWorld5/"><svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-facebook" viewBox="0 0 16 16">
  <path
								d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z" />
</svg></a></li>
			</ul>
		</div>
	</footer>
</body>
</html>