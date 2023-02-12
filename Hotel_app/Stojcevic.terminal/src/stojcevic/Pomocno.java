package stojcevic;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Pomocno {

	public static Scanner ulaz;
	public static boolean DEV;

	public static int unosBrojRaspon(String poruka, int min, int max) {
		int i;
		while(true) {
			try {
				System.out.print(poruka);
				i = Integer.parseInt(ulaz.nextLine());
				if(i<min || i>max) {
					System.out.println("Broj mora biti između " 
							+ min + " i " + max);
					continue;
				}
				return i;
			} catch (Exception e) {
				System.out.println("Niste unijeli broj");
			}
		}
	}

	public static String unosTeksta(String poruka) {
		String s;
		while(true) {
			System.out.print(poruka);
			s = ulaz.nextLine();
			if(s.trim().isEmpty()) {
				System.out.println("Obavezan unos");
				continue;
			}
			return s;
		}	
	}
	
	public static BigDecimal unosIznosa(String poruka) {

		System.out.println(poruka);
		String s = ulaz.nextLine();
		return new BigDecimal(s);

	}
	
	public static boolean unosStatusa(String poruka) {

		String s;
		while (true) {
//			System.out.println(poruka);
			s = unosTeksta(poruka);
			if (s.equalsIgnoreCase("DA")) {
				return true;
			}else if (s.equalsIgnoreCase("NE")) {
				return false;
			}else {
			System.out.println("nepoznat upis");
			}
		}

	}
	
	public static Date unosDatuma(String poruka) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		while (date == null) {
			System.out.print(poruka + " (" +"dd-MM-yyyy" + "): ");
			String dateStr = ulaz.nextLine();
			try {
				date = format.parse(dateStr);
			} catch (Exception e) {
				System.out.println("Pogrešan format datuma. Pokušajte ponovno.");
			}
		}

		return date;
	}
}
