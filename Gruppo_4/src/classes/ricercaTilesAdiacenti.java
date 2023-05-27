package classes;

import java.util.ArrayList;
import java.util.List;

public class ricercaTilesAdiacenti {
	/**
	 * 
	 * @param dimensioneGruppo: prende l'array di partenza e ritorna la 
	 * e conta per ciascun sottogruppo il punteggio corrispondente, per poi 
	 * sommarlo al punteggio finale
	 * @return ritorna la somma di tutti i punteggi.
	 */
		public static int punti(List<Integer> dimensioneGruppo) {
			int punteggio=0;
			for(int x=0; x<dimensioneGruppo.size(); x++) {
				if(dimensioneGruppo.get(x)==3) {
					punteggio+=2;
				}
				if(dimensioneGruppo.get(x)==4) {
					punteggio+=3;
				}
				if(dimensioneGruppo.get(x)==5) {
					punteggio+=5;
				}
				if(dimensioneGruppo.get(x)>=6) {
					punteggio+=8;
				}
				
			}
			return punteggio;
		}
		
		/**
		 * data la @param libreria di partenza, estrapola da quest'ultima il numero righe e colonne
		 * viene creata una matrice temporanea di booleani per tener traccia dei valori passati
		 * e una lista di gruppi adiacenti, da ritornare poi al termine dell'esecuzione della funzione
		 * successivamente faccio scorrere la lista e cerco gli elementi non vuoti (diversi da 0)
		 * e non ancora visti (!visti[i][j]) appena li trovo, applico l'algoritmo di ricerca "controllaAdiacenti"
		 * e aggiungo l'intero ritornato alla lista listaGruppiAdiacenti.
		 * infine ritorn la lista
		 *  
		 * @param libreria
		 * @return listaGruppiAdiacenti
		 */
	    public static List<Integer> listaElementiAdiacenti(int[][] libreria) {
	        int rows = libreria.length;
	        int cols = libreria[0].length;
	        boolean[][] visti = new boolean[rows][cols];
	        List<Integer> listaGruppiAdiacenti = new ArrayList<>();

	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                if (!visti[i][j] && libreria[i][j]!=0) {
	                    int dimensioneGruppoCorrente = controllaAdiacenti(libreria, visti, i, j, libreria[i][j]);
	                    listaGruppiAdiacenti.add(dimensioneGruppoCorrente);
	                }
	            }
	        }

	        return listaGruppiAdiacenti;
	    }
	    
	    
	    /**
	     * la funzione controlla adiacenti funziona ricorsivamente:
	     * il "cursore", indicato da @param riga e @param clnn tenta di andare in
	     * una casella adiacente, settando la casella di partenza come già vista.
	     * se la casella fosse già stata vista in uno step precedente,
	     * o fosse di un altro colore ritorna 0 ma nel caso in cui fosse dello stesso colore
	     * aggiunge 1 al contatore delle caselle adiacenti e continua con gli scan successivi.
	     * al termine dei layer di scan ritorna al livello più alto il numero di caselle adiacenti, 
	     * fino a ritornare al livello di partenza
	     * 
	     * @param libreria
	     * @param visti	->griglia di valutazione per capire se già visti
	     * @param riga	->numero riga attuale
	     * @param clnn	->numero colonna attuale
	     * @param precedente	->necessario per salvare il colore precedente
	     * @return	->int: contenente la dimensione del gruppo considerato
	     */
	    private static int controllaAdiacenti(int[][] libreria, boolean[][] visti, int riga, int clnn, int precedente) {
	        int rows = libreria.length;
	        int cols = libreria[0].length;

	        
	        if(visti[riga][clnn] || libreria[riga][clnn] != precedente)//valuto che il colore sia lo stesso
	        	return 0;

	        visti[riga][clnn] = true;

	        int size = 1;

	        if (riga - 1 >= 0) //necessario per evitare di uscire dalla matrice
	            size += controllaAdiacenti(libreria, visti, riga - 1, clnn, precedente); // sopra

	        if (riga + 1 < rows) //necessario per evitare di uscire dalla matrice
	            size += controllaAdiacenti(libreria, visti, riga + 1, clnn, precedente); // sotto

	        if (clnn - 1 >= 0) //necessario per evitare di uscire dalla matrice
	            size += controllaAdiacenti(libreria, visti, riga, clnn - 1, precedente); // sinistra

	        if (clnn + 1 < cols) //necessario per evitare di uscire dalla matrice
	            size += controllaAdiacenti(libreria, visti, riga, clnn + 1, precedente); // destra

	        return size;
	    }
		
}
