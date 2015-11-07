package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.Account;
import com.DAO.DBOperation;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
//		int s=Integer.parseInt(request.getParameter("selection"));
//		 //String s=request.getParameter("selection");
//		 System.out.println(s);
//		if(s==1) {
//			Account a=new Account();
//			a.setFirstName(request.getParameter("first"));
//			a.setLastName(request.getParameter("last"));
//			a.setEmail(request.getParameter("email"));
//			a.setPassword(request.getParameter("password"));
//			a.setNumber(Integer.parseInt(request.getParameter("number")));
//			a.setAltEmail(request.getParameter("email1"));
//			a.setCountry("India");
//			System.out.println(a);
//			DBOperation dbops=new DBOperation();
//			dbops.createAccount(a);
//			System.out.println(dbops.createAccount(a));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int s=Integer.parseInt(request.getParameter("selection"));
		System.out.println(s);
		if(s==1) {
			Account a=new Account();
			a.setFirstName(request.getParameter("first"));
			a.setLastName((String)request.getAttribute("last"));
			a.setEmail((String)request.getAttribute("email"));
			a.setPassword((String)request.getAttribute("password"));
			a.setNumber(Integer.parseInt((String) request.getAttribute("number")));
			a.setAltEmail((String)request.getAttribute("email1"));
			a.setCountry("India");
			
			System.out.println(a);
			DBOperation dbops=new DBOperation();
			dbops.createAccount(a);
		}
	}
}
