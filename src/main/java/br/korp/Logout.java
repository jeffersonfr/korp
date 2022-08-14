package br.korp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = "authorized";

		HttpSession session = request.getSession();
		
		session.removeAttribute(ID);
		session.invalidate();

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
		
		dispatcher.forward(request, response);
	}

}
