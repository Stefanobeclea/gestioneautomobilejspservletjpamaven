package it.prova.gestioneautomobilejspservletjpamaven.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestioneautomobilejspservletjpamaven.model.Automobile;
import it.prova.gestioneautomobilejspservletjpamaven.service.MyServiceFactory;
import it.prova.gestioneautomobilejspservletjpamaven.utility.UtilityAutomobileForm;


@WebServlet("/ExecuteModificaServlet")
public class ExecuteModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExecuteModificaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idInputParam = request.getParameter("idDaEliminare");
		String marcaInputParam = request.getParameter("marca");
		String modelloInputParam = request.getParameter("modello");
		String prezzoInputStringParam = request.getParameter("prezzo");
		String dataImmatricolazioneStringParam = request.getParameter("dataImmatricolazione");

		// preparo un bean (che mi serve sia per tornare in pagina
		// che per inserire) e faccio il binding dei parametri
		Automobile automobileInstance = UtilityAutomobileForm.createAutomobileFromParams(marcaInputParam,
				modelloInputParam, prezzoInputStringParam, dataImmatricolazioneStringParam);
		automobileInstance.setId(Long.parseLong(idInputParam));
		// se la validazione non risulta ok
		
		if (!NumberUtils.isCreatable(idInputParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore. iD");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		if (!UtilityAutomobileForm.validateAutomobileBean(automobileInstance)) {
			request.setAttribute("modifica_automobile_attr", automobileInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/automobile/modifica.jsp").forward(request, response);
			return;
		}
		
		// se sono qui i valori sono ok quindi posso creare l'oggetto da inserire
		// occupiamoci delle operazioni di business
		try {
			MyServiceFactory.getAutomobileServiceInstance().aggiorna(automobileInstance);
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
