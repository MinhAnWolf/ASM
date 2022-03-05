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
    <button
      class="navbar-toggler"
      type="button"
      data-mdb-toggle="collapse"
      data-mdb-target="#navbarLeftAlignExample"
      aria-controls="navbarLeftAlignExample"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <i class="fas fa-bars"></i>
    </button>

    <!-- Collapsible wrapper -->
    <div class="collapse navbar-collapse" id="navbarLeftAlignExample">
      <!-- Left links -->
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./indexAdmin">Video</a>
        </li>
		    <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./profileU">User</a>
        </li>
            <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./thongke">Thống kê</a>
        </li>
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
						<img alt="" src="./imgs/${poster}">
						<div class="col-7"></div>
					</div>
					<div class="col-md-6">
						<form action="new" enctype="multipart/form-data" method="post">
							<!-- Name input -->
							<div class="form-outline mb-4">
							
							  <input type="text" id="form4Example1" class="form-control"
									name="id" value="${id}" />  <label class="form-label" for="form4Example1">Video
									ID</label>
							</div>

							<!-- Email input -->
							<div class="form-outline mb-4">
								<input type="text" id="form4Example2" class="form-control"
									name="title" value="${title}" /> <label class="form-label" for="form4Example2">Video
									Title</label>
							</div>
							<div class="form-outline mb-4">
								<input  value="${views}" type="text" id="form4Example2" class="form-control"
									name="views" /> <label class="form-label" for="form4Example2">Views</label>
							</div>
							<!-- Message input -->
							<div  class="form-outline mb-4">
								<textarea  class="form-control" id="form4Example3" rows="4"
									name="description">${description}</textarea>
								<label class="form-label" for="form4Example3">Description</label>
							</div>

							<!-- Checkbox -->
							<div class="form-check form-check-inline">
								<input ${active?'checked':''} class="form-check-input" type="radio" name="active"
									id="inlineRadio1" value="true" /> <label
									class="form-check-label" for="inlineRadio1">Active</label>
							</div>

							<div class="form-check form-check-inline">
								<input ${active?'':'checked'} class="form-check-input" type="radio" name="active"
									id="inlineRadio2" value="false" /> <label
									class="form-check-label" for="inlineRadio2">In Active</label>
							</div>
							<br> <label class="form-label" for="customFile">Chọn
								Poster</label> <input type="file" name="poster" class="mt-3">  <h4 style="color: black;">${poster}</h4>
							<!-- Submit button
							<button type="submit" class="btn btn-primary btn-block mb-4 mt-3">Create</button> -->
							<button type="submit" class="btn btn-primary mt-3">Create</button>
							<button formaction="Uvideo" formmethod="post" type="submit" class="btn btn-success">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<table class="table align-middle mt-5">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Poster</th>
					<th scope="col">Views</th>
					<th scope="col">Description</th>
					<th scope="col">Active</th>
					<th scope="col">Update</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${listVideo}">
					<tr>
						<th>${i.id}</th>
						<td>${i.title}</td>
						<td>${i.poster}</td>
						<th>${i.views}</th>
						<td>${i.description}</td>
						<td>${i.active}</td>
						<td><a  href="./editV?id=${i.id}" role="button"><i class="fas fa-wrench"></i>
							Edit
						</a></td>
						<td><a class="btn btn-danger px-3" href="./RemoveV?id=${i.id}"
							role="button"><i class="fas fa-times"></i></a></td>
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