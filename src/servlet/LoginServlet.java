package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.*;
/**
 * Servlet implementation class TicketServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("id");
		String pw = request.getParameter("pw");
		String lname = request.getParameter("lname");
		String fname = request.getParameter("fname");
		String passport = request.getParameter("pp");
		HttpSession hs = request.getSession(true);
		hs.setAttribute("id",username);
		Register register = new Register();
		if(lname == null || fname == null || passport == null) {   //Login
			if(register.login(username, pw))
				response.sendRedirect("/AirBusController/main.html");
			else {
				PrintWriter out = response.getWriter();
				out.write("Username or Phone Number is not correct...");
			}
			//System.out.println(username+pw);
			
		}
		else {                                                     //Register
			
			if(register.addUser(username, fname, lname, pw, passport))
				response.sendRedirect("/AirBusController/main.html");
			else{
				PrintWriter out = response.getWriter();
				out.write("There is something wrong with your infomation...");
			}
			//System.out.println(username+pw);
		}
		
	}

}
