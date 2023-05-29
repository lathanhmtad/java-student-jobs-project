package com.example.dao;

import com.example.model.TotNghiep;

public class TotNghiepDAO extends AbstractDAO<TotNghiep> {

	public boolean insertTotNghiep(TotNghiep totNghiep) {
		String sql = "insert into tot_nghiep(so_cmnd, ma_truong, ma_nganh, he_tn, ngay_tn, loai_tn) values(?,?,?,?,?,?)";
		return insert(sql, totNghiep.getSoCMND(), totNghiep.getMaTruong(), totNghiep.getMaNganh(), totNghiep.getHeTN(),
				totNghiep.getNgayTN(), totNghiep.getLoaiTN());
	}

}
