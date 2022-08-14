package br.korp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Logger;

import org.apache.tomcat.jakartaee.bcel.Const;
  
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

    public void init() throws ServletException {
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = "authorized";
		
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		if (name.equals("admin") == false || pass.equals("123456") == false) {
			session.removeAttribute(ID);
			session.invalidate();
			
		    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);

			return;
		}

		session.setAttribute(ID, new Boolean(true));
		session.setAttribute("name", name);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/report.html");
		
		dispatcher.forward(request, response);
	}

}
