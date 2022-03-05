<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Search Film</title>
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
<body style="background-color: rgb(17,17,17);">
	<jsp:include page="nav.jsp"></jsp:include>
	
	<section class="container">

		<div class="row row-cols-1 row-cols-md-4 g-4" id="row">
			
		</div>
		<br>
	</section>
</body>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.js"></script>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	
    var id;

    function loadMore(param) {
        id = param.value;
        console.log(id);
        $.ajax({
            type : "POST",
            data : {
                id : id
            },
            url : "<c:url value = "/film"/>"
        }).then(function(data){
        	console.log("done!");
        	document.getElementById("row").innerHTML = data;
        	
        }).fail(function(error){
        	console.log("fail!");
        	
        });
    }
</script>
</html>