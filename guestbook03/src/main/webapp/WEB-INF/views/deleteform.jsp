<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/delete&no=${vo.no}" method="post">
		<input type ='hidden' name ="a" value="delete">
		<input type='hidden' name="no" value=""> 
		비밀번호 : <input type="password" name="password"> 
		<input type="submit" value="확인">
	</form>
	<br>
	<a href="${pageContext.request.contextPath }">메인으로 돌아가기</a>
</body>
</html>