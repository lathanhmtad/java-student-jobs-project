package com.example.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TotNghiep {
	private String soCMND;
	private String maTruong;
	private String maNganh;
	private String heTN;
	private Date ngayTN;
	private String loaiTN;
}
