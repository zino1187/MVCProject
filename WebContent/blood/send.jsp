<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function regist(){
	form1.action="/blood/blood.do?requestType=blood"; //요청 url 
	form1.submit();
}
</script>
</head>
<body>
	<form name="form1" method="post">
		<select name="blood">
			<option value="A">A형</option>
			<option value="B">B형</option>
			<option value="O">O형</option>
			<option value="AB">AB형</option>			
		</select>
		<input type="button" value="판단 요청하기" onClick="regist()">
	</form>
</body>
</html>


