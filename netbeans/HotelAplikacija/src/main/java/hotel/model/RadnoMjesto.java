package hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class RadnoMjesto extends Entitet {
	
	private String naziv;
	private BigDecimal placa;
	private boolean smjenskiRad;
        
        @OneToMany(mappedBy = "radnoMjesto")
        private List<Djelatnik> djelatnici;
	
	
	public RadnoMjesto() {
		super();			
}
	
	public RadnoMjesto(int sifra, String naziv, BigDecimal placa, boolean smjenskiRad)  {
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
