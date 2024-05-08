use student_jobs_management;
-- Chèn dữ liệu mẫu vào bảng truong
INSERT INTO truong (ma_truong, ten_truong, address, phone)
VALUES ('UDN', 'Đại học Đà Nẵng', 'Hòa khánh, Đà Nẵng', '123456789'),
       ('BKA', 'Đại học Bách khoa Hà Nội', 'Thái Nguyên, Hà Nội', '987654321'),
       ('VKU', 'Trường Đại học Công nghệ thông tin và truyền thông Việt – Hàn – Đại học Đà Nẵng', 'Ngũ Hành Sơn, Đà Nẵng', '456789123'),
		('QSB', 'Đại học Bách Khoa TP.HCM', 'Số 268 Lý Thường Kiệt, Quận 10, TP.HCM', '028 3864 2584'),
       ('SPH', 'Trường Đại học sư phạm Huế', 'Số 280 An Dương Vương, Quận 5, TP.HCM', '028 3835 5204');
		
-- Chèn dữ liệu mẫu vào bảng nganh
INSERT INTO nganh (ma_nganh, ten_nganh, loai_nganh)
VALUES ('CNTT', 'Công nghệ thông tin', 'Công nghệ số'),
       ('DTGVSP', 'Giáo dục mầm non', 'Sư phạm'),
       ('NKMT', 'Mỹ thuật đô thị', 'Năng khiếu, mỹ thuật'),
       ('NN-VH-NC', 'Ngôn ngữ Anh', 'Ngôn ngữ, Văn học và Văn hóa nước ngoài'),
       ('KD', 'Marketing', 'Kinh doanh');

-- Chèn dữ liệu mẫu vào bảng sinh_vien
INSERT INTO sinh_vien (so_cmnd, full_name, email, phone, address)
VALUES ('123213456789', 'Nguyễn Văn A', 'nguyenvana@example.com', '1111111111', 'Đà Nẵng'),
       ('987654321', 'Trần Thị B', 'tranthib@example.com', '2222222222', 'Địa chỉ 2'),
       ('456789123', 'Lê Văn C', 'levanc@example.com', '3333333333', 'Địa chỉ 3');


-- Chèn dữ liệu mẫu vào bảng tot_nghiep
INSERT INTO tot_nghiep (so_cmnd, ma_truong, ma_nganh, he_tn, ngay_tn, loai_tn)
VALUES ('123213456789', 'VKU', 'CNTT', 'Cao đẳng', '2024-05-01', 'Loại giỏi'),
       ('987654321', 'UDN', 'NKMT', 'Đại học', '2023-06-02', 'Loại khá'),
       ('456789123', 'SPH', 'DTGVSP', 'Cao đẳng', '2050-11-03', 'Loại trung bình');

-- Chèn dữ liệu mẫu vào bảng cong_viec
INSERT INTO cong_viec (so_cmnd, ngay_vao_cong_ty, ma_nganh, ten_cong_viec, ten_cong_ty, dia_chi_cong_ty, thoi_gian_lam_viec)
VALUES ('123213456789', '2029-10-02', 'CNTT', 'Web develop', 'Công ty cho dân công nghệ thông tin', 'Hòa sơn', '08:00:00'),
       ('987654321', '2023-05-02', 'NKMT', 'Vẽ kỹ thuật', 'Công ty vẽ năng khiếu', 'Địa chỉ B', '06:00:00'),
       ('456789123', '2023-05-03', 'DTGVSP', 'Chăm sóc gấu trúc', 'Công ty chăm sóc trẻ em', 'Địa chỉ C', '10:00:00');


-- select *
-- from sinh_vien
-- where so_cmnd = ? or full_name = ? or email = ? or phone = ? or address = ?;


select sv.so_cmnd, full_name, tn.ma_nganh as ma_nganh_tot_nghiep, tn.ma_truong as ma_truong_tot_nghiep, cv.ma_nganh as ma_nganh_cong_ty, cv.ten_cong_ty, cv.thoi_gian_lam_viec
from sinh_vien as sv
inner join tot_nghiep as tn on sv.so_cmnd = tn.so_cmnd
inner join cong_viec as cv on sv.so_cmnd = cv.so_cmnd
where sv.so_cmnd = '123213456789';


SELECT sv.so_cmnd, sv.full_name, tn.ma_nganh AS ma_nganh_tot_nghiep, ngtn.ten_nganh AS ten_nganh_tot_nghiep, tn.ma_truong, truongtn.ten_truong AS ten_truong_tot_nghiep, cv.ma_nganh AS ma_nganh_cong_ty, ngcv.ten_nganh AS ten_nganh_cong_ty, cv.ten_cong_ty, cv.thoi_gian_lam_viec
FROM sinh_vien AS sv
INNER JOIN tot_nghiep AS tn ON sv.so_cmnd = tn.so_cmnd
INNER JOIN nganh AS ngtn ON tn.ma_nganh = ngtn.ma_nganh
INNER JOIN truong AS truongtn ON tn.ma_truong = truongtn.ma_truong
INNER JOIN cong_viec AS cv ON sv.so_cmnd = cv.so_cmnd
INNER JOIN nganh AS ngcv ON cv.ma_nganh = ngcv.ma_nganh
where sv.so_cmnd = "681728311231231"