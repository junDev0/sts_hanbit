var admin = (function(){
	var _pass;
	var getPass = function(){return this._pass;};
	var setPass = function(pass){this._pass = pass;};
	return{
		getPass : getPass,
		setPass : setPass,
		init : function(){
			$('#a_admin').click(function(){});
		},
		check : function(){
			var isAdmin = confirm('관리자입니까?');
			if(!isAdmin){
				alert('관리자만 접근 가능합니다.');
			}else{
				var password = prompt('관리자 비번을 입력바랍니다.');
				if(password == getPass){
					location.href = sessionStorage.getItem('context');
				}else{
					alert('관리자 비번이 틀립니다.')
				}
			}
		}
	};
})();