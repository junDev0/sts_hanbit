<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="box">
<!-- 	//id,age,name,regDate,gender,profileImg -->

	<h2>회원 상세정보</h2>
	
	<table id = "member_detail">
		<tr>
			<td rowspan="5" style ="width:30%"><img src="${context}/resources/img/${member.profileImg}" alt="W3Schools.com" width="104" height="142"></td>
			<td style ="width:20%" class="font_bold bg_color_yellow">ID</td>
			<td style="width: 40%">${member.id}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">비밀번호</td>
			<td >${member.pw}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">이름</td>
			<td>${member.name}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">성별</td>
			<td>${member.gender}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">e-mail</td>
			<td colspan="2">${member.email}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">전공과목</td>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">수강과목</td>
			<td colspan="2"></td>
		</tr>
			
		<tr>
			<td class="font_bold bg_color_yellow">생년월일</td>
			<td colspan="2">${member.ssn}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">등록일</td>
			<td colspan="2">${member.regDate}</td>
		</tr>
	</table>	
</div>