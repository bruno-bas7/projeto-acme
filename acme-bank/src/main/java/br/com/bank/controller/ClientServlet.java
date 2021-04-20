package br.com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.Client;
import br.com.bank.service.ClientServiceImpl;

@WebServlet("/clientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientServiceImpl service;
	
	public ClientServlet() {
		this.service = new ClientServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Response to client").append(request.getContextPath());
	}

	@SuppressWarnings("unlikely-arg-type")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//PEGA OS DADOS DO REQUEST
		String name  = request.getParameter("name"); 
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		//MONTEI O MEU OBJETO CLIENT
		Client client = new Client();
		client.setName(name);
		client.setEmail(email);
		client.setPhone(phone);
		
		if(service.getClientByPhone(client.getPhone())){
		//Busca no db se existe o mesmo telefone cadastrado.
		
		//caso tenha o mesmo phone, será direcionado para pag de erro.	
			String error = "Phone já cadastrado";
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp"); 
			request.setAttribute("error",error);
			rd.forward(request, response);
			
		}
		
		if(service.getClientByEmail(client.getEmail())){
			//Busca no db se existe o mesmo email cadastrado.
			
			//caso tenha o mesmo email, será direcionado para pag de erro.	
				String error = "Email já cadastrado";
				
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp"); 
				request.setAttribute("error",error);
				rd.forward(request, response);
				
		}
		
		//caso nao possua o mesmo email ou telefone cadastrado, será direcionado para pag de success.
		//SALVAR O MEU CLIENT
		this.service.save(client);
		//salvar o cadastro e direcionar para pag de sucess
		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		request.setAttribute("client",client);
		rd.forward(request, response);
	}
}