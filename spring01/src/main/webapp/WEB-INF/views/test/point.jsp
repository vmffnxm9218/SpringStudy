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
<form method="post" action="point_result.do">
name:<input type="text" name="name"><br>
korea:<input type="text" name="kor"><br>
english:<input type="text" name="eng"><br>
math:<input type="text" name="math"><br>
<input type="submit" value="확인"><br>

</form>
</body>
</html> 