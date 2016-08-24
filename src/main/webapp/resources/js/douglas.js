var util = (function(){
	var _page,_directory;
	var setPage = function(page){this._page=page;};
	var setDirectory = function(directory){this._directory=directory;};
	var getPage = function(){return this._page;};
	var getDirectory = function(){return this._directory};
	return {
		move : function(directory,page){
			var context= sessionStorage.getItem("context")+'/'+getDirectory()+'.do?page='+getPage();
			setDirectory(directory);
			setPage(page);
			location.href = context+'/douglas.do?page='+page;
		},
		isNumber : function(value){
			return typeof value == 'number' && isFinite(value);
		}
	};
})();
var move = function(context,page){
	location.href = context+'/douglas.do?page='+page;
}

var douglas = (function(){
		var context= sessionStorage.getItem("context");
		var init = function() {
		$('#bt_bom').click(function(){move(context,'bom');});
		$('#bt_dom').click(function(){move(context,'dom');});
		$('#bt_kaup').click(function(){move(context,'kaup');});
		$('#bt_account').click(function(){move(context,'account');});
	};
	return{
		init : init
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