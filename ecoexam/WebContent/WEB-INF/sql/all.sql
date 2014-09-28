conn system/manager;
drop user ecoexam cascade;
create user ecoexam identified by ecoexam24;
grant connect, resource to ecoexam;
grant create view to ecoexam;
alter user ecoexam account unlock;
conn ecoexam/ecoexam24;

ALTER SESSION SET NLS_LANGUAGE=American;

drop sequence seq_club;
drop sequence seq_board;
drop sequence seq_file;
drop sequence seq_comments;
drop sequence seq_test;

drop table member;
drop table board;
drop table club;
drop table clubjoin;
drop table post;
drop table attachfile;
drop table comments;
drop table test;
drop table question;
drop table example;
drop table correctanswer;
drop table memberanswer;
drop table clubtest;
drop table grade;

create table member(
memberid	 varchar2(50)	not null,
memberpw	 varchar2(50)	not null, 
memberemail	 varchar2(100)	not null, 
membercreatedate date
);

alter table member add constraint pk_member primary key (memberid);

create table board(
boardno		number(10)	not null,
boardname 	varchar2(50) 	not null
);

alter table board add constraint pk_board primary key (boardno);

create table club(
clubno		 number(10) 	not null, 
clubname	 varchar2(50)	not null, 
clubmanagerid 	 varchar2(50)	not null, 
clubclearok 	 varchar(20)	default 'false',
clubboardno	 number(10)	not null, 
clubcreatedate	 date
);

alter table club add constraint pk_club primary key (clubno);
alter table club add constraint fk_club_managerid foreign key(clubmanagerid) references member(memberid) on delete cascade;
alter table club add constraint fk_club_boardno foreign key(clubboardno) references board(boardno) on delete cascade;

create table clubjoin(
clubno		number(10)	not null, 
memberid	varchar2(50) 	not null,
clubrole	varchar2(50)	default 'clubmember',
clubjoindate 	date,
clubagreeok	varchar2(20)	default 'false'
);

alter table clubjoin add constraint pk_clubjoin primary key (clubno, memberid);
alter table clubjoin add constraint fk_clubjoin_clubno foreign key(clubno) references club(clubno) on delete cascade;
alter table clubjoin add constraint fk_clubjoin_memberid foreign key(memberid) references member(memberid) on delete cascade;

create table post(
postno		number(10)	not null,
posttitle	varchar2(100)	default '제목없음',
memberid	varchar2(50) 	not null, 
postcontent	varchar2(500) 	not null,
postcreatedate	date, 
postcount 	number(10)	default 0, 
boardno 	number(10) 	not null
);

alter table post add constraint pk_post primary key (postno);
alter table post add constraint fk_post_memberid foreign key(memberid) references member(memberid) on delete cascade;
alter table post add constraint fk_post_boardno foreign key(boardno) references board(boardno) on delete cascade;

create table faq(
faqno		number(10)	not null,
faqtitle	varchar2(100)	not null,
faqcontent	varchar2(500) 	not null,
faqcreatedate	date, 
faqcount 	number(10)	default 0, 
category 	varchar2(50),
boardno		number(10) not null
);

alter table faq add constraint pk_faq primary key (faqno);
alter table faq add constraint fk_faq_boardno foreign key(boardno) references board(boardno) on delete cascade;


create table attachfile(
fileno		number(10) 	not null, 
postno 		number(10) 	not null, 
filename	varchar2(100)
);

alter table attachfile add constraint pk_attachfile primary key (fileno);
alter table attachfile add constraint fk_attachfile_postno foreign key(postno) references post(postno) on delete cascade;

create table comments(
commentsno	number(10)	not null, 
postno 		number(10) 	not null, 
memberid 	varchar2(50)	not null, 
commentscontent varchar2(500), 
commentscreatedate date
);

alter table comments add constraint pk_comments primary key (commentsno);
alter table comments add constraint fk_comments_postno foreign key(postno) references post(postno) on delete cascade;
alter table comments add constraint fk_comments_memberid foreign key(memberid) references member(memberid) on delete cascade;

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

create table question(
testno		varchar2(50)	not null, 
questionno	number(10)	not null,
question	varchar2(500)	not null, 
questioncontent varchar2(500), 
questionkind	varchar2(50)	not null
);

alter table question add constraint pk_question primary key (testno, questionno);
alter table question add constraint fk_question_testno foreign key(testno) references test(testno) on delete cascade;


create table example(
testno		varchar2(50) 	not null, 
questionno 	number(10) 	not null, 
exampleno 	number(10) 	not null, 
examplecontent 	varchar2(500) 	not null
);

alter table example add constraint pk_example primary key (testno,questionno,exampleno);
alter table example add constraint fk_example_questionno foreign key(testno,questionno) references question(testno,questionno) on delete cascade;

create table correctanswer(
testno 		varchar2(50) 	not null, 
questionno 	number(10) 	not null, 
correctanswer 	varchar2(100) 	not null, 
questionpoint 	number(10) 	not null
);

alter table correctanswer add constraint pk_correctanswer primary key (testno, questionno);
alter table correctanswer add constraint fk_correctanswer_questionno foreign key(testno,questionno) references question(testno,questionno) on delete cascade;
ALTER TABLE correctanswer DROP CONSTRAINT fk_correctanswer_questionno;

create table memberanswer(
testno 		varchar2(50) 	not null,
memberid 	varchar2(50) 	not null, 
questionno 	number(10) 	not null, 
memberanswer 	varchar2(100) 	not null
);

alter table memberanswer add constraint pk_memberanswer primary key (testno,memberid,questionno);
alter table memberanswer add constraint fk_memberanswer_memberid foreign key(memberid) references member(memberid) on delete cascade;
alter table memberanswer add constraint fk_memberanswer_questionno foreign key(testno,questionno) references question(testno,questionno) on delete cascade;

create table clubtest(
testno 		varchar2(50) 	not null, 
clubno 		number(10) 	not null
);

alter table clubtest add constraint pk_clubtest primary key (testno, clubno);
alter table clubtest add constraint fk_clubtest_testno foreign key(testno) references test(testno) on delete cascade;
alter table clubtest add constraint fk_clubtest_clubno foreign key(clubno) references club(clubno) on delete cascade;

create table grade(
clubno 		number(10) 	not null,
memberid 	varchar2(50) 	not null, 
testno 		varchar2(50) 	not null,
grade 		number(10)
);

alter table grade add constraint pk_grade primary key (clubno, memberid, testno);
alter table grade add constraint fk_grade_clubno foreign key(clubno) references club(clubno) on delete cascade;
alter table grade add constraint fk_grade_memberid foreign key(memberid) references member(memberid) on delete cascade;
alter table grade add constraint fk_grade_testno foreign key(testno) references test(testno) on delete cascade;


create sequence seq_club
increment by 1
start with 1
maxvalue 9999999
nocache
nocycle;

create sequence seq_board
increment by 1
start with 1
maxvalue 9999999
nocache
nocycle;

create sequence seq_file
increment by 1
start with 1
maxvalue 9999999
nocache
nocycle;

create sequence seq_comments
increment by 1
start with 1
maxvalue 9999999
nocache
nocycle;

create sequence seq_test
increment by 1
start with 1
maxvalue 9999999
nocache
nocycle;

create sequence seq_post
increment by 1
start with 1
maxvalue 9999999
nocache
nocycle;

create sequence seq_faq
increment by 1
start with 1
maxvalue 9999999
nocache
nocycle;

commit;