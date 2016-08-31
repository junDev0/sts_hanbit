// var application = (function(){})();  IIFE 패턴
var app = (function(){
   var init = function(context) {
	   
	  session.setAttribute(context); 
      onCreate();
      member.init();
      user.init();
      account.init();
      kaup.init();
      grade.init();
      nav.init();
      admin.init();
   };
   var context = function(){return sessionStorage.getItem('context');};
   var js = function(){return sessionStorage.getItem('js');};
   var css = function() {return sessionStorage.getItem('css');};
   var img = function() {return sessionStorage.getItem('img');};
   var to_douglas = function() {util.move('','')};
   var setContentView=function(){
	      $('footer').addClass('bottom').addClass('footer');
	      $('#global_content').addClass('box');
	      $('#global_content a').addClass('cursor_pointer');
	      $('#global_content_a_regist').text('Sign Up').click(function(){controller.move('member','regist')});
	      $('#global_content_a_login').text('Login').click(function(){controller.move('member','login')});
	      $('#global_content_a_admin').text('Admin').click(function(){admin.check()});
	      $('#header_brand').attr('alt','android_icon').attr('src',app.img()+'/android_brand.jpg')
	      .css('width','45px').css('height','45px');

	      
   };
   var onCreate = function() {
	   setContentView();
      $('#title').click(function(){controller.home();});
      $('#a_member').click(function(){controller.move('member','main');});
      $('#a_grade').click(function(){controller.move('grade','main');});
      $('#a_account').click(function(){controller.move('account','main');});
      $('#a_school').click(function(){controller.move('global','school_info');});


}
   return {
      init : init,
      context : context,
      js : js,
      css : css,
      img : img,
      to_douglas : to_douglas,
      onCreate : onCreate,
      setContentView : setContentView
   }
})();



var admin = (function() {
	var _pass;
    var	getPass = function(){return this._pass;};
    var setPass = function(pass){this._pass=pass;};
    var init = function(){onCreate();};
    var setContentView = function(){
	      $('#admin_thumbnail1').attr('alt','mgnt').attr('src',app.img()+'/mgnt.jpg')
	      .css('width','300px').css('height','230px');
	      $('#admin_thumbnail2').attr('alt','grade').attr('src',app.img()+'/grade.jpg')
	      .css('width','300px').css('height','230px');
	      $('#admin_thumbnail3').attr('alt','account').attr('src',app.img()+'/account.jpg')
	      .css('width','300px').css('height','230px');
	      $('#admin_content h3').addClass('text_center');
    };
    var onCreate = function(){
    	setContentView();
        $('#admin_nav #member_mgmt #list').click(function(){controller.move('member','list');});
        $('#admin_nav #member_mgmt #findBy').click(function(){controller.move('member','find');});
        $('#admin_nav #member_mgmt #count').click(function(){controller.move('member','count');});
        $('#admin_nav #account_mgmt #list').click(function(){controller.move('account','list');});
        $('#admin_nav #account_mgmt #open').click(function(){controller.move('account','open');});
        $('#admin_nav #account_mgmt #delete').click(function(){controller.move('account','delete');});
        $('#admin_nav #account_mgmt #find').click(function(){controller.move('account','find');});
        $('#admin_nav #account_mgmt #count').click(function(){controller.move('account','count');});

    };
    
    return {
    	init : init,
    	setContentView : setContentView,
    	onCreate : onCreate,
    	getPass : getPass,
    	setPass : setPass,
    	check : function() {
    		setPass(1);
			var isAdmin = confirm('관리자입니까?');
			if (!isAdmin) {
				alert('관리자만 접근 가능합니다.');
			} else {
				var password = prompt('관리자 비번을 입력바랍니다');
				if(password == getPass()){
					controller.move('admin','main');
				}else{
					alert('관리자 비번이 틀립니다.');
				}
			}
		}
    };
})();




var user = (function(){
	var init = function(){};
	var setContextView = function(){};
	var onCreate = function(){
		setContentView();
        $('#bt_bom').click(function(){controller.move('','bom');});
        $('#bt_dom').click(function(){controller.move('','dom');});
        $('#bt_kaup').click(function(){controller.move('','kaup');});
        $('#bt_account').click(function(){controller.move('','account');});
        $('#account_regist').click(function(){controller.move('account','regist');});
        $('#account_deposit').click(function(){controller.move('account','deposit');});
        $('#account_withdraw').click(function(){controller.move('account','withdraw');});
        $('#account_update').click(function(){controller.move('account','update');});
        $('#account_delete').click(function(){controller.move('account','delete');});
        $('#account_list').click(function(){controller.move('account','list');});
        $('#account_search').click(function(){controller.move('account','search');});
        $('#account_count').click(function(){controller.move('account','count');});
	};
	  
	   return {
	      init : init,
	   };
	})();


