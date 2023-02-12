package stojcevic.obrada;

import java.util.ArrayList;
import java.util.List;

import stojcevic.Pomocno;
import stojcevic.Start;
import stojcevic.model.RadnoMjesto;
import stojcevic.model.Smjestaj;

public class Smjestaji {
	
	private List<Smjestaj> smjestaji;
	private Start start;
	
	
	public Smjestaji(Start start) {
		super();
		this.start = start;
		smjestaji = new ArrayList<>();
	}
	public Smjestaji(Start start, List<Smjestaj> smjestaji) {
		super();
		this.start = start;
		this.smjestaji = smjestaji;
		
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
//		odabirIzbornika();
		
	}
	
	
//	private void odabirIzbornika() {
//		switch(Pomocno.unosBrojRaspon("Odaberite opciju: ", 1, 5)) {
//		case 1:
//			pregled(true);
//			break;
//		case 2:
//			unosNovogSmještaja();
//			break;
//		case 3:
//			if(Smještaji.size()==0) {
//				System.out.println("Nema smještaja kojeg bi mijenali");
//				izbornik();
//			}else {
////				promjena();
//			}
//			break;
//		case 4:
//			if(Smještaji.size()==0) {
//				System.out.println("Nema radnog mjesta kojeg bi obrisali");
//				izbornik();
//			}else {
////				brisanje();
//			}
//			break;
//		case 5:
//			start.glavniIzbornik();
//		}
//}
	
	
	
	private void unosNovogSmještaja() {
		Smjestaj s = new Smjestaj();
		s.setSifra(Pomocno.unosBrojRaspon("Unesite šifru smještaja: ", 1, Integer.MAX_VALUE));
		s.setVrsta(Pomocno.unosTeksta("Unesite vrstu smještaja: "));
		s.setBrojKreveta(Pomocno.unosBrojRaspon("Unesite broj kreveta: ", 1, Integer.MAX_VALUE));
		s.setCijena(Pomocno.unosIznosa("Unesite cijenu smještaja: "));
		s.setRaspolozivost(Pomocno.unosStatusa("Unesite 'da' ako je smještaj raspoloživ odnosno 'ne' ukoliko je zauzet!"));
		
		
		
		izbornik();
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
