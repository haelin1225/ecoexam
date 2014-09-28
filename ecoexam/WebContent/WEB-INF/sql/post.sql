create table post (
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