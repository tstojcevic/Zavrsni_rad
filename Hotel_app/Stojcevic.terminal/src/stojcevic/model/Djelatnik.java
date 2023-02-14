package stojcevic.model;

public class Djelatnik extends Entitet {

	private String ime;
	private String prezime;
	private String brojUgovora;
	private String OIB;
	private RadnoMjesto radnoMjesto;

	public Djelatnik() {
		super();
	}

	public Djelatnik(int sifra, String ime, String prezime, String brojUgovora, String oIB,
			RadnoMjesto radnoMjesto) {
		super(sifra);
		this.ime = ime;
		this.prezime = prezime;
		this.brojUgovora = brojUgovora;
		OIB = oIB;
		this.radnoMjesto = radnoMjesto;
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

	public String getBrojUgovora() {
		return brojUgovora;
	}

	public void setBrojUgovora(String brojUgovora) {
		this.brojUgovora = brojUgovora;
	}

	public String getOIB() {
		return OIB;
	}

	public void setOIB(String oIB) {
		OIB = oIB;
	}

	public RadnoMjesto getRadnoMjesto() {
		return radnoMjesto;
	}

	public void setRadnoMjesto(RadnoMjesto radnoMjesto) {
		this.radnoMjesto = radnoMjesto;
	}

	@Override
	public String toString() {
		return "ime: " + ime + "	prezime: " + prezime + "	OIB: " + OIB + "	Broj_Ugovora: " + brojUgovora + "	radno mjesto: " + radnoMjesto + "";
		
	}
	
}
