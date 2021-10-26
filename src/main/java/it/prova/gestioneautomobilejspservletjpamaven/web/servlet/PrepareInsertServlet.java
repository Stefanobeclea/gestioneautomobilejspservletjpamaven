package it.prova.gestioneautomobilejspservletjpamaven.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneautomobilejspservletjpamaven.model.Automobile;



@WebServlet("/PrepareInsertServlet")
public class PrepareInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrepareInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("insert_automobile_attr", new Automobile());
		request.getRequestDispatcher("/automobile/insert.jsp").forward(request, response);
	}


}
