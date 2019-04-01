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
			<li class="nav-item">
				<a class="nav-link" href="./">홈</a>
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
			<li class="nav-item active">
				<a class="nav-link" href="#">예매조회</a>
			</li>
		</ul>
	</nav>
	<br/><br/>
	
<table class="table table-striped">
		<tr> 
			<td>예약번호</td>
			<td>영화관</td>
			<td>영화</td>
			<td>날짜</td>
			<td>상영 시간</td>
		</tr>
		<c:forEach items="${book}" var="b" varStatus="status">
			<tr>
				<td>
					${b.b_no}
				</td>
				<td>
					${cinema[status.index]}
				</td>
				<td>
					${movie[status.index]}	
				</td>
				
				<td>
					${b.date}
				</td>
				<td>
					${b.s_time} - ${b.e_time}
				</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>