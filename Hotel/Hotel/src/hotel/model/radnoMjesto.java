package hotel.model;

import java.math.BigDecimal;

public class radnoMjesto extends Entitet {
	
	private String naziv;
	private BigDecimal placa;
	private boolean smjenskiRad;
	
	
	
	
	public radnoMjesto() {
		super();
	}
	public radnoMjesto(int sifra, String naziv, BigDecimal placa, boolean smjenskiRad) {
		super(sifra);
		this.naziv = naziv;
		this.placa = placa;
		this.smjenskiRad = smjenskiRad;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public BigDecimal getPlaca() {
		return placa;
	}
	public void setPlaca(BigDecimal placa) {
		this.placa = placa;
	}
	public boolean isSmjenskiRad() {
		return smjenskiRad;
	}
	public void setSmjenskiRad(boolean smjenskiRad) {
		this.smjenskiRad = smjenskiRad;
	}
	
	

}
