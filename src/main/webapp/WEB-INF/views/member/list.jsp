
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="box">
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">학생목록</div>
  <div class="panel-body">
    <p>...</p>
  </div>

  <!-- Table -->
<table class="table">
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
	
	</table>
</div>
</div>    
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



