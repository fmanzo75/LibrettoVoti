package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {

	public static void main(String[] args) {
		System.out.println("Test metodi di Libretto");
		Libretto libretto = new Libretto();
		Voto voto1 = new Voto("Analisi 1", 30, LocalDate.of(2019, 2, 15));
		// punto 1
		libretto.add(voto1);
		libretto.add(new Voto("Chimica", 25,LocalDate.of(2019, 9, 15)));
		libretto.add(new Voto("Fisica 1", 28,LocalDate.of(2019, 7, 15)));
		libretto.add(new Voto("Informatica", 24,LocalDate.of(2019, 9, 15)));
		System.out.println(libretto);
		// punto 2
		List<Voto> listaVenticinque = libretto.listaVotiUguali(25);
		System.out.println(listaVenticinque);
		// punto 2 bis
		Libretto venticinque = libretto.votiUguali(25);
		System.out.println(venticinque);
		// punto 3
		Voto analisi = libretto.ricercaCorso("Analisi 1");
		System.out.println(analisi);
		Voto analisi3 = libretto.ricercaCorso("Analisi 3");
		System.out.println(analisi3);
		// tdp 2021 L08 min50
	}

}
