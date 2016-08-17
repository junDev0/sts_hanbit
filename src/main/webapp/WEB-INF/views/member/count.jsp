
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp"/>	
<jsp:include page="../global/header.jsp"/>	
<jsp:include page="../global/navi.jsp"/>
	<div class="box">
	<h2>회원수 페이지</h2><br/>
		총 회원수는 ${count} 명입니다.
		<br/><a href="${context }/member.do"><img src="${img}/user.jpg" alt="user" style="width: 30px"/></a>

	</div>
<jsp:include page = "../global/footer.jsp"/>
<jsp:include page = "../global/end.jsp"/>