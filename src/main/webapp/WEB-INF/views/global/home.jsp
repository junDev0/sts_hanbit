<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>	
<div class = "box">
<h2>서비스를 이용하시려면 회원가입을 하셔야 합니다.</h2>
 	<a href="${context}/member.do?cmd=regist">회원가입 바로가기</a>
	<a href="${context}/member.do?cmd=login">로그인 바로가기</a>
	<a href="${context}/global.do?cmd=main">[임시]글로벌메인</a>
 
 </div>	
<jsp:include page = "footer.jsp"/>
<jsp:include page = "end.jsp"/> 
