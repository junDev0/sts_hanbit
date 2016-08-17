<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp"/>	
<jsp:include page="../global/header.jsp"/>	
<jsp:include page="../global/navi.jsp"/>
	<div class="box">
	<h2>검색(이름) 페이지</h2><br/>
	<form action="${context }/member/result/findByName_result.jsp" method="post">
		<span class="meta">검색할 이름 입력</span><input type="text" name="name"/><br/><br/>
		<input type="submit" value="확인"/>
  		<input type="reset" value="취소"/>
	</form><br/>
		<a href="${context }/member/main.jsp"><img src="${img}/user.jpg" alt="user" style="width: 30px"/></a>

	</div>
<jsp:include page = "../global/footer.jsp"/>
<jsp:include page = "../global/end.jsp"/>