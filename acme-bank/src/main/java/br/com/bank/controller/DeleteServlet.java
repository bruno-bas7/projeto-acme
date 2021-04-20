package br.com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.service.ClientServiceImpl;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientServiceImpl service;
	
	public DeleteServlet() {
		this.service = new ClientServiceImpl();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idClient = request.getParameter("id");
		
		
		String id = request.getParameter("id");
		
		if (service.deleteById(Long.parseLong(idClient))) {
			RequestDispatcher rd = request.getRequestDispatcher("delete.jsp"); 
			rd.forward(request, response);
			
		}else {
			String error = "ID NOT FOUND, PLEASE CHECK ID.";
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp"); 
			request.setAttribute("error",error);
			rd.forward(request, response);
		}
	}
}