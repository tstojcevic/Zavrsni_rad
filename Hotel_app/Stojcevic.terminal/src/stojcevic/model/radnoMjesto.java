package stojcevic.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class radnoMjesto extends Entitet {
	
	private String naziv;
	private BigDecimal placa;
	private boolean smjenskiRad;
	private List<Djelatnik> djelatnici;
	
	
	
	
	public radnoMjesto() {
		super();
		djelatnici = new ArrayList<>();
		
}
	public radnoMjesto(int sifra, String naziv, BigDecimal placa, boolean smjenskiRad, List<Djelatnik> djelatnici) {
		super(sifra);
		this.naziv = naziv;
		this.placa = placa;
		this.smjenskiRad = smjenskiRad;
		this.djelatnici = djelatnici;
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
	public List<Djelatnik> getDjelatnici() {
		return djelatnici;
	}
	public void setDjelatnici(List<Djelatnik> djelatnici) {
		this.djelatnici = djelatnici;
	}
	
	
	@Override
	public String toString() {
		return naziv;
	}
	
	

}
