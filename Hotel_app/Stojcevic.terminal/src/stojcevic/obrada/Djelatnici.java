package stojcevic.obrada;


import java.util.ArrayList;
import java.util.List;

import stojcevic.Pomocno;
import stojcevic.Start;
import stojcevic.model.Djelatnik;
import stojcevic.model.RadnoMjesto;

public class Djelatnici {
	
	private List<Djelatnik> djelatnici;
	private Start start;
	
	
	

	public Djelatnici(Start start) {
		super();
		this.start = start;
		djelatnici = new ArrayList<>();
		testPodaci();
	}

	public Djelatnici(Start start, List<Djelatnik> djelatnici) {
		super();
		this.start = start;
		this.djelatnici = djelatnici;
		testPodaci();
	}
	
private void testPodaci() {
//		if(Pomocno.DEV) {
			djelatnici.add(new Djelatnik(1, "Marko", "Marković", "25/2023", "02410283576", null));
			djelatnici.add(new Djelatnik(2, "Ivan", "Antolić", "20/2023", "97356332162", null));
			djelatnici.add(new Djelatnik(3, "Vanja", "Tolić", "15/2023", "51922450731", null));
//		}
		
	}

public void izbornik() {
		
		System.out.println("");
		System.out.println("Djelatnik izbornik");
		System.out.println("Dostupne opcije");
		System.out.println("1. Pregled svih djelatnika");
		System.out.println("2. Unos novog djelatnika");
		System.out.println("3. Promjena postojećeg djelatnika");
		System.out.println("4. Brisanje djelatnika");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
		
	}
	
	

	private void odabirIzbornika() {
		switch(Pomocno.unosBrojRaspon("Odaberite opciju: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovogDjelatnika();
			break;
		case 3:
			if(djelatnici.size()==0) {
				System.out.println("Nema djelatnika kojeg bi mijenali");
				izbornik();
			}else {
				promjena();
			}
			break;
		case 4:
			if(djelatnici.size()==0) {
				System.out.println("Nema djelatnika kojeg bi obrisali");
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
		int rb = Pomocno.unosBrojRaspon("Odaberite djelatnika kojeg želite obrisati: ", 1, djelatnici.size());
		djelatnici.remove(rb - 1);
		izbornik();
		
	}

	private void promjena() {
		pregled(false);
		int rb = Pomocno.unosBrojRaspon("Unesite djelatnika kojeg želite promijeniti: ", 1, djelatnici.size());
		Djelatnik d = djelatnici.get(rb-1);
		d.setIme(Pomocno.unosTeksta("Unesite ime djelatnika: "));
		d.setPrezime(Pomocno.unosTeksta("Unesite prezime djelatnika: "));
		d.setBrojUgovora(Pomocno.unosTeksta("Unesite broj ugovora djelatnika: "));
		d.setOIB(Pomocno.unosTeksta("Unesite OIB djelatnika: "));
		
		start.getRadnaMjesta().pregled(false);
		int i = Pomocno.unosBrojRaspon("Unesite radno mjesto koje želite promijeniti za djelatnika: ", 1,
				start.getRadnaMjesta().getRadnaMjesta().size());
		d.setRadnoMjesto(start.getRadnaMjesta().getRadnaMjesta().get(i - 1));
		
		izbornik();
	}

	public void pregled(boolean prikaziIzbornik) {
		System.out.println("Djelatnici u aplikaciji:");
		int rb = 1;
		for (Djelatnik d : djelatnici ) {
			System.out.println(rb++ + ". " + d);
		}
		if (prikaziIzbornik) {
			izbornik();
		}
		
	}

	private void unosNovogDjelatnika() {
		djelatnici.add(unesiNovogDjelatnika());
		izbornik();
	}

	private Djelatnik unesiNovogDjelatnika() {
		Djelatnik d = new Djelatnik();
		d.setSifra(Pomocno.unosBrojRaspon("Unesite šifru djelatnika: ", 1, Integer.MAX_VALUE));
		d.setIme(Pomocno.unosTeksta("Unesite ime djelatnika: "));
		d.setPrezime(Pomocno.unosTeksta("Unesite prezime djelatnika: "));
		d.setBrojUgovora(Pomocno.unosTeksta("Unesite broj ugovora djelatnika: "));
		d.setOIB(Pomocno.unosTeksta("Unesite OIB djelatnika: "));
		
		start.getRadnaMjesta().pregled(false);
		int rb = Pomocno.unosBrojRaspon("Unesite radno mjesto za djelatnika: ", 1, 
				start.getRadnaMjesta().getRadnaMjesta().size());
		d.setRadnoMjesto(start.getRadnaMjesta().getRadnaMjesta().get(rb-1));
		
		return d;
	}

	public List<Djelatnik> getDjelatnici() {
		return djelatnici;
	}

	public void setDjelatnici(List<Djelatnik> djelatnici) {
		this.djelatnici = djelatnici;
	}
	
	

}
