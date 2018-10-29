<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>게시판</title>
<script>
function currentPage(currentPage){
	var form = document.getElementById('board_form');
	var page = document.getElementById('page');
	page.value = currentPage;
	form.action = "listboard";
	form.submit();
}

$(document).ready(function(){
	
	$('tr').filter(function(index){
		return index %2 == 0;
	}).css({
		background : 'black',
		color : 'orange'
	});
});
</script>
</head>
<body>
<h2>[게시판]</h2>
<form id="board_form" action="boardlist" type="post">
	<table border="1">
		<thead>
			<tr>
				<th >글번호</th>
				<th>이름</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<tbody>
			<c:forEach var="board" items="${boardList}"> 
				<tr>
					<td>${board.boardNum}</td>
					<td>${board.userId}</td>
					<td><a href="boardinfo?boardNum=${board.boardNum}">${board.title}</a></td>
					<td>${board.regdate}</td>
					<td>${board.hitcount}</td>
				</tr>
			</c:forEach>
			
			
			<tr>
			<td colspan=5>
	    
	
		<input type="hidden" name="page" id="page"/>
			<input type="text" name="searchKeyword"><input type="button" onclick="currentPage(1)" value="검색"><br>
			
			<input class="button" name="pre" type="button" onclick="currentPage(${navi.currentPage-1} )" value="이전페이지"/>
			<c:forEach var="pageNum" begin="${navi.startPageGroup }" end="${navi.endPageGroup }">
				<a href="listboard?page=${pageNum }">${pageNum }</a>
			</c:forEach>
			<input class="button" name="next" type="button" onclick="currentPage(${navi.currentPage+1} )" value="다음페이지"/>
			<input class="button" name="write" type="submit" value="글쓰기"></td>
			</tr>
			</tbody>
			
			</thead>
		
	</table>
	</form>
</body>
</html>