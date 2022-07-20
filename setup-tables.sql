create table review(
id int primary key auto_increment,
name varchar(30) not null,
text char(255) not null,
registered datetime,
evaluation int not null);