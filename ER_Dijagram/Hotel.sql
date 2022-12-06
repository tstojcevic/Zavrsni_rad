# xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < D:\Zavrsni_rad\ER_Dijagram\Hotel.sql

drop database if exists hotel;
create database hotel;
use hotel;

create table gost (
    sifra int not null primary key auto_increment,
    ime varchar (20) not null,
    prezime varchar (30) not null,
    oib char(11) not null,
    email varchar (30) not null,
    kontakt_telefon varchar(20)
);

create table djelatnik (
    sifra int not null primary key auto_increment,
    ime varchar(20) not null,
    prezime varchar(30) not null,
    br_ugovora varchar(20) not null,
    oib char(11) not null,
    radno_mjesto int
);

create table smjestaj (
    sifra int not null primary key auto_increment,
    vrsta varchar(20) not null,
    broj_kreveta int not null,
    cijena decimal (18,2) not null,
    raspolozivost boolean not null
);

create table rezervacija (
    sifra int not null primary key auto_increment,
    datum_prijave datetime not null,
    datum_odjave datetime not null,
    broj_gostiju int not null,
    broj_rezervacije varchar(20),
    broj_smjestajnih_jedinica varchar(20),
    gost int 
);

create table radno_mjesto (
    sifra int not null primary key auto_increment,
    naziv varchar(30) not null,
    placa decimal (18,2) not null,
    smjenski_rad boolean
);

create table djelatnik_rezervacija (
    sifra int not null primary key auto_increment,
    rezervacija int,
    djelatnik int
);

create table rezervacija_smjestaj (
    sifra int not null primary key auto_increment,
    rezervacija int,
    smjestaj int
);


alter table djelatnik add foreign key (radno_mjesto) references radno_mjesto(sifra);
alter table djelatnik_rezervacija add foreign key(djelatnik) references djelatnik(sifra);
alter table djelatnik_rezervacija add foreign key(rezervacija) references rezervacija(sifra);
alter table rezervacija add foreign key(gost) references gost(sifra);
alter table rezervacija_smjestaj add foreign key(smjestaj) references smjestaj(sifra);
alter table rezervacija_smjestaj add foreign key(rezervacija) references rezervacija(sifra);
