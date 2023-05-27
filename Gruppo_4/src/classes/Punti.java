package classes;

import java.util.ArrayList;
import java.util.Arrays;

public class Punti {
	
	
	/**
	 * direttamente come costruttore
	 * @param 
	 * @return
	 */
	public int punteggio;
	public Punti(){
		this.punteggio=0;
	}
	
	//ritorna true se libreria è stata completata, va chiamato per ogni giocatore alla fine di ogni turno e se è true termina la partita
	public boolean libreriaCompleta(int[][] libreria) {
		boolean completa = true;
		for (int riga = 0; riga < 6; riga++) {
			for (int colonna = 0; colonna < 7; colonna++) {
				if (libreria[riga][colonna] == 0) {//scorre la libreria dei giocatori per cercare il primo che la completa
					completa = false; 			
					break;
				}
			}
		}
		return completa;
	}

	
	
	// analizza il singolo giocatore e ritorna il punteggio ottenuto per l'obiettivo personale, nel main ciclo per scorrere i giocatori
	//(va controllato solo una volta a fine partita)
	public int puntiObiettivoPersonale(int numeroObiettivoPersonale) {
		
		int punti = 0;
		
		switch (numeroObiettivoPersonale) {
		case 0:
			punti = 0;
			break;
		case 1:
			punti = 1;
			break;
		case 2:
			punti = 2;
			break;
		case 3:
			punti = 4;
			break;
		case 4:
			punti = 6;
			break;
		case 5:
			punti = 9;
			break;
		case 6:
			punti = 12;
			break;
		default:
			break;
		}
		return punti; 
	}
	
	
	
	//da chiamare nel metodo successivo(ordineDeiGiocatoriPerObiettivoComune), controlla chi ha completato l'obiettivo comune e in caso ritorna true
	public boolean obiettivoComuneSvolto(int numeroObiettivoComune,  int[][] libreria) {
		boolean flag = false;
		
		ObiettivoComune ob = new ObiettivoComune();
			switch (numeroObiettivoComune) {
			case 1:
				if (ob.ObiettivoComune1(libreria)) {
					flag = true;
				}
			case 2:
				if (ob.ObiettivoComune2(libreria)) {
					flag = true;
				}
			case 3:
				if (ob.obiettivo3(libreria)) {
					flag = true;
				}
			case 4:
				if (ob.obiettivo4(libreria)) {
					flag = true;
				}
			case 5:
				if (ob.ObiettivoComune5(libreria)) {
					flag = true;
				}
			case 6:
				if (ob.ObiettivoComune6(libreria)) {
					flag = true;
				}
			case 7:
				if (ob.ObiettivoComune7(libreria)) {
					flag = true;
				}
			case 8:
				if (ob.ObiettivoComune8(libreria)) {
					flag = true;
				}
			case 9:
				if (ob.ObiettivoComune9(libreria)) {
					flag = true;
				}
			case 10:
				if (ob.ObiettivoComune10(libreria)) {
					flag = true;
				}
			case 11:
				if (ob.ObiettivoComune11(libreria)) {
					flag = true;
				}
			case 12:
				if (ob.ObiettivoComune12(libreria)) {
					flag = true;
				}
			}
		return flag;
	}
	
	
	/**
	 * condensata in funzione separata
	 */
	
	

	
	
	
	
