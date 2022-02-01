<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
name:${dto.name }<br>
korea:${dto.kor }<br>
math:${dto.math }<br>
eng:${dto.eng }<br>
총점: ${dto.total }<br>
평균:${dto.average }<br>

</body>
</html>