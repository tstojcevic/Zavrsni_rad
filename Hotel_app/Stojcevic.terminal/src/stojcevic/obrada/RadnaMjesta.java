package stojcevic.obrada;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import stojcevic.Pomocno;
import stojcevic.Start;
import stojcevic.model.RadnoMjesto;

public class RadnaMjesta  {
	
	private List<RadnoMjesto> radnaMjesta;
	private Start start;
	
	
	
	
	public RadnaMjesta(Start start) {
		super();
		this.start = start;
		radnaMjesta = new ArrayList<>();
		testPodaci();
	}
	
	
	public RadnaMjesta(Start start, List<RadnoMjesto> radnaMjesta) {
		super();
		this.start = start;
		this.radnaMjesta = radnaMjesta;
		testPodaci();
	}
	
	
private void testPodaci() {
		radnaMjesta.add(new RadnoMjesto(1, "Kuhinja", new BigDecimal(1500), true));
		radnaMjesta.add(new RadnoMjesto(2, "Bar", new BigDecimal(950), true));
		radnaMjesta.add(new RadnoMjesto(3, "Recepcija", new BigDecimal(1000), true));
		
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
		RadnoMjesto rm = radnaMjesta.get(rb - 1);
		rm.setNaziv(Pomocno.unosTeksta("Unesite naziv radnog mjesta: "));
		rm.setPlaca(Pomocno.unosIznosa("Unesite iznos plaće: "));
		rm.setSmjenskiRad(Pomocno.unosStatusa("Unesite 'da' ili 'ne' ukoliko je obvezan smjenski rad!"));
		izbornik();
		
	}

	private void unosNovogRadnogMjesta() {
		radnaMjesta.add(unesiNovoRadnoMjesto());
		izbornik();
	}
	

	private RadnoMjesto unesiNovoRadnoMjesto() {
		RadnoMjesto rm = new RadnoMjesto();
		rm.setSifra(Pomocno.unosBrojRaspon("Unesite šifru radnog mjesta: ", 1, Integer.MAX_VALUE));
		rm.setNaziv(Pomocno.unosTeksta("Unesite naziv radnog mjesta: "));
		rm.setPlaca(Pomocno.unosIznosa("Unesite iznos plaće: "));
		rm.setSmjenskiRad(Pomocno.unosStatusa("Unesite 'da' ili 'ne' ukoliko je obvezan smjenski rad!"));
		return rm;	

	}



	public void pregled(boolean prikaziIzbornik) {
		System.out.println("Radna mjesta u aplikaciji:");
		int rb = 1;
		for (RadnoMjesto rm : radnaMjesta ) {
			System.out.println(rb++ + ". " + rm);
		}
		if (prikaziIzbornik) {
			izbornik();
		}
	}


	public List<RadnoMjesto> getRadnaMjesta() {
		return radnaMjesta;
	}
	public void setRadnaMjesta(List<RadnoMjesto> radnaMjesta) {
		this.radnaMjesta = radnaMjesta;
	}
	

}
