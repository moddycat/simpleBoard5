<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form id="board_form" action="infoboard" method="post">
		작성자 : ${boardinfo.userId}<br>
		글제목 : ${boardinfo.title }<br>
		글내용<br>
			<textarea readonly="readonly" rows="20" cols="60" name="content" id="content">${boardinfo.content }</textarea><br>
			<a href="download?boardNum=${boardinfo.boardNum}">다운로드</a>
	
	<br>
	<input type="submit" value="목록보기">
		</form>
</body>
</html>