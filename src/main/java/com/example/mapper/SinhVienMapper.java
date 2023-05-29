package com.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.SinhVien;

public class SinhVienMapper implements RowMapper<SinhVien>{

	@Override
	public SinhVien mapRow(ResultSet rs) {
		
		try {
			SinhVien sv = new SinhVien();
			sv.setFullName(rs.getString("full_name"));
			sv.setAddress(rs.getString("address"));
			sv.setEmail(rs.getString("email"));
			sv.setSoCMND(rs.getString("so_cmnd"));
			sv.setPhone(rs.getString("phone"));
			
			return sv;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
