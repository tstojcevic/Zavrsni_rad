package stojcevic.obrada;

import java.util.ArrayList;
import java.util.List;

import stojcevic.Pomocno;
import stojcevic.Start;
import stojcevic.model.Gost;

public class Gosti {
	
	private List<Gost> gosti;
	private Start start;
	
	
	
	public Gosti(Start start) {
		super();
		this.start = start;
		gosti = new ArrayList<>();
		}
	
	
	public Gosti(Start start, List<Gost> gostis) {
		super();
		this.start = start;
		this.gosti = gosti;
		
	}
	
public void izbornik() {
		
		System.out.println("");
		System.out.println("Gost izbornik");
		System.out.println("Dostupne opcije");
		System.out.println("1. Pregled svih gostiju");
		System.out.println("2. Unos novog gosta");
		System.out.println("3. Promjena postojećeg gosta");
		System.out.println("4. Brisanje gosta");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
		
	}
	
	
	
	
	private void odabirIzbornika() {
		switch(Pomocno.unosBrojRaspon("Odaberite opciju: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
//			unosNovogGosta();
			break;
		case 3:
			if(gosti.size()==0) {
				System.out.println("Nema gosta kojeg bi mijenali");
				izbornik();
			}else {
//				promjena();
			}
			break;
		case 4:
			if(gosti.size()==0) {
				System.out.println("Nema gosta kojeg bi obrisali");
				izbornik();
			}else {
//				brisanje();
			}
			break;
		case 5:
			start.glavniIzbornik();
		}
	
	
}


	private void pregled(boolean prikaziIzbornik) {
		System.out.println("Gosti u aplikaciji:");
		int rb = 1;
		for (Gost g : gosti ) {
			System.out.println(rb++ + ". " + g);
		}
		if (prikaziIzbornik) {
			izbornik();
		}
	}


	public List<Gost> getGosti() {
		return gosti;
	}
	public void setGosti(List<Gost> gosti) {
		this.gosti = gosti;
	}
	
	

}