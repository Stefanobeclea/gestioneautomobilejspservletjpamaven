package it.prova.gestioneautomobilejspservletjpamaven.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestioneautomobilejspservletjpamaven.model.Automobile;
import it.prova.gestioneautomobilejspservletjpamaven.service.AutomobileService;
import it.prova.gestioneautomobilejspservletjpamaven.service.MyServiceFactory;




@WebServlet("/ExecuteDeleteServlet")
public class ExecuteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdDellAutomobileDiCuiVoglioEliminare = request.getParameter("idDaEliminare");

		AutomobileService automobileServiceInstance = MyServiceFactory.getAutomobileServiceInstance();
		if (!NumberUtils.isCreatable(parametroIdDellAutomobileDiCuiVoglioEliminare)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		try {
			Automobile automobileDaEliminare = automobileServiceInstance
					.caricaSingoloElemento(Long.parseLong(parametroIdDellAutomobileDiCuiVoglioEliminare));

			automobileServiceInstance.rimuovi(automobileDaEliminare);

			request.setAttribute("listaAutomobiliAttribute", automobileServiceInstance.listAll());
			
			String destinazione = "automobile/results.jsp";

			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
	}

}
