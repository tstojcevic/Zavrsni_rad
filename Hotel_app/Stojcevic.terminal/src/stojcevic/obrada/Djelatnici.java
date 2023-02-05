package stojcevic.obrada;

import java.util.ArrayList;
import java.util.List;

import stojcevic.Pomocno;
import stojcevic.Start;
import stojcevic.model.Djelatnik;

public class Djelatnici {
	
	private List<Djelatnik> djelatnici;
	private Start start;
	
	
	

	public Djelatnici(Start start) {
		super();
		this.start = start;
		djelatnici = new ArrayList<>();
	}

	public Djelatnici(Start start, List<Djelatnik> djelatnici) {
		super();
		this.start = start;
		this.djelatnici = djelatnici;
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
			pregled();
		case 2:
			unosNovogDjelatnika();
		case 5:
			start.glavniIzbornik();
		}
	
}

	private void pregled() {
		System.out.println("Djelatnici u aplikaciji:");
		for (Djelatnik d : djelatnici ) {
			System.out.println(d);
		}
		izbornik();
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
		d.setOIB(Pomocno.unosTeksta("Unesite OIB djelatnika: "));
//		d.setRadnoMjesto(Pomocno.unosTeksta("Unesite radno mjesto djelatnika: "));
		d.setBrojUgovora(Pomocno.unosTeksta("Unesite broj ugovora djelatnika: "));
		return d;
	}

	public List<Djelatnik> getDjelatnici() {
		return djelatnici;
	}

	public void setDjelatnici(List<Djelatnik> djelatnici) {
		this.djelatnici = djelatnici;
	}
	
	
	

}
