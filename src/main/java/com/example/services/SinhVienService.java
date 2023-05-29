package com.example.services;

import java.util.List;

import com.example.dao.SinhVienDAO;
import com.example.model.SinhVien;

public class SinhVienService {
	SinhVienDAO dao;

	public SinhVienService() {
		dao = new SinhVienDAO();
	}

	public boolean insertSinhVien(SinhVien sinhVien) {
		return dao.insertSinhVien(sinhVien);
	}

	public List<SinhVien> searchSinhVienInfo(String searchTerm) {
		return dao.searchSinhVienInfo(searchTerm);
	}
	
	public List<SinhVien> searchSinhVienTotNghiepAndViecLam(String searchTerm) {
		return dao.searchSinhVienTotNghiepAndViecLam(searchTerm);
	}

	public boolean deleteSinhVienBySoCMND(String soCMND) {
		return dao.deleteSinhVienBySoCMND(soCMND);
		
	}
	
	
	
}
