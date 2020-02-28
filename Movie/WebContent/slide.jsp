<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://kit.fontawesome.com/bad24df0ae.js"
	crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	font-family: Arial;
	margin: 0;
}

* {
	box-sizing: border-box;
}

.column {
	vertical-align: middle;
}

/* Position the image container (needed to position the left and right arrows) */
.container {
	position: relative;
}

/* Hide the images by default */
.mySlides {
	display: none;
}

/* Add a pointer when hovering over the thumbnail images */
.cursor {
	cursor: pointer;
}

/* Next & previous buttons */
.prev, .next {
	cursor: pointer;
	position: absolute;
	top: 40%;
	width: auto;
	padding: 16px;
	margin-top: -50px;
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
.caption-container {
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
</style>
</head>
<body>

	<h2 style="text-align: center">Slideshow Gallery</h2>
	<c:forEach var="member" items="${select}">
		<div class="container">
			<div class="mySlides">
				<div class="numbertext">1 / 6</div>
				<img src="fileUpload/${member.photo}" width="100%" height="100px"
					id="img1">

			</div>

			<div class="mySlides">
				<div class="numbertext">2 / 6</div>
				<img src="fileUpload/${member.photo1}" width="100%" height="100px"
					id="img2">
			</div>

			<div class="mySlides">
				<div class="numbertext">3 / 6</div>
				<img src="fileUpload/${member.photo2}" width="100%" height="100px"
					id="img3">
			</div>

			<div class="mySlides">
				<div class="numbertext">4 / 6</div>
				<img src="fileUpload/${member.photo3}" width="100%" height="100px"
					id="img4">
			</div>

			<div class="mySlides">
				<div class="numbertext">5 / 6</div>
				<img src="fileUpload/${member.photo4}" width="100%" height="100px"
					id="img5">
			</div>

			<div class="mySlides">
				<div class="numbertext">6 / 6</div>
				<img src="fileUpload/${member.photo5}" width="100%" height="100px"
					id="img6">
			</div>

			<a class="prev" onclick="plusSlides(-1)">❮</a> <a class="next"
				onclick="plusSlides(1)">❯</a>

			<div class="caption-container">
				<p id="caption"></p>
			</div>

			<div class="row">
				<div class="column">
					<img class="demo cursor" src="fileUpload/${member.photo}"
						style="width: 100%" onclick="currentSlide(1)" alt="The Woods">
				</div>
				<div class="column">
					<img class="demo cursor" src="fileUpload/${member.photo1}"
						style="width: 100%" onclick="currentSlide(2)" alt="Cinque Terre">
				</div>
				<div class="column">
					<img class="demo cursor" src="fileUpload/${member.photo2}"
						style="width: 100%" onclick="currentSlide(3)"
						alt="Mountains and fjords">
				</div>
				<div class="column">
					<img class="demo cursor" src="fileUpload/${member.photo3}"
						style="width: 100%" onclick="currentSlide(4)"
						alt="Northern Lights">
				</div>
				<img class="demo cursor" src="fileUpload/${member.photo4}"
					style="width: 100%" onclick="currentSlide(5)"
					alt="Nature and sunrise">
				<div class="column"></div>
				<div class="column">
					<img class="demo cursor" src="fileUpload/${member.photo5}"
						style="width: 100%" onclick="currentSlide(6)"
						alt="Snowy Mountains">
				</div>
			</div>
		</div>
		<div></div>
		<div>
			<c:if test="${requestScope.Chance eq 'no'}">
				<i class="far fa-heart"
					onclick="location.href='SympathyPlus?mnum=${requestScope.mnum}&mname=${requestScope.mname}'">${requestScope.Sympathy}</i>
			</c:if>
			<c:if test="${requestScope.Chance eq 'yes'}">
				<i class="fas fa-heart"
					onclick="location.href='SympathyMinus?mnum=${requestScope.mnum}&mname=${requestScope.mname}'">${requestScope.Sympathy}</i>
			</c:if>
${requestScope.score}
		</div>
		<c:if test="${sessionScope.id eq 'rlagus2259'}">
			<a href="UpdateTextSelect?boardnumber=${member.boardnumber}">수정하기</a>
			<a href="BoardTextDelete?mnum=${member.boardnumber}">삭제하기</a>

		</c:if>
		<iframe src="boardListPaging?mnum=${member.boardnumber}" width=100%
			height="500px"></iframe>
	</c:forEach>




	<script>


var slideIndex = 1;
showSlides(slideIndex);

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
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
  captionText.innerHTML = dots[slideIndex-1].alt;
}


		




</script>

</body>
</html>