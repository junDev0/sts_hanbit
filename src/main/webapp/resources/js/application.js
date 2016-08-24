// var application = (function(){})();  IIFE 패턴
var app = (function(){
	var init = function(context) {
		sessionStorage.setItem('context',context);
		move();
		
	};
	var context = function(){
		return sessionStorage.getItem('context');
	};
	var to_douglas = function() {
		location.href=context()+"/douglas.do";
	};
	var move = function(){
		$('#title').click(function(){
			location.href=context()+"/";
		});
		$('#a_member').click(function(){
			location.href = context()+"/member/main";
		});
		$('#a_grade').click(function(){
			alert('===');
			location.href = context()+"/member/main";
			/*location.href = context()+"/grade/main";*/
		});
		$('#a_account').click(function(){
			location.href = context()+"/account/main";
		});
		$('#a_school').click(function(){
			location.href = context()+"/global/school_info";
		});
		
	}
	return {
		init : init,
		to_douglas : to_douglas,
		move : move,
		context : context
	}
})();