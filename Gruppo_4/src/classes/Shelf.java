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
			if (this.matrix[i][0]==0) {
				possibleColumn.add(i);
			}
		}
		return possibleColumn;
	}
	
	
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
			int colonnaScelta=sc.nextInt();
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
			}
		}
	}
	
	
	public ArrayList<Integer> chooseOrder(ArrayList<Integer> mano) {
		System.out.println("scrivere la posizione del primo elemento "
				+ "da prendere (da 0 a "+(mano.size()-1)+")");
		System.out.println("elementi (posizione, colore): ");
		for(int i=0; i<mano.size(); i++) {
			System.out.print("(posizione "+i+", colore "+mano.get(i)+"); ");
		}
		ArrayList<Integer> ordinati= new ArrayList<Integer>();

		Scanner scan= new Scanner(System.in);
		
		do {
			
			int posizione=scan.nextInt();
			scan.reset();
			if(posizione>=0 && posizione<mano.size()) {
				System.out.println("removing");
				ordinati.add(mano.get(posizione));
				mano.remove(posizione);
			} else {
				System.out.println("selezionare un numero tra 0 e "+(mano.size()-1));
			}
				
		} while (mano.size()>0);
		
		return ordinati;
	}
	public void printShelf() {
		for(int i=0; i<6; i++) {
			System.out.print(i+1+": ");
			for(int j=0; j<5; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("   1 2 3 4 5");
	}
	
}
