package com.example.services;

import java.util.List;

import com.example.dao.TruongDAO;
import com.example.model.Truong;

public class TruongService {
	private TruongDAO dao;
	
	
	
	public TruongService() {
		dao = new TruongDAO();
	}



	public List<Truong> findAll() {
		return dao.findAll();
	}
}
