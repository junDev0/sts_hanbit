// var application = (function(){})();  IIFE 패턴
var app = (function(){
	var init = function(context) {
		sessionStorage.setItem('context',context);
		sessionStorage.setItem('js',context+'/resources/js');
		sessionStorage.setItem('css',context+'/resources/css');
		sessionStorage.setItem('img',context+'/resources/img');
		move();
		$('#global_content').addClass('box');
		$('#global_content').addClass('cursor');
		$('#global_content h2').text('서비스를 이용하시려면 회원가입을 하셔야 합니다');
		$('#global_content_a_regist').text('SIGN UP').click(function(){util.move('member','regist');});
		$('#global_content_a_login').text('LOGIN').click(function(){util.move('member','login');});
		$('#global_content_a_admin').text('ADMIN MODE').click(function(){util.move('user','main');}).click(function(){admin.check();});
		$('#global_content').addClass('remove_underline');

	};
	var context = function(){
		return sessionStorage.getItem('context');
	};
	var js = function(){
		return sessionStorage.getItem('js');
	};
	var css = function(){
		return sessionStorage.getItem('css');
	};
	var img = function(){
		return sessionStorage.getItem('img');
	};
	var to_douglas = function() {
		location.href=context()+"/douglas.do";
	};
	var move = function(){
		$('#title').click(function(){
			util.home();
		});
		$('#a_member').click(function(){
			util.move('member','main');
		});
		$('#a_grade').click(function(){
			util.move('grade','main');
		});
		$('#a_account').click(function(){
			util.move('account','main');
		});
		$('#a_school').click(function(){
			util.move('global','school_info');
		});
		
	}
	return {
		init : init,
		to_douglas : to_douglas,
		move : move,
		context : context,
		img:img,
		js:js,
		css:css
	}
})();

