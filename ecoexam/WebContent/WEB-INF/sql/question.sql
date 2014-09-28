create table question(
	testno		varchar2(50)	not null, 
	questionno	number(10)	not null,
	question	varchar2(500)	not null, 
	questioncontent varchar2(500), 
	questionkind	varchar2(50)	not null
);

alter table question add constraint pk_question primary key (testno, questionno);
alter table question add constraint fk_question_testno foreign key(testno) references test(testno) on delete cascade;
