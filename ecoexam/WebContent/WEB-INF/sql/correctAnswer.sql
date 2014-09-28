create table correctanswer(
	testno 		varchar2(50) 	not null, 
	questionno 	number(10) 	not null, 
	correctanswer 	varchar2(100) 	not null, 
	questionpoint 	number(10) 	not null
);

alter table correctanswer add constraint pk_correctanswer primary key (testno, questionno);
alter table correctanswer add constraint fk_correctanswer_questionno foreign key(testno,questionno) references question(testno,questionno) on delete cascade;
ALTER TABLE correctanswer DROP CONSTRAINT fk_correctanswer_questionno;