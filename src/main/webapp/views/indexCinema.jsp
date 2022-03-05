<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Trang chủ</title>
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.css"
	rel="stylesheet" />
<style type="text/css">
.intro-2 {
	background:
		url("https://mdbootstrap.com/img/Photos/Others/img (51).jpg")
		no-repeat center center;
	background-size: cover;
}

.view {
	margin-top: -56px;
}

.navbar {
	z-index: 1;
}

html, body, header, .view {
	height: 100%;
}
</style>
</head>
<body style="background: rgb(86, 85, 89);">
	<jsp:include page="/views/nav.jsp"></jsp:include>
	<div class="container m-5">
		<h3 class="" style="color: red;">PHIM ĐỀ CỬ</h3>
	</div>
	<hr style="color: red;">
	<section class="container mb-5">
		<!-- Carousel wrapper -->
		<div id="carouselBasicExample" class="carousel slide carousel-fade"
			data-mdb-ride="carousel">
			<!-- Indicators -->
			<div class="carousel-indicators">
				<button type="button" data-mdb-target="#carouselBasicExample"
					data-mdb-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<button type="button" data-mdb-target="#carouselBasicExample"
					data-mdb-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-mdb-target="#carouselBasicExample"
					data-mdb-slide-to="2" aria-label="Slide 3"></button>
			</div>

			<!-- Inner -->
			<div class="carousel-inner">
				<!-- Single item -->
				<div class="carousel-item active">
					<img
						src="https://image.lag.vn/upload/news/21/04/19/review-conan-vien-dan-do-3_ILAE.jpg"
						class="d-block w-100" alt="Sunset Over the City" />
					<div class="carousel-caption d-none d-md-block">
						<h5>First slide label</h5>
						<p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
					</div>
				</div>

				<!-- Single item -->
				<div class="carousel-item">
					<img
						src="https://afamilycdn.com/150157425591193600/2021/2/11/14751884443497880450504831813681599361407354o-1613040377435808694470.jpg"
						class="d-block w-100" alt="Canyon at Nigh" />
					<div class="carousel-caption d-none d-md-block">
						<h5>Second slide label</h5>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
					</div>
				</div>
				<!-- Single item -->
				<div class="carousel-item">
					<img
						src="https://trainghiemso.vn/wp-content/uploads/2018/09/marvels-spider-man-review-featured.jpg"
						class="d-block w-100" alt="Cliff Above a Stormy Sea" />
					<div class="carousel-caption d-none d-md-block">
						<h5>Third slide label</h5>
						<p>Praesent commodo cursus magna, vel scelerisque nisl
							consectetur.</p>
					</div>
				</div>
			</div>
			<!-- Inner -->

			<!-- Controls -->
			<button class="carousel-control-prev" type="button"
				data-mdb-target="#carouselBasicExample" data-mdb-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-mdb-target="#carouselBasicExample" data-mdb-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
		<!-- Carousel wrapper <c:url value = "./imgs/"/>${i.poster}-->
	</section>
	<section class="container">

		<div class="row row-cols-1 row-cols-md-4 g-4">
			<c:forEach var="i" items="${title}">
				<div class="col">
					<div class="card h-100">
						<a href="./detail?id=${i.id}">
						<img src="/ASM/imgs/${i.poster}"
							class="card-img-top" alt="Skyscrapers" />
							</a>
						<div class="card-body">
							<h5 class="card-title">
								<a href="./detail?id=${i.id}" >${i.title}</a>
							</h5>
						</div>
						<div class="card-footer">
							<small class="text-muted">Lượt xem : ${i.views}</small>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<br>
	</section>
	<!-- Section: Video TOP 8 -->
	<section class="">
		<div class="container text-light my-5">
			<h4 class="text-uppercase black-text mx-3" style="color: yellow;"><i class="fas fa-fire-alt"></i>  Có Thể Bạn Thích ?</h4>
			<hr style="color: yellow;">
			<!-- Carousel wrapper -->
			<div id="carouselFavorite"
				class="carousel slide carousel-dark text-center"
				data-mdb-ride="carousel">
				<!-- Controls -->
				<div class="d-flex justify-content-center mb-4 position-relative">
					<!-- Inner -->
					<div class="carousel-inner py-4">
						<!-- Single item -->
						<div class="carousel-item active" style="width: 100%;">
							<div class="container">
								<div class="row">
									<c:forEach var="video" items="${top4x1}">
										<!--Video col_3-->
										<div class="col-3 position-relative">
											<div class="bg-image hover-overlay ripple position-relative"
												data-mdb-ripple-color="light">
												<img src="<c:url value = "/imgs/"/>${video.poster }" class="col-12" />
										
												<div class="mask" style="background-color: rgba(251, 251, 251, 0.2)">
										
													<a href="<c:url value = "/detail?id=${video.id }"/>">
														<i class="far fa-play-circle fa-5x position-absolute top-50 start-50 translate-middle"></i>
													</a>
												
												</div>
												<div class="row">
													<div style="margin: 5px;" class="col-12  text-truncate position-absolute top-0 start-0 w-100"><c:out value="${video.title }" /></div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>

						<!-- Single item -->
						<div class="carousel-item">
							<div class="container">
								<div class="row">
									<c:forEach var="video" items="${top4x2}">
										<!--Video col_3-->
										<div class="col-3 position-relative">
											<div class="bg-image hover-overlay ripple position-relative"
												data-mdb-ripple-color="light">
												<img src="<c:url value = "/imgs/"/>${video.poster}" class="col-12" />
										
												<div class="mask" style="background-color: rgba(251, 251, 251, 0.2)">
										
													<a href="<c:url value = "/detail?id=${video.id}"/>">
														<i class="far fa-play-circle fa-5x position-absolute top-50 start-50 translate-middle"></i>
													</a>
												
												</div>
												<div class="row">
													<div style="margin: 5px;" class="col-12 text-truncate position-absolute top-0 start-0"><c:out value="${video.title }" /></div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
					<!-- Inner -->
					<button
						class="bg-dark carousel-control-prev position-absolute top-50 start-0 translate-middle"
						type="button" data-mdb-target="#carouselFavorite"
						data-mdb-slide="prev" style="width: 50px; height: 80%; margin-left: 25px;">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					</button>
					<button
						class="bg-dark carousel-control-next position-absolute top-50 start-100 translate-middle"
						type="button" data-mdb-target="#carouselFavorite"
						data-mdb-slide="next" style="width: 50px; height: 80%; margin-left: -25px;">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
					</button>
				</div>
			</div>
			<!-- Carousel wrapper -->
		</div>
	</section>
	<hr>
	<!-- Section: Video TOP 8 -->
</body>
<!-- MDB -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.js"></script>
</html>