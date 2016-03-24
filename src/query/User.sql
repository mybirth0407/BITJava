drop table if exists User;
CREATE TABLE User(
	no int unsigned not null auto_increment primary key,
	email varchar(100) not null,
	name varchar(20) not null,
	passwd varchar(41) not null,
	birth_year int unsigned not null,
	birth_month int unsigned not null,
	birth_day int unsigned not null,
	gender char(1) not null,
	selfintro text  
);

select * from User;