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
		testPodaci();
	}

	public Gosti(Start start, List<Gost> gosti) {
		super();
		this.start = start;
		this.gosti = gosti;
		testPodaci();
	}

	private void testPodaci() {
		if (Pomocno.DEV) {
			gosti.add(new Gost(1, "Ivica", "Ivić", "44036942226", "iivic@gmail.com", "+385981234567"));
			gosti.add(new Gost(2, "Marija", "Marijanović", "06442453523", "mmarijanovic@gmail.com", "+385951486277"));
			gosti.add(new Gost(3, "Ksenija", "Horvat", "06442453523", "khorvat@gmail.com", "+385951486277"));
		}
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
		switch (Pomocno.unosBrojRaspon("Odaberite opciju: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovogGosta();
			break;
		case 3:
			if (gosti.size() == 0) {
				System.out.println("Nema gosta kojeg bi mijenali");
				izbornik();
			} else {
				promjena();
			}
			break;
		case 4:
			if (gosti.size() == 0) {
				System.out.println("Nema gosta kojeg bi obrisali");
				izbornik();
			} else {
				brisanje();
			}
			break;
		case 5:
			start.glavniIzbornik();
		}

	}

	private void brisanje() {
		pregled(false);
		int rb = Pomocno.unosBrojRaspon("Odaberite gosta kojeg želite obrisati: ", 1, gosti.size());
		gosti.remove(rb - 1);
		izbornik();
	}

	private void promjena() {
		pregled(false);
		int rb = Pomocno.unosBrojRaspon("Unesite gosta kojeg želite promijeniti: ", 1, gosti.size());
		Gost g = gosti.get(rb - 1);
		g.setIme(Pomocno.unosTeksta("Unesite ime gosta: "));
		g.setPrezime(Pomocno.unosTeksta("Unesite prezime gosta"));
		g.setOIB(Pomocno.unosTeksta("Unesite OIB gosta: "));
		g.setEmail(Pomocno.unosTeksta("Unesite e-mail gosta: "));
		g.setKontakTelefon(Pomocno.unosTeksta("Unesite kontakt telefon gosta: "));

		izbornik();
	}

	private void unosNovogGosta() {
		gosti.add(unesiNovogGosta());
		izbornik();
	}

	private Gost unesiNovogGosta() {
		Gost g = new Gost();
		g.setSifra(Pomocno.unosBrojRaspon("Unesite šifru gosta: ", 1, Integer.MAX_VALUE));
		g.setIme(Pomocno.unosTeksta("Unesite ime gosta: "));
		g.setPrezime(Pomocno.unosTeksta("Unesite prezime gosta"));
		g.setOIB(Pomocno.unosTeksta("Unesite OIB gosta: "));
		g.setEmail(Pomocno.unosTeksta("Unesite e-mail gosta: "));
		g.setKontakTelefon(Pomocno.unosTeksta("Unesite kontakt telefon gosta: "));
		return g;
	}

	private void pregled(boolean prikaziIzbornik) {
		System.out.println("Gosti u aplikaciji:");
		int rb = 1;
		for (Gost g : gosti) {
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
