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

.column {
	vertical-align: middle;
}

/* Position the image container (needed to position the left and right arrows) */
.containerslide {
	position: relative;
	width: 100%;
}

/* Hide the images by default */
.mySlides {
	display: none;
}

.mySlides img {
	height: 300px;
}

.column img {
	height: 100px;
}

/* Add a pointer when hovering over the thumbnail images */
.cursor {
	cursor: pointer;
}

/* Next & previous buttons */
.prev {
	float: left;
	z-index: 1;
	cursor: pointer;
	width: auto;
	padding: 16px;
	margin-top: -200px;
	color: white;
	font-weight: bold;
	font-size: 20px;
	border-radius: 0 3px 3px 0;
	user-select: none;
	-webkit-user-select: none;
}

.next {
	float: right;
	z-index: 1;
	cursor: pointer;
	width: auto;
	padding: 16px;
	margin-top: -200px;
	color: white;
	font-weight: bold;
	font-size: 20px;
	border-radius: 0 3px 3px 0;
	user-select: none;
	-webkit-user-select: none;
}

/* Position the "next button" to the right */
.next {
	right: 0;
	border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
	background-color: rgba(0, 0, 0, 0.8);
}

/* Number text (1/3 etc) */
.numbertext {
	color: #f2f2f2;
	font-size: 12px;
	padding: 8px 12px;
	position: absolute;
	top: 0;
}

