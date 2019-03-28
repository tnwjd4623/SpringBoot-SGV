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
	home
	<table>
		<tr> 
		</tr>
		<tr>
			<c:forEach items="${movieList}" var="m">
				<form action="login">	
					<td>
						<input type="hidden" name="m_no" value=${m.m_no}>
						<img src=${m.m_img}><br/>
						${m.m_title}<br/>
						<input type="submit" value="예매하기">
					</td>
				</form>
				</c:forEach>
		</tr>
	</table>
	
	<!--  <button onClick="location.href='/addSchedule'">상영시간 추가</button>
	-->
	
</body>
</html>