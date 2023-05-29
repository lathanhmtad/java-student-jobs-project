package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.SinhVien;
import com.example.services.SinhVienService;

@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchController() {
		super();
	}

	// http://localhost:8080/student-jobs-project/search?type=thong-tin-sinh-vien
	// http://localhost:8080/student-jobs-project/search?type=tot-nghiep-va-viec-lam

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");

		String view = "";
		if (type.equals("thong-tin-sinh-vien")) {
			view = "/views/search_student_info.jsp";
		} else if (type.equals("tot-nghiep-va-viec-lam")) {
			view = "/views/search_tot_nghiep_va_viec_lam_info.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		String view = null;
		String searchTerm = request.getParameter("searchTerm");
		SinhVienService service = new SinhVienService();
		List<SinhVien> searchResults = null;
		if (type.equals("thong-tin-sinh-vien")) {
			searchResults = service.searchSinhVienInfo(searchTerm);
			view = "/views/search_student_info.jsp";
		} else if (type.equals("tot-nghiep-va-viec-lam")) {
			searchResults = service.searchSinhVienTotNghiepAndViecLam(searchTerm);
			view = "/views/search_tot_nghiep_va_viec_lam_info.jsp";
		}

		request.setAttribute("searchResults", searchResults);
		request.setAttribute("searchTerm", searchTerm);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}
