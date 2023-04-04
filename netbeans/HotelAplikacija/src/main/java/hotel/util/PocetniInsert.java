/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.util;

import com.github.javafaker.Faker;
import hotel.model.Djelatnik;
import hotel.model.Gost;
import hotel.model.RadnoMjesto;
import hotel.model.Rezervacija;
import hotel.model.Smjestaj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.hibernate.Session;

/**
 *
 * @author Korisnik
 */
public class PocetniInsert {

    private static final int BROJ_GOSTIJU = 50;
    private static final int BROJ_RADNIH_MJESTA = 5;
    private static final int BROJ_SMJESTAJA = 20;
    private static final int BROJ_DJELATNIKA = 20;
    private static final int BROJ_REZERVACIJA = 25;

    private Faker faker;
    private List<Gost> gosti;
    private List<RadnoMjesto> radna_mjesta;
    private List<Smjestaj> smjestaji;
    private List<Djelatnik> djelatnici;
    private List<Rezervacija> rezervacije;

    private Session session;

    public PocetniInsert() {

        faker = new Faker();
        gosti = new ArrayList<>();
        radna_mjesta = new ArrayList<>();
        smjestaji = new ArrayList<>();
        djelatnici = new ArrayList<>();
        rezervacije = new ArrayList<>();

        session = HibernateUtil.getSession();
        session.beginTransaction();

        kreirajGoste();
        kreirajRadnaMjesta();
        kreirajSmjestaje();
        kreirajDjelatnike();
        kreirajRezervacije();

        session.getTransaction().commit();
    }

    private void kreirajGoste() {

        Gost g;
        for (int i = 0; i < BROJ_GOSTIJU; i++) {
            g = new Gost();
            g.setIme(faker.name().firstName());
            g.setPrezime(faker.name().lastName());
            g.setOIB(Alati.dovuciOib());
            g.setEmail(faker.internet().emailAddress());
            g.setKontakTelefon(faker.phoneNumber().cellPhone());

            session.persist(g);
            gosti.add(g);
        }

    }

    private void kreirajRadnaMjesta() {

        RadnoMjesto rm;
        for (int i = 0; i < BROJ_RADNIH_MJESTA; i++) {
            rm = new RadnoMjesto();
            rm.setNaziv(faker.job().position());
            rm.setPlaca(new BigDecimal(faker.number().numberBetween(800, 2500)));
            rm.setSmjenskiRad(faker.bool().bool());

            session.persist(rm);
            radna_mjesta.add(rm);
        }

    }

    private void kreirajSmjestaje() {

        Smjestaj s;
        for (int i = 0; i < BROJ_SMJESTAJA; i++) {
            s = new Smjestaj();
            s.setVrsta(faker.rockBand().name());
            s.setBrojKreveta(faker.number().numberBetween(1, 3));
            s.setCijena(new BigDecimal(faker.number().numberBetween(80, 200)));
            s.setRaspolozivost(faker.bool().bool());

            session.persist(s);
            smjestaji.add(s);
        }
    }

    private void kreirajDjelatnike() {

        Djelatnik d;
        for (int i = 0; i < BROJ_DJELATNIKA; i++) {
            d = new Djelatnik();
            d.setIme(faker.name().firstName());
            d.setPrezime(faker.name().lastName());
            d.setBrojUgovora(faker.number().toString());
            d.setOIB(Alati.dovuciOib());
            d.setRadnoMjesto(radna_mjesta.get(sb(0, BROJ_RADNIH_MJESTA - 1)));

            session.persist(d);
            djelatnici.add(d);
        }
    }

    private void kreirajRezervacije() {

        Rezervacija r;
        List<Djelatnik> d;
        List<Smjestaj> s;

        for (int i = 0; i < BROJ_REZERVACIJA; i++) {
            r = new Rezervacija();
            r.setDatumPrijave(faker.date().birthday());
            r.setDatumOdjave(faker.date().birthday());
            r.setBrojGostiju(faker.number().numberBetween(1, 6));
            r.setBrojRezervacije(faker.number().digit());
            r.setBrojSmjestajnihJedinica(faker.number().numberBetween(1, 20));
            r.setGost(gosti.get(sb(0, BROJ_GOSTIJU - 1)));
            d = new ArrayList<>();
            s = new ArrayList<>();

            for (int y = 0; y < sb(1, 3); y++) {
                d.add(djelatnici.get(sb(0, BROJ_DJELATNIKA - 1)));
            }

            for (int x = 0; x < sb(1, 20); x++) {
                s.add(smjestaji.get(sb(0, BROJ_SMJESTAJA - 1)));
            }

            r.setDjelatnici(d);
            r.setSmjestaji(s);

            session.persist(r);
            rezervacije.add(r);

        }
    }

    private int sb(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
