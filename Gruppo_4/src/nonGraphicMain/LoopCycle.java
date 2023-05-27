package nonGraphicMain;

import java.util.ArrayList;
import classes.*;

public class LoopCycle {
	public Table tavolo;
	public ArrayList<Giocatore> giocatori;
	private int turno;
	public int numObComune;
	public boolean flagObComuniAttivi;
	public OrdineObComune ordineObComune;
	
	
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
		
		System.out.println("tavolo: \n");
		tavolo.printGrid();
		
		if((turno+1)%giocatori.size()==0) {
			giocatoreAttuale=giocatori.get(giocatori.size()-1);
		} else {
			giocatoreAttuale=giocatori.get(((turno+1)%giocatori.size())-1);
		}
		System.out.println("\n"+giocatoreAttuale.nome+", seleziona la colonna della tua libreria dove mettere gli elementi tra le seguenti ");
		
		
		int colonnaLibreria=this.giocatoreAttuale.shelf.selezioneColonna();
		int maxColonne=this.giocatoreAttuale.shelf.getMax(colonnaLibreria);
		System.out.println("potrai pescare al massimo "+maxColonne+" elementi");//////////////////////////////////////
	
		//int[] cordianteIniziali=this.tavolo.getStarterCoordinates();
		//int[] coordinateFinali=this.tavolo.getEndingCoordinates(cordianteIniziali, maxColonne);
		//ArrayList<Integer> mano=this.tavolo.extractTiles(this.tavolo.grid, cordianteIniziali[0], cordianteIniziali[1], coordinateFinali[0], coordinateFinali[1], maxColonne, true);
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
		
		/**
		 *per ora sei arrivato a pescare le coordinate iniziali, e finali, 
		 *devi ancora togliere i tasselli correttamente; 
		 *selezionare l'ordine da metterenella griglia
		 *metterli effettivamente
		 * attivare i controlli (obiettivi comuni)
		 * controllare shelf piena
		 */
		
		/**
		 * scegliere obiettivo comune
		 * ******************************************************************
		 * controllare obiettivi personali
		 * sistema di conversione in punti
		 * stampa obiettivo
		 * universitario che ha finito il lavoro :-)
		 */
		
		this.turno++;
		return true;
	}
}
