package it.prova.gestioneautomobilejspservletjpamaven.web.servlet;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestioneautomobilejspservletjpamaven.service.MyServiceFactory;


@WebServlet("/PrepareModificaServlet")
public class PrepareModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrepareModificaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAutomobileParam = request.getParameter("idAutomobile");

		if (!NumberUtils.isCreatable(idAutomobileParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("modifica_automobile_attr", MyServiceFactory.getAutomobileServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idAutomobileParam)));
		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/automobile/modifica.jsp").forward(request, response);
	}

	

}
