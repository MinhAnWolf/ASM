<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin</title>
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
		<div class="row mt-5">
			<div class="col-md-4">
				<!-- Tab navs -->
				<div>
					<div>
						<!-- Tab navs -->
						<nav class="navbar navbar-expand-lg navbar-light bg-light">
							<!-- Container wrapper -->
							<div class="container-fluid">
								<!-- Toggle button -->
								<button class="navbar-toggler" type="button"
									data-mdb-toggle="collapse"
									data-mdb-target="#navbarLeftAlignExample"
									aria-controls="navbarLeftAlignExample" aria-expanded="false"
									aria-label="Toggle navigation">
									<i class="fas fa-bars"></i>
								</button>

								<!-- Collapsible wrapper -->
								<div class="collapse navbar-collapse"
									id="navbarLeftAlignExample">
									<!-- Left links -->
									<ul class="navbar-nav me-auto mb-2 mb-lg-0">
										<li class="nav-item"><a class="nav-link active"
											aria-current="page" href="./indexAdmin">Video</a></li>
										<li class="nav-item"><a class="nav-link active"
											aria-current="page" href="./profileU">User</a></li>
										<li class="nav-item"><a class="nav-link active"
											aria-current="page" href="./thongke">Thống kê</a></li>
									</ul>
									<!-- Left links -->
								</div>
								<!-- Collapsible wrapper -->
							</div>
							<!-- Container wrapper -->
						</nav>
						<!-- Tab navs -->
					</div>
				</div>
				<!-- Tab navs -->
			</div>
			<div class="col-md-8">
				<div class="row">
					<div class="col-md-6">
						<img alt="" src="">
						<div class="col-7"></div>
					</div>
					<div class="col-md-6">
						<form action="showUs" enctype="multipart/form-data">
							<!-- Name input -->
							<div class="form-outline mb-4">

								<input type="text" id="form4Example1" class="form-control"
									name="id" value="${id}" /> <label class="form-label" for="form4Example1">User
									ID</label>
							</div>

							<!-- Email input -->
							<div class="form-outline mb-4">
								<input type="text" id="form4Example2" class="form-control"
									name="password" value="${password}" /> <label class="form-label"
									for="form4Example2">Password </label>
							</div>
							<div class="form-outline mb-4">
								<input type="text" id="form4Example2" class="form-control"
									name="email" value="${email}" /> <label class="form-label" for="form4Example2">Email</label>
							</div>
							<!-- Message input -->
							<div class="form-outline mb-4">
								<input type="text" id="form4Example2" class="form-control"
									name="fullname" value="${fullname}" /> <label class="form-label" for="form4Example2">FullName</label>
							</div>

							<!-- Checkbox -->
							<div class="form-check form-check-inline">
								<input ${admin?'checked':''} class="form-check-input"
									type="radio" name="admin" id="inlineRadio1" value="true" /> <label
									class="form-check-label" for="inlineRadio1">Admin</label>
							</div>

							<div class="form-check form-check-inline">
								<input  ${admin?'':'checked'} class="form-check-input"
									type="radio" name="admin" id="inlineRadio2" value="false" />
								<label class="form-check-label" for="inlineRadio2">
									User</label>
							</div> <br> <hr>
							<!-- Submit button
							<button type="submit" class="btn btn-primary btn-block mb-4 mt-3">Create</button> -->
							<button formmethod="post" type="submit" class="btn btn-success">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<table class="table align-middle mt-5">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Password</th>
					<th scope="col">Email</th>
					<th scope="col">FullName</th>
					<th scope="col">Admin</th>
					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
			<!-- triều bảo sau này đi làm thì dùng c:url + c:out-->
				<c:forEach var="i" items="${itemsU}">
					<tr>
						<th>${i.id}</th>
						<td>${i.password}</td>
						<td>${i.email}</td>
						<th>${i.fullname}</th>
						<td>${i.admin?'Admin':'User'}</td>
						<td><a href="./showUs?id=${i.id}" role="button"><i
								class="fas fa-wrench"></i> Edit</a></td>
						<td><a class="btn btn-danger px-3"
							href="./Udelete_u?id=${i.id}" role="button"><i
								class="fas fa-times"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<!-- MDB -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.js"></script>
</html>