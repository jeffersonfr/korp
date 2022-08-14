package br.korp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Credentials extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Credentials() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = "authorized";
		
		HttpSession session = request.getSession();
		Boolean authorized = (Boolean)session.getAttribute(ID);
		
		if (authorized != null) {
			if (authorized.booleanValue() == true) {
				String name = (String)session.getAttribute("name");

				response.getWriter().append("{\"name\": \"" + name + "\"}");
				
				return;
			}
		}
		
	    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	}

}
