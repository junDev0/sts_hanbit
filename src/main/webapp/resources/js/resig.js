var grade = (function(){
	return {
		init : function(){
			
			$('#grade_content').addClass('box');
			$('#grade_content > article')
				.css('width','300px')
				.css('text-align','left')
				.css('margin','0 auto');
			$('#img_home').css('width','30px');
			$('#title').css('font-size','40px');
			$('#a_regist').click(function() {location.href=app.context()+"/grade/regist.do";});
			$('#a_update').click(function() {location.href=app.context()+"/grade/update.do";	});
			$('#a_delete').click(function() {location.href=app.context()+"/grade/delete.do";});
			$('#a_list').click(function() {location.href=app.context()+"/grade/list.do";});
			$('#a_count').click(function() {location.href=app.context()+"/grade/count.do";});
			$('#a_find').click(function() {location.href=app.context()+"/grade/search.do";});
		}
	};
})();