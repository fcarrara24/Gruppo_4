package Gruppo_4;

import java.util.ArrayList;

public class contaAdiacenti {
	private int[] [] libreria;
	private int[] [] vicinanza;

	public int punteggio(int [][] lib) {
		this.libreria=lib;
		int punti=0;
		for (int color=1; color<=6; color++) { 						//scorro i colori
			int [] [] adiacenti=null;								//resetto la griglia temporale
			this.vicinanza= adiacenti;								//resetto il valore totale delle caselle vicine
			for (int i=0; i<6; i++) {								//scorro le righe
				for (int j=0; j<5; j++) { 							//scorro le colonne
					if(this.libreria[i][j]==color) {				//controllo che il colore sia corretto per ciascuno scanner
						this.vicinanza[i][j]=adiacenza( i,  j);		//valuto l'adiacenza per ciascuno dei punti;
					}
				}
			} //alla fine di questo ciclo ho la tabella delle colonne vicine

			for (int i=0; i<6; i++) {								//scorro le righe
				for (int j=0; j<5; j++) { 							//scorro le colonne
					if(this.libreria[i][j]==color) {				//controllo che il colore sia corretto per ciascuno scanner
						punti+=esecuzione(color, i, j);
					}
				}
			}

		}

		return punti;
	}

	private int adiacenza(int i, int j){
		int ad=0;
		if(this.libreria[i][j]==this.libreria[i+1][j]) {
			ad++;
		}
		if(this.libreria[i][j]==this.libreria[i-1][j]) {
			ad++;
		}
		if(this.libreria[i][j]==this.libreria[i][j+1]) {
			ad++;
		}
		if(this.libreria[i][j]==this.libreria[i][j-1]) {
			ad++;
		}
		return ad;
	}

	private int esecuzione(int c, int posInX, int posInY) {
		ArrayList<Integer> listaX=new ArrayList<Integer>(); //dichiaro un'arraylist contenente le coordinae ordinate x
		ArrayList<Integer> listaY=new ArrayList<Integer>(); //dichiaro un'arraylist contenente le coordinae ordinate y
		int x=posInX;										//creo una coordinata x iniziale per muovermi
		int y=posInY;										//creo una coordinata y iniziale per muovermi

		int gruppoAdiacenti=0;   							//per contare le caselle adiacenti 

		do {
			if(this.vicinanza[x][y]>=1) {


				this.vicinanza[x][y]=this.vicinanza[x][y]--; //decremento le caselle vicine adiacenti

				if(this.vicinanza[x][y]==1) {
					this.libreria[x][y]=0;	//reset del colore
					gruppoAdiacenti++;		//solo quando resetto il tassello lo aggiungo al sistema di punti

				} 
				listaX.add(posInX);			//aggiungo la posizione attuale x all'inizio della lista di coordinate
				listaX.add(posInY);			//aggiungo la posizione attuale y all'inizio della lista di coordinate


				if(this.vicinanza[x][y+1]>0) {

					y=y+1;					//se possibile mi sposto sotto
				} else if (this.vicinanza[x+1][y]>0) {

					x=x+1;					//se possibile mi sposto a destra
				} else if (this.vicinanza[x][y-1]>0) {

					y=y-1;					//se possibile mi sposto sotto
				} else if (this.vicinanza[x-1][y]>0) {

					x=x+1;					//se possibile mi sposto a sinistra
				}
			}


			else { 		

				this.libreria[x][y]=0;			//se la vicinanza è pari a 0,  allora resetto il colore 
				listaX.remove(listaX.size()); 	//nel caso in cui ci fosse un valore all'origine, lo tolgo dalla lista
				listaY.remove(listaY.size());

			}
		} while (listaX.size()==0);				//continuo a scorrere fino a che non torna al valore di partenza

		return puntiCorrispondenti(gruppoAdiacenti);
	}


	private int puntiCorrispondenti(int numeroAdiacenti) {
		int punti=0; 							//converte le caselle adiacenti direttamente in punti

		if (numeroAdiacenti==3) {
			punti=2;
		}else if (numeroAdiacenti==4) {
			punti=3;
		}else if (numeroAdiacenti==5) {
			punti=5;
		}else if (numeroAdiacenti>5) {
			punti=8;
		}
		return punti;
	}
}
