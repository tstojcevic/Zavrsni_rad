package stojcevic;

import java.util.Scanner;

import stojcevic.obrada.Djelatnici;
import stojcevic.obrada.Gosti;
import stojcevic.obrada.RadnaMjesta;
import stojcevic.obrada.Rezervacije;
import stojcevic.obrada.Smjestaji;

public class Start {
	
	private Djelatnici djelatnici;
	private Gosti gosti;
	private RadnaMjesta radnaMjesta;
	private Smjestaji smjestaji;
	private Rezervacije rezervacije;

	//početni dio aplikacije napravljen u Eclipse
	
public Start() {
	
		Pomocno.ulaz = new Scanner(System.in);
		djelatnici = new Djelatnici(this);
		gosti = new Gosti(this);
		radnaMjesta = new RadnaMjesta(this);
		smjestaji = new Smjestaji(this);
		rezervacije = new Rezervacije(this);
		pozdravnaPoruka();
		glavniIzbornik();
		
	}

	public void glavniIzbornik() {
		
		System.out.println("");
		System.out.println("GLAVNI IZBORNIK");
		System.out.println("Dostupne opcije");
		System.out.println("1. Djelatnik");
		System.out.println("2. Gost");
		System.out.println("3. Radno Mjesto");
		System.out.println("4. Rezervacija");
		System.out.println("5. Smještaj");
		System.out.println("6. Izlaz iz programa");
		odabirGlavnogIzbornika();
		
		
	}

	private void odabirGlavnogIzbornika() {
		switch(Pomocno.unosBrojRaspon("Odabrana opcija: ", 1, 6)) {
		
		case 1:
			djelatnici.izbornik();
			break;
		case 2:
			gosti.izbornik();
			break;
		case 3:
			radnaMjesta.izbornik();
			break;
		case 4:
			rezervacije.izbornik();
			break;
		case 5:
			smjestaji.izbornik();
			break;
		case 6:
			System.out.println("Izlazite iz programa.");
			System.out.println("Doviđenja!");
		}
		
	}

	private void pozdravnaPoruka() {
		System.out.println("Dobrodošli u Hotel terminal aplikaciju");
		
	}
	
	
	
	
	public Smjestaji getSmjestaji() {
		return smjestaji;
	}

	public Gosti getGosti() {
		return gosti;
	}

	public Djelatnici getDjelatnici() {
		return djelatnici;
	}

	public RadnaMjesta getRadnaMjesta() {
		return radnaMjesta;
	}
	
	public Rezervacije getRezervacije() {
		return rezervacije;
	}

	public static void main(String[] args) {
		if(args.length==1) {
			Pomocno.DEV=true;
		}else {
			Pomocno.DEV=false;
		}
		new Start();
		
	}

}
