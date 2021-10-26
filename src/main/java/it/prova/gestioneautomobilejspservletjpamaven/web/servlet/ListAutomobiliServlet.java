package it.prova.gestioneautomobilejspservletjpamaven.web.servlet;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneautomobilejspservletjpamaven.service.MyServiceFactory;



@WebServlet("/ListAutomobiliServlet")
public class ListAutomobiliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ListAutomobiliServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try {
				request.setAttribute("listaAutomobiliAttribute", MyServiceFactory.getAutomobileServiceInstance().listAll());
			} catch (Exception e) {
				//qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
				e.printStackTrace();
				request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
			request.getRequestDispatcher("/automobile/results.jsp").forward(request, response);
	}

	
}
