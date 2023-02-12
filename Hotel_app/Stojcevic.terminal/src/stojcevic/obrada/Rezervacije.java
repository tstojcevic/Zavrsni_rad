package stojcevic.obrada;

import java.util.ArrayList;
import java.util.List;

import stojcevic.Pomocno;
import stojcevic.Start;
import stojcevic.model.RadnoMjesto;
import stojcevic.model.Rezervacija;

public class Rezervacije {
	
	private List<Rezervacija> rezervacije;
	private Start start;
	
	
	
	public Rezervacije(Start start) {
		super();
		this.start = start;
		rezervacije = new ArrayList<>();
//		testPodaci();
	}
	public Rezervacije(Start start, List<Rezervacija> rezervacije) {
		super();
		this.start = start;
		this.rezervacije = rezervacije;
//		testPodaci();
	}
	
public void izbornik() {
		
		System.out.println("");
		System.out.println("Rezervacije izbornik");
		System.out.println("Dostupne opcije");
		System.out.println("1. Pregled svih rezervacija");
		System.out.println("2. Unos nove rezervacije");
		System.out.println("3. Promjena postojećih rezervacija");
		System.out.println("4. Brisanje rezervacija");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
		
	}

private void odabirIzbornika() {
	switch(Pomocno.unosBrojRaspon("Odaberite opciju: ", 1, 5)) {
	case 1:
		pregled(true);
		break;
	case 2:
		unosNoveRezervacije();
		break;
	case 3:
		if(rezervacije.size()==0) {
			System.out.println("Nema rezervacije koju bi mijenali");
			izbornik();
		}else {
			promjena();
		}
		break;
	case 4:
		if(rezervacije.size()==0) {
			System.out.println("Nema rezervacije koju bi obrisali");
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
	int rb = Pomocno.unosBrojRaspon("Odaberite rezervaciju koju želite obrisati: ", 1, rezervacije.size());
	rezervacije.remove(rb - 1);
	izbornik();
}
private void promjena() {
	pregled(false);
	int rb = Pomocno.unosBrojRaspon("Unesite rezervaciju koju želite promijeniti: ", 1, rezervacije.size());
	Rezervacija r = rezervacije.get(rb - 1);
	r.setDatumPrijave(Pomocno.unosDatuma("Unesite datum prijave iz rezervacije: "));
	r.setDatumOdjave(Pomocno.unosDatuma("Unesite datum odjave iz rezervacije: "));
	r.setBrojGostiju(Pomocno.unosBrojRaspon("Unesite broj gostiju koji je naveden na rezervaciji: ", 1, Integer.MAX_VALUE));
	r.setBrojRezervacije(Pomocno.unosTeksta("Unesite broj zaprimljene rezervacije: "));
	r.setBrojSmjestajnihJedinica(Pomocno.unosBrojRaspon("Unesite broj smještajnih jedinica sa rezervacije: ", 1, Integer.MAX_VALUE));
	
	start.getGosti().pregled(false);
	int i = Pomocno.unosBrojRaspon("Unesite gosta kojeg želite promijeniti: ", 1,
			start.getGosti().getGosti().size());
	r.setGost(start.getGosti().getGosti().get(i - 1));
	while (true) {
		
		start.getDjelatnici().pregled(false);
		int x = Pomocno.unosBrojRaspon("Kojeg djelatnika želite dodati?", 1, start.getDjelatnici().getDjelatnici().size());

		r.getDjelatnici().add(start.getDjelatnici().getDjelatnici().get(x - 1));
		if (Pomocno.unosBrojRaspon("0 za kraj dodavanja djelatnika", 0, Integer.MAX_VALUE) == 0) {
			break;

		}
	}
	while (true) {
		
		start.getSmjestaji().pregled(false);
		int x = Pomocno.unosBrojRaspon("Koji smještaj želite dodati?", 1, start.getSmjestaji().getSmjestaji().size());

		r.getSmjestaji().add(start.getSmjestaji().getSmjestaji().get(x - 1));
		if (Pomocno.unosBrojRaspon("0 za kraj dodavanja smještaja", 0, Integer.MAX_VALUE) == 0) {
			break;

		}
	}
	
	izbornik();
}
private void unosNoveRezervacije() {
	Rezervacija r = new Rezervacija();
	r.setSifra(Pomocno.unosBrojRaspon("Unesi šifru rezervacije: ", 1, Integer.MAX_VALUE));
	r.setDatumPrijave(Pomocno.unosDatuma("Unesite datum prijave iz rezervacije: "));
	r.setDatumOdjave(Pomocno.unosDatuma("Unesite datum odjave iz rezervacije: "));
	r.setBrojGostiju(Pomocno.unosBrojRaspon("Unesite broj gostiju koji je naveden na rezervaciji: ", 1, Integer.MAX_VALUE));
	r.setBrojRezervacije(Pomocno.unosTeksta("Unesite broj zaprimljene rezervacije: "));
	r.setBrojSmjestajnihJedinica(Pomocno.unosBrojRaspon("Unesite broj smještajnih jedinica sa rezervacije: ", 1, Integer.MAX_VALUE));
	
	start.getGosti().pregled(false);
	int rb = Pomocno.unosBrojRaspon("Unesite gosta na kojeg glasi rezervacija: ", 1, 
			start.getGosti().getGosti().size());
	r.setGost(start.getGosti().getGosti().get(rb-1));
	
	while (true) {
		start.getDjelatnici().pregled(false);
		rb = Pomocno.unosBrojRaspon("Unesite djelatnika koji je obradio rezervaciju: ", 1, 
				start.getDjelatnici().getDjelatnici().size());
		r.getDjelatnici().add(start.getDjelatnici().getDjelatnici().get(rb-1));
		if(Pomocno.unosBrojRaspon("0 za kraj dodavanja djelatnika", 0, Integer.MAX_VALUE)==0) {
			break;
		}
	}
	
	while (true) {
		start.getSmjestaji().pregled(false);
		rb = Pomocno.unosBrojRaspon("Unesite smještaj koji je na rezervaciji: ", 1, 
				start.getSmjestaji().getSmjestaji().size());
		r.getSmjestaji().add(start.getSmjestaji().getSmjestaji().get(rb-1));
		if(Pomocno.unosBrojRaspon("0 za kraj dodavanja smještaja: ", 0, Integer.MAX_VALUE)==0) {
			break;
		}
	}
	
	rezervacije.add(r);
	izbornik();
	
}


public void pregled(boolean prikaziIzbornik) {
	System.out.println("Rezervacije u aplikaciji:");
	int rb = 1;
	for (Rezervacija r : rezervacije ) {
		System.out.println(rb++ + ". " + r);
	}
	if (prikaziIzbornik) {
		izbornik();
	}
}
	
	
	
	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}
	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	public Start getStart() {
		return start;
	}
	public void setStart(Start start) {
		this.start = start;
	}
	
	

}
