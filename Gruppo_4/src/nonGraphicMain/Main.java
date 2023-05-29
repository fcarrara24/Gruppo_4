package nonGraphicMain;


import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;


import classes.*;


public class Main {

	/**
	 * chiedo all'utente di inserire un numero di giocatori e per
	 * ciascuno di questi assegno un nome
	 * @param args
	 */
	public static void main(String[] args) {
		int numeroGiocatori=0;
		
		Regolamento regole= new Regolamento();
		regole.scegliRegola();
		
		ArrayList<Integer> obiettivoPersonaleLista= new ArrayList<Integer>();
		ObiettivoComune obiettivoComune=new ObiettivoComune();
		System.out.println("obiettivo comune numero "+obiettivoComune.numeroObiettivo);
		for (int i=1; i<=12; i++) {
			obiettivoPersonaleLista.add(i);
		}
		Scanner sc= new Scanner(System.in);
		do {
			System.out.println("seleziona numero giocatori (da 2 a 4) ");	
			numeroGiocatori=sc.nextInt();
		}
		 while ((numeroGiocatori!=2 && numeroGiocatori!=3 && numeroGiocatori!=4));
		sc.reset();
		/**
		 * creazione giocatori
		 */
		ArrayList <Giocatore> arrayGiocatori= new ArrayList <Giocatore>();
		
		for (int num=1; num<=numeroGiocatori; num++) {
			Random rand= new Random();
			int numeroObiettivo=rand.nextInt(obiettivoPersonaleLista.size());
			Giocatore giocatore=new Giocatore(num, numeroObiettivo);
			obiettivoPersonaleLista.remove(numeroObiettivo);
			arrayGiocatori.add(giocatore);
			System.out.println(" il giocatore "+giocatore.nome+" ha l'obiettivo personale numero "+giocatore.obiettivoPersonale.numero);
			System.out.println(" scrivere -true- per vedere il pattern degli obiettivi personali, -false- per saltarlo: ");
			sc.reset();
			boolean visualizza=sc.nextBoolean();
			if (visualizza) {
				regole.listaObPersonali();
			}
		}
		
		/**
		 * table iniziale
		 */
		Table table=new Table(numeroGiocatori);
		
			
		LoopCycle ciclo= new LoopCycle(arrayGiocatori, table, obiettivoComune.numeroObiettivo);
		
		/**
		 * ricerca delle tiles adiacenti, cercando internamente la lista di elementi adiacenti data la matrice,
		 * per poi sommarli convertendoli in punti
		 */
		int punteggio_massimo=0;
		String vincitore = null;
		
		for(Giocatore player: arrayGiocatori) {
			
			player.puntiGiocatore.punteggio+=ricercaTilesAdiacenti.punti(ricercaTilesAdiacenti.listaElementiAdiacenti(player.shelf.matrix));
			player.puntiGiocatore.punteggio+=player.puntiGiocatore.puntiObiettivoPersonale(player.obiettivoPersonale.SelectorObiettivoPersonale(player.shelf.matrix));
			System.out.println("Giocatore"+player.ID+" ("+player.nome+")"
					+ "hai totalizzato "+player.puntiGiocatore.punteggio+" punti");
			if(player.puntiGiocatore.punteggio>=punteggio_massimo) {
				punteggio_massimo=player.puntiGiocatore.punteggio;
				vincitore=player.nome;
			}
		}
		System.out.println("\n\n il vincitore è "+vincitore);
		
	}

}
