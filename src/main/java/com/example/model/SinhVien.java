package com.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class SinhVien {
	private String soCMND;
	private String fullName;
	private String email;
	private String phone;
	private String address;
	
	private TotNghiep totNghiep;
	private CongViec congViec; 
}
