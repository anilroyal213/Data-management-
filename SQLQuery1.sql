create schema Anil authorization AnilVenkat;

create table Anil.anilsProjectUsersData(
id int identity(1,1),
name varchar(25),
dob date,
age int,
email varchar(250),
phoneNumber varchar(15),
userName varchar(25),
passWord varchar(25),
isDelete bit,
createdOn Datetime,
createdBy varchar(25),
updatedOn Datetime,
updatedBy varchar(25)
);



INSERT INTO Anil.anilsProjectUsersData
(name, dob, age, email, phoneNumber, userName, passWord, isDelete, createdOn, createdBy, updatedOn, updatedBy)
VALUES
('John Doe', '1980-01-01', 41, 'johndoe1@example.com', '1234567890', 'johndoe1', 'password123', 0, GETDATE(), 'user', GETDATE(), 'admin'),
('Jane Doe', '1981-02-02', 40, 'janedoe2@example.com', '1234567891', 'janedoe2', 'password123', 0, GETDATE(), 'user', GETDATE(), 'admin'),
('Jim Doe', '1982-03-03', 39, 'jimdoe3@example.com', '1234567892', 'jimdoe3', 'password123', 0, GETDATE(), 'user', GETDATE(), 'admin'),
('Jill Doe', '1983-04-04', 38, 'jilldoe4@example.com', '1234567893', 'jilldoe4', 'password123', 0, GETDATE(), 'admin', GETDATE(), 'admin'),
('Jack Doe', '1984-05-05', 37, 'jackdoe5@example.com', '1234567894', 'jackdoe5', 'password123', 0, GETDATE(), 'admin', GETDATE(), 'admin'),
('Jerry Doe', '1985-06-06', 36, 'jerrydoe6@example.com', '1234567895', 'jerrydoe6', 'password123', 0, GETDATE(), 'admin', GETDATE(), 'admin'),
('Jenny Doe', '1986-07-07', 35, 'jennydoe7@example.com', '1234567896', 'jennydoe7', 'password123', 0, GETDATE(), 'admin', GETDATE(), 'admin'),
('Jeff Doe', '1987-08-08', 34, 'jeffdoe8@example.com', '1234567897', 'jeffdoe8', 'password123', 0, GETDATE(), 'admin', GETDATE(), 'admin'),
('Julia Doe', '1988-09-09', 33, 'juliadoe9@example.com', '1234567898', 'juliadoe9', 'password123', 0, GETDATE(), 'admin', GETDATE(), 'admin'),
('Jake Doe', '1989-10-10', 32, 'jakedoe10@example.com', '1234567899', 'jakedoe10', 'password123', 0, GETDATE(), 'admin', GETDATE(), 'admin');


select * from Anil.anilsProjectUsersData;


create table Anil.AdminsData(
id int identity(1,1),
userName varchar(25),
passWord varchar(25)
);

INSERT INTO Anil.AdminsData (userName, passWord)
VALUES 
('admin1111', 'password1'),
('admin2222', 'password2'),
('admin3333', 'password3'),
('admin4444', 'password4'),
('admin5555', 'password5');


truncate table Anil.AdminsData;


select * from Anil.AdminsData;

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


INSERT INTO Anil.UsersData (fileName, fileType, fileContent, belongsTo, isDelete, createdBy, createdOn, updatedBy, updatedOn)
VALUES 
('file1.txt', 'txt', 'This is the content of file1.txt', 'admin1', 0, 'admin1', GETDATE(), 'admin1', GETDATE()),
('file2.txt', 'txt', 'This is the content of file2.txt', 'admin2', 0, 'admin2', GETDATE(), 'admin2', GETDATE()),
('file3.txt', 'txt', 'This is the content of file3.txt', 'admin3', 0, 'admin3', GETDATE(), 'admin3', GETDATE()),
('file4.txt', 'txt', 'This is the content of file4.txt', 'admin4', 0, 'admin4', GETDATE(), 'admin4', GETDATE()),
('file5.txt', 'txt', 'This is the content of file5.txt', 'admin5', 0, 'admin5', GETDATE(), 'admin5', GETDATE()),
('file6.txt', 'txt', 'This is the content of file6.txt', 'admin1', 0, 'admin1', GETDATE(), 'admin1', GETDATE()),
('file7.txt', 'txt', 'This is the content of file7.txt', 'admin2', 0, 'admin2', GETDATE(), 'admin2', GETDATE()),
('file8.txt', 'txt', 'This is the content of file8.txt', 'admin3', 0, 'admin3', GETDATE(), 'admin3', GETDATE()),
('file9.txt', 'txt', 'This is the content of file9.txt', 'admin4', 0, 'admin4', GETDATE(), 'admin4', GETDATE()),
('file10.txt', 'txt', 'This is the content of file10.txt', 'admin5', 0, 'admin5', GETDATE(), 'admin5', GETDATE()),
('file11.txt', 'txt', 'This is the content of file11.txt', 'admin1', 0, 'admin1', GETDATE(), 'admin1', GETDATE()),
('file12.txt', 'txt', 'This is the content of file12.txt', 'admin2', 0, 'admin2', GETDATE(), 'admin2', GETDATE()),
('file13.txt', 'txt', 'This is the content of file13.txt', 'admin3', 0, 'admin3', GETDATE(), 'admin3', GETDATE()),
('file14.txt', 'txt', 'This is the content of file14.txt', 'admin4', 0, 'admin4', GETDATE(), 'admin4', GETDATE()),
('file15.txt', 'txt', 'This is the content of file15.txt', 'admin5', 0, 'admin5', GETDATE(), 'admin5', GETDATE()),
('file16.txt', 'txt', 'This is the content of file16.txt', 'admin1', 0, 'admin1', GETDATE(), 'admin1', GETDATE()),
('file17.txt', 'txt', 'This is the content of file17.txt', 'admin2', 0, 'admin2', GETDATE(), 'admin2', GETDATE()),
('file18.txt', 'txt', 'This is the content of file18.txt', 'admin3', 0, 'admin3', GETDATE(), 'admin3', GETDATE()),
('file19.txt', 'txt', 'This is the content of file19.txt', 'admin4', 0, 'admin4', GETDATE(), 'admin4', GETDATE()),
('file20.txt', 'txt', 'This is the content of file20.txt', 'admin5', 0, 'admin5', GETDATE(), 'admin5', GETDATE()),
('file21.txt', 'txt', 'This is the content of file21.txt', 'admin1', 0, 'admin1', GETDATE(), 'admin1', GETDATE());


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

select * from Anil.History




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



