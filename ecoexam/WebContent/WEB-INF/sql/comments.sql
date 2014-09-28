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