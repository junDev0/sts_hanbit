<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul id = "admin_nav" class="nav nav-tabs">
  <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      회원관리 <span class="caret"></span>
    </a>
    <ul id = "member_mgmt" class="dropdown-menu">

		<li><a id = "list" href="#">목록 </a></li>
		<li><a id = "findBy" href="#">검색</a></li>
		<li><a id = "count" href="#">회원수</a></li>
    </ul>
  </li>
  <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      성적관리 <span class="caret"></span>
    </a>
    <ul id = "grade_mgmt" class="dropdown-menu">
    	<li><a id = "g_regist" href="#">등록</a></li>
		<li><a id = "g_detail" href="#">상세</a></li>
		<li><a id = "g_update" href="#">수정 </a></li>
		<li><a id = "g_delete" href="#">삭제 </a></li>
		<li><a id = "g_list" href="#">목록 </a></li>
		<li><a id = "g_count" href="#">카운트</a></li>
		<li><a id = "g_find" href="#">검색</a></li>    
    </ul>
  </li>
  <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      계좌관리 <span class="caret"></span>
    </a>
    <ul id= "account_mgmt" class="dropdown-menu">
    	<li><a id="list" href="#">목록</a></li>
		<li><a id="find" href="#">조회</a></li>
		<li><a id="count" href="#">통장수</a></li>
    </ul>
  </li>    
</ul>
<script type="text/javascript">
$(function(){
	$('#admin_nav').css('height','50px');
});
</script>