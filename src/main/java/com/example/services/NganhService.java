package com.example.services;

import java.util.List;

import com.example.dao.NganhDAO;
import com.example.model.Nganh;

public class NganhService {
	private NganhDAO dao;

	public NganhService() {
		dao = new NganhDAO();
	}
	
	public List<Nganh> findAll() {
		return dao.findAll();
	}
	
	
}
