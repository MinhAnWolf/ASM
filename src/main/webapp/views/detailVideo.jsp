<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Phim</title>
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
<body style="background: rgb(86, 85, 89);">
	<jsp:include page="/views/nav.jsp"></jsp:include>
	<c:set var="i" value="${itemVid}" />
	<div class="container py-5">
		<div class="row">
			<div class="col-9">
				<div class="row">


					<div class="col-12 mt-5">

						<h4 style="color: yellow;">Title : ${i.title}</h4>
						<div class="ratio ratio-16x9">
							<iframe src="https://www.youtube.com/embed/${i.id}"
								title="YouTube video" allowfullscreen></iframe>
						</div>
						<br>
						<div class="container">
							<div class="py-3">
								<h5 style="color: white;">Views : ${i.views}</h5>

								<c:set var="theString" value="${on_off}" />
								<c:if test="${fn:containsIgnoreCase(on_off, 'on')}">
									<button onclick="loadMore()"
										class="btn btn-light btn-lg active m-auto fas fa-thumbs-up"
										id="btn-like"></button>
								</c:if>
								<c:if test="${fn:containsIgnoreCase(on_off, 'off')}">
									<button onclick="loadMore()"
										class="btn btn-danger btn-lg active m-auto fas fa-thumbs-up"
										id="btn-like"></button>
								</c:if>


								<a href="#" class="btn btn-secondary btn-lg active m-auto"
									role="button" data-mdb-toggle="modal"
									data-mdb-target="#exampleModal">Share</a>
							</div>
							<h3 style="color: yellow;">
								<u> Nội Dung :</u>
							</h3>
							<p style="color: white;">${i.description}</p>
						</div>
					</div>
				</div>
				<div class="row mt-5">
				<h2 style="color:#009F75;">Lịch sử bạn đã xem</h2>
				<c:forEach var="i" items="${historyShowDetaile}">
					<div class="col-3 py-2">
						<div class="card h-100">
							<a href="./detail?id=${i.video.id}"> <img
								src="/ASM/imgs/${i.video.poster}" class="card-img-top"
								alt="Skyscrapers" />
							</a>
							<div class="card-body">
								<h5 class="card-title">
									<a href="./detail?id=${i.video.id}">${i.video.title}</a>
								</h5>
							</div>
							<div class="card-footer">
								<small class="text-muted">Lượt xem : ${i.video.views}</small>
							</div>
						</div>
					</div>
				</c:forEach>
				</div>
				
			</div>
			<div class="col-3">
				<h3 class="text-center" style="color: yellow;">Có Thể Bạn Biết</h3>
				<c:forEach var="j" items="${cardVid}">
					<div class="card border border-primary shadow-0 mb-3"
						style="max-width: 18rem;">
						<div class="card-header">Lượt xem : ${j.views}</div>
						<div class="card-body text-primary">
							<a href="./detail?id=${j.id}"> <img class="w-100" alt="ABC"
								src="/ASM/imgs/${j.poster}">
								<h5 class="card-title text-center">${j.title}</h5>
							</a>
							<div class="row">
								<div class="col-12 text-truncate">${j.description}</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="btn-close" data-mdb-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<!-- Name input -->
					<div class="form-outline mb-4">
						<input name="subject" type="text" id="subject"
							class="form-control" /> <label class="form-label" for="subject">Subject</label>
					</div>

					<!-- Email input -->
					<div class="form-outline mb-4">
						<input name="to" type="email" id="to" class="form-control" /> <label
							class="form-label" for="to">Email Friend</label>
					</div>

					<!-- Message input -->
					<div class="form-outline mb-4">
						<textarea name="content" class="form-control" id="content"
							rows="4"></textarea>
						<label class="form-label" for="content">Message</label>
					</div>

					<button onclick="loadShare()"
						class="btn btn-primary btn-block mb-4">Send</button>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-mdb-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- End Modal -->
</body>
<!-- MDB -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	var id;

	function loadMore() {
		id = '${itemVid.id}';
		console.log(id);
		$
				.ajax({
					type : "POST",
					data : {
						id : id
					},
					url : "<c:url value = "/like"/>"
				})
				.then(
						function(data) {
							console.log("done!");
							const element = document.getElementById("btn-like");
							if (element.className.includes("light")) {
								element.className = "btn btn-danger btn-lg active m-auto fas fa-thumbs-up";
							} else {
								element.className = "btn btn-light btn-lg active m-auto fas fa-thumbs-up";
							}
						}).fail(function(error) {
					console.log("fail!");

				});
	}
	function loadShare() {
		var vid = '${itemVid.id}';
		var subject = document.getElementById("subject").value;
		var to = document.getElementById("to").value;
		var content = document.getElementById("content").value;
		console.log(vid);
		console.log(subject);
		console.log(to);
		console.log(content);
		$.ajax({
			type : "POST",
			data : {
				vid : vid,
				subject : subject,
				to : to,
				content : content
			},
			url : "<c:url value = "/send"/>"
		}).then(function(data) {
			console.log("done!");

		}).fail(function(error) {
			console.log("fail!");

		});
	}
</script>

</html>