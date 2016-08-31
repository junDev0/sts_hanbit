<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="#{css}/member.css"/>

</head>
<body>
	<div class="box">	
	<h2>검색(성별) 페이지</h2><br/>
	<form action="${context }/member/result/findByGen_result.jsp" method="post">
		<span class="meta">검색할 성별 입력</span><input type="text" name="gender"/><br/><br/>
		<input type="submit" value="확인"/>
  		<input type="reset" value="취소"/>
	</form><br/>
		<a href="${context }/member/member_controller.jsp"><img src="${img}/user.jpg" alt="user" style="width: 30px"/></a>
		<a href="${context }/index.jsp"><img src="${img}/home.png" alt="home" style="width: 30px"/></a>

	</div>
</html>