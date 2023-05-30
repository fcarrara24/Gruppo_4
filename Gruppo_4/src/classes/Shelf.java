package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Shelf {
	public int[][] matrix=new int[6][5];
	
	
	/**
	 * costruttore: inizializzo la shelf a 0 e la assegno ad un giocatore

	 */
	public Shelf (){
		
		for(int i=0; i<6; i++)
			for(int j=0; j<5; j++) {
			this.matrix[i][j]=0;
		}
		
	}
	/**
	 * prendo le colonne possibili da stampare e le salvo x la combobox
	 * @return
	 */
	public ArrayList<Integer> getColumn(){
		ArrayList<Integer> possibleColumn= new ArrayList<Integer>();
		for (int i=0; i<5; i++) {
			if (this.matrix[0][i]==0) {
				possibleColumn.add(i);
			}
		}
		return possibleColumn;
	}
	
	/**
	 * permette di selezionare la colonna nella quale andranno gli elementi, la funzione viene chiamata subito, in modo tale da 
	 * non escldere nessun elemento dalla lista di partenza perchè non ci sta tra le colonne
	 * @return
	 */
	public int selezioneColonna() {
		System.out.println("libreria: \n");
		printShelf();
		System.out.print("selezionare una colonna tra quelle elencate ( ");
		for(Integer colonna: getColumn()) {
			System.out.print(colonna+" ");
		}
		System.out.print(")\n");
		Scanner sc=new Scanner(System.in);
		while(true) {
			sc.reset();
			int colonnaScelta;
			try {
				colonnaScelta=sc.nextInt();
			} catch (Exception e) {
				colonnaScelta=-1;
				sc.nextLine();
			}
			for(Integer colonna: getColumn()) {
				if(colonna==colonnaScelta) {
					return colonnaScelta;
				}
			}
			
			System.out.println("seleziona un elemento tra quelli indicati");
			
		}
		
		
	}
	
	/**
	 * ritorno il numero di elementi massimi pescabili per colonna
	 * @param column
	 * @return
	 */
	public int getMax(int column) {
		for (int j=0; j<3; j++) {
			if(this.matrix[j+1][column]!=0) {
				return j+1;
			}
		}
		return 3;
	}
	
	/**
	 * inserisco ciascun elemento pescato nella matrice
	 */
	public void insertTile(int column, int tile) {
		
		for (int i=0; i<5; i++) {
			if (this.matrix[i+1][column]!=0) {
				this.matrix[i][column]=tile;
				return;
			} 
		}
		this.matrix[5][column]=tile;
	}
	
	/**
	 * funzione che prende @param mano e ordina gli elementi secondo le esigenze degli utenti, per ordianre questi ultimi viene chiesta la loro posizione nell'araylist
	 * @param mano
	 * @return
	 */
	public ArrayList<Integer> chooseOrder(ArrayList<Integer> mano) {
		ArrayList<Integer> ordinati= new ArrayList<Integer>();

		Scanner scan= new Scanner(System.in);
		
		do {
			System.out.println("scrivere la posizione del primo elemento "
					+ "da prendere (da 0 a "+(mano.size()-1)+")");
			System.out.println("elementi (posizione, colore): ");
			
			for(int i=0; i<mano.size(); i++) {
				System.out.print("(posizione "+i+", colore "+mano.get(i)+"); ");
			}
			int posizione;
			try {
				scan.reset();
				posizione=scan.nextInt();
			} catch (Error e) {
				posizione=-1;
			}
			
			if(posizione>=0 && posizione<mano.size()) {
				ordinati.add(mano.get(posizione));
				mano.remove(posizione);
			} else {
				System.out.println("selezionare un numero tra 0 e "+(mano.size()-1));
			}
				
		} while (mano.size()>0);
		
		return ordinati;
	}
	
	/**
	 * funzione per stampare la griglia
	 */
	public void printShelf() {
		for(int i=0; i<6; i++) {
			System.out.print(i+1+": ");
			for(int j=0; j<5; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("   0 1 2 3 4");
	}
	
}
