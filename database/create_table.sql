create database student_jobs_management;

use student_jobs_management;

create table truong (
	ma_truong varchar(50) primary key,
    ten_truong varchar(255),
    address varchar(255),
    phone varchar(20)
);

create table nganh(
	ma_nganh varchar(50) primary key,
    ten_nganh varchar(50),
    loai_nganh varchar(50)
);

create table sinh_vien
(
	so_cmnd varchar(50) primary key,
    full_name varchar(50),
    email varchar(50),
    phone varchar(20),
    address varchar(255)
);

create table tot_nghiep (
	so_cmnd varchar(50),
    ma_truong varchar(50),
    ma_nganh varchar(50),
    he_tn varchar(50),
    ngay_tn date,
    loai_tn varchar(20),
    
    primary key(so_cmnd, ma_truong, ma_nganh),
    
    foreign key(so_cmnd) references sinh_vien(so_cmnd) on update cascade on delete cascade,
	foreign key(ma_truong) references truong(ma_truong) on update cascade on delete cascade,
	foreign key(ma_nganh) references nganh(ma_nganh) on update cascade on delete cascade
);

create table cong_viec (
	so_cmnd varchar(50) ,
    ngay_vao_cong_ty date,
    ma_nganh varchar(50),
    ten_cong_viec varchar(50),
    ten_cong_ty varchar(50),
    dia_chi_cong_ty varchar(50),
    thoi_gian_lam_viec time,
    
    primary key(so_cmnd, ngay_vao_cong_ty),
    
  	foreign key(so_cmnd) references sinh_vien(so_cmnd) on update cascade on delete cascade,
    foreign key(ma_nganh) references nganh(ma_nganh)
);