var admin = (function(){
	var _pass;
	var getPass = function(){return this._pass;};
	var setPass = function(pass){this._pass = pass;};
	return{
		getPass : getPass,
		setPass : setPass,
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

var util = (function(){
	var _page,_directory;
	var setPage = function(page){this._page=page;};
	var setDirectory = function(directory){this._directory=directory;};
	var getPage = function(){return this._page;};
	var getDirectory = function(){return this._directory};
	return {
		setPage : setPage,
		getPage : getPage,
		setDirectory : setDirectory,
		getDirectory : getDirectory,
	
		move : function(directory,page){
			setDirectory(directory);
			setPage(page);
			location.href = app.context()+'/'+getDirectory()+'/'+getpage();
		},
		isNumber : function(value){
			return typeof value == 'number' && isFinite(value);
		},
		home : function(){location.href=app.context()+'/'}

	};
})();
var move = function(directory,page){
	location.href = app.context()+'/'+directory+'/'+page;
}

var user = (function(){
	   var context = sessionStorage.getItem("context");
	   return {
	      init : function() {
	         $('#bt_bom').click(function(){move(context,'bom');});
	         $('#bt_dom').click(function(){move(context,'dom');});
	         $('#bt_kaup').click(function(){move(context,'kaup');});
	         $('#bt_account').click(function(){move(context,'account');});
	      },
	   account : function(){
	         $('#account_regist').click(function(){location.href=app.context()+"/account/regist"});
	         $('#account_deposit').click(function(){location.href=app.context()+"/account/deposit"});
	         $('#account_withdraw').click(function(){location.href=app.context()+"/account/withdraw"});
	         $('#account_update').click(function(){location.href=app.context()+"/account/update"});
	         $('#account_delete').click(function(){location.href=app.context()+"/account/delete"});
	         $('#account_list').click(function(){location.href=app.context()+"/account/list"});
	         $('#account_search').click(function(){location.href=app.context()+"/account/search"});
	         $('#account_count').click(function(){location.href=app.context()+"/account/count"});
	      }
	   };
	})();
var account = (function(){
	var _account_no = 0,_money = 0;
	var setAccountNo = function(account_no){this._account_no=account_no;}
	var getAccountNo = function(){return this._account_no;}
	var setMoney = function(money){_money = money;}
	var getMoney = function(){return _money;}
	return{
		setAccountNo : setAccountNo,
		getAccountNo : getAccountNo,
		setMoney : setMoney,
		getMoney : getMoney,
		init : function(){ 
			$('#bt_spec_show').click(member.spec());
			$('#bt_make_account').click(this.spec());
			$('#bt_deposit').click(this.deposit());
			$('#bt_withdraw').click(this.withdraw());
		},
		spec : function account_spec(){
				setAccountNo(Math.floor(Math.random()*899999)+100000);
				document.querySelector('#result_account').innerHTML = getAccountNo();
		},
		deposit : function account_deposit(){
			var r_acc = document.querySelector('#result_account').innerText;
			if(this.getAccountNo == 0){
					//r_acc == null
					//r_acc === undefined
				alert('먼저 통장이 개설되어야 합니다.');
			}else{
				setMoney(getMoney()+Number(document.querySelector('#money').value));
				document.querySelector('#rest_money').innerHTML= getMoney();				
			}
		},
		withdraw : function account_withdraw(){
			setMoney(getMoney()-Number(document.querySelector('#money').value));
			document.querySelector('#rest_money').innerHTML= getMoney();
		}

		
	};
})();

var member2 = (function(){
	var _name='',_gender='',_ssn='';
	var _age = 0;
	var setName = function(name){this._name=name;}
	var getName = function(){return this._name;}
	var setGender = function(gender){this._gender = gender;}
	var getGender = function(){return this._gender}
	var setSsn = function(ssn){this._ssn = ssn;}
	var getSsn = function(){return this._ssn;}
	var setAge = function(age){this._age=age;}
	var getAge = function(){return this._age;}
	return {
		setGender : setGender,
		spec : function member_spec(){
			var date = new Date();
			this._name = document.querySelector('#name').value;
			this._age = 0;
			this._gender = '';
			this._ssn = document.querySelector('#ssn').value;
			
			if(this._name == '' || this._ssn == ''){
				alert('이름 및 주민번호를 입력해주세요.');
			}else{
			
			var gen_ssn = this._ssn.substring(this._ssn.length-1,this._ssn.length);
			switch (Number(gen_ssn)%2) {
			case 0:	this._gender = '여자';
				break;
			default: this._gender = '남자';
				break;
			}
			var age_ssn = this._ssn.substring(0,2);
			var userYear = 1900+Number(age_ssn);
			if(gen_ssn == '3'||gen_ssn == '4'){
				userYear = 2000+Number(age_ssn);
			}
			this._age = Number(date.getFullYear())-userYear;
			
			document.querySelector('#result_name').innerHTML='이름 : '+this._name;
			document.querySelector('#result_age').innerHTML='나이 : '+this._age;
			document.querySelector('#result_gender').innerHTML='성별 : '+this._gender;
			}
		}
		
	};
})();


var kaup = (function(){
	return{
		init : function kaup_init(){
			var bt_kaup_calc = document.getElementById('bt_kaup_calc');
			bt_kaup_calc.addEventListener('click',this.calc,false);
		},
		calc : function kaup_calc(){
			var name=document.querySelector('#name').value;
			var height=document.getElementById('height').value;
			var weight=document.getElementById('weight').value;
			console.log('name'+name);
			console.log('height'+height);
			console.log('weight'+weight);
			var result = '';
			var kaup = weight / (height / 100) / (height / 100);
			if (kaup < 18.5) {
				result = "저체중";
			} else if (kaup < 22.9 && kaup > 18.5) {
				result = "정상";
			} else if (kaup < 24.9 && kaup > 23.0) {
				result = "위험체중";
			} else if (kaup < 29.9 && kaup > 25.0) {
				result = "비만1단계";
			} else if (kaup < 40 && kaup > 30.0) {
				result = "비만2단계";
			} else if (kaup >= 40) {
				result = "비만3단계";
			}
			document.getElementById('result').innerHTML=name+'의 카우푸결과'+result;
			/*return name + "의 BMI지수는 " + Double.parseDouble(String.format("%.2f", kaup)) + "이고, " + result + "이다";*/
		}
	
			
	};
})();




/*account*/
var global = {
		init : function() {
			document.querySelector('#bt_modern_js')
			.addEventListener('click',douglas.to_modernjs,false);
		}
	}


var member = (function(){
	return{
		init : function(){
			$('#regist').click(function(){location.href=app.context()+"/member/regist"});
			$('#detail').click(function(){location.href=app.context()+"/member/detail"});
			$('#update').click(function(){location.href=app.context()+"/member/update"});
			$('#delete').click(function(){location.href=app.context()+"/member/delete"});
			$('#login').click(function(){location.href=app.context()+"/member/login"});
			$('#logout').click(function(){location.href=app.context()+"/member/logout"});
			$('#list').click(function(){location.href=app.context()+"/member/list"});
			$('#findBy').click(function(){location.href=app.context()+"/member/findBy"});
			$('#count').click(function(){location.href=app.context()+"/member/count"});
			$('#member_content_img_home').attr('alt','home').attr('src',app.img()+'/home.png').css('width','30px');
			$('#member_content_a_home').click(function(){location.href=app.context()+"/"});
			$('#member_content').addClass('box').css('font-size','20px');
			$('#member_content > article').css('width','300px').addClass('center').addClass('text_left')
			.css('font-size','20px');
			$('#member_content a').css('font-size','20px').addClass('cursor');
			$('#member_content > h1').text('MEMBER MGMT');
			$('#member_content_ol > li > a').addClass('remove_underline');
			$('#member_content_ol > li:first > a').text('SIGN UP');
			$('#member_content_ol > li:nth(1) > a').text('MY INFO');
			$('#member_content_ol > li:nth(2) > a').text('INFO MODIFY');
			$('#member_content_ol > li:nth(3) > a').text('DROP USER');
			$('#member_content_ol > li:nth(4) > a').text('LOGIN');
			$('#member_content_ol > li:nth(5) > a').text('LOGOUT');
			$('#member_content_ol > li:nth(6) > a').text('LIST');
			$('#member_content_ol > li:nth(7) > a').text('SEARCH');
			$('#member_content_ol > li:nth(8) > a').text('COUNT');
			
		}
	};
})();

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
			$('#a_update').click(function() {location.href=app.context()+"/grade/update.do";});
			$('#a_delete').click(function() {location.href=app.context()+"/grade/delete.do";});
			$('#a_list').click(function() {location.href=app.context()+"/grade/list.do";});
			$('#a_count').click(function() {location.href=app.context()+"/grade/count.do";});
			$('#a_find').click(function() {location.href=app.context()+"/grade/search.do";});
		}
	};
})();