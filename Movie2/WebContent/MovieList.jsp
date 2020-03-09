<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<style>
div {
	border-radius: 10px;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#id1 td, th {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Freelancer - Start Bootstrap Theme</title>

<!-- Custom fonts for this theme -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Theme CSS -->
<link href="css/freelancer.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Navigation -->
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top"
				onclick="location.href='search.jsp'">Movie grade</a>
			<button
				class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">


					<c:choose>
						<c:when test="${!empty sessionScope.id}">
							<li class="nav-item mx-0 mx-lg-1"><a
								class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
								href="Logout">Logout</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item mx-0 mx-lg-1"><a
								class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
								href="Login.jsp">Login</a></li>
						</c:otherwise>
					</c:choose>
					<c:if test="${sessionScope.id eq 'rlagus2259'}">
						<li class="nav-item mx-0 mx-lg-1"><a
							class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							href="Admin.jsp">Admin</a></li>
					</c:if>
					<c:if test="${!empty sessionScope.id}">
						<li class="nav-item mx-0 mx-lg-1"><a
							class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							href="PasswordCheck?id=${sessionScope.id}">update</a></li>
					</c:if>

					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="#portfolio">best</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="#about">New Movie</a></li>
				</ul>
			</div>

		</div>
	</nav>

	<!-- Masthead -->
	<header class="masthead bg-primary text-white text-center">
		<div class="container d-flex align-items-center flex-column"></div>
	</header>

	<!-- Portfolio Section -->
	<section class="page-section portfolio" id="portfolio">
		<div class="container">

			<!-- Portfolio Section Heading -->

			<!-- Icon Divider -->
			<!-- Portfolio Grid Items -->
			<div class="row">

				<table table id="id1">
					<tr>
						<th>영화제목</th>
						<th>메인포토</th>
						<th>영화내용</th>

					</tr>
					<c:forEach var="movie" items="${selectMovie}">
						<tr>
							<td><a href="boardListPaging?mname=${movie.boardtitle}">${movie.boardtitle}</a></td>
							<td><img src="fileUpload/${movie.photo}" max-width="300px" max-height="300px"></td>
							<td>${movie.text}</td>

						</tr>
					</c:forEach>
				</table>



				<div id="pageOrder">
					<!-- 페이징 처리 -->
					<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>
					<c:if test="${paging.page>1}">
						<a href="Movies?page=${paging.page-1}&mname=${requestScope.mname}">[이전]</a>&nbsp;
	</c:if>
					<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
						var="i" step="1">
						<c:choose>
							<c:when test="${i eq paging.page}">
			${i}
		</c:when>
							<c:otherwise>
								<a href="Movies?page=${i}&mname=${requestScope.mname}">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${paging.page>=paging.maxPage}">
[다음]
</c:if>
					<c:if test="${paging.page<paging.maxPage}">
						<a href="Movies?page=${paging.page+1}&mname=${requestScope.mname}">[다음]</a>
					</c:if>
				</div>
				<!-- /.row -->

			</div>
	</section>

	<!-- About Section -->

	<!-- Copyright Section -->
	<section class="copyright py-4 text-center text-white">
		<div class="container">
			<small>Copyright &copy; Your Website 2019</small>
		</div>
	</section>

	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
	<div class="scroll-to-top d-lg-none position-fixed ">
		<a class="js-scroll-trigger d-block text-center text-white rounded"
			href="#page-top"> <i class="fa fa-chevron-up"></i>
		</a>
	</div>

	<!-- Portfolio Modals -->

	<!-- Portfolio Modal 1 -->
	<div class="portfolio-modal modal fade" id="portfolioModal1"
		tabindex="-1" role="dialog" aria-labelledby="portfolioModal1Label"
		aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">

				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true"> <i class="fas fa-times"></i>
					</span>
				</button>
				<div class="modal-body text-center">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<!-- Portfolio Modal - Title -->
								<h2
									class="portfolio-modal-title text-secondary text-uppercase mb-0">Log
									Cabin</h2>
								<!-- Icon Divider -->
								<div class="divider-custom">
									<div class="divider-custom-line"></div>
									<div class="divider-custom-icon">
										<i class="fas fa-star"></i>
									</div>
									<div class="divider-custom-line"></div>
								</div>
								<!-- Portfolio Modal - Image -->
								<img class="img-fluid rounded mb-5"
									src="img/portfolio/cabin.png" alt="">
								<!-- Portfolio Modal - Text -->
								<p class="mb-5">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Mollitia neque assumenda ipsam nihil,
									molestias magnam, recusandae quos quis inventore quisquam velit
									asperiores, vitae? Reprehenderit soluta, eos quod consequuntur
									itaque. Nam.</p>
								<button class="btn btn-primary" href="#" data-dismiss="modal">
									<i class="fas fa-times fa-fw"></i> Close Window
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Portfolio Modal 3 -->
	<script>
		
	</script>


	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="js/jqBootstrapValidation.js"></script>
	<script src="js/contact_me.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/freelancer.min.js"></script>

</body>

</html>
