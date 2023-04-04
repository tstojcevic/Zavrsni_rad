/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.controller;

import hotel.model.Rezervacija;
import hotel.model.Smjestaj;
import hotel.util.HotelException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaSmjestaj extends Obrada<Smjestaj> {

    @Override
    public List<Smjestaj> read() {
        return session.createQuery("from Smjestaj order by vrsta", Smjestaj.class).list();
    }

    public List<Smjestaj> read(String uvjet) {
        uvjet = uvjet.trim();
        uvjet = "%" + uvjet + "%";
        return session.createQuery(" from Smjestaj "
                + " where concat(vrsta,' ',brojKreveta,' ',cijena,' ',raspolozivost) "
                + " like :uvjet "
                + " order by vrsta ",
                Smjestaj.class).setParameter("uvjet", uvjet)
                .setMaxResults(10)
                .list();
    }

    

    @Override
    protected void kontrolaUnos() throws HotelException {
        kontrolaVrsta();
        kontrolaBrojKreveta();
        kontrolaCijena();
        kontrolaRaspolozivost();
    }

    @Override
    protected void kontrolaPromjena() throws HotelException {
        kontrolaVrstaNull();

        kontrolaBrojKrevetaNull();

        kontrolaCijenaNull();

        kontrolaRaspolozivostNull();

    }

    @Override
    protected void kontrolaBrisanje() throws HotelException {
        if (entitet.getRezervacije() != null && !entitet.getRezervacije().isEmpty()) {

            StringBuilder sb = new StringBuilder();
            sb.append("Smještaj ");
            sb.append(entitet.getVrsta());
            sb.append(" se ne može obrisati jer postoji rezervacija:");
            sb.append("\n");
            int b = 0;
            for (Rezervacija r : entitet.getRezervacije()) {
                sb.append(++b);
                sb.append(". ");
                sb.append(r.getBrojRezervacije());
                sb.append("\n");
            }
            sb.append("--------");

            throw new HotelException(sb.toString());
        }

    }

    private void kontrolaVrsta() throws HotelException {
        kontrolaVrstaNull();
    }

    private void kontrolaVrstaNull() throws HotelException {

        if (entitet.getVrsta() == null) {
            throw new HotelException("Vrsta smještaja mora biti odabrana");
        }
    }

    private void kontrolaBrojKreveta() throws HotelException {
        kontrolaBrojKrevetaNull();
    }

    private void kontrolaCijena() throws HotelException {
        kontrolaCijenaNull();

    }

    private void kontrolaCijenaNull() throws HotelException {
        if (entitet.getCijena() == null
                || entitet.getCijena().compareTo(BigDecimal.ZERO) <= 0
                || entitet.getCijena().compareTo(new BigDecimal(10000)) >= 1) {
            throw new HotelException("Cijena mora biti postavljena, "
                    + "veća od 0 i manja od 10000");
        }
    }

    private void kontrolaRaspolozivost() throws HotelException {
        kontrolaRaspolozivostNull();
    }

    private void kontrolaRaspolozivostNull() throws HotelException {

        String unos = "";
        if (unos.equalsIgnoreCase("da")) {

        } else if (unos.equalsIgnoreCase("ne")) {

        } else {
            System.out.println("Pogrešan unos. Unijeti 'da' ili 'ne'.");

        }

    }

    private void kontrolaBrojKrevetaNull() throws HotelException {
        if (entitet.getBrojKreveta() == 0) {
            throw new HotelException("Broj kreveta mora biti odabran");
        }

    }
}
