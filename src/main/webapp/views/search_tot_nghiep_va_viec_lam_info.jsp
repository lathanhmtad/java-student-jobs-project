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
		<form method="post" action="search?type=tot-nghiep-va-viec-lam">
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
			    <th>Mã ngành tốt nghiệp</th>
			    <th>Mã trường tốt nghiệp</th>
			    <th>Mã ngành công ty</th>
			    <th>Tên công ty</th>
			    <th>Thời gian làm việc</th>
		  </tr>
		  
		  <c:forEach var="item" items="${searchResults }">
		  	<tr>
			    <td>${item.soCMND }</td>
			    <td>${item.fullName }</td>
			    <td>${item.totNghiep.maNganh }</td>
			    <td>${item.totNghiep.maTruong }</td>
			    <td>${item.congViec.maNganh }</td>
			    <td>${item.congViec.tenCongTy }</td>
			    <td>${item.congViec.thoiGianLamViec }</td>
		  	</tr>
		  </c:forEach>
		  
		</table>
		
																								
	</div>
</body>
</html>