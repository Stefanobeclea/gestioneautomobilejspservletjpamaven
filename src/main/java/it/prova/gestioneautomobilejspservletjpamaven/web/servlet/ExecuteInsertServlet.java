package it.prova.gestioneautomobilejspservletjpamaven.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneautomobilejspservletjpamaven.model.Automobile;
import it.prova.gestioneautomobilejspservletjpamaven.service.MyServiceFactory;
import it.prova.gestioneautomobilejspservletjpamaven.utility.UtilityAutomobileForm;

@WebServlet("/ExecuteInsertServlet")
public class ExecuteInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// estraggo input
		String marcaInputParam = request.getParameter("marca");
		String modelloInputParam = request.getParameter("modello");
		String prezzoInputStringParam = request.getParameter("prezzo");
		String dataImmatricolazioneStringParam = request.getParameter("dataImmatricolazione");

		// preparo un bean (che mi serve sia per tornare in pagina
		// che per inserire) e faccio il binding dei parametri
		Automobile automobileInstance = UtilityAutomobileForm.createAutomobileFromParams(marcaInputParam,
				modelloInputParam, prezzoInputStringParam, dataImmatricolazioneStringParam);

		// se la validazione non risulta ok
		if (!UtilityAutomobileForm.validateAutomobileBean(automobileInstance)) {
			request.setAttribute("insert_automobile_attr", automobileInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/automobile/insert.jsp").forward(request, response);
			return;
		}

		// se sono qui i valori sono ok quindi posso creare l'oggetto da inserire
		// occupiamoci delle operazioni di business
		try {
			MyServiceFactory.getAutomobileServiceInstance().inserisciNuovo(automobileInstance);
			request.setAttribute("listaAutomobiliAttribute", MyServiceFactory.getAutomobileServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/automobile/results.jsp").forward(request, response);

	}
}