var account = (function(){
	var _account_no = 0,_money = 0;
	var setAccountNo = function(account_no){this._account_no=account_no;}
	var getAccountNo = function(){return this._account_no;}
	var setMoney = function(money){_money = money;}
	var getMoney = function(){return _money;}
	var init = function(){
		
	};
	var setContentView = function(){
		
	};
	var onCreate = function(){
		setContentView();
		$('#bt_spec_show').click(member.spec());
		$('#bt_make_account').click(this.spec());
		$('#bt_deposit').click(this.deposit());
		$('#bt_withdraw').click(this.withdraw());
	};
	return{
		setAccountNo : setAccountNo,
		getAccountNo : getAccountNo,
		setMoney : setMoney,
		getMoney : getMoney,
		init : init,
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

var member = (function(){
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
	var init = function(){
		onCreate();
	};
	var setContentView = function(){
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
		$('#member_regist').addClass('box');
		$('#member_regist_bt_join').addClass('btn').addClass('btn-primary');
		$('#member_regist #bt_cancel').addClass('btn').addClass('btn-danger');
		//
		$('#member_regist_form').addClass('form-horizontal');
		$('#member_regist_form > div').addClass('form-group').addClass('form-group-lg');
		$('#member_regist_form > div > label').addClass('col-sm-2').addClass('control-label');
		$('#member_regist_form > div > div').addClass('col-sm-10');
		$('#member_regist_form > div > div > input').addClass('form-control');
		$('#member_regist #rd_major > label:gt(1)').addClass('radio-inline');
		$('#member_regist #ck_subject').addClass('checkbox');
		$('#member_regist #ck_subject > label').addClass('checkbox-inline');	
		$('#member_find_form').attr('action',sessionStorage.getItem('context')+'/member/search');
		$('#member_find_form input[type="submit]"').click(function(e){
			$('member_find_form').submit();
		});
		$('#member_find_form input[type="hidden"]').attr('name','context').attr('value',app.context());
	};
	var onCreate = function(){
		setContentView();
		$('#regist').click(function(){controller.move('member','regist');});
		$('#detail').click(function(){controller.move('member','detail');});
		$('#update').click(function(){controller.move('member','update');});
		$('#delete').click(function(){controller.move('member','delete');});
		$('#login').click(function(){controller.move('member','login');});
		$('#logout').click(function(){controller.move('member','logout');});
		$('#list').click(function(){controller.move('member','list');});
		$('#findBy').click(function(){controller.move('member','find');});
		$('#count').click(function(){controller.move('member','count');});
	};
	var setName = function(name){this._name=name;}
	var getName = function(){return this._name;}
	var setGender = function(gender){this._gender = gender;}
	var getGender = function(){return this._gender}
	var setSsn = function(ssn){this._ssn = ssn;}
	var getSsn = function(){return this._ssn;}
	var setAge = function(age){this._age=age;}
	var getAge = function(){return this._age;}
	return {
		init : init,
		setName : setName,
		getName : getName,
		setAge : setAge,
		getAge : getAge,
		setSsn : setSsn,
		getSsn : getSsn,
		setGender : setGender,
		getGender : getGender,
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
	var init = function(){
		onCreate();
	};
	var setContentView = function(){
		
	};
	var onCreate = function(){
		setContentView();
		document.addEventListener('click',this.calc,false);
	};
	return{
		init : init,
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



var grade = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#grade_content').addClass('box');
		$('#grade_content > article')
			.css('width','300px')
			.css('text-align','left')
			.css('margin','0 auto');
		$('#img_home').css('width','30px');
		$('#title').css('font-size','40px');
	};
	var onCreate = function(){
		setContentView();
		$('#a_regist').click(function() {controller.move('grade','regist');});
		$('#a_update').click(function() {controller.move('grade','update');});
		$('#a_delete').click(function() {controller.move('grade','delete');});
		$('#a_list').click(function() {controller.move('grade','list');});
		$('#a_count').click(function() {controller.move('grade','count');});
		$('#a_find').click(function() {controller.move('grade','search');});
	};
	return {
		init : init,
		setContentView : setContentView,
		onCreate : onCreate
	}
})();

var session = (function(){
	var setAttribute = function(context){
		sessionStorage.setItem('context',context);
	    sessionStorage.setItem('js',context+'/resources/js');
	    sessionStorage.setItem('css',context+'/resources/css');
	    sessionStorage.setItem('img',context+'/resources/img');
	    	
	};
	var getAttribute = function(){
		return sessionStorage.getItem('context');
		
	};
	
	return {
		setAttribute : setAttribute,
		getAttribute : getAttribute
	}
	
    
})();

var controller = (function(){
	   var _page, _directory;
	   var setPage = function(page){this._page = page;};
	   var setDirectory = function(directory){this._directory = directory;};
	   var getPage = function(){return this._page};
	   var getDirectory = function(){return this._directory};
	   return{
	      setPage : setPage,
	      setDirectory : setDirectory,
	      getPage : getPage,
	      getDirectory : getDirectory,
	      move : function(directory,page){
	         setDirectory(directory);
	         setPage(page);
	         location.href=app.context()+'/'+getDirectory()+'/'+getPage();
	      },
	      isNumber : function(value){
	         return typeof value === 'number' && isFinite(value);
	      },
	      home : function() {location.href=app.context()+'/';}
	   };
	})();

var util = (function(){
	return {
		isNumber : function(value){
			return typeof value === 'number' && isFinite(value);
		}
	};
})();

var nav = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#nav ul').addClass('last_style_none').addClass('over_hidden').addClass('bg_color_black')
		.css('margin','0').css('padding','0');
		$('#nav li').addClass('float_left').addClass('display_inline')
		.css('border-right','1px').css('solid','#bbb');
		$('#nav li:last-child').addClass('border_right_none');
		$('#nav li a').addClass('display_block').addClass('li_a_color').addClass('text_center')
		.addClass('text_decoration_none').css('padding','14px','16px');
		$('nav li a:hover:not(.active)').addClass('bg_color_green');
		$('nav .active').addClass('bg_color_black');
	};
	var onCreate = function(){
		setContentView();
	};
	return {
		init : init,
		setContentView : setContentView,
		onCreate : onCreate
		
	}
})();