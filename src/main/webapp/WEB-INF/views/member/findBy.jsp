
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp"/>	
<jsp:include page="../global/header.jsp"/>	
<jsp:include page="../global/navi.jsp"/>
<style type="text/css">
iframe.ifrm {
	border: none;
	width: 400px;
	height: 400px;
}
</style>

	<div class="box">
	<h1>내정보검색</h1><br/>
	<h2>ID검색</h2><br/>
	<form action="${context}/member.do"; method="get">
		<input type="text" name="keyword" placeholder="검색할 ID"/>
		<input type="hidden" name="action" value = "find_by_id" />
		<input type="hidden" name="page" value = "find_by_id" />
		<input type="submit" value="회원가입"/>
  		<input type="reset" value="취소"/>	
  	</form><br/>
	<h2>이름검색</h2><br/>
	<form action="${context}/member.do"; method="get">
		<input type="text" name="keyword" placeholder="검색할 이름"/>	
		<input type="hidden" name="action" value = "find_by_name" />
		<input type="hidden" name="page" value = "list" />
		<input type="submit" value="회원가입"/>
  		<input type="reset" value="취소"/>	</form>

	</div>
<jsp:include page = "../global/footer.jsp"/>
<jsp:include page = "../global/end.jsp"/>