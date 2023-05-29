package nonGraphicMain;

import java.util.ArrayList;
import java.util.Scanner;

import classes.*;

public class LoopCycle {
	public Table tavolo;
	public ArrayList<Giocatore> giocatori;
	private int turno;
	public int numObComune;
	public boolean flagObComuniAttivi;
	public OrdineObComune ordineObComune;
	public Regolamento regolamento= new Regolamento();
	
	private Giocatore giocatoreAttuale;
	
	public LoopCycle(ArrayList<Giocatore> giocatori, Table tavolo, int numeroObiettivoComune) {
		int turno=0;
		
		this.numObComune=numeroObiettivoComune;
		this.turno=turno;
		this.giocatori=giocatori;
		this.tavolo=tavolo;
		this.flagObComuniAttivi=true;
		
		
		this.ordineObComune= new OrdineObComune(giocatori.size());
		while(Funzione());
	}
	
	boolean Funzione() {
		Scanner sc=new Scanner(System.in);
		sc.reset();
		System.out.println("obiettivo comune numero"+numObComune);
		
		System.out.println("tavolo: \n");
		tavolo.printGrid();
		
		if((turno+1)%giocatori.size()==0) {
			giocatoreAttuale=giocatori.get(giocatori.size()-1);
		} else {
			giocatoreAttuale=giocatori.get(((turno+1)%giocatori.size())-1);
		}
		
		System.out.println(giocatoreAttuale.nome+", il tuo obiettivo personale è il numero "+giocatoreAttuale.obiettivoPersonale.numero
						   +" scrivere -true- per vedere il regolamento, -false- per saltarlo");
		boolean scelta=sc.nextBoolean();
		if(scelta) {
			regolamento.listaObPersonali();
		}
		System.out.println("\n"+giocatoreAttuale.nome+", seleziona la colonna della tua libreria dove mettere gli elementi tra le seguenti ");
		
		int colonnaLibreria=this.giocatoreAttuale.shelf.selezioneColonna();
		int maxColonne=this.giocatoreAttuale.shelf.getMax(colonnaLibreria);
		System.out.println("potrai pescare al massimo "+maxColonne+" elementi");
		ArrayList<Integer> mano=this.tavolo.getColors(maxColonne);
		ArrayList<Integer> elementiOrdinati=this.giocatoreAttuale.shelf.chooseOrder(mano);
		for(int i=0; i<elementiOrdinati.size(); i++) {
			this.giocatoreAttuale.shelf.insertTile(colonnaLibreria, elementiOrdinati.get(i));
		}
		
		if(flagObComuniAttivi && 
		   this.giocatoreAttuale.puntiGiocatore.obiettivoComuneSvolto(numObComune,  
											   this.giocatoreAttuale.shelf.matrix)) {
			this.giocatoreAttuale.puntiGiocatore.punteggio+=this.ordineObComune.punteggioCorrispondente(this.giocatoreAttuale.ID);
			this.flagObComuniAttivi=false;
		}
		
		/**
		 * condizione di fine gioco  con aggiunta di un punto
		 */
		if(this.giocatoreAttuale.puntiGiocatore.libreriaCompleta(giocatoreAttuale.shelf.matrix)) {
			this.giocatoreAttuale.puntiGiocatore.punteggio+=1;
			
			return false;		
		}
		
		
		this.turno++;
		return true;
	}
}
