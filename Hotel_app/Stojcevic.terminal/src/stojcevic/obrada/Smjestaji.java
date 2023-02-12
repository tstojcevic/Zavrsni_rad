package stojcevic.obrada;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import stojcevic.Pomocno;
import stojcevic.Start;
import stojcevic.model.Smjestaj;

public class Smjestaji {
	
	private List<Smjestaj> smjestaji;
	private Start start;
	
	
	public Smjestaji(Start start) {
		super();
		this.start = start;
		smjestaji = new ArrayList<>();
		testPodaci();
	}
	
	public Smjestaji(Start start, List<Smjestaj> smjestaji) {
		super();
		this.start = start;
		this.smjestaji = smjestaji;
		testPodaci();
	}
	
private void testPodaci() {
		smjestaji.add(new Smjestaj(1, "polupansion", 2, new BigDecimal(150), true));
		smjestaji.add(new Smjestaj(2, "polupansion", 2, new BigDecimal(150), true));
		smjestaji.add(new Smjestaj(3, "polupansion", 2, new BigDecimal(150), true));
		
	}

public void izbornik() {
		
		System.out.println("");
		System.out.println("Smještaji izbornik");
		System.out.println("Dostupne opcije");
		System.out.println("1. Pregled svih smještaja");
		System.out.println("2. Unos novog smještaja");
		System.out.println("3. Promjena postojećeg smještaja");
		System.out.println("4. Brisanje smještaja");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
		
	}
	
	
	private void odabirIzbornika() {
		switch(Pomocno.unosBrojRaspon("Odaberite opciju: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovogSmještaja();
			break;
		case 3:
			if(smjestaji.size()==0) {
				System.out.println("Nema smještaja kojeg bi mijenali");
				izbornik();
			}else {
				promjena();
			}
			break;
		case 4:
			if(smjestaji.size()==0) {
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
		int rb = Pomocno.unosBrojRaspon("Odaberite smještaj koji želite obrisati: ", 1, smjestaji.size());
		smjestaji.remove(rb - 1);
		izbornik();
	}

	private void promjena() {
		pregled(false);
		int rb = Pomocno.unosBrojRaspon("Unesite smještaj koji želite promijeniti", 1, smjestaji.size());
		Smjestaj s = smjestaji.get(rb-1);
		s.setVrsta(Pomocno.unosTeksta("Unesite vrstu smještaja: "));
		s.setBrojKreveta(Pomocno.unosBrojRaspon("Unesite broj kreveta: ", 1, Integer.MAX_VALUE));
		s.setCijena(Pomocno.unosIznosa("Unesite cijenu smještaja: "));
		s.setRaspolozivost(Pomocno.unosStatusa("Unesite 'da' ako je smještaj raspoloživ, odnosno 'ne' ukoliko nije raspoloživ: "));
		
		izbornik();
	}

	private void unosNovogSmještaja() {
		smjestaji.add(unesiNoviSmjestaj());
		izbornik();
	}

	private Smjestaj unesiNoviSmjestaj() {
		Smjestaj s = new Smjestaj();
		s.setSifra(Pomocno.unosBrojRaspon("Unesite šifru smještaja: ", 1, Integer.MAX_VALUE));
		s.setVrsta(Pomocno.unosTeksta("Unesite vrstu smještaja: "));
		s.setBrojKreveta(Pomocno.unosBrojRaspon("Unesite broj kreveta: ", 1, Integer.MAX_VALUE));
		s.setCijena(Pomocno.unosIznosa("Unesite cijenu smještaja: "));
		s.setRaspolozivost(Pomocno.unosStatusa("Unesite 'da' ako je smještaj raspoloživ, odnosno 'ne' ukoliko nije raspoloživ"));
		return s;
	}

	public void pregled(boolean prikaziIzbornik) {
		System.out.println("Smještaji u aplikaciji:");
		int rb = 1;
		for (Smjestaj s : smjestaji ) {
			System.out.println(rb++ + ". " + s);
		}
		if (prikaziIzbornik) {
			izbornik();
		}
	}
	
	
	
	
	public List<Smjestaj> getSmjestaji() {
		return smjestaji;
	}
	public void setSmjestaji(List<Smjestaj> smjestaji) {
		this.smjestaji = smjestaji;
	}

	
	

}
