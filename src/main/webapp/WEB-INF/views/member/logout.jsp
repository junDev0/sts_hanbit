
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="box">

	<form action="${context }/member.do?action=logout" method="post">
	<input type="hidden" name = "directory" value="home"/>
		<input type="submit" value="로그아웃"/>
  		<input type="reset" value="취소"/>
	</form>
	
		<br/><a href="${context }/index.jsp"><img src="${img}/home.png" alt="home" style="width: 30px"/></a>

	</div>
	
