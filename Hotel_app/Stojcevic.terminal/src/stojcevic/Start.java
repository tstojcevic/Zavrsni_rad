package stojcevic;

public class Start {
	
public Start() {
		
		pozdravnaPoruka();
		glavniIzbornik();
		
	}

	private void glavniIzbornik() {
		
		System.out.println("");
		System.out.println("GLAVNI IZBORNIK");
		System.out.println("Dostupne opcije");
		System.out.println("1. Djelatnik");
		System.out.println("2. Gost");
		System.out.println("3. Radno Mjesto");
		System.out.println("4. Rezervacija");
		System.out.println("5. Smještaj");
		System.out.println("6. Izlaz iz programa");
		
		
	}

	private void pozdravnaPoruka() {
		System.out.println("Dobrodošli u Hotel terminal aplikaciju");
		
	}
	
	public static void main(String[] args) {
		
		new Start();
		
	}

}
