<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 게시판</title>
</head>
<body>
<h2>[ 회원 게시판 ]</h2>
	<ul>
	
	<c:if test="${sessionScope.userid == null}">
		<li><a href="memberjoin">회원가입</a></li>
		<li><a href="memberlogin">로그인</a></li> 
	</c:if>
	
	<c:if test="${sessionScope.userid != null}">
		<li><a href="logout">로그아웃</a></li>
		<li><a href="updateForm">개인정보수정</a></li>
		
	</c:if>
		<li><a href="listboard">게시판</a></li> 
		
	</ul>
	<div>
		<img src="./resources/images/money.png" />
	</div>
</body>
</html>