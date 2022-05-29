Create Table License(
Id int Identity(1,1) primary key,
License_Issue_Date datetime NOT NULL,
License_Expiration_Date datetime NOT NULL,
License_number int NOT NULL
)

Create Table Drivers(
Id int Identity(1,1) primary key,
Surname varchar(50) NOT NULL,
Name varchar(50) NOT NULL,
Patronymic varchar(50) NOT NULL,
Passport_series varchar(4) NOT NULL,
Passport_number varchar(6) NOT NULL,
Phone varchar(11) NOT NULL,
Brand varchar(20) NOT NULL,
Registration_number varchar(10) NOT NULL,
Permissible_mass int NOT NULL,
License_number int NOT NULL foreign key references License(Id),
Statuss bit NOT NULL
)

Create Table Ñustomer(
Id int Identity(1,1) primary key,
Ñustomer_name varchar(100) NOT NULL,
Legal_address_customer varchar(100) NOT NULL,
TIN_customer varchar(10) NOT NULL,
Customer_checkpoint varchar(10) NOT NULL,
Customer_phone varchar(11) NOT NULL,
OGRN_customer varchar(50) NOT NULL,
Email_address_customer varchar(100) NOT NULL,
)

Create Table Materials(
Id int Identity(1,1) primary key,
Material_name varchar(50) NOT NULL,
)

Create Table Orders(
Id int Identity(1,1) primary key,
Ñustomer int NOT NULL foreign key references Ñustomer(Id),
Loading_location varchar(50) NOT NULL,
Place_of_unloading varchar(50) NOT NULL,
Date_of_download date NOT NULL,
Unloading_date date NOT NULL,
Cargo_weight varchar(50) NOT NULL,
Shipping_name int NOT NULL foreign key references Materials(Id),
)

Create Table Trips(
Id int Identity(1,1) primary key,
Orders int NOT NULL foreign key references Orders(Id),
Drivers int NOT NULL foreign key references Drivers(Id),
Ñustomer int NOT NULL foreign key references Ñustomer(Id)
)

Create Table Role(
Id int Identity(1,1) primary key,
Name varchar(50) NOT NULL
)

Create Table Employees(
Id int Identity(1,1) primary key,
Surname varchar(50) NOT NULL,
Name varchar(50) NOT NULL,
Patronymic varchar(50) NOT NULL,
Login varchar(50) NOT NULL,
Password varchar(50) NOT NULL,
RoleId int NOT NULL foreign key references Role(Id)
)

