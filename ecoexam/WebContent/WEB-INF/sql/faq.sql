create table faq(
	faqno		number(10)	not null,
	faqtitle	varchar2(100)	not null,
	faqcontent	varchar2(500) 	not null,
	faqcreatedate	date, 
	faqcount 	number(10)	default 0, 
	category 	varchar2(50),
	boardNo		number(10) not null
);

alter table faq add constraint pk_faq primary key (faqno);
alter table faq add constraint fk_faq_boardno foreign key(boardno) references board(boardno) on delete cascade;