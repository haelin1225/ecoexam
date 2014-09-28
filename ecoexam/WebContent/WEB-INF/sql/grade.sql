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