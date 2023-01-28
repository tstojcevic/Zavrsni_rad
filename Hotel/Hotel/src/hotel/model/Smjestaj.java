package hotel.model;

public class Smjestaj extends Entitet{
	
	private String vrsta;
	private int brojKreveta;
	private float cijena;
	private boolean raspolozivost;
	
	
	
	public Smjestaj() {
		super();
	}
	public Smjestaj(int sifra, String vrsta, int brojKreveta, float cijena, boolean raspolozivost) {
		super(sifra);
		this.vrsta = vrsta;
		this.brojKreveta = brojKreveta;
		this.cijena = cijena;
		this.raspolozivost = raspolozivost;
	}
	public String getVrsta() {
		return vrsta;
	}
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}
	public int getBrojKreveta() {
		return brojKreveta;
	}
	public void setBrojKreveta(int brojKreveta) {
		this.brojKreveta = brojKreveta;
	}
	public float getCijena() {
		return cijena;
	}
	public void setCijena(float cijena) {
		this.cijena = cijena;
	}
	public boolean isRaspolozivost() {
		return raspolozivost;
	}
	public void setRaspolozivost(boolean raspolozivost) {
		this.raspolozivost = raspolozivost;
	}
	
	

}
