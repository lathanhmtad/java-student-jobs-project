package com.example.model;

import java.sql.Date;
import java.sql.Time;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class CongViec {
	private String soCMND;
	private Date ngayVaoCongTy;
	private String maNganh;
	private String tenCongViec;
	private String tenCongTy;
	private String diaChiCongTy;
	private Time thoiGianLamViec;
}
