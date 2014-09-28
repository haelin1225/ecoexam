create table member (
	memberid	 varchar2(50)	not null,
	memberpw	 varchar2(50)	not null, 
	memberemail	 varchar2(100)	not null, 
	membercreatedate date
);

alter table member add constraint pk_member primary key (memberid);