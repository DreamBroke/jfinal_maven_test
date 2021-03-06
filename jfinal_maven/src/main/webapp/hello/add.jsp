<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>JFinal-Add</title>
<link href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
label {
	width: 32px;
	display: inline-block;
}
.center {
    text-align: center;
}
</style>
</head>
<body>
	<h2 class="center">Add</h2>
	<hr>
	<c:choose>
		<c:when test="${empty commodity }">
			<form action="add" method="post" id="form" class="container center" onsubmit="return validate()">
				<label for="id">ID</label> <input id="id" name="commodity.id"><br>
				<label for="name">姓名</label> <input id="name" name="commodity.name"><br>
				<label for="price">价格</label> <input id="price"
					name="commodity.price"><br> <label for="quantity">数量</label>
				<input id="quantity" name="commodity.quantity"><br>
				<button type="submit" id="submit">提交</button>
				<button type="reset">重置</button>
			</form>
		</c:when>
		<c:otherwise>
			<form action="update" method="post" id="form" class="container center" onsubmit="return validate()">
				<label for="id">ID</label> <input id="id" name="commodity.id" disabled
					value="${commodity.id}"><br> <label for="name">姓名</label>
				<input id="name" name="commodity.name" value="${commodity.name}"><br>
				<label for="price">价格</label> <input id="price" type="number" name="commodity.price" value="${commodity.price}"><br>
				<label for="quantity">数量</label> <input id="quantity" type="number"
					name="commodity.quantity" value="${commodity.quantity}"><br>
				<input type="hidden" value="${commodity.id}" name="id">
				<button type="submit" id="submit">提交</button>
				<button type="reset">重置</button>
			</form>
		</c:otherwise>
	</c:choose>
	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		function validate() {
			if ($("#name").val() === "" || $("#price").val() === ""
					|| $("#quantity").val() === "") {
				alert("姓名、价格、数量不能为空！");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>