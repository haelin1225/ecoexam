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
