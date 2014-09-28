create table memberanswer(
	testno 		varchar2(50) 	not null,
	memberid 	varchar2(50) 	not null, 
	questionno 	number(10) 	not null, 
	memberanswer 	varchar2(100) 	not null
);

alter table memberanswer add constraint pk_memberanswer primary key (testno,memberid,questionno);
alter table memberanswer add constraint fk_memberanswer_memberid foreign key(memberid) references member(memberid) on delete cascade;
alter table memberanswer add constraint fk_memberanswer_questionno foreign key(testno,questionno) references question(testno,questionno) on delete cascade;
