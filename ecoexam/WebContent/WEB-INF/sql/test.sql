create table test(
testno 		varchar2(50) 	not null,
testmakerid	varchar2(50)	not null, 
testname	varchar2(100)	not null, 
testtime	number(10),
testtotalscore 	number(10) 	not null, 
testpoint 	varchar2(50), 
testkind 	varchar2(50), 
testexamplecount number(10),
testtotalquestion number(10) 	not null, 
testfilename 	varchar2(100),
testcreatedate date not null
);


alter table test add constraint pk_test primary key (testno);
alter table test add constraint fk_test_memberid foreign key(testmakerid) references member(memberid) on delete cascade;