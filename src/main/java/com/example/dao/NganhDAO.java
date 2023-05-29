package com.example.dao;

import java.util.List;

import com.example.mapper.NganhMapper;
import com.example.model.Nganh;

public class NganhDAO extends AbstractDAO<Nganh> {
	public List<Nganh> findAll() { 
		String sql = "select * from Nganh";
		return query(sql, new NganhMapper());
	}
}
 