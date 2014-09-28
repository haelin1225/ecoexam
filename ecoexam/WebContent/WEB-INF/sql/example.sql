create table example(
	testno		varchar2(50) 	not null, 
	questionno 	number(10) 	not null, 
	exampleno 	number(10) 	not null, 
	examplecontent 	varchar2(500) 	not null
);

alter table example add constraint pk_example primary key (testno,questionno,exampleno);
alter table example add constraint fk_example_questionno foreign key(testno,questionno) references question(testno,questionno) on delete cascade;