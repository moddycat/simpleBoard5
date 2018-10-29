<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script >
function golist(){
	var form = document.forms["board_form"];
	form.action="golist"
	
	form.submit();
}
</script>
</head>
<body>
	<form id="board_form" action="boardwrite" method="post" enctype="multipart/form-data">
		작성자<input type="text" readonly="readonly" value="${sessionScope.userid}"><br>
		글제목<input type="text" name="title"><br>
		글내용<br>
			<textarea rows="20" cols="60" name="content" id="content"></textarea><br>
		업로드<input name="uploadfile" type="file"><br>

		<input type="submit" value="등록"> <button type="button" onclick="golist()">목록보기</button>
		
	</form>
</body>
</html>