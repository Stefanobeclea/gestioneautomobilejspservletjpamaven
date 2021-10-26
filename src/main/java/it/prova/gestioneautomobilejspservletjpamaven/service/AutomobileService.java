package it.prova.gestioneautomobilejspservletjpamaven.service;

import java.util.List;

import it.prova.gestioneautomobilejspservletjpamaven.dao.AutomobileDAO;
import it.prova.gestioneautomobilejspservletjpamaven.model.Automobile;


public interface AutomobileService {
	public void setAutomobileDao(AutomobileDAO articoloDao);

	public List<Automobile> listAll() throws Exception;

	public Automobile caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Automobile input) throws Exception;

	public void inserisciNuovo(Automobile input) throws Exception;

	public void rimuovi(Automobile input) throws Exception;

	public List<Automobile> findByExample(Automobile input) throws Exception;
}
