package hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Gost extends Entitet {

	private String ime;
	private String prezime;
	private String OIB;
	private String email;
	private String kontaktTelefon;
        
        @OneToMany(mappedBy = "gost")
        private List<Rezervacija> rezervacije;
	
	
	
	public Gost() {
		super();
	}
	public Gost(int sifra, String ime, String prezime, String oIB, String email, String kontakTelefon) {
		super(sifra);
		this.ime = ime;
		this.prezime = prezime;
		OIB = oIB;
		this.email = email;
		this.kontaktTelefon = kontakTelefon;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getOIB() {
		return OIB;
	}
	public void setOIB(String oIB) {
		OIB = oIB;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKontakTelefon() {
		return kontaktTelefon;
	}
	public void setKontakTelefon(String kontakTelefon) {
		this.kontaktTelefon = kontakTelefon;
	}

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }
        
        
	
	@Override
	public String toString() {
		return ime + " " + prezime;
	}
	
}
