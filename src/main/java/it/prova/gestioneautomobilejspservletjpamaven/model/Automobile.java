package it.prova.gestioneautomobilejspservletjpamaven.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "automobile")
public class Automobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "marca")
	private String marca;
	@Column(name = "modello")
	private String modello;
	@Column(name = "prezzo")
	private Integer prezzo;
	@Column(name = "dataimmatricolazione")
	private Date dataImmatricolazione;
	
	public Automobile() {
		// TODO Auto-generated constructor stub
	}

	public Automobile(Long id, String marca, String modello, Integer prezzo, Date dataImmatricolazione) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
		this.dataImmatricolazione = dataImmatricolazione;
	}
	
	

	public Automobile(String marca, String modello) {
		super();
		this.marca = marca;
		this.modello = modello;
	}

	public Automobile(String marca, String modello, Integer prezzo, Date dataImmatricolazione) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
		this.dataImmatricolazione = dataImmatricolazione;
	}

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModello() {
		return modello;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public Date getDataImmatricolazione() {
		return dataImmatricolazione;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public void setDataImmatricolazione(Date dataImmatricolazione) {
		this.dataImmatricolazione = dataImmatricolazione;
	}
	
	
}
