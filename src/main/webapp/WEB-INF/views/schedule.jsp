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
	<form action="insert_schedule">
	<table>
		<tr> 
		</tr>
		<tr>
			<c:forEach items="${movieList}" var="m">
					<td>
						<img src=${m.m_img}><br/>
						<input type="radio" name="movie" value=${m.m_no}>${m.m_title}
					</td>
			</c:forEach>
		</tr>
	</table>
	
	<table>	
			<c:forEach items="${cinemaList}" var="c">
				<tr>
					<td><input type="radio" name="cinema" value=${c.no}>${c.name}</td>
				</tr>	
			</c:forEach>
		
	</table>
	
	날짜 선택<input type="date" name="date">
	시작 시간<input type="time" name="s_time">
	종료 시간<input type="time" name="e_time">
	
	<input type="submit" value="추가">
	</form>
</body>
</html>