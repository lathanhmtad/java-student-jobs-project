package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.SinhVien;
import com.example.model.TotNghiep;
import com.example.services.SinhVienService;
import com.example.services.TotNghiepService;
import com.example.utils.FormUtil;


@WebServlet("/sinh-vien")
public class SinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SinhVienController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		SinhVien sinhVien = FormUtil.toModel(request, SinhVien.class);
		TotNghiep totNghiep = FormUtil.toModel(request, TotNghiep.class);
		
		SinhVienService sinhVienService = new SinhVienService();
		TotNghiepService totNghiepService = new TotNghiepService();
		
		boolean insertSinhVienSuccess = sinhVienService.insertSinhVien(sinhVien);		
		if(insertSinhVienSuccess) {
			boolean insertTotNgiepSuccess = totNghiepService.insertTotNghiep(totNghiep);
			if(insertTotNgiepSuccess) {
				response.sendRedirect(request.getContextPath() + "/home?alert=success&message=Insert success");
				return;
			}
			else {
				sinhVienService.deleteSinhVienBySoCMND(sinhVien.getSoCMND());
			}
		}
		response.sendRedirect(request.getContextPath() + "/home?alert=danger&message=Insert failed");
	}

}