	/**
	 * integrata direttamente in una funzione separata
	 * @param giocatoriInOrdine
	 * @param punti
	 * @param numeroGiocatori
	 * @return
	 */
	public int[] puntiObiettivoComune(ArrayList<Integer> giocatoriInOrdine, int punti[], int numeroGiocatori) {

        int cont = 0;
        for (int elemento: giocatoriInOrdine) {	//conto gli zeri(numero di player che non hanno completato l'obiettivo comune)
            if (elemento == 0) {
                cont++;
            }
        }
        
        switch(cont) {
        case 0:	//significa che tutti hanno completato l'obiettivo
        	punti[giocatoriInOrdine.get(0)] = punti[giocatoriInOrdine.get(0)] + 8; // assegna 8 punti a chi l'ha completato per primo

        	if (numeroGiocatori == 2) {
        		punti[giocatoriInOrdine.get(1)] = punti[giocatoriInOrdine.get(1)] + 4; // assegna i punti a chi l'ha completato per secondo (diversi a seconda che i giocatori totali 2 o piu)
        	} else {
        		punti[giocatoriInOrdine.get(1)] = punti[giocatoriInOrdine.get(1)] + 6;
        	}

        	punti[giocatoriInOrdine.get(2)] = punti[giocatoriInOrdine.get(2)] + 4;// assegna 4 punti per chi l'ha completato per terzo

        	punti[giocatoriInOrdine.get(3)] = punti[giocatoriInOrdine.get(3)] + 2;// assegna 2 punti per chi l'ha completato per quarto

        	 	
        case 1: //significa che uno non ha completato l'obiettivo (ultima posizione dell'arraylist)
        	punti[giocatoriInOrdine.get(0)] = punti[giocatoriInOrdine.get(0)] + 8;

        	if (numeroGiocatori == 2) {
        		punti[giocatoriInOrdine.get(1)] = punti[giocatoriInOrdine.get(1)] + 4;
        	} else {
        		punti[giocatoriInOrdine.get(1)] = punti[giocatoriInOrdine.get(1)] + 6;
        	}
        	punti[giocatoriInOrdine.get(2)] = punti[giocatoriInOrdine.get(2)] + 4;
          	punti[giocatoriInOrdine.get(3)] = punti[giocatoriInOrdine.get(3)] + 0;
        	
          	
        case 2: //due non hanno completato l'obiettivo
        	punti[giocatoriInOrdine.get(0)] = punti[giocatoriInOrdine.get(0)] + 8;

        	if (numeroGiocatori == 2) {
        		punti[giocatoriInOrdine.get(1)] = punti[giocatoriInOrdine.get(1)] + 4;
        	} else {
        		punti[giocatoriInOrdine.get(1)] = punti[giocatoriInOrdine.get(1)] + 6;
        	} 
        	punti[giocatoriInOrdine.get(2)] = punti[giocatoriInOrdine.get(2)] + 0;
        	punti[giocatoriInOrdine.get(3)] = punti[giocatoriInOrdine.get(3)] + 0;
        
        	
        case 3: //tre non hanno completato l'obiettivo
        	punti[giocatoriInOrdine.get(0)] = punti[giocatoriInOrdine.get(0)] + 8;
        	punti[giocatoriInOrdine.get(1)] = punti[giocatoriInOrdine.get(1)] + 0;
        	punti[giocatoriInOrdine.get(2)] = punti[giocatoriInOrdine.get(2)] + 0;
        	punti[giocatoriInOrdine.get(3)] = punti[giocatoriInOrdine.get(3)] + 0;
        	
        	
        case 4: //nessuno ha completato l'obiettivo comune
        	punti[giocatoriInOrdine.get(0)] = punti[giocatoriInOrdine.get(0)] + 0;
        	punti[giocatoriInOrdine.get(1)] = punti[giocatoriInOrdine.get(1)] + 0;
        	punti[giocatoriInOrdine.get(2)] = punti[giocatoriInOrdine.get(2)] + 0;
        	punti[giocatoriInOrdine.get(3)] = punti[giocatoriInOrdine.get(3)] + 0;
        }
		
	return punti;
	}
	/**
	 * provo a sostituirla con quella sotto, in funzione del 
	 * giocatore
	 * @param punti
	 * @param numeroGiocatori
	 */
	//scorre i giocatori e azzera i punti a tutti
	//public void azzeraPunti(int[] punti, int numeroGiocatori) {	
		//for (int i = 0; i < numeroGiocatori; i++) {
			//punti[i] = 0;
		//}
	//}
	//public ArrayList<Integer> giocatoriInOrdine = new ArrayList<Integer>();
		//private ArrayList<Giocatore> lista = new ArrayList<Giocatore>();
		
		// controllo alla fine di ogni turno
		//l'arraylist  giocatoriInOrdine alla fine contiene valori da 1 a 4 in base all'ordine dei giocatori che hanno completato l'obiettivo comune
		/**
		 * sposto in fondo
		 * @param g
		 * @param numeroGiocatore
		 * @param numeroObiettivoComune
		 * @param numeroGiocatori
		 * @param libreria
		 * @return
		 */
		/*
		private ArrayList<Integer> ordineDeiGiocatoriPerObiettivoComune(Giocatore g[], int numeroGiocatore, int numeroObiettivoComune, int numeroGiocatori, Integer libreria[][]) {
			boolean[] flag = new boolean[g.length];
			for (int z = 0; z < giocatoriInOrdine.size(); z++) {
	         	   giocatoriInOrdine.add(0); //inizializzo l'arraylist giocatoriInOrdine a 0, cosi avro 0 quando il giocatore non ha completato l'obiettivo
	       		}
			Arrays.fill(flag, true); //tutti gli elementi dell'array flag sono true (true significa che vanno controllati, false no perche hanno gia completato l'obiettivo comune nei turni precedenti) 
				
			for (int k = 0; k < g.length; k++) { //copio il contenuto del'array giocatore  nell'arraylist "lista"
		            lista.add(g[k]);	
				}	
			
				for(int j=0;j<g.length;j++) {		//ciclo che scorre tutti i giocatori
					if(flag[j]==true) {			
							if(g[j].obiettivoComuneSvolto(g, numeroGiocatore, numeroObiettivoComune, numeroGiocatori, libreria){
						giocatoriInOrdine.add(j+1); 	//metto nell'arraylist il numero del giocatore
						lista.remove(j);		
						flag[j]=false;
					}
					}
				}	
				return giocatoriInOrdine; 

			
		}
		*/
}