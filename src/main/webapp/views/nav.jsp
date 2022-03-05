<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light "
	style="background: rgb(0, 0, 0);">
	<!-- Container wrapper -->
	<div class="container">
		<!-- Navbar brand -->
		<a class="navbar-brand me-2" href="./ephim"> <img
			src="https://fptbox.com.vn/wp-content/uploads/2019/02/fpt-play-3.jpg"
			height="40" alt="MDB Logo" loading="lazy" style="margin-top: -1px;" />
		</a>

		

		<!-- Toggle button -->
		<div class="d-flex align-items-center">
			<form action="updateUser">
				<button type="submit" class="btn btn-link px-3 me-2">
					Chào... ${sessionScope.userCloud.fullname}</button>
			</form>
			<form action="goOut">
				<button class="btn btn-primary me-3">Sign Out</button>
			</form>
			<a class="btn btn-dark px-3" href="./indexAdmin" role="button"><i
				class="fab fa-github"></i></a> <a class="btn btn-danger px-3"
				href="./pgLoveVi" role="button"><i
				class="fas fa-heart"></i> </a>
		</div>
	</div>
	<!-- Collapsible wrapper -->
	<!-- Container wrapper -->
</nav>
<!-- Navbar -->
<nav style="margin-left: 35%">
	<div class="input-group container mt-3">
		<div class="form-outline w-50">
			<input oninput="loadMore(this)"
			 type="search" id="form1" class="form-control"
				placeholder="Tìm kiếm video" aria-label="Search" />
		</div>
					<a class="btn btn-dark px-3" href="./film" role="button"><i
				class="fas fa-search"></i></a>
	</div>
</nav>
<!--Main Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark black mt-5 container"
	style="background: rgb(50, 48, 49);">
	<a class="navbar-brand" href="#" style="margin-left: 20%"><strong>PHIM
			MỚI</strong></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#"
				style="color: white;">THỂ LOẠI <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link" href="#"
				style="color: white;">PHIM LẺ</a></li>
			<li class="nav-item"><a class="nav-link" href="#"
				style="color: white;">PHIM BỘ</a></li>
			<li class="nav-item"><a class="nav-link" href="#"
				style="color: white;">PHIM THUYẾT MINH</a></li>
			<li class="nav-item"><a class="nav-link" href="#"
				style="color: white;">CHIẾU RẠP</a></li>
			<li class="nav-item"><a class="nav-link" href="#"
				style="color: white;">TRAILER</a></li>
			<li class="nav-item"><a class="nav-link" href="#"
				style="color: white;">QUỐC GIA</a></li>
		</ul>
	</div>
</nav>



