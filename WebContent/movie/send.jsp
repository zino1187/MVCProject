<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function regist(){
	form1.action="/movie/movie.do"; //요청 url 
	form1.submit();
}
</script>
</head>
<body>
	<form name="form1" method="post">
		<select name="movie">
			<option value="정글북">정글북</option>
			<option value="엑스맨 아포칼립스">엑스맨 아포칼립스</option>
			<option value="워크래프트">워크래프트</option>
			<option value="컨저링">컨저링</option>
			<option value="곡성">곡성</option>
		</select>
		<input type="button" value="판단 요청하기" onClick="regist()">
	</form>
</body>
</html>


