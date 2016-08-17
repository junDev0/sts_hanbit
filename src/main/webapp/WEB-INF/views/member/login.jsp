<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp"/>	
<jsp:include page="../global/header.jsp"/>	

<div class="box">
	<h2>${result}</h2>
	<form action="${context }/member.do" method="post">
		<span class="meta">ID</span><input type="text" name="id"/><br/>
		<span class="meta">비밀번호</span><input type="password" name="pw"/><br/><br/>
		<input type="hidden" name = "action" value="login"/>
		<input type="hidden" name = "directory" value="global"/>
  		<input type="submit" value="로그인"/>
  		<input type="reset" value="취소"/><br/><br/><br/>
  		
	</form>
	
		<br/><a href="${context}/index.jsp"><img src="${img}/home.png" alt="home" style="width: 30px"/></a>

	</div>
	
<jsp:include page = "../global/footer.jsp"/>
<jsp:include page = "../global/end.jsp"/>