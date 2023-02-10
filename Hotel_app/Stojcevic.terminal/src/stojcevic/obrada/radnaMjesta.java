package stojcevic.obrada;

import java.util.ArrayList;
import java.util.List;

import stojcevic.Pomocno;
import stojcevic.Start;
import stojcevic.model.Djelatnik;
import stojcevic.model.radnoMjesto;

public class radnaMjesta  {
	
	private List<radnoMjesto> radnaMjesta;
	private Start start;
	
	
	
	
	public radnaMjesta(Start start) {
		super();
		this.start = start;
		radnaMjesta = new ArrayList<>();
		testPodaci();
	}
	
	
	public radnaMjesta(Start start, List<radnoMjesto> radnaMjesta) {
		super();
		this.start = start;
		this.radnaMjesta = radnaMjesta;
		testPodaci();
	}
	
	
private void testPodaci() {
		
	}


public void izbornik() {
		
		System.out.println("");
		System.out.println("Radna mjesta izbornik");
		System.out.println("Dostupne opcije");
		System.out.println("1. Pregled svih radnih mjesta");
		System.out.println("2. Unos novog radnog mjesta");
		System.out.println("3. Promjena postojećeg radnog mjesta");
		System.out.println("4. Brisanje radnih mjesta");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
		
	}
	
	
	private void odabirIzbornika() {
		switch(Pomocno.unosBrojRaspon("Odaberite opciju: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovogRadnogMjesta();
			break;
		case 3:
			if(radnaMjesta.size()==0) {
				System.out.println("Nema radnog mjesta kojeg bi mijenali");
				izbornik();
			}else {
				promjena();
			}
			break;
		case 4:
			if(radnaMjesta.size()==0) {
				System.out.println("Nema radnog mjesta kojeg bi obrisali");
				izbornik();
			}else {
				brisanje();
			}
			break;
		case 5:
			start.glavniIzbornik();
		}
}


	private void brisanje() {
		pregled(false);
		int rb = Pomocno.unosBrojRaspon("Odaberite djelatnika kojeg želite obrisati: ", 1, radnaMjesta.size());
		radnaMjesta.remove(rb - 1);
		izbornik();
	}


	private void promjena() {
		pregled(false);
		int rb = Pomocno.unosBrojRaspon("Unesite radno mjesto koje želite promijeniti: ", 1, radnaMjesta.size());
		radnoMjesto r = radnaMjesta.get(rb - 1);
		r.setNaziv(Pomocno.unosTeksta("Unesite naziv radnog mjesta: "));
		r.setPlaca(Pomocno.unosPlace("Unesite iznos plaće: "));
//		r.setSmjenskiRad(false);
		
		start.getDjelatnici().pregled(false);
		int i = Pomocno.unosBrojRaspon("Unesite kojeg djelatnika želite na radnom mjestu: ", 1,
				start.getDjelatnici().getDjelatnici().size());
//		r.setDjelatnik(start.getDjelatnici().getDjelatnici().get(i - 1));
	}


	private void unosNovogRadnogMjesta() {
		radnoMjesto r = new radnoMjesto();
		r.setSifra(Pomocno.unosBrojRaspon("Unesite šifru radnog mjesta: ", 1, Integer.MAX_VALUE));
		r.setNaziv(Pomocno.unosTeksta("Unesite naziv radnog mjesta: "));
		r.setPlaca(Pomocno.unosPlace("Unesite iznos plaće: "));
//		r.setSmjenskiRad(false);
		start.getDjelatnici().pregled(false);
		int rb = Pomocno.unosBrojRaspon("Odaberite djelatnika: ", 1,
				start.getDjelatnici().getDjelatnici().size());
//		r.setDjelatnik(start.getDjelatnici().getDjelatnici().get(rb-1));
		
		radnaMjesta.add(r);
		izbornik();
	}


	


	public void pregled(boolean prikaziIzbornik) {
		System.out.println("Radna mjesta u aplikaciji:");
		int rb = 1;
		for (radnoMjesto r : radnaMjesta ) {
			System.out.println(rb++ + ". " + r);
		}
		if (prikaziIzbornik) {
			izbornik();
		}
	}


	public List<radnoMjesto> getRadnaMjesta() {
		return radnaMjesta;
	}
	public void setRadnaMjesta(List<radnoMjesto> radnaMjesta) {
		this.radnaMjesta = radnaMjesta;
	}
	
	
	

}
