package com.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Nganh;

public class NganhMapper implements RowMapper<Nganh> {

	@Override
	public Nganh mapRow(ResultSet rs) {
		try {
			Nganh res = new Nganh();
			res.setMaNganh(rs.getString("ma_nganh"));
			res.setTenNganh(rs.getString("ten_nganh"));
			res.setLoaiNganh(rs.getString("loai_nganh"));
			
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
