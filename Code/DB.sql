
--drop database hammad
create database hammad
use hammad

--drop table Teams
create table Team
(
TeamID int primary key
)

--drop table Projects
create table Project(
Team_ID int ,
P_ID int not null,
Name_P nvarchar(30) not null,
Cnic_ProjectManager nvarchar(30) not null,
ProjectManager nvarchar(30) not null,
RequiredBudget int,
primary key(P_ID),
foreign key(Team_ID) references Team(TeamID)
)


--drop table Beneficiary
create table Beneficiary(
B_ID int not null,
p_id int,
Name_B nvarchar(30) not null,
Cnic_B nvarchar(30) not null,
Adress nvarchar(30) not null,
PhoneNo nvarchar(20) not null,
dob nvarchar(20),
Income int,
RequiredMoney int,
primary key(B_ID),
foreign key(P_id) references Project(P_ID) on update cascade
)

--drop table assessor
create table assessor(
A_ID int primary key,
A_name nvarchar(30) not null,
A_Cnic nvarchar(30) not null
)


--drop table Volunteer
create table Volunteer(
V_ID int not null,
Name_V nvarchar(30) not null,
Cnic_V nvarchar(30) not null,
Rank_V nvarchar(20) not null,
Team_ID int not null,
Availability_V nvarchar(20) not null,
primary key(V_ID),
foreign key(Team_id) references Team(TeamID) on update cascade
)

--drop table donor
create table donor(
p_id int not null,
D_ID int not null,
Name_D nvarchar(30) not null,
Cnic_D nvarchar(30) not null,
primary key(D_ID),
foreign key(p_id) references Project(P_ID) 
)

--drop table Fund
create table Fund(
d_id int,
foreign key(d_id) references donor(D_ID) on update cascade,
cash int,
gift nvarchar(20),
Item nvarchar(10)
)

--drop table Questions
create table Questions(
A_id int,
foreign key(A_id) references assessor(A_ID) on update cascade,
Ques nvarchar(50)
)

--drop table selected
create table selected(
B_id int,
foreign key(B_id) references Beneficiary(B_ID) 
)

--drop table donate
create table donate(
d_id int,
b_id int,
foreign key(d_id) references Donor(D_ID),
foreign key(b_id) references Beneficiary(B_ID)
)


---------------

--Team  Entries
insert into Team values('1')
insert into Team values('2')
insert into Team values('3')

--Project Entries
insert into Project values('1','1','Donate Money','35201-6452381-7','Hammad','123000')
insert into Project values('2','2','Donate Gift','35221-2152231-7','Maqsood','223000')
insert into Project values('2','3','Donate Fruit','35221-2152331-7','Masood','123000')

--Beneficary Entries
insert into Beneficiary values('1','1','Ali','35101-9876543-1','Lahore','032112234567','20 Oct 1999','20000','15000')
insert into Beneficiary values('2','1','Hamza','35101-3271143-1','Karachi','032110004567','21 Oct 1999','10000','30000')

--Voluntter Entries
insert into Volunteer values('1','Kazim','35401-0987456-8','Worker','1','4am to 1pm')
insert into Volunteer values('2','ali','35401-3987456-8','Leader','1','4am to 1pm')
insert into Volunteer values('3','hamza','35421-0987456-8','Worker','1','4am to 1pm')

insert into Volunteer values('4','kashif','35401-0987456-8','Worker','2','4pm to 1am')
insert into Volunteer values('5','daud','35401-3987456-8','Leader','2','4pm to 1am')
insert into Volunteer values('6','baig','35421-0987456-8','Worker','2','4pm to 1am')


--Donor Entries
insert into donor values('1','1','Malik Riaz','35101-9801234-1')
insert into donor values('1','2','Shahid','35101-9801234-1')


--fund Entries
insert into Fund values('1','50000','Car','')
insert into Fund values('1','40000','Bike','Fridge')
insert into Fund values('2','90000','','')

--Assessor Entries
insert into  assessor values('1','Hamza','32101-9867212-0')
insert into  assessor values('2','Hannan','32201-9827232-1')

--Question Entries

insert into Questions values('1','Is your Income less than 12000 ?')
insert into Questions values('1','Are u Belong to Village area ?')
insert into Questions values('1','your Family depend on your income ?')

insert into Questions values('2','You need Loan for Seveere issues ?')
insert into Questions values('2','Is your income is less than 10000 ?')
insert into Questions values('2','Are u belong to undeveloped Area ?')

insert into selected values('1')

update Beneficiary set RequiredMoney=15000 where RequiredMoney=0
delete from donate where d_id=1


select * from Team
select * from Project
select * from Volunteer
select * from Beneficiary
select * from Donor
select * from Fund
select * from assessor
select * from Questions
select * from selected
select * from donate

--drop procedure Money
create procedure Money
@bid int,@out int OUTPUT

as
begin
declare @amount int
declare @store int
declare @flag int
declare @flag1 int

set @out=0

select @amount=B.RequiredMoney,@store=B.p_id
from Beneficiary B
where B.B_ID=@bid

if(@amount!=0)
begin
select @flag=D.D_ID,@flag1=F.cash
from donor D
join Fund F on D.D_ID=F.d_id
where F.cash>@amount and D.p_id=@store

if(@flag!=0 and @out=0)
begin

update Fund set cash=@flag1-@amount where Fund.d_id=@flag
update Beneficiary set RequiredMoney=0 where B_ID=@bid
set @out=1

end

end

end

select * from Fund

declare @var int
exec Money 1,@var OUTPUT

select @var as vari





