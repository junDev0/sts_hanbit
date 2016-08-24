
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
	#member_detail{border: 1px solid gray; width: 90%;height: 300px; margin: 0 auto;border-collapse: collapse;}
	#member_detail tr{border: 1px solid gray;height: 20%}
	#member_detail tr td{border: 1px solid gray;}
	.font_bold{font-weight: bold;}
	.bg_color_yellow{background-color:yellow}
</style>

<div class="box">
<!-- 	//id,age,name,regDate,gender,profileImg -->

	<h2>회원 상세정보</h2>
	
	<table id = "member_detail">
		<tr>
			<td rowspan="5" style ="width:30%"><img src="${img}/${user.img}" alt="W3Schools.com" width="104" height="142"></td>
			<td style ="width:20%" class="font_bold bg_color_yellow">ID</td>
			<td style="width: 40%">${user.id}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">비밀번호</td>
			<td >${user.pw}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">이름</td>
			<td>${user.name}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">성별</td>
			<td>${user.gender}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">e-mail</td>
			<td colspan="2">${user.email}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">전공과목</td>
			<td colspan="2">${user.major}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">수강과목</td>
			<td colspan="2">${user.subjects}</td>
		</tr>
			
		<tr>
			<td class="font_bold bg_color_yellow">생년월일</td>
			<td colspan="2">${user.ssn}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">등록일</td>
			<td colspan="2">${user.reg}</td>
		</tr>
	</table>
	
	
		<br/><a href="${context }/member.do"><img src="${img}/user.jpg" alt="user" style="width: 30px"/></a>

	</div>