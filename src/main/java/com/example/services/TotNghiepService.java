package com.example.services;

import com.example.dao.TotNghiepDAO;
import com.example.model.TotNghiep;

public class TotNghiepService {

	private TotNghiepDAO dao;
	
	public TotNghiepService() {
		dao = new TotNghiepDAO();
	}
	
	public boolean insertTotNghiep(TotNghiep totNghiep) {
		return dao.insertTotNghiep(totNghiep);
	}
}
