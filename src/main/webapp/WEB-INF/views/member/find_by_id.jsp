<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>	
<jsp:include page="../global/navi.jsp"/>
<style type="text/css">
	#member_detail{border: 1px solid gray; width: 90%;height: 300px; margin: 0 auto;border-collapse: collapse;}
	#member_detail tr{border: 1px solid gray;height: 20%}
	#member_detail tr td{border: 1px solid gray;}
	.font_bold{font-weight: bold;}
	.bg_color_yellow{background-color:yellow}
</style>

	<div class="box">
	<h2>내정보보기(ID) 페이지</h2><br/>
		<table id = "member_detail">
		<tr>
			<td rowspan="4" style ="width:30%"><img src="${img}/${result_bean.profileImg}" alt="W3Schools.com" width="104" height="142"></td>
			<td style ="width:20%" class="font_bold bg_color_yellow">ID</td>
			<td style="width: 40%">${result_bean.id}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">비밀번호</td>
			<td >${result_bean.pw}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">이름</td>
			<td>${result_bean.name}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">성별</td>
			<td>${result_bean.gender}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">e-mail</td>
			<td colspan="2">${result_bean.email}</td>
		</tr>
		
		<tr>
			<td class="font_bold bg_color_yellow">생년월일</td>
			<td colspan="2">${result_bean.ssn}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">등록일</td>
			<td colspan="2">${result_bean.regDate}</td>
		</tr>
	</table>
		<a href="${context }/member.do"><img src="${img}/user.jpg" alt="user" style="width: 30px"/></a>

	</div>
<jsp:include page = "../global/footer.jsp"/>
<jsp:include page = "../global/end.jsp"/>