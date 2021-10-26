package it.prova.gestioneautomobilejspservletjpamaven.service;

import it.prova.gestioneautomobilejspservletjpamaven.dao.AutomobileDAO;
import it.prova.gestioneautomobilejspservletjpamaven.dao.AutomobileDAOImpl;

public class MyServiceFactory {

	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static AutomobileService ARTICOLO_SERVICE_INSTANCE = null;
	private static AutomobileDAO ARTICOLODAO_INSTANCE = null;

	public static AutomobileService getAutomobileServiceInstance() {
		if (ARTICOLO_SERVICE_INSTANCE == null)
			ARTICOLO_SERVICE_INSTANCE = new AutomobileServiceImpl();

		if (ARTICOLODAO_INSTANCE == null)
			ARTICOLODAO_INSTANCE = new AutomobileDAOImpl();

		ARTICOLO_SERVICE_INSTANCE.setAutomobileDao(ARTICOLODAO_INSTANCE);

		return ARTICOLO_SERVICE_INSTANCE;
	}

}
