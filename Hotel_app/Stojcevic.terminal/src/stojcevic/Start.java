package stojcevic;

import java.util.Scanner;

import stojcevic.obrada.Djelatnici;

public class Start {
	
	private Djelatnici djelatnici;
	
public Start() {
	
		Pomocno.ulaz = new Scanner(System.in);
		djelatnici = new Djelatnici(this);
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
		case 6:
			System.out.println("Izlazite iz programa.");
			System.out.println("Doviđenja!");
		}
		
	}

	private void pozdravnaPoruka() {
		System.out.println("Dobrodošli u Hotel terminal aplikaciju");
		
	}
	
	public static void main(String[] args) {
		
		new Start();
		
	}

}