package com.example.dao;

import java.util.List;

import com.example.mapper.SinhVienMapper;
import com.example.mapper.SinhVienViecLamMapper;
import com.example.model.SinhVien;

public class SinhVienDAO extends AbstractDAO<SinhVien> {
	public boolean insertSinhVien(SinhVien sinhVien) {
		String sql = "insert into sinh_vien(so_cmnd, full_name, email, phone, address) values(?,?,?,?,?)";

		return insert(sql, sinhVien.getSoCMND(), sinhVien.getFullName(), sinhVien.getEmail(), sinhVien.getPhone(),
				sinhVien.getAddress());
	}

	public List<SinhVien> searchSinhVienInfo(String searchTerm) {
		searchTerm = searchTerm.toLowerCase().trim();
//		String searchPattern = "%" + searchTerm + "%";
		String sql = "SELECT * FROM sinh_vien WHERE so_cmnd = ? OR full_name = ? OR email = ? OR phone = ?";
		return query(sql, new SinhVienMapper(), searchTerm, searchTerm, searchTerm, searchTerm);
	}

	public List<SinhVien> searchSinhVienTotNghiepAndViecLam(String searchTerm) {
		String sql = "select sv.so_cmnd, full_name, tn.ma_nganh as ma_nganh_tot_nghiep, tn.ma_truong as ma_truong_tot_nghiep, cv.ma_nganh as ma_nganh_cong_ty, cv.ten_cong_ty, cv.thoi_gian_lam_viec\r\n"
				+ "from sinh_vien as sv\r\n"
				+ "inner join tot_nghiep as tn on sv.so_cmnd = tn.so_cmnd\r\n"
				+ "inner join cong_viec as cv on sv.so_cmnd = cv.so_cmnd\r\n"
				+ "where sv.so_cmnd = ?";
		return query(sql, new SinhVienViecLamMapper(), searchTerm);
	}


	public boolean deleteSinhVienBySoCMND(String soCMND) {
		String sql = "DELETE FROM sinh_vien WHERE so_cmnd = ?";
		return update(sql, soCMND);
	}
}
