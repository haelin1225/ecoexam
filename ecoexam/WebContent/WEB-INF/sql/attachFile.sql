create table attachfile (
	fileno		number(10) 	not null, 
	postno 		number(10) 	not null, 
	filename	varchar2(100)
);

alter table attachfile add constraint pk_attachfile primary key (fileno);
alter table attachfile add constraint fk_attachfile_postno foreign key(postno) references post(postno) on delete cascade;