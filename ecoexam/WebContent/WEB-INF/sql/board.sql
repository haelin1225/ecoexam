create table board (
	boardno		number(10)	not null,
	boardname 	varchar2(50) 	not null
);

alter table board add constraint pk_board primary key (boardno);