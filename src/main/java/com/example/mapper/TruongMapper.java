package com.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Truong;

public class TruongMapper implements RowMapper<Truong> {

	@Override
	public Truong mapRow(ResultSet rs) {
		try {
			Truong tr = new Truong();
			
			tr.setMaTruong(rs.getString("ma_truong"));
			tr.setTenTruong(rs.getString("ten_truong"));
			tr.setAddress(rs.getString("address"));
			tr.setPhone(rs.getNString("phone"));
			
			return tr;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
