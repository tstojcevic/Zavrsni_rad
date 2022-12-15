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
    gost int, 
    djelatnik int
);

create table radno_mjesto (
    sifra int not null primary key auto_increment,
    naziv varchar(30) not null,
    placa decimal (18,2) not null,
    smjenski_rad boolean not null
);


create table rezervacija_smjestaj (
    sifra int not null primary key auto_increment,
    rezervacija int,
    smjestaj int
);


alter table djelatnik add foreign key (radno_mjesto) references radno_mjesto(sifra);
alter table rezervacija add foreign key(gost) references gost(sifra);
alter table rezervacija add foreign key(djelatnik) references djelatnik(sifra);
alter table rezervacija_smjestaj add foreign key(smjestaj) references smjestaj(sifra);
alter table rezervacija_smjestaj add foreign key(rezervacija) references rezervacija(sifra);

insert into gost (ime,prezime,oib,email)
values ('Marko','Marković',01234567891,'mmarkovic@email.com'), ('Petar','Petrović',12345678910,'ppetrovic@email.com'), ('Ivan','Ivić',23456789123,'iivic@email.com');

insert into radno_mjesto (naziv,placa,smjenski_rad)
values ('Recepcija', 6900.00, 1), ('Kuhinja', 8000.00, 1), ('Bar', 6000.00, 0);

insert into djelatnik (ime,prezime,br_ugovora,oib,radno_mjesto)
values ('Marija', 'Mitrović', 'Br.1256', 45678932145,1), ('Sofija', 'Pašalić', 'Br.3478', 67912374591,2), ('Darko', 'Stazić', 'Br.3978', 65278913918,3);

insert into smjestaj (vrsta,broj_kreveta,cijena,raspolozivost)
values ('Polupansion', 2, 1000.00, 1),('Puni pansion', 2, 1250.00, 0), ('All inclusive', 3, 2000.00, 1);

insert into rezervacija (datum_prijave,datum_odjave,broj_gostiju,gost,djelatnik)
values ('2022-05-25','2022-05-30',2,2,1), ('2022-06-12','2022-06-20',3,1,1), ('2022-07-28','2022-08-05',4,3,1);

insert into rezervacija_smjestaj (rezervacija,smjestaj)
values (1,1), (2,2), (3,3);