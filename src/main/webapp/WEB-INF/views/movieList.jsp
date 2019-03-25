<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="search">
			<input type="text" name="text">
			<input type="submit" value="검색">
		</form>
	</center>
	
	<table>
		<tr>
			<td>제목</td>
			<td>포스터</td>
			<td>개봉일</td>
			<td>평점</td>
			<td>감독</td>
			<td></td>
		</tr>
		<c:forEach items="${movieList}" var="m">
			<tr>
				<form action="insert_movie">
					<input type="hidden" name="title" value="${m.m_title}">
					<input type="hidden" name="img" value=${m.m_img}>
					<input type="hidden" name="pubDate" value="${m.m_pubDate}">
					<input type="hidden" name="rating" value="${m.m_rating}">
					<input type="hidden" name="director" value="${m.m_director}">
					
					<td>${m.m_title}</td>
					<td><img src=${m.m_img}></td>
					<td>${m.m_pubDate}</td>
					<td>${m.m_rating}</td>
					<td>${m.m_director}</td>
					<td><input type="submit" value="등록"></td>
				</form>
			</tr>	
		</c:forEach>
		
	</table>

</body>
</html>