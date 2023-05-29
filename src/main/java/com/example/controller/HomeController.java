package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Nganh;
import com.example.model.Truong;
import com.example.services.NganhService;
import com.example.services.TruongService;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		NganhService nganhService = new NganhService();
		TruongService truongService = new TruongService();
		
		List<Truong> listTruong = truongService.findAll();
		List<Nganh> listNganh = nganhService.findAll();
		
		request.setAttribute("listTruong", listTruong);
		request.setAttribute("listNganh", listNganh);
		
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");
		if(message != null && alert != null) {
			request.setAttribute("message", message);
			request.setAttribute("alert", alert);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/student_input_form.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
