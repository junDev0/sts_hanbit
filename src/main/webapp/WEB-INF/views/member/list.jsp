
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp"/>	
<jsp:include page="../global/header.jsp"/>	
<jsp:include page="../global/navi.jsp"/>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 120%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>

<div class = box>
	<h2>리스트 페이지</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>이 름</th>
			<th>등록일</th>
			<th>성별</th>
			<th>생년월일</th>
			<th>이메일</th>
			<th>전화번호</th>
		</tr>
	<c:forEach var="member" items="${list}">
		<tr>
			<td>${member.id}</td>
			<td><a href="${context }/member.do?action=find_by_id&page=find_by_id&keyword=${member.id}">${member.name}</a></td>
			<td>${member.regDate}</td>
			<td>${member.gender}</td>			
			<td>${member.age}</td>
			<td>${member.email}</td>
			<td>${member.phone}</td>
			
		<tr>
	
	</c:forEach>
	
	</table><br/>
		<a href="${context }/member.do"><img src="${img}/user.jpg" alt="user" style="width: 30px"/></a>

	</div>
<jsp:include page = "../global/footer.jsp"/>
<jsp:include page = "../global/end.jsp"/>