/* Container for image text */
.caption-containerslide {
	text-align: center;
	background-color: #222;
	padding: 2px 16px;
	color: white;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Six columns side by side */
.column {
	float: left;
	width: 16.66%;
}

/* Add a transparency effect for thumnbail images */
.demo {
	opacity: 0.6;
}

.active, .demo:hover {
	opacity: 1;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#id1 td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

#star_grade a {
	text-decoration: none;
	color: gray;
}

#star_grade a.on {
	color: red;
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
		<div class="container d-flex align-items-center flex-column">
			<c:forEach var="sld" items="${select}">

				<div class="containerslide">
					<div class="mySlides">
						<div class="numbertext">1 / 6</div>
						<img src="fileUpload/${sld.photo}" style="width: 100%">
					</div>

					<div class="mySlides">
						<div class="numbertext">2 / 6</div>
						<img src="fileUpload/${sld.photo1}" style="width: 100%">
					</div>

					<div class="mySlides">
						<div class="numbertext">3 / 6</div>
						<img src="fileUpload/${sld.photo2}" style="width: 100%">
					</div>

					<div class="mySlides">
						<div class="numbertext">4 / 6</div>
						<img src="fileUpload/${sld.photo3}" style="width: 100%">
					</div>

					<div class="mySlides">
						<div class="numbertext">5 / 6</div>
						<img src="fileUpload/${sld.photo4}" style="width: 100%">
					</div>

					<div class="mySlides">
						<div class="numbertext">6 / 6</div>
						<img src="fileUpload/${sld.photo5}" style="width: 100%">
					</div>

					<a class="prev" onclick="plusSlides(-1)">❮</a> <a class="next"
						onclick="plusSlides(1)">❯</a>

					<div class="caption-container">
						<p id="caption"></p>
					</div>

					<div class="row">
						<div class="column">
							<img class="demo cursor" src="fileUpload/${sld.photo}"
								style="width: 100%" onclick="currentSlide(1)">
						</div>
						<div class="column">
							<img class="demo cursor" src="fileUpload/${sld.photo1}"
								style="width: 100%" onclick="currentSlide(2)">
						</div>
						<div class="column">
							<img class="demo cursor" src="fileUpload/${sld.photo2}"
								style="width: 100%" onclick="currentSlide(3)">
						</div>
						<div class="column">
							<img class="demo cursor" src="fileUpload/${sld.photo3}"
								style="width: 100%" onclick="currentSlide(4)">
						</div>
						<div class="column">
							<img class="demo cursor" src="fileUpload/${sld.photo4}"
								style="width: 100%" onclick="currentSlide(5)">
						</div>
						<div class="column">
							<img class="demo cursor" src="fileUpload/${sld.photo5}"
								style="width: 100%" onclick="currentSlide(6)">
						</div>
					</div>
					${sld.text}
				</div>


			</c:forEach>
			<br>
			<h1>평점:${requestScope.score}</h1>
			<c:if test="${requestScope.Chance eq 'no'}">
				<i class="far fa-heart" onclick="symplus()">${requestScope.Sympathy}</i>
			</c:if>
			<c:if test="${requestScope.Chance eq 'yes'}">
				<i class="fas fa-heart" onclick="symminus()">${requestScope.Sympathy}</i>
			</c:if>


		</div>
	</header>

	<!-- Portfolio Section -->
	<section class="page-section portfolio" id="portfolio">
		<div class="container">

			<!-- Portfolio Section Heading -->

			<!-- Icon Divider -->
			<!-- Portfolio Grid Items -->
			<div class="row">

				<c:if test="${!empty sessionScope.id}">
					<table>
						<tr>
							<td>
								<form action="CommentWrite" id="ComCheck">
									<input id="id1" name="score" readonly h type="hidden">
									<input type="hidden" value="${requestScope.mnum}" name="save">
									<input type="hidden" value="${requestScope.mname}" name="mname">

									<p id="star_grade">
										<a href="#" onclick="stars('1')">★</a> <a href="#"
											onclick="stars('2')">★</a> <a href="#" onclick="stars('3')">★</a>
										<a href="#" onclick="stars('4')">★</a> <a href="#"
											onclick="stars('5')">★</a>
									</p>
							</td>
							<td><textarea minlength="5" style="resize: none" name="text"
									cols="65" rows="3" value="${member.text}"></textarea></td>
							<td><input type="button" onclick="CommentCheck()" value="작성">
								</form></td>
							<br>
							<p id="ComChecks"></p>
						</tr>
					</table>
				</c:if>
				<table>
					<tr>
						<td>
							<form action="boardListPaging">
								<input type="hidden" value="${requestScope.mnum}" name="mnum">
								<input type="hidden" value="${requestScope.mname}" name="mname">
								<input type="hidden" value="베댓순" name="filters"> <input
									type="submit" value="베댓">
							</form>

						</td>
						<td>
							<form action="boardListPaging">
								<input type="hidden" value="${requestScope.mnum}" name="mnum">
								<input type="hidden" value="${requestScope.mname}" name="mname">

								<input type="hidden" value="최신순" name="filters"> <input
									type="submit" value="최신순">
							</form>
						</td>
					</tr>
				</table>

				<table table id="id1">
				<tr>
<th>회원아이디</th>
<th>댓글내용</th>
<th>평점</th>
<th>작성시간</th>
<th>좋아요</th>
<th>싫어요</th>
				</tr>
					<c:forEach var="member" items="${selectComment}">
						<tr>
							<td>${member.id}</td>
							<td>${member.text}</td>
							<td>평점:${member.score}</td>
							<td>${member.cdate}</td>




							<td><c:choose>
									<c:when test="${member.gchance eq 'NO'}">
										<i class="far fa-thumbs-up" onclick="good('${member.bnum}')">${member.gcnum}</i>
									</c:when>
									<c:otherwise>
										<i class="fas fa-thumbs-up" onclick="good('${member.bnum}')">${member.gcnum}</i>
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${member.mchance eq 'NO'}">
										<i class="far fa-thumbs-up" onclick="Minus('${member.bnum}')">${member.mcnum}</i>
									</c:when>
									<c:otherwise>
										<i class="fas fa-thumbs-up" onclick="Minus('${member.bnum}')">${member.mcnum}</i>
									</c:otherwise>
								</c:choose></td>
							<c:if test="${sessionScope.id eq member.id}">
								<td><a
									href="CommentDelete?bnum=${member.bnum}&page=${paging.page}&mnum=${requestScope.mnum}">삭제</a>
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</table>



				<div id="pageOrder">
					<!-- 페이징 처리 -->
					<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>
					<c:if test="${paging.page>1}">
						<a
							href="boardListPaging?page=${paging.page-1}&filters=${requestScope.filters}&search=${requestScope.search}&mnum=${requestScope.mnum}&mname=${requestScope.mname}">[이전]</a>&nbsp;
	</c:if>
					<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
						var="i" step="1">
						<c:choose>
							<c:when test="${i eq paging.page}">
			${i}
		</c:when>
							<c:otherwise>
								<a
									href="boardListPaging?page=${i}&filters=${requestScope.filters}&search=${requestScope.search}&mnum=${requestScope.mnum}&mname=${requestScope.mname}">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${paging.page>=paging.maxPage}">
[다음]
</c:if>
					<c:if test="${paging.page<paging.maxPage}">
						<a
							href="boardListPaging?page=${paging.page+1}&filters=${requestScope.filters}&search=${requestScope.search}&mnum=${requestScope.mnum}&mname=${requestScope.mname}">[다음]</a>
					</c:if>
					<form action="boardListPaging">
						<select name="filters">
							<option value="작성자">작성자</option>
							<option value="글내용">글내용</option>
						</select><input type="text" name="search"> <input type="hidden"
							name="mnum" value="${requestScope.mnum}" readonly> <input
							type="submit">
					</form>


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
		var slideIndex = 1;
		showSlides(slideIndex);

		var save = 0;
		function good(result) {
		
			var retry = result;
			if (!'${sessionScope.id}') {
				alert('로그인후 이용하세요');
			} else {

				location.href = "GoodPlus?bnum=" + retry
						+ "&page=${paging.page}&mnum=${requestScope.mnum}&mname=${requestScope.mname}";
			}

		}

		function Minus(result) {
			console.log(result);
			var retry = result;
			if (!'${sessionScope.id}') {
				alert('로그인후 이용하세요');
			} else {
				location.href = "MinusPlus?bnum=" + retry
						+ "&page=${paging.page}&mnum=${requestScope.mnum}&mname=${requestScope.mname}";
			}

		}

		function stars(s) {
			save = s;
			document.getElementById("id1").value = save;
		}

		$('#star_grade a').click(function() {

			$(this).parent().children("a").removeClass("on"); /* 별점의 on 클래스 전부 제거 */
			$(this).addClass("on").prevAll("a").addClass("on"); /* 클릭한 별과, 그 앞 까지 별점에 on 클래스 추가 */
			return false;
		});

		function CommentCheck() {
			if (save != 0) {
				document.getElementById("ComCheck").submit();
			} else {
				document.getElementById("ComChecks").innerHTML = "평점을 매겨주세요"

			}
		}

		function plusSlides(n) {
			showSlides(slideIndex += n);
		}

		function currentSlide(n) {
			showSlides(slideIndex = n);
		}

		function showSlides(n) {
			var i;
			var slides = document.getElementsByClassName("mySlides");
			var dots = document.getElementsByClassName("demo");
			var captionText = document.getElementById("caption");
			if (n > slides.length) {
				slideIndex = 1
			}
			if (n < 1) {
				slideIndex = slides.length
			}
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			for (i = 0; i < dots.length; i++) {
				dots[i].className = dots[i].className.replace(" active", "");
			}
			slides[slideIndex - 1].style.display = "block";
			dots[slideIndex - 1].className += " active";
			captionText.innerHTML = dots[slideIndex - 1].alt;
		}

		function symplus() {
			if (!'${sessionScope.id}') {
				alert('로그인후 이용하세요');

			} else {
				location.href = "SympathyPlus?mnum=${requestScope.mnum}&mname=${requestScope.mname}";

			}
		}
		function symminus() {

			if (!'${sessionScope.id}') {
				alert('로그인후 이용하세요');

			} else {
				location.href = "SympathyMinus?mnum=${requestScope.mnum}&mname=${requestScope.mname}";

			}

		}
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
