package model;

public class Gost extends Entitet {

	private String ime;
	private String prezime;
	private String OIB;
	private String email;
	private int kontakTelefon;
	
	
	
	public Gost() {
		super();
	}
	public Gost(int sifra, String ime, String prezime, String oIB, String email, int kontakTelefon) {
		super(sifra);
		this.ime = ime;
		this.prezime = prezime;
		OIB = oIB;
		this.email = email;
		this.kontakTelefon = kontakTelefon;
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
	public int getKontakTelefon() {
		return kontakTelefon;
	}
	public void setKontakTelefon(int kontakTelefon) {
		this.kontakTelefon = kontakTelefon;
	}
	
}
