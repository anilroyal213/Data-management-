create schema Anil authorization AnilVenkat;

create table Anil.anilsProjectUsersData(
id int identity(1,1),
name varchar(25),
dob date,
age int,
email varchar(250),
phoneNumber varchar(15),
userNmae varchar(25),
passWord varchar(25),
isDelete bit,
createdOn Datetime,
createdBy varchar(25),
updatedOn Datetime,
updatedBy varchar(25)
);

create table Anil.AdminsData(
id int identity(1,1),
userName varchar(25),
passWord varchar(25)
);


CREATE TABLE Anil.Images (
    Id INT PRIMARY KEY IDENTITY(1,1),
	Imagename varchar(30),
    ImageData VARBINARY(MAX)
);


create table Anil.UsersData(
id int identity(1,1),
fileName varchar(50),
fileType varchar(10),
fileContent varchar(max),
belongsTo Varchar(25),
isDelete Bit,
createdBy varchar(25),
createdOn Datetime,
updatedBy varchar(25),
updatedOn Datetime,
);



create table Anil.History(
id int identity(1,1),
fileName varchar(30),
fileType varchar(10),
fileContent varchar(max),
typeOfOperation varchar(10),
changesDoneDate datetime,
changesDoneBy varchar(25),
dataBelongsTo varchar(25)
);




drop table  Anil.Images;
Insert into  Anil.AdminsData values('Anil','Sanjay');

select userName,passWord from  Anil.AdminsData;

drop table  Anil.AdminsData;
INSERT INTO Anil.anilsProjectUsersData
VALUES ('John Doe', '1990-05-15', 30, 'john.doe@example.com', '123456789', 'johndoe', 'password123', 0, GETUTCDATE(), 'Admin', GETUTCDATE(), 'Admin');





INSERT INTO anilsProjectUsersData VALUES();



select * from Anil.anilsProjectUsersData;



drop table Anil.anilsProjectUsersData;

INSERT INTO anilsProjectUsersData VALUES ('ANIL','PULLIRAMAMA');

SELECT * FROM anilsProjectUsersData;



select * from Anil.Images;


drop Table Anil.Images



