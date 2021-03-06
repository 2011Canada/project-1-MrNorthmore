package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.AuthController;
import com.revature.controllers.ErrorController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AuthController authController = new AuthController();
	
	private ErrorController errorController = new ErrorController();
	
	private UserController userController = new UserController();
	
	private ReimbursementController reimbursementController = new ReimbursementController();
	
	
	protected void directControlRouter(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// We will use this context for defaults
		ServletContext sc = this.getServletContext();
		
		
		// This is the URI that we will use to map to the correct controller
		String URI = req.getRequestURI().substring(req.getContextPath().length(), 
													req.getRequestURI().length());
		
		System.out.println(URI);
		switch (URI) {
			case "/login":{
				switch (req.getMethod()) {
					case "GET":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "POST":{
						authController.userLogin(req, res);
						break;
					}
					case "PUT":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "DELETE":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					default:{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
				
				}
				break;
			}
			case "/users": {
				switch (req.getMethod()) {
					case "GET":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "POST":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "PUT":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "DELETE":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					default:{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
				}
				break;
			}
			case "/reimbursements": {
				switch(req.getMethod()) {
					case "GET":{
						reimbursementController.getAllReimbursements(req, res);
						break;
					}
					case "POST":{
						reimbursementController.getReimbursementsByUser(req, res);
						break;
					}
					case "PUT":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "DELETE":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					default:{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
				}
				break;
			}
			case "/pending-reimbursements": {
				switch(req.getMethod()) {
					case "GET":{
						// This gets all pending reimbursements
						reimbursementController.getPendingReimbursements(req, res);
						break;
					}
					case "POST":{
						// This gets all pending reimbursements for a specific user
						reimbursementController.getPendingReimbursementsByUser(req, res);
						break;
					}
					case "PUT":{
						// This updates a pending reimbursement to approved or rejected
						reimbursementController.updateReimbursement(req, res);
						break;
					}
					case "DELETE":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					default:{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
				}
				break;
			}
			case "/reimbursements/new": {
				switch(req.getMethod()) {
					case "GET":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "POST":{
						// This gets all pending reimbursements for a specific user
						reimbursementController.createNewReimbursement(req, res);
						break;
					}
					case "PUT":{
						// This updates a pending reimbursement to approved or rejected
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "DELETE":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					default:{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
				}
				break;
			}
			default:{
				res.setStatus(404);
				res.getWriter().write("No Such Resource");
				break;
			}
			
		}
		
	}
       
	protected void directControl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//to handle all internal errors/exceptions
		try {
			directControlRouter(request, response);
		}catch (Throwable t) {
			errorController.handle(request, response, t);//go to the error controller
		}
	}

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		directControl(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		directControl(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		directControl(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
