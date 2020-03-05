<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/freelancer.min.css" rel="stylesheet">

<style>
* {
	box-sizing: border-box;
}

body {
	font: 16px Arial;
}

/*the container must be positioned relative:*/
.autocomplete {
	position: relative;
	display: inline-block;
}

input {
	border: 1px solid transparent;
	background-color: #f1f1f1;
	padding: 10px;
	font-size: 16px;
	border-radius: 50px;
}

input[type=text] {
	background-color: #f1f1f1;
	width: 100%;
}

input[type=submit] {
	background-color: DodgerBlue;
	color: #fff;
	cursor: pointer;
}

.autocomplete-items {
	position: absolute;
	border: 1px solid #d4d4d4;
	border-bottom: none;
	border-top: none;
	font-size: 16px;
	z-index: 99;
	/*position the autocomplete items to be the same width as the container:*/
	top: 100%;
	left: 0;
	right: 0;
}

.autocomplete-items div {
	padding: 10px;
	cursor: pointer;
	color: black;
	background-color: #fff;
	border-bottom: 1px solid #d4d4d4;
}

/*when hovering an item:*/
.autocomplete-items div:hover {
	background-color: #e9e9e9;
}

/*when navigating through the items using the arrow keys:*/
.autocomplete-active {
	background-color: DodgerBlue !important;
	color: #ffffff;
}s
</style>
</head>

<body id="page-top" onload="select()">

	<!-- Navigation -->
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">Start
				Bootstrap</a>
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
						href="#about">About</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="#contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Masthead -->
	<header class="masthead bg-primary text-white text-center">
		<div class="container d-flex align-items-center flex-column">

			<!-- Masthead Avatar Image -->
			<img class="masthead-avatar mb-5" src="img/avataaars.svg" alt="">

			<!-- Masthead Heading -->
			<h1 class="masthead-heading text-uppercase mb-0">
				<form autocomplete="off" action="MovieSelect">
					<div class="autocomplete" style="width: 300px;">
						<input id="myInput" type="text" name="mname" placeholder="search">
					</div>
					<input type="submit" value="검색">
				</form>
			</h1>

			<!-- Icon Divider -->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>

			<!-- Masthead Subheading -->
			<p class="masthead-subheading font-weight-light mb-0">Graphic
				Artist - Web Designer - Illustrator</p>

		</div>
	</header>

	<!-- Portfolio Section -->
	<section class="page-section portfolio" id="portfolio">
		<div class="container">

			<!-- Portfolio Section Heading -->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0">인기영화
				Best3</h2>

			<!-- Icon Divider -->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>

			<!-- Portfolio Grid Items -->
			<div class="row">
				<c:forEach var="best" items="${best}">

					<!-- Portfolio Item 1 -->
					<div class="col-md-6 col-lg-4">
						<div class="portfolio-item mx-auto" data-toggle="modal"
							data-target="#portfolioModal${best.count}">
							<div
								class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
								<div
									class="portfolio-item-caption-content text-center text-white">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div>
							<img class="img-fluid" src="fileUpload/${best.photo1}" alt="">
						</div>
					</div>
				</c:forEach>

			</div>
			<!-- /.row -->

		</div>
	</section>

	<!-- About Section -->

	<!-- Copyright Section -->
	<section class="copyright py-4 text-center text-white">
		<div class="container">
			<small>Copyright &copy; Your Website 2020</small>
		</div>
	</section>

	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
	<div class="scroll-to-top d-lg-none position-fixed ">
		<a class="js-scroll-trigger d-block text-center text-white rounded"
			href="#page-top"> <i class="fa fa-chevron-up"></i>
		</a>
	</div>

	<!-- Portfolio Modals -->

	<c:forEach var="best" items="${best}">
		<!-- Portfolio Modal 1 -->
		<div class="portfolio-modal modal fade"
			id="portfolioModal${best.count}" tabindex="-1" role="dialog"
			aria-labelledby="portfolioModal1Label" aria-hidden="true">
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
										class="portfolio-modal-title text-secondary text-uppercase mb-0">${best.boardtitle}</h2>
									<!-- Icon Divider -->
									<div class="divider-custom">
										<div class="divider-custom-line"></div>
										<div class="divider-custom-icon">
											<i class="fas fa-star"></i>
										</div>
										<div class="divider-custom-line"></div>
									</div>
									<!-- Portfolio Modal - Image -->

									<!-- Portfolio Modal - Text -->
									<iframe src="MovieSelect?mname=${best.boardtitle}" width=100%
										height="500px"></iframe>
									<p class="mb-5">${best.text}</p>

									<iframe src="boardListPaging?mnum=${best.boardnumber}"
										width=100% height="500px"></iframe>
									<button class="btn btn-primary" href="#" data-dismiss="modal">
										<i class="fas fa-times fa-fw"></i> 취소
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>



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


	<!--Make sure the form has the autocomplete function switched off:-->


	<script>
		function autocomplete(inp, arr) {
			/*the autocomplete function takes two arguments,
			the text field element and an array of possible autocompleted values:*/
			var currentFocus;
			/*execute a function when someone writes in the text field:*/
			inp.addEventListener(
							"input",
							function(e) {
								var a, b, i, val = this.value;
								/*close any already open lists of autocompleted values*/
								closeAllLists();
								if (!val) {
									return false;
								}
								currentFocus = -1;
								/*create a DIV element that will contain the items (values):*/
								a = document.createElement("DIV");
								a.setAttribute("id", this.id
										+ "autocomplete-list");
								a.setAttribute("class", "autocomplete-items");
								/*append the DIV element as a child of the autocomplete container:*/
								this.parentNode.appendChild(a);
								/*for each item in the array...*/
								for (i = 0; i < arr.length; i++) {
									/*check if the item starts with the same letters as the text field value:*/
									if (arr[i].substr(0, val.length)
											.toUpperCase() == val.toUpperCase()) {
										/*create a DIV element for each matching element:*/
										b = document.createElement("DIV");
										/*make the matching letters bold:*/
										b.innerHTML = "<strong>"
												+ arr[i].substr(0, val.length)
												+ "</strong>";
										b.innerHTML += arr[i]
												.substr(val.length);
										/*insert a input field that will hold the current array item's value:*/
										b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
										/*execute a function when someone clicks on the item value (DIV element):*/
										b
												.addEventListener(
														"click",
														function(e) {
															/*insert the value for the autocomplete text field:*/
															inp.value = this
																	.getElementsByTagName("input")[0].value;
															/*close the list of autocompleted values,
															(or any other open lists of autocompleted values:*/
															closeAllLists();
														});
										a.appendChild(b);
									}
								}
							});
			/*execute a function presses a key on the keyboard:*/
			inp.addEventListener("keydown", function(e) {
				var x = document.getElementById(this.id + "autocomplete-list");
				if (x)
					x = x.getElementsByTagName("div");
				if (e.keyCode == 40) {
					/*If the arrow DOWN key is pressed,
					increase the currentFocus variable:*/
					currentFocus++;
					/*and and make the current item more visible:*/
					addActive(x);
				} else if (e.keyCode == 38) { //up
					/*If the arrow UP key is pressed,
					decrease the currentFocus variable:*/
					currentFocus--;
					/*and and make the current item more visible:*/
					addActive(x);
				} else if (e.keyCode == 13) {
					/*If the ENTER key is pressed, prevent the form from being submitted,*/
					e.preventDefault();
					if (currentFocus > -1) {
						/*and simulate a click on the "active" item:*/
						if (x)
							x[currentFocus].click();
					}
				}
			});
			function addActive(x) {
				/*a function to classify an item as "active":*/
				if (!x)
					return false;
				/*start by removing the "active" class on all items:*/
				removeActive(x);
				if (currentFocus >= x.length)
					currentFocus = 0;
				if (currentFocus < 0)
					currentFocus = (x.length - 1);
				/*add class "autocomplete-active":*/
				x[currentFocus].classList.add("autocomplete-active");
			}
			function removeActive(x) {
				/*a function to remove the "active" class from all autocomplete items:*/
				for (var i = 0; i < x.length; i++) {
					x[i].classList.remove("autocomplete-active");
				}
			}
			function closeAllLists(elmnt) {
				/*close all autocomplete lists in the document,
				except the one passed as an argument:*/
				var x = document.getElementsByClassName("autocomplete-items");
				for (var i = 0; i < x.length; i++) {
					if (elmnt != x[i] && elmnt != inp) {
						x[i].parentNode.removeChild(x[i]);
					}
				}
			}
			/*execute a function when someone clicks in the document:*/
			document.addEventListener("click", function(e) {
				closeAllLists(e.target);
			});
		}

		/*An array containing all the country names in the world:*/
		var countries = [ "" ];

		<c:forEach var="member" items="${select}">
		countries.push("${member.boardtitle}");
		</c:forEach>

		function select() {
			if (!'${requestScope.select}') {
				location.href = "MovieSearch";

			} else {

			}
		}
		/*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
		autocomplete(document.getElementById("myInput"), countries);

		//Get the modal
		var modal = document.getElementById('id01');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

</body>
</html>