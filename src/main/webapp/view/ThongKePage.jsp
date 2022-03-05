<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thông Kê</title>
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
</head>
<body>

	<div class="container">
		<!-- Tabs navs -->
		<ul class="nav nav-tabs mb-3" id="ex1" role="tablist">
			<li class="nav-item" role="presentation"><a
				class="nav-link active" id="ex1-tab-1" data-mdb-toggle="tab"
				href="#ex1-tabs-1" role="tab" aria-controls="ex1-tabs-1"
				aria-selected="true">Số lượt yêu thích</a></li>
			<li class="nav-item" role="presentation"><a class="nav-link"
				id="ex1-tab-2" data-mdb-toggle="tab" href="#ex1-tabs-2" role="tab"
				aria-controls="ex1-tabs-2" aria-selected="false">Đang Update</a></li>
			<li class="nav-item" role="presentation"><a class="nav-link"
				id="ex1-tab-3" data-mdb-toggle="tab" href="#ex1-tabs-3" role="tab"
				aria-controls="ex1-tabs-3" aria-selected="false">Đang Update</a></li>
		</ul>
		<!-- Tabs navs -->

		<!-- Tabs content -->
		<div class="tab-content" id="ex1-content">
			<div class="tab-pane fade show active" id="ex1-tabs-1"
				role="tabpanel" aria-labelledby="ex1-tab-1">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th class="text-center" scope="col">Title</th>
							<th scope="col">Like</th>
							<th scope="col">newDateLike</th>
							<th scope="col">oldDateLike</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="i" items="${listThongKe}">
							<tr class="table-active">
								<td class="text-center">${i.group}</td>
								<td>${i.count}</td>
								<td>${i.newest}</td>
								<td>${i.newest}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<hr style="color: red;">
				<h3>Tìm user đã like video</h3>
				<form action="search" method="post">
					<div class="input-group">
						<div class="form-outline">
							<input name="keySearch" type="text" id="form1"
								class="form-control" /> <label class="form-label" for="form1">Nhập tiêu đề video</label>
						</div>
						<button class="btn btn-primary">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</form>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th class="text-center" scope="col">UserName</th>
							<th scope="col">Title Video</th>
							<th scope="col">Views</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="j" items="${search}">
							<tr class="table-active">
								<td class="text-center">${j.user.id}</td>
								<td>${j.video.title}</td>
								<td>${j.video.views}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<h3>Tìm user đã Share</h3>
				<form action="ss" method="post">
					<div class="input-group">
						<div class="form-outline">
							<input name="keyShare" type="text" id="form1"
								class="form-control" /> <label class="form-label" for="form1">Nhập tiêu đề video</label>
						</div>
						<button class="btn btn-primary">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</form>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th class="text-center" scope="col">UserName</th>
							<th scope="col">FullName</th>
							<th scope="col">Email</th>
							<th scope="col">DateShare</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="j" items="${share}">
							<tr class="table-active">
								<td class="text-center">${j.user.id}</td>
								<td>${j.user.fullname}</td>
								<td>${j.user.email}</td>
								<td>${sharedate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="tab-pane fade" id="ex1-tabs-2" role="tabpanel"
				aria-labelledby="ex1-tab-2">
				Tab2
				</div>
			<div class="tab-pane fade" id="ex1-tabs-3" role="tabpanel"
				aria-labelledby="ex1-tab-3">Tab 3 content</div>
		</div>
			<div class="text-center">
				<form action="ephim"></form>
				<button>Go Home</button>
			</div>
	</div>
	<!-- Tabs content -->
</body>
<!-- MDB -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.js"></script>
</html>