insert into member 
values('M1','1111','one@',sysdate);
insert into member 
values('M2','2222','two@',sysdate);


insert into board 
values(seq_board.nextval,'B1');

insert into club 
values(seq_club.nextval,'C1','M1','false',1,sysdate);
insert into club 
values(seq_club.nextval,'C2','M1','false',1,sysdate);

insert into clubjoin 
values(1,'M1','clubmember',sysdate,'false');

insert into post 
values(seq_post.nextval,'P1','M1','post content',sysdate,0,1);

insert into attachfile 
values(seq_file.nextval,1,'file name');

insert into comments 
values(seq_comments.nextval,1,'M1','comments content',sysdate);

insert into test 
values('N'||seq_test.nextval,'M1','T1',100,100,'true','去钦屈',1,1,'C:\');
insert into test 
values('N'||seq_test.nextval,'M1','T1',100,100,'false','按包侥',1,1,'C:\');

insert into test(testno,testmakerid,testname,testtime,testtotalscore,testtotalquestion,testfilename) 
values('E'||seq_test.nextval,'M1','exist1',100,100,1,'C:\exist\one.docx');
insert into test(testno,testmakerid,testname,testtime,testtotalscore,testtotalquestion,testfilename) 
values('E'||seq_test.nextval,'M1','exist2',100,100,1,'C:\exist\two.docx');

insert into question 
values('N1',1,'question?','question content','按包侥');

insert into example 
values('N1',1,1,'example content');

insert into correctanswer 
values('N1',1,'5',100);

insert into memberanswer 
values('N1','M1',1,'5');

insert into clubtest 
values('N1',1);

insert into grade 
values(1,'M1','N1',100);

commit;
