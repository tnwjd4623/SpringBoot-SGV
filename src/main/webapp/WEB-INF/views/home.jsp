<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String cp = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href= "<%=cp %>/resources/css/bootstrap.css">
	<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript"src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<%=cp %>/resources/js/bootstrap.js"></script>
	
	<div class="container" style="text-align:center;">
		<h4>SGV</h4>
	</div>
	
	<nav class="navbar navbar-expand-lg bg-light navbar-light">
		<ul class="navbar-nav navbar-center" >
			<li class="nav-item active">
				<a class="nav-link" href="#">홈</a>
			</li>
			<li class="nav-item ">
				<a class="nav-link" href="#">예매</a>
			</li>
			<li class="nav-item">
				<a class= "nav-link" href="#">영화</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">영화관</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="./book_user">예매조회</a>
			</li>
		</ul>
	</nav>
	<br/><br/>
	<table>
		<tr> 
		</tr>
		<tr>
			<c:forEach items="${movieList}" var="m">
				<form action="login">	
					<td width="200" style="text-align:center";>
						<input type="hidden" name="m_no" value=${m.m_no}>
						<img src=${m.m_img} width="150" height="200"><br/>
						<h10>${m.m_title}</h10><br/>
						<input class="btn btn-outline-danger" type="submit" value="예매하기">
					</td>
				</form>
				</c:forEach>
		</tr>
	</table>
	
	<!--  <button onClick="location.href='/addSchedule'">상영시간 추가</button>
	-->
	
</body>
</html>