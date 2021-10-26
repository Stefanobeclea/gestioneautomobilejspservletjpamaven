package it.prova.gestioneautomobilejspservletjpamaven.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestioneautomobilejspservletjpamaven.model.Automobile;


//nel nome della classe vi è Automobile in quanto è una classe specifica
public class UtilityAutomobileForm {

	public static Automobile createAutomobileFromParams(String marcaInputParam, String modelloInputParam,
			String prezzoInputStringParam, String dataImmatricolazioneStringParam) {

		Automobile result = new Automobile(marcaInputParam, modelloInputParam);

		if (NumberUtils.isCreatable(prezzoInputStringParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputStringParam));
		}
		result.setDataImmatricolazione(parseDateImmatricolazioneFromString(dataImmatricolazioneStringParam));

		return result;
	}

	public static boolean validateAutomobileBean(Automobile automobileToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(automobileToBeValidated.getMarca())
				|| StringUtils.isBlank(automobileToBeValidated.getModello())
				|| automobileToBeValidated.getPrezzo() == null 
				|| automobileToBeValidated.getPrezzo() < 1
				|| automobileToBeValidated.getDataImmatricolazione() == null) {
			return false;
		}
		return true;
	}

	public static Date parseDateImmatricolazioneFromString(String dataImmatricolazioneStringParam) {
		if (StringUtils.isBlank(dataImmatricolazioneStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataImmatricolazioneStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
