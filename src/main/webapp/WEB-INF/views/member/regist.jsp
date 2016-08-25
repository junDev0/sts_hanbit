<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<section id="member_regist">
	<form id="member_regist_form" action="${context }/member.do?action=regist" method="post">
		<div class="form-group">
			<label for="exampleInputName">이름</label>
			<div><input type="text" name="name" placeholder="NAME"/></div>
		</div>
		<div class="form-group">
			<label for="exampleInputId">ID</label>
			<div><input type="text" name="id" placeholder="ID"/></div>
		</div>
		<div class="form-group">
			<label for="exampleInputId">PW</label>
			<div><input type="password" name="pw" placeholder="PW"/></div>
		</div>
		<div class="form-group">
			<label for="exampleInputId">EMAIL</label>
			<div><input type="text"  name="email" placeholder="EMAIL"/></div>
		</div>
		<div class="form-group">
			<label for="exampleInputId">SSN</label>
			<div><input type="text"  name="ssn" placeholder="SSN"/></div>
		</div>
		<div class="form-group">
			<label for="exampleInputId">휴대폰</label>
			<div><input type="text" name="phone" placeholder="PHONE"/></div>
		</div>
		<div id="rd_major">
		<label for="exampleInputId">전공</label><br>
		<label class="radio-inline"><input type="radio"  id="inlineRadio1" name="major" value="computer" checked/> 컴공학부</label>
		<label class="radio-inline"><input type="radio"  id="inlineRadio2" name="major" value="mgmt" /> 경영학부</label>
		<label class="radio-inline"><input type="radio"  id="inlineRadio3"name="major" value="math" /> 수학부</label>
		<label class="radio-inline"><input type="radio" id="inlineRadio4" name="major" value="eng" /> 영문학부</label>
		</div>	
	<div>
    <label for="exampleInputId">수강과목</label><br>
    <div>
      <div id="ck_subject" class="checkbox">
		
		<label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox1" name="subject" value="java" /> Java</label>
		<label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox2" name="subject" value="sql" /> SQL</label>
		<label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox3" name="subject" value="cpp" /> C++</label>
		<label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox4" name="subject" value="python" /> 파이썬</label>
		<label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox5" name="subject" value="delphi" /> 델파이</label>
		<label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox6" name="subject" value="html" /> HTML</label>
      </div>
    </div>
  </div>

		
		<input type="hidden" name = "directory" value="home"/>
		<input id="member_regist_bt_join" type="submit" value="회원가입"/>
  		<input id="bt_cancel" type="reset" value="취소"/>
	</form>
		<br/><a href="${context}/index.jsp"><img src="${img }/home.png" alt="home" style="width: 30px"/></a>
	
</section>