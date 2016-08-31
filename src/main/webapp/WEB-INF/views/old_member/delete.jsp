<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="box">
<embed src="${img }/minjung.gif" style="width: 300px;height: 200px;">
	<h2>${delete_result}</h2>
	<h2>회원탈퇴 페이지</h2><br/>
	<form action="${context }/member.do?page=delete&action=delete" method="post">
		<span class="meta">비밀번호 입력</span><input type="text" name="pw"/><br/><br/>
		<input type="hidden" name = "directory" value="home"/>
		<input type="submit" value="확인"/>
  		<input type="reset" value="취소"/>
	</form><br/>
		<a href="${context }/membe.do"><img src="${img}/user.jpg" alt="user" style="width: 30px"/></a>

	</div>
