create table member(
    no integer unsigned not null primary key auto_increment,
    email varchar(200) not null default '',
    passwd varchar(20) not null,
    name varchar(20) not null
    );

create table member(
    no integer unsigned not null,
    email varchar(200) not null default '',
    passwd varchar(20) not null,
    name varchar(20) not null,
    primary key no
    );

    
insert into member
    values(null, 'kickscar@gmail.com', passwd('kickscar'), 'daehyuck');
    
-- login
select *
from member
where email = 'kickscar@gmail.com' and passwd('hello');

-- table modify
alter table member
add column resident_registration_number char(14) not null;

alter table member
drop column resident_registration_number;

alter table member
add clomun join_date datetime not null;

alter table member
change name name varchar(100) not null;

alter table member rename user;

desc member;