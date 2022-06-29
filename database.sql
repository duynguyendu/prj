DROP DATABASE Milktea
CREATE DATABASE Milktea
GO

USE Milktea
GO

CREATE TABLE tblUser (
  UserID integer IDENTITY(1, 1) PRIMARY KEY,
  FirstName nvarchar(50) NOT NULL,
  LastName nvarchar(50),
  Email nvarchar(100) NOT NULL UNIQUE,
  Password nvarchar(30) NOT NULL,
  PhoneNumber nvarchar(10),
  Address nvarchar(100),
  RoleID integer, -- FK
  Status integer DEFAULT 1,
)
GO

CREATE TABLE tblRole (
  RoleID integer IDENTITY(1, 1) PRIMARY KEY,
  RoleName nvarchar(30) NOT NULL,
)
GO

CREATE TABLE tblOrder (
  OrderID integer IDENTITY(1, 1) PRIMARY KEY,
  UserID integer NOT NULL, -- FK
  OrderDate datetime, -- The date order is set
  Total integer, -- Calculated field LMAO
  Status integer DEFAULT 1,
)
GO

CREATE TABLE tblOrderDetail (
  DetailID integer IDENTITY(1, 1) PRIMARY KEY,
  OrderID integer, -- FK
  ProductID integer, -- FK
  Price integer NOT NULL, -- This price might have discount
  Quanity integer NOT NULL, -- the quanity in this order
)
GO

CREATE TABLE tblProduct (
  ProductID integer IDENTITY(1, 1) PRIMARY KEY,
  Name nvarchar(100) NOT NULL,
  Price integer NOT NULL,
  Quanity integer NOT NULL,
  Description text,
  CategoryID integer, -- FK
  Status integer DEFAULT 1,
)
GO

CREATE TABLE tblCategory (
  CategoryID integer IDENTITY(1, 1) PRIMARY KEY,
  Name nvarchar(100) NOT NULL,
)
GO

ALTER TABLE tblUser
  ADD CONSTRAINT FK_User_Role FOREIGN KEY (RoleID) 
  REFERENCES tblRole (RoleID)
  ON DELETE SET DEFAULT

ALTER TABLE tblOrder
  ADD CONSTRAINT FK_Order_User FOREIGN KEY (UserID)
  REFERENCES tblUser (UserID)
  ON DELETE CASCADE
  ON UPDATE CASCADE

ALTER TABLE tblOrderDetail
  ADD CONSTRAINT FK_OrderDetail_Order FOREIGN KEY (OrderID)
  REFERENCES tblOrder (OrderID)
  ON UPDATE CASCADE
  ON DELETE CASCADE

ALTER TABLE tblOrderDetail
  ADD CONSTRAINT FK_OrderDetail_Product FOREIGN KEY (ProductID)
  REFERENCES tblProduct (ProductID)
  ON DELETE CASCADE


ALTER TABLE tblProduct 
  ADD CONSTRAINT FK_Product_Category FOREIGN KEY (CategoryID)
  REFERENCES tblCategory (CategoryID)
  ON DELETE SET NULL
