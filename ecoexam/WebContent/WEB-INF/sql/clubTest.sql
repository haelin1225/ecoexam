create table clubtest(
	testno 		varchar2(50) 	not null, 
	clubno 		number(10) 	not null
);

alter table clubtest add constraint pk_clubtest primary key (testno, clubno);
alter table clubtest add constraint fk_clubtest_testno foreign key(testno) references test(testno) on delete cascade;
alter table clubtest add constraint fk_clubtest_clubno foreign key(clubno) references club(clubno) on delete cascade;
