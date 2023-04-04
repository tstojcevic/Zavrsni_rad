/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.controller;

import hotel.model.Djelatnik;
import hotel.model.Rezervacija;
import hotel.util.Alati;
import hotel.util.HotelException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaDjelatnik extends Obrada<Djelatnik> {

    @Override
    public List<Djelatnik> read() {
        return session.createQuery("from Djelatnik order by ime, prezime", Djelatnik.class).list();
    }

    public List<Djelatnik> read(String uvjet) {
        uvjet = uvjet.trim();
        uvjet = "%" + uvjet + "%";
        return session.createQuery(" from Djelatnik "
                + " where concat(ime,' ',prezime,' ',brojUgovora,' ',OIB,' ',radnoMjesto) "
                + " like :uvjet "
                + " order by ime, prezime ",
                Djelatnik.class).setParameter("uvjet", uvjet)
                .setMaxResults(10)
                .list();
    }

    public List<Djelatnik> read(String uvjet,
            boolean traziOdPocetkaImena) {
        uvjet = uvjet.trim();
        if (traziOdPocetkaImena) {
            uvjet = uvjet + "%";
        } else {
            uvjet = "%" + uvjet + "%";
        }

        return session.createQuery("from Djelatnik "
                + " where concat(ime,' ',prezime,' ',ime) "
                + " like :uvjet "
                + " order by prezime, ime ",
                Djelatnik.class)
                .setParameter("uvjet", uvjet)
                .setMaxResults(12)
                .list();
    }

    @Override
    protected void kontrolaUnos() throws HotelException {
       
        if(entitet.getRadnoMjesto().getSifra()==0){
            entitet.setRadnoMjesto(null);
        }
        
        kontrolaIme();
        kontrolaPrezime();
        kontrolaBrojUgovora();
        kontrolaOIB();

    }

    @Override
    protected void kontrolaPromjena() throws HotelException {
        kontrolaImeNull();
        kontrolaImeBroj();
        kontrolaImeMinimalnaDuzina();
        kontrolaImeMaksimalnaDuzina();
        kontrolaImeSadrziBroj();
        
        kontrolaPrezimeNull();
        kontrolaPrezimeBroj();
        kontrolaPrezimeMinimalnaDuzina();
        kontrolaPrezimeMaksimalnaDuzina();
        kontrolaPrezimeSadrziBroj();
        
        kontrolaBrojUgovoraNull();
        
        kontrolaOIBNull();
    }

    @Override
    protected void kontrolaBrisanje() throws HotelException {
        if (entitet.getRezervacije() != null && !entitet.getRezervacije().isEmpty()) {

            StringBuilder sb = new StringBuilder();
            sb.append("Djelatnik ");
            sb.append(entitet.getIme());
            sb.append(" ");
            sb.append(entitet.getPrezime());
            sb.append(" se ne može obrisati jer je zadužen za rezervaciju:");
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

    private void kontrolaIme() throws HotelException{
        kontrolaImeNull();
        kontrolaImeBroj();
        kontrolaImeMinimalnaDuzina();
        kontrolaImeMaksimalnaDuzina();
        kontrolaImeSadrziBroj();
    }
    
    private void kontrolaImeNull() throws HotelException {

        if (entitet.getIme() == null) {
            throw new HotelException("Ime mora biti upisano");
        }
    }
    
    private void kontrolaImeBroj() throws HotelException {
        boolean broj = false;
        try {
            Double.parseDouble(entitet.getIme());
            broj = true;
        } catch (Exception e) {
        }
        if (broj) {
            throw new HotelException("Ime djelatnika ne smije biti broj");
        }
    }
    private void kontrolaImeMinimalnaDuzina() throws HotelException {
        if (entitet.getIme().trim().length() < 3) {
            throw new HotelException("Ime djelatnika može imati minimalno 3 znaka");
        }
    }
    
    private void kontrolaImeMaksimalnaDuzina() throws HotelException {
        if (entitet.getIme().trim().length() > 20) {
            throw new HotelException("Ime djelatnika može imati maksimalno 20 znakova");
        }
    }
    
    private void kontrolaImeSadrziBroj() throws HotelException {

        char[] b = entitet.getIme().toCharArray();

        for (char ch : b) {
            if (Character.isDigit(ch)) {
                throw new HotelException("Ime sadrži broj");
            }

        }
    }

    private void kontrolaPrezime() throws HotelException{
        kontrolaPrezimeNull();
        kontrolaPrezimeBroj();
        kontrolaPrezimeMinimalnaDuzina();
        kontrolaPrezimeMaksimalnaDuzina();
        kontrolaPrezimeSadrziBroj();
    }

    private void kontrolaPrezimeNull() throws HotelException {
        if (entitet.getPrezime() == null) {
            throw new HotelException("Prezime mora biti upisano");
        }
    }
    
    private void kontrolaPrezimeBroj() throws HotelException {
        boolean broj = false;
        try {
            Double.parseDouble(entitet.getPrezime());
            broj = true;
        } catch (Exception e) {
        }
        if (broj) {
            throw new HotelException("Prezime djelatnika ne smije biti broj");
        }
    }
    
    private void kontrolaPrezimeMinimalnaDuzina() throws HotelException {
        if (entitet.getPrezime().trim().length() < 3) {
            throw new HotelException("Prezime djelatnika može imati minimalno 3 znaka");
        }
    }
    
    private void kontrolaPrezimeMaksimalnaDuzina() throws HotelException {
        if (entitet.getPrezime().trim().length() > 30) {
            throw new HotelException("Prezime djelatnika može imati maksimalno 30 znakova");
        }
    }
    
    private void kontrolaPrezimeSadrziBroj() throws HotelException {
        char[] b = entitet.getIme().toCharArray();
        for (char ch : b) {
            if (Character.isDigit(ch)) {
                throw new HotelException("Prezime sadrži broj");
            }
        }
    }

    private void kontrolaOIB() throws HotelException{
        kontrolaOIBNull();
    }

    private void kontrolaOIBNull()throws HotelException{
        if (entitet.getOIB() == null) {
            throw new HotelException("OIB mora biti unesen");
        } else if (!Alati.kontrolaOIB(entitet.getOIB())) {
            throw new HotelException("OIB nije u dobrom formatu");
        }
    }

    private void kontrolaBrojUgovora() throws HotelException{
        kontrolaBrojUgovoraNull();
    }

    private void kontrolaBrojUgovoraNull() throws HotelException{
        if (entitet.getBrojUgovora()== null) {
            throw new HotelException("Broj ugovora mora biti upisan");
        }
    }
}
