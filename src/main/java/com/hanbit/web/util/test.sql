select * from member_bean;
select * from grade;
select * from account_member;
	id varchar(20) primary key,
	pw varchar(20),
	name varchar(20),
	regDate varchar(20),
	gender varchar(20),
	ssn varchar(20),
	profile_img varchar2(100),
	email varchar2(30),
	phone varchar2(15),


select * from account_member where account_no = 909709;
select * from member_bean where id ='hong';
select * from SUBJECT_MEMBER;
select count(*) as count from member_bean where id = 'hong';

select * from subject;
select * from subject where id = 'hong';
