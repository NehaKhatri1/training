create table test1 ( col1 varchar);
insert into test1 values('abcd');
alter table test1 add column col2 varchar;
insert into test1 values('abcde','lksjf')
update bookdetails set category='arts' where username='ma'
alter table login alter column urldata varchar(20000000)

create table login ( fullname varchar(255) , emailId varchar(255) , category varchar (255) , gender varchar (200), Password varchar(200))
create table userNameCategoryBookIdBookName ( username varchar(255) , category varchar(255) , bookid varchar(255) , bookname varchar(255))

create table bookDetails( bookid varchar(255) , bookname varchar(255) , pageContent varchar(2000000) , username varchar(255) , category varchar(255) , topicNumberAndName varchar(255))


alter table bookDetails alter column bookid varchar(255) not null; 
alter table bookDetails add primary key (bookid ) ( this is working and copied )


drop/delete  column in a table
ALTER TABLE COURSETABLE DROP COLUMN HANDSHAKEFLAG ;