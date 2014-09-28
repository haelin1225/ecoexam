create table club (
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