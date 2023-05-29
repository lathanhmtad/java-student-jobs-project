<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
<link rel="stylesheet" href="<c:url value="css/app.css"/>">
</head>
<body>
	<div>
		<form method="post" action="search?type=thong-tin-sinh-vien">
			<label for="searchTerm">Tìm kiếm sinh viên</label> 
			<input type="text" id="searchTerm"
				name="searchTerm" placeholder="" value="${searchTerm }" required="required">
				
			<input type="submit" value="Tìm kiếm">
		</form>
		
		<h1 class="text-center">Thông tin tìm kiếm</h1>

		<table id="customers">
		  <tr>
			    <th>Số CMND</th>
			    <th>Họ tên</th>
			    <th>Email</th>
			    <th>Số điện thoại</th>
			    <th>Địa chỉ</th>
		  </tr>
		  
		  <c:forEach var="item" items="${searchResults }">
		  	<tr>
			    <td>${item.soCMND }</td>
			    <td>${item.fullName }</td>
			    <td>${item.email }</td>
			    <td>${item.phone }</td>
			    <td>${item.address }</td>
		  	</tr>
		  </c:forEach>
		  
		</table>
		
																								
	</div>
</body>
</html>