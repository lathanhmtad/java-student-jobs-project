package com.example.dao;

import java.util.List;

import com.example.mapper.TruongMapper;
import com.example.model.Truong;

public class TruongDAO extends AbstractDAO<Truong> {
	public List<Truong> findAll() {
		String sql = "select * from Truong";
		
		return query(sql, new TruongMapper());
	}
}	
