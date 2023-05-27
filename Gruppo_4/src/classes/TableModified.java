package classes;


import java.util.ArrayList;
import java.util.Scanner;



public class TableModified {





		private static int row = 10; //aggiungo una linea e una colonna finte in modo da gestire i colori correttamente
		private static int column= 10;

		public int [][] grid;						//la libreria dei valori prendibili
		private boolean [][] PosizioniPossibili= new boolean [row][column]; //serve per caprire se quaesti spot sono prendibili
		private  ArrayList<Integer> colori; //aggiungo un arraylist di colori

		private int size;
		private int startX;
		private int startY;
		private int endX;
		private int endY;

		private boolean takeTurn;






		private final int[][] grigliaGiocatori ={
				{5,5,5,3,4,5,5,5,5},
				{5,5,5,2,2,4,5,5,5},
				{5,5,3,2,2,2,3,5,5},
				{5,4,2,2,2,2,2,2,3},
				{4,2,2,2,2,2,2,2,4},
				{3,2,2,2,2,2,2,4,5},
				{5,5,3,2,2,2,3,5,5},
				{5,5,5,4,2,2,5,5,5},
				{5,5,5,5,4,3,5,5,5},
		};




		/**
		 * costruttore da usare a inizio partita, passa alla griglia di giocatori e controlla la posizione specifica; 
		 * se il valore in tale coordinata è minore o uguale al numero giocatori, allora quella sarà una posizione possibile 
		 * per la matrice
		 * 
		 * @param Nplayer
		 */
		public TableModified(int Nplayer) // costruttore: crea per la prima volta un tavolo, controllando il numero giocatori
		{
			this.colori=ColoriTotali();
			this.grid=new int[9][9];

			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					if(Nplayer>=this.grigliaGiocatori[i][j])
						this.PosizioniPossibili[i][j]=true;
				}
			}
			this.grid= getGeneralTavolo();
		}




		//grigliaGenerale

		public int[][] getGeneralTavolo(){
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {


					if ((this.PosizioniPossibili[i][j])) { //controllo di essere in una posizione legale per il numero di giocatori 
						int rand=(int) (Math.random() * this.colori.size()); //prendo una posizione random per ciascun colore inserito
						this.grid [i][j] = colori.get(rand);		//posiziono nell'array il colore estratto randomicamente	
						this.colori.remove(rand);		//rimuovo l'elemento pescato dall'arraylist delle posizioni pescabili
					}
					else {
						this.grid[i][j]=0;
					}
				}
			}

			return grid;
		}


		//funzione da chiamare alla fine di ogni giocata: nel caso in cui la griglia generale fosse completamente vuota permette di fare il refresh

		public void caselleSeparate() { 
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					if (this.grid[i][j]!=0) {
						if (!(this.grid[i+1][j]==0 && this.grid[i-1][j]==0 && this.grid[i][j+1]==0 && this.grid[i][j-1]==0)) { //controlla se le caselle adiacenti un punto sono vuote sono tutte vuote, se si 
							return;
						} 
					}
				}
			}
			getGeneralTavolo();
		}

		/**
		 * stampa della griglia fenerale: fa scorrere la griglia per stampare le coordinate corrette
		 */
		public void printGrid() {
			for (int i = 0; i < 9; i++) {
				System.out.print("\n" + (i+1) + ": ");
				for (int j = 0; j < 9; j++) {
					System.out.print(this.grid[i][j] + " ");
				}
			}
			System.out.println("\n\n   1"+" 2"+" 3"+" 4"+" 5"+" 6"+" 7"+" 8"+" 9\n");
		}




		/**
		 * costruttore chiamato all'inizio: permette di creare una bag nuova di colori dalla quale pescare
		 * i colori sono 6 (ciclo for esterno) e aggiunge 22 tasselli dello stesso tipo per ciascuno di questi(for interno)
		 * @return
		 */
		private ArrayList<Integer> ColoriTotali(){
			ArrayList<Integer> colori=new ArrayList<Integer>();

			for(int i=1; i<=6; i++) {	//ripeto il processo per 6 colori
				for(int j=0; j<22; j++) { //aggiungo 22 tasselli x ciascun tipo
					colori.add(i);
				}
			}

			return colori;
		}

		/**
		 * per la nuova griglia è possibile resettare i valori però bisogna svuotare il campo
		 */
		void checkAndResetTable() {

			for(int i=0; i<row; i++) {
				for(int j=0; j<row; j++) {
					if(!(i!=0 || grid[i-1][j]==0)) {
						return;
					}
					if(!(j!=0 || grid[i][j-1]==0)) {
						return;
					}
					if(!(i!=grid.length || grid[i+1][j]==0)) {
						return;
					}
					if(!(i!=grid[0].length || grid[i][j+1]==0)) {
						return;
					}

				}

			}

			for(int i=0; i<row; i++) {
				for(int j=0; j<row; j++) {
					if(this.grid[i][j]!=0)
						this.colori.add(this.grid[i][j]);
				}
			}

			getGeneralTavolo();
		}



		private boolean isValidInput() {
			return startX >= 0 && startX < grid.length &&
					startY >= 0 && startY < grid[0].length &&
					endX >= 0 && endX < grid.length &&
					endY >= 0 && endY < grid[0].length &&
					size >= 0 && grid[endX][endY]!=0;
					//&& direction >= 0 && direction <= 3;
		}

		


		private boolean adjacentFree(int x, int y) {
			if(grid[x][y]==0) {
				return false;
			}
			
			if(x>=8 || grid[x+1][y]==0) {

				return true;
			}
			if(y>=8 || grid[x][y+1]==0) {

				return true;
			}
			if(x==0 || grid[x-1][y]==0) {

				return true;
			}
			if(y==0 || grid[x][y-1]==0) {

				return true;
			}

			return false;
		}
		
		

		

		public ArrayList<Integer> getColors(int maxItems) {
			int x1;
			int y1;
			ArrayList<Integer> extractedTiles = new ArrayList<Integer>();
			Scanner sc = new Scanner(System.in);
			do {
				sc.reset();
				System.out.print("inserire coordinate da pescare dalla board:\n X ");
				// x

				x1 = sc.nextInt() - 1;
				sc.reset();

				// y
				System.out.print(" Y ");
				y1 = sc.nextInt() - 1;
				sc.reset();

			} while (!adjacentFree(x1, y1));

			extractedTiles.add(grid[x1][y1]);
			this.grid[x1][y1] = 0;

			int x2 = 0;
			int y2 = 0;

			if (maxItems >= 2) {
				System.out.println("desideri continuare? (true = si, false = no)");
				sc.reset();
				boolean continua = sc.nextBoolean();
				if (continua) {
					sc.reset();
					System.out.print("inserire coordinate da pescare dalla board:\n X ");
					// x

					x2 = sc.nextInt() - 1;
					sc.reset();

					// y
					System.out.print(" Y ");
					y2 = sc.nextInt() - 1;
					sc.reset();
				}
				while ((!adjacentFree(x2, y2) || java.lang.Math.abs((x1 - x2) + (y1 - y2)) != 1))
					;

				extractedTiles.add(grid[x2][y2]);
				this.grid[x2][y2] = 0;

				if (maxItems >= 3) {
					System.out.println("desideri continuare? (true = si, false = no)");
					sc.reset();
					if (x2 > x1 && adjacentFree(x2 + 1, y2)) {
						// right
						extractedTiles.add(grid[x2 + 1][y2]);
						this.grid[x2 + 1][y2] = 0;
					} else if (x1 > x2 && adjacentFree(x2 - 1, y2)) {
						// left
						extractedTiles.add(grid[x2 - 1][y2]);
						this.grid[x2 - 1][y2] = 0;
					} else if (y2 > y1 && adjacentFree(x2, y2 + 1)) {
						// down
						extractedTiles.add(grid[x2][y2 + 1]);
						this.grid[x2][y2 + 1] = 0;
					} else if (y1 > y2 && adjacentFree(x2, y2 - 1)) {
						// up
						extractedTiles.add(grid[x2][y2 - 1]);
						this.grid[x2][y2 - 1] = 0;
					}
				}
			}
			sc.close();
			return extractedTiles;
		}
		

		

}
