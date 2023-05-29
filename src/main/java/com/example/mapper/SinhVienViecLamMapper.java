package com.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.CongViec;
import com.example.model.SinhVien;
import com.example.model.TotNghiep;

public class SinhVienViecLamMapper implements RowMapper<SinhVien> {

	@Override
	public SinhVien mapRow(ResultSet rs) {
		try {
			SinhVien sv = new SinhVien();
			sv.setSoCMND(rs.getString("so_cmnd"));
			sv.setFullName(rs.getString("full_name"));
			
			TotNghiep tn = new TotNghiep();
			tn.setMaNganh(rs.getString("ma_nganh_tot_nghiep"));
			tn.setMaTruong(rs.getString("ma_truong_tot_nghiep"));
			
			CongViec cv = new CongViec();
			cv.setMaNganh(rs.getString("ma_nganh_cong_ty"));
			cv.setTenCongTy(rs.getString("ten_cong_ty"));
			cv.setThoiGianLamViec(rs.getTime("thoi_gian_lam_viec"));
			
			sv.setTotNghiep(tn);
			sv.setCongViec(cv);
			
			return sv;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

}
