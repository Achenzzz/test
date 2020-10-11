<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>下载</title>
</head>
<body>
	<form action="DownloadServlet" method="get" name="postform">
		<table>
			<tr>
				<td>序号</td>
				<td>名称</td>
				<td>路径名</td>
				<td>描述</td>
				<td>文件大小</td>
				<td>星级</td>
				<td>图片路径</td>
				<td>是否下载</td>
			</tr>

			<c:forEach items="${downloads}" var="download" varStatus="message">
				<tr>
					<td>${download.id}</td>
					<td>${download.name}</td>
					<td>${download.path}</td>
					<td>${download.description}</td>
					<td>${download.size}</td>
					<td>${download.star}</td>
					<td>${download.image}</td>
					<td><button name= "按钮"  value = ${download.id}>点我下载</button></td>
					
				</tr>
			
			</c:forEach>
		</table>
	</form>
</body>
</html>