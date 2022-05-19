CREATE DATABASE	JDBCQLSV
ON PRIMARY 
(
	NAME = 'QLSV_DATA',
	FILENAME='C:\SQLCSDL\JDBCQLSV_DATA.mdf',
	
	SIZE = 10,
	MAXSIZE = 100,
	FILEGROWTH = 1
)
LOG ON
(
	NAME = 'QLSV_LOG',
	FILENAME='C:\SQLCSDL\JDBCQLSV_LOG.ldf',
	SIZE = 10,
	MAXSIZE = 100,
	FILEGROWTH = 1
)
use JDBCQLSV
CREATE TABLE LopHoc
(
	MaLop nvarchar(20) constraint pk_maLop PRIMARY KEY,
	TenLop nvarchar(40) Not null,
	SiSo Int,
	GVCN nvarchar(50)
)
insert into [dbo].[LopHoc]
values('L01','IT',20,'Trung')
CREATE TABLE SinhVien
(
	MaSV nvarchar(20) constraint pk_masv PRIMARY KEY,
	HoTen nvarchar(40) Not null,
	GioiTinh nvarchar(10),
	NgaySinh Datetime,
	DaiChi nvarchar(30) Not Null,
	Email nvarchar(20),
	MaLop nvarchar(20) constraint fk_lopHoc_maLop foreign key(MaLop)	references LopHoc(MaLop),
)
insert into [dbo].[SinhVien]
values('SV01','Loc','Nu',GETDATE(),'HHH','locngu','L01')
insert into [dbo].[SinhVien] values('SV02','Loc Coc','Nam',GETDATE(),'abc','locngu','L01')


update [dbo].[SinhVien] 
set [HoTen]='hungdd',[GioiTinh]='Nam',[NgaySinh]=GETDATE(),[DaiChi]='hhhhh',[Email]='locng',[MaLop]='L01'
where MaSV = '18079021'
