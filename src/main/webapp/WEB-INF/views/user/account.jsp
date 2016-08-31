<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/douglas.css"/>

<script src="${js}/douglas.js"></script>
<div id= "container">
<section class="formbox">
	<p>Creator 학습장</p>
	<p>회원 정보 입력</p>
	이름 : <input type="text" id="name" name="name" value="" />
	SSN : <input type="text" id="ssn" name="ssn" value="" />
	<button id = "bt_spec_show">회원정보 보기</button>
	<button id = "bt_make_account">통장개설</button>
</section>
<section class = "formbox">
	<p>회원정보</p>
	<article id = "result_name"></article>
	<article id = "result_age"></article>
	<article id = "result_gender"></article>
	<article id = "result_account"></article>
	<article id = "rest_money"></article>
</section>
<section>
<p style='display: inline;'>입.출금 : </p>
	금액 : <input type="text" id="money" name="money" value=""/>
	<button id = "bt_deposit">입금</button>	
	<button id = "bt_withdraw">출금</button>	
</section>
</div>

<script>
account.init();
</script>
