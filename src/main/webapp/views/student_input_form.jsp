<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nhập thông tin sinh viên</title>

<link rel="stylesheet" href="<c:url value="css/app.css"/>">

<style>


</style>
</head>
<body>
	<div class="container">
		<h1 class="text-center">Nhập thông tin cho sinh viên sau khi tốt nghiệp</h1>
		<div>
			<c:if test="${not empty message }">
				<h6 class="alert alert-${alert }">${message }</h6>		
			</c:if>
		
			<form action="sinh-vien" method="post" id="studentForm">
				
				<label for="cmnd">Chứng minh nhân dân</label> 
				<input type="text" id="cmnd"
					name="soCMND" required="required"> 
				
				<label for="fullName">Họ tên</label> 
				<input type="text" id="fullName" name="fullName" required="required"> 
				
				<label for="email">Email</label> 
				<input type="email" id="email" name="email" required="required"> 
					
				<label for="phone">Số điện thoại</label> 
				<input type="text" id="phone" name="phone" required="required"> 
				
				<label for="address">Địa chỉ</label> 
				<input type="text" id="address" name="address" required="required"> 
				
		
				<label for="maTruong">Chọn trường</label> 
				<select id="maTruong" name="maTruong">
					<option value=""></option>
					
					<c:forEach var="item" items="${listTruong }">
						<option value="${item.maTruong }">${item.tenTruong }</option>
					</c:forEach>
				</select> 
				
				<label for="maNganh">Chọn ngành</label> 
				<select id="maNganh" name="maNganh">
					<option value=""></option>
					
					<c:forEach var="item" items="${listNganh }">
						<option value="${item.maNganh }">${item.tenNganh }</option>
					</c:forEach>
				</select> 
				
				<label for="heTN">Hệ tốt nghiệp</label> 
				<input type="text" id="heTN" name="heTN" required="required"> 
				
				<label for="ngayTN">Ngày tốt nghiệp</label> 
				<input type="date" id="ngayTN" name="ngayTN" required="required"> 
				
				<label for="loaiTN">Loại tốt ngiệp</label> 
				<input type="text" id="loaiTN" name="loaiTN" required="required"> 
				
				<input type="submit" value="submit" id="submitForm">
			</form>
		</div>
	</div>
	
	<script type="text/javascript">
		if (window.history.replaceState) {
			window.history.replaceState(null, null, window.location.href);
		}

		const inputSubmit = document.getElementById("submitForm")
		
		console.log(inputSubmit);
		
		const form = document.getElementById("studentForm")
		
		inputSubmit.onclick = function(e) {
			e.preventDefault();

			const selectedTruong = document.getElementById("maTruong").value;  
			const selectedNganh = document.getElementById("maNganh").value;

			if(selectedTruong === "") {
				alert("Vui lòng chọn trường");
				return;
			}

			if(selectedNganh === "") {
				alert("Vui lòng chọn ngành");
				return;
			}

			form.submit();
		}
	
	</script>
</body>
</html>