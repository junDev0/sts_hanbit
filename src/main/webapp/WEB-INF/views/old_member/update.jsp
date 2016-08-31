
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
div.box1 {
    border: 5px solid powderblue;
    padding: 30px;
    margin: 0 auto;
    width: 600px;
    text-align: center;
}
	#member_detail{border: 1px solid gray; width: 90%;height: 200px; margin: 0 auto;border-collapse: collapse;}
	#member_detail tr{border: 1px solid gray;height: 20%}
	#member_detail tr td{border: 1px solid gray;}
	.font_bold{font-weight: bold;}
	.bg_color_yellow{background-color:yellow}
</style>
<div class="box">
<!-- 	//id,age,name,regDate,gender,profileImg -->
	<h2>${update_result}</h2> <br/>
	<h2>회원 상세정보</h2>
	<form action="${context }/member.do?page=update&action=update" method="post">
	<table id = "member_detail">
		<tr>
			<td rowspan="4" style ="width:30%"><img src="${img}/${user.img}" alt="W3Schools.com" width="104" height="142"></td>
			<td style ="width:20%" class="font_bold bg_color_yellow">ID</td>
			<td style="width: 40%">${user.id}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">비밀번호</td>
			<td ><input type="text" name="pw" value="${user.pw}"/></td>
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
			<td colspan="2"><input type="text" name="e-mail" value="${user.email}"/></td>
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
		<input type="hidden" name = "id" value="${user.id}">
			<input type="submit" value="수정"/>
  		<input type="reset" value="취소"/>
	</form>
		<br/><a href="${context }/member.do"><img src="${img}/user.jpg" alt="user" style="width: 30px"/></a>
		<a href="${context }/home.do"><img src="${img}/home.png" alt="home" style="width: 30px"/></a>

	</div>
