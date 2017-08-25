<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>JFinalTest</title>
<link href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
td {
	text-align: center;
	padding: 5px;
	min-width: 40px;
}
.center {
    text-align: center;
}
</style>
</head>
<body>
	<div class="center">
        <h2 style="display: inline;">
            <a href="hello">显示全部</a> <a href="hello/add">添加</a>
        </h2>
        <input type="text" id="ID" placeholder="输入ID查询">
        <button onclick="selectById()">确定</button>
    </div>
	<hr />
	<div class="container">
		<table class="table table-striped">
			<tr>
				<td>ID</td>
				<td>名称</td>
				<td>价格</td>
				<td>数量</td>
				<td></td>
				<td></td>
			</tr> 
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="6">没有符合条件的数据</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list}" var="commodity" varStatus="status">
						<tr>
							<td>${commodity.id}</td>
							<td>${commodity.name}</td>
							<td>￥ ${commodity.price}</td>
							<td>${commodity.quantity}个</td>
							<td><a href="hello/add?id=${commodity.id}">修改</a></td>
							<td><button onclick="deleteCommodity(${commodity.id})">刪除</button></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
function deleteCommodity(id) {
	if(confirm("确定删除吗？")){
        alert("删除成功！");
        location.href = "hello?method=delete&id=" + id;
    }
}

function selectById() {
	if($("#ID").val().trim() === ""){
        alert("ID不能为空！");
        return;
    }
	location.href = "hello?id=" + $("#ID").val();
}
</script>
</body>
</html>
