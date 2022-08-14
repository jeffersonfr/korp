package br.korp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Report() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String relativeWebPath = "WEB-INF/data/data.json";

		byte[] buffer = new byte[10 * 1024];

		InputStream input = getServletContext().getResourceAsStream(relativeWebPath);
	    OutputStream output = response.getOutputStream();

	    for (int length = 0; (length = input.read(buffer)) > 0;) {
	        output.write(buffer, 0, length);
	    }
	    
	    input.close();
	    output.close();
	    
	    // response.sendError(HttpServletResponse.SC_NOT_FOUND);
	}

}
