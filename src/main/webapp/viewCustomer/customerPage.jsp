<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Favorite Customer</title>
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
<link rel="stylesheet" href="https://wowjs.uk/css/libs/animate.css">
</head>
<body style="background: rgb(86, 85, 89);">
	<jsp:include page="/views/nav.jsp"></jsp:include>
	<div class="container m-5 px-5">
		<h3 class="" style="color: yellow;">Danh Sách Yêu Thích</h3>
	</div>
	<section class="container">

		<div class="row row-cols-1 row-cols-md-4 g-4">
			<c:forEach var="i" items="${listFavorite}">
				<div class="col span3 wow swing center">
					<div class="card h-100">
						<a href="./detail?id=${i.video.id}">
						<img src="<c:url value = "/imgs/"/>${i.video.poster}"
							class="card-img-top" alt="Skyscrapers" />
							</a>
						<div class="card-body">
							<h5 class="card-title">
								<a href="./detail?id=${i.video.id}" >${i.video.title}</a>
							</h5>
						</div>
						<div class="card-footer">
							<small class="text-muted">Lượt xem : ${i.video.views}</small>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<br>
	</section>
</body>
<!-- MDB -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.js"></script>
<script src="https://wowjs.uk/dist/wow.min.js"></script>
<script>
	new WOW().init();
</script>
</html>