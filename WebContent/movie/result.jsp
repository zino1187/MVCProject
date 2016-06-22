<%@ page contentType="text/html; charset=UTF-8"%>
<%
	/*
	request.getAttibute();  //request 객체 저장된 데이터를 추출할때 씀.. 
	//전제 조건 요청이 아직 살아 있는 동안만 이 메서드를 호출할 수 잇음..
	request.getParameter("test"); //클라이언트가 전송한 파라미터를 받는 메서드!!
	*/
	String msg=(String)request.getAttribute("msg");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
서버로부터 받은 결과 메세지 :  <%=msg %>
</body>
</html>