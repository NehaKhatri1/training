

miniSchoolersTables:-

1. table  for signup / registration 
	
		create table user_registration (emailId varchar(255), password varchar(100),Profession varchar(100));	
		insert into user_registration values('lovely@gmail.com','passpass','tutor');	
	
		

		
2.	InvitationTable for to render notifications:- 	

//CREATE TABLE COURSETABLE (EMAIID VARCHAR(500) ,COURSE VARCHAR(500),FIELD VARCHAR(500));

CREATE TABLE  INVITATIONTABLE (RECIPIENTEMAILID varchar(250),SENDEREMAILID varchar(250) ,SENDERIMAGE VARCHAR(20000000), SENDERNAME varchar(250),SENDERCOURSE varchar(250),SENDERFIELD varchar(250));


3. LocationTable


CREATE TABLE LOCATIONTABLEWITHOUTPRIMARYKEY  (EmaiId VARCHAR(255), 
city VARCHAR(500),district VARCHAR(500), state VARCHAR(500), locality VARCHAR(500));

INSERT INTO LOCATIONTABLEWITHOUTPRIMARYKEY   VALUES('nehakhatri10@gmail.com','delhi','null','delhi','dwarka');

select * from LOCATIONTABLE ;



4. CREATE TABLE CourseTable (EmaiId VARCHAR(500) ,Course VARCHAR(500),Field VARCHAR(500));

   INSERT INTO CourseTable VALUES('nehakhatri10@gmail.com','B.com.','accounts');
   
   
   
 5. ALTER TABLE LOCATIONTABLEWITHOUTPRIMARYKEY  ADD PICURLDATA  VARCHAR(1000000);
 
 

		
		
	

		
		
	
insert statements:-

insert into user_registration  values('a@a.com','a','Tutor','amar','null');
insert into user_registration  values('b@b.com','b','Tutor','bob','null');
insert into user_registration  values('x@x.com','x','Student','xylam','null');
insert into user_registration  values('y@y.com','y','Student','yarab','null');
insert into user_registration  values('z1@z1.com','z','Student','zebra1','null');
insert into user_registration  values('z@z.com','z1','Student','zeenga','null');


 
    