/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.controller;

import hotel.model.Gost;
import hotel.model.Rezervacija;
import hotel.model.Smjestaj;
import hotel.util.HotelException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaRezervacija extends Obrada<Rezervacija> {

    @Override
    public List<Rezervacija> read() {
        return session.createQuery("from Rezervacija", Rezervacija.class).list();
    }

    public List<Rezervacija> read(Gost g) {
        return session.createQuery("from Rezervacija "
                + " where gost=:Gost "
                + " order by brojRezervacije desc ",
                Rezervacija.class)
                .setParameter("Gost", g)
                .list();

    }

    @Override
    protected void kontrolaUnos() throws HotelException {
        if(entitet.getGost().getSifra()==0){
            entitet.setGost(null);
        }
        
    }

    @Override
    protected void kontrolaPromjena() throws HotelException {

    }

    @Override
    protected void kontrolaBrisanje() throws HotelException {

    }

}
