<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng Kí</title>
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
	<section class="vh-100 bg-image"
		style="background-image: url('https://user-images.githubusercontent.com/33485020/108069438-5ee79d80-7089-11eb-8264-08fdda7e0d11.jpg');">
		<div class="mask d-flex align-items-center h-100 gradient-custom-3">
			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-7 col-xl-6">
						<div class="card" style="border-radius: 15px;">
							<div class="card-body p-5">
								<h2 class="text-uppercase text-center mb-5">Update an
									account</h2>

								<form action="register" method="post">

									<div class="form-outline mb-4">
										<input name="id" type="text" id="form3Example1cg"
											class="form-control form-control-lg"
											value="${sessionScope.userCloud.id}" /> <label
											class="form-label" for="form3Example1cg">UserName </label>
									</div>
									<div class="form-outline mb-4">
										<input value="${sessionScope.userCloud.fullname}" name="fullname" type="text" id="form3Example1cg"
											class="form-control form-control-lg" /> <label
											class="form-label" for="form3Example1cg">FullName </label>
									</div>
									<div class="form-outline mb-4">
										<input value="${sessionScope.userCloud.email}" name="email" type="email" id="form3Example3cg"
											class="form-control form-control-lg" /> <label
											class="form-label" for="form3Example3cg">Your Email</label>
									</div>

									<div class="form-outline mb-4">
										<input name="password" type="password" id="form3Example4cg"
											class="form-control form-control-lg" /> <label
											class="form-label" for="form3Example4cg">Password</label>
									</div>

									<div class="form-outline mb-4">
										<input name="password_Cf" type="password"
											id="form3Example4cdg" class="form-control form-control-lg" />
										<label class="form-label" for="form3Example4cdg">Repeat
											your password</label>
									</div>
									<input type="hidden" name="Admin" value="false">

									<div class="d-flex justify-content-center">
										<button formaction="updateUser" formmethod="post"
											class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Update</button>
									</div>

									<p class="text-center text-muted mt-5 mb-0">
										Have already an account? <a href="./login"
											class="fw-bold text-body"><u>Login here</u></a>
									</p>

								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
<!-- MDB -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.js"></script>
</html>