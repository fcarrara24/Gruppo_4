package Gruppo_4;


	
	import java.io.Console;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.Scanner;



	public class Tavolo {
				
				private static int row = 10; //aggiungo una linea e una colonna finte in modo da gestire i colori correttamente
				private static int column= 10;
				
				private int [][] grid=new int [row][column];						//la libreria dei valori prendibili
				private boolean [][] PosizioniPossibili= new boolean [row][column]; //serve per caprire se quaesti spot sono prendibili
				private int firstX;
				private int firstY;
				
				private int finalX;
				private int finalY;
				
				private ArrayList<Integer> PossibleX;
				private ArrayList<Integer> PossibleY;
				private  ArrayList<Integer> colori; //aggiungo un arraylist di colori


	
		
				
		private void n4Giocatori() { //indica le posizioni dove è possibile inserire le caselle in una griglia da 4 elementi
			boolean[][] PP=new boolean[row][column];
			PP[0][0]=false; PP[0][1]=false; PP[0][2]=false; PP[0][3]=false;PP[0][4]=false; PP[0][5]=false; PP[0][6]=false; PP[0][7]=false; PP[0][8]=false; PP[0][9]=false;
			PP[1][0]=false;	PP[1][1]=false; PP[1][2]=false; PP[1][3]=false;PP[1][4]=true ; PP[1][5]=true ; PP[1][6]=false; PP[1][7]=false; PP[1][8]=false; PP[1][9]=false; 
			PP[2][0]=false; PP[2][1]=false; PP[2][2]=false; PP[2][3]=false;PP[2][4]=true ; PP[2][5]=true ; PP[2][6]=true ; PP[2][7]=false; PP[2][8]=false; PP[2][9]=false;
			PP[3][0]=false; PP[3][1]=false; PP[3][2]=false; PP[3][3]=true ;PP[3][4]=true ; PP[3][5]=true ; PP[3][6]=true ; PP[3][7]=true ; PP[3][8]=false; PP[3][9]=false;
			PP[4][0]=false; PP[4][1]=false; PP[4][2]=true ; PP[4][3]=true ;PP[4][4]=true ; PP[4][5]=true ; PP[4][6]=true ; PP[4][7]=true ; PP[4][8]=true ; PP[4][9]=true ;
			PP[5][0]=false; PP[5][1]=true;  PP[5][2]=true;  PP[5][3]=true; PP[5][4]=true;  PP[5][5]=true;  PP[5][6]=true;  PP[5][7]=true;  PP[5][8]=true;  PP[5][9]=true ;
			PP[6][0]=false; PP[6][1]=true ; PP[6][2]=true ; PP[6][3]=true ;PP[6][4]=true ; PP[6][5]=true ; PP[6][6]=true ; PP[6][7]=true ; PP[6][8]=true ; PP[6][9]=false;
			PP[7][0]=false; PP[7][1]=false; PP[7][2]=false; PP[7][3]=true ;PP[7][4]=true ; PP[7][5]=true ; PP[7][6]=true ; PP[7][7]=true ; PP[7][8]=false; PP[7][9]=false;
			PP[8][0]=false; PP[8][1]=false; PP[8][2]=false; PP[8][3]=false;PP[8][4]=true ; PP[8][5]=true ; PP[8][6]=true ; PP[8][7]=false; PP[8][8]=false; PP[8][9]=false;
			PP[9][0]=false; PP[9][1]=false; PP[9][2]=false; PP[9][3]=false;PP[9][4]=false; PP[9][5]=true ; PP[9][6]=true ; PP[9][7]=false; PP[9][8]=false; PP[9][9]=false;
			
			this.PosizioniPossibili=PP; //salva la posizione nella matrice posizioni possibili
			return;
		}
		
		private void n3Giocatori() { //indica le posizioni dove è possibile inserire le caselle in una griglia da 3 elementi
			boolean[][] PP=new boolean[row][column];
			PP[0][0]=false; PP[0][1]=false; PP[0][2]=false; PP[0][3]=false;PP[0][4]=false; PP[0][5]=false; PP[0][6]=false; PP[0][7]=false; PP[0][8]=false; PP[0][9]=false;
			PP[1][0]=false;	PP[1][1]=false; PP[1][2]=false; PP[1][3]=false;PP[1][4]=true ; PP[1][5]=false; PP[1][6]=false; PP[1][7]=false; PP[1][8]=false; PP[1][9]=false; 
			PP[2][0]=false; PP[2][1]=false; PP[2][2]=false; PP[2][3]=false;PP[2][4]=true ; PP[2][5]=true ; PP[2][6]=false; PP[2][7]=false; PP[2][8]=false; PP[2][9]=false;
			PP[3][0]=false; PP[3][1]=false; PP[3][2]=false; PP[3][3]=true ;PP[3][4]=true ; PP[3][5]=true ; PP[3][6]=true ; PP[3][7]=true ; PP[3][8]=false; PP[3][9]=false;
			PP[4][0]=false; PP[4][1]=false; PP[4][2]=false; PP[4][3]=true ;PP[4][4]=true ; PP[4][5]=true ; PP[4][6]=true ; PP[4][7]=true ; PP[4][8]=true ; PP[4][9]=true ;
			PP[5][0]=false; PP[5][1]=false; PP[5][2]=true;  PP[5][3]=true; PP[5][4]=true;  PP[5][5]=true;  PP[5][6]=true;  PP[5][7]=true;  PP[5][8]=true;  PP[5][9]=false;
			PP[6][0]=false; PP[6][1]=true ; PP[6][2]=true ; PP[6][3]=true ;PP[6][4]=true ; PP[6][5]=true ; PP[6][6]=true ; PP[6][7]=true ; PP[6][8]=false; PP[6][9]=false;
			PP[7][0]=false; PP[7][1]=false; PP[7][2]=false; PP[7][3]=true ;PP[7][4]=true ; PP[7][5]=true ; PP[7][6]=true ; PP[7][7]=true ; PP[7][8]=false; PP[7][9]=false;
			PP[8][0]=false; PP[8][1]=false; PP[8][2]=false; PP[8][3]=false;PP[8][4]=false; PP[8][5]=true ; PP[8][6]=true ; PP[8][7]=false; PP[8][8]=false; PP[8][9]=false;
			PP[9][0]=false; PP[9][1]=false; PP[9][2]=false; PP[9][3]=false;PP[9][4]=false; PP[9][5]=false; PP[9][6]=true ; PP[9][7]=false; PP[9][8]=false; PP[9][9]=false;
			
			this.PosizioniPossibili=PP; //salva la posizione nella matrice posizioni possibili
			return;
		}
		
		private void n2Giocatori() { //indica le posizioni dove è possibile inserire le caselle in una griglia da 3 elementi
			boolean[][] PP=new boolean[row][column];
			PP[0][0]=false; PP[0][1]=false; PP[0][2]=false; PP[0][3]=false;PP[0][4]=false; PP[0][5]=false; PP[0][6]=false; PP[0][7]=false; PP[0][8]=false; PP[0][9]=false;
			PP[1][0]=false;	PP[1][1]=false; PP[1][2]=false; PP[1][3]=false;PP[1][4]=false; PP[1][5]=false; PP[1][6]=false; PP[1][7]=false; PP[1][8]=false; PP[1][9]=false; 
			PP[2][0]=false; PP[2][1]=false; PP[2][2]=false; PP[2][3]=false;PP[2][4]=true ; PP[2][5]=true ; PP[2][6]=false; PP[2][7]=false; PP[2][8]=false; PP[2][9]=false;
			PP[3][0]=false; PP[3][1]=false; PP[3][2]=false; PP[3][3]=false;PP[3][4]=true ; PP[3][5]=true ; PP[3][6]=true ; PP[3][7]=false; PP[3][8]=false; PP[3][9]=false;
			PP[4][0]=false; PP[4][1]=false; PP[4][2]=false; PP[4][3]=true ;PP[4][4]=true ; PP[4][5]=true ; PP[4][6]=true ; PP[4][7]=true ; PP[4][8]=true ; PP[4][9]=false;
			PP[5][0]=false; PP[5][1]=false; PP[5][2]=true;  PP[5][3]=true; PP[5][4]=true;  PP[5][5]=true;  PP[5][6]=true;  PP[5][7]=true;  PP[5][8]=true;  PP[5][9]=false;
			PP[6][0]=false; PP[6][1]=false; PP[6][2]=true ; PP[6][3]=true ;PP[6][4]=true ; PP[6][5]=true ; PP[6][6]=true ; PP[6][7]=true ; PP[6][8]=false; PP[6][9]=false;
			PP[7][0]=false; PP[7][1]=false; PP[7][2]=false; PP[7][3]=false;PP[7][4]=true ; PP[7][5]=true ; PP[7][6]=true ; PP[7][7]=false; PP[7][8]=false; PP[7][9]=false;
			PP[8][0]=false; PP[8][1]=false; PP[8][2]=false; PP[8][3]=false;PP[8][4]=false; PP[8][5]=true ; PP[8][6]=true ; PP[8][7]=false; PP[8][8]=false; PP[8][9]=false;
			PP[9][0]=false; PP[9][1]=false; PP[9][2]=false; PP[9][3]=false;PP[9][4]=false; PP[9][5]=false; PP[9][6]=false; PP[9][7]=false; PP[9][8]=false; PP[9][9]=false;
			
			this.PosizioniPossibili=PP; //salva la posizione nella matrice posizioni possibili
			return;
		}
		
		private int scanner() { //dato che lo scanner veniva usato spesso, ho deciso di trasformarlo in una classe
			Scanner sc=new Scanner(System.in);
			int val=sc.nextInt();
			return val;
		}
		
		public Tavolo(int Nplayer) // costruttore: crea per la prima volta un tavolo, controllando il numero giocatori
		{
			this.colori=ColoriTotali();
			//quando creo la nuova griglia mi assicuro che sia bianca
			for(int i=1; i<=9; i++) {
				for(int j=1; j<=9; j++) {
					this.grid[i][j]=0; //resetto il colore a bianco
				}
			}
			
			//in base al numero di giocatori chiamo una delle 3 griglie boolean che adattano la griglia a tot giocatori
			if (Nplayer==2) {
				n2Giocatori();
			} else if (Nplayer==3) {
				n3Giocatori();
			} else if (Nplayer==4) {
				n4Giocatori();
			}
			
			getGeneralTavolo(); //ri
		}
			
			
			
			
			//grigliaGenerale
			
		public int[][] getGeneralTavolo(){
				for (int i=1; i<=9; i++) {
					for (int j=1; j<=9; j++) {
						
						
						if ((this.PosizioniPossibili[i][j]) && this.grid[i][j]==0) { //controllo di essere in una posizione legale per il numero di giocatori 
							int rand=(int) (Math.random() * this.colori.size()); //prendo una posizione random per ciascun colore inserito
							this.grid [i][j] = colori.get(rand);		//posiziono nell'array il colore estratto randomicamente	
							this.colori.remove(rand);		//rimuovo l'elemento pescato dall'arraylist delle posizioni pescabili
						}
					}
				}
				
				return grid;
			}
			
			
			
			
			
			//funzione utile per capire se il tassello è immediatamente pescabile al primo turno, controlla se ha almeno un lato libero
			private boolean isSideFree(int x, int y) {
				if (this.grid[x+1][y]==0) {
					return true;
				}
				if (this.grid[x-1][y]==0) {
					return true;
				}
				if (this.grid[x][y+1]==0) {
					return true;
				}
				if (this.grid[x][y-1]==0) {
					return true;
				}
				return false;
			}
			
			
			
	
			
			
			//funzione da chiamare alla fine di ogni giocata: nel caso in cui la griglia generale fosse completamente vuota permette di fare il refresh
			
			public void caselleSeparate() { 
				for (int i=1; i<=9; i++) {
					for (int j=1; j<=9; j++) {
						if (this.grid[i][j]!=0) {
							if (!(this.grid[i+1][j]==0 && this.grid[i-1][j]==0 && this.grid[i][j+1]==0 && this.grid[i][j-1]==0)) { //controlla se le caselle adiacenti un punto sono vuote sono tutte vuote, se si 
								return;
							} 
						}
					}
				}
				getGeneralTavolo();
			}

			
			//funzione per stampare la griglia generale
			public void printGrid() {
				System.out.println();
				for (int i = 1; i <= 9; i++) {
					System.out.print("\n" + (i) + ": ");
					for (int j = 1; j <= 9; j++) {
						System.out.print(this.grid[i][j] + " ");
					}
				}
				System.out.println("\n\n   1"+" 2"+" 3"+" 4"+" 5"+" 6"+" 7"+" 8"+" 9");
			}
			
			
			
	/** aggiunta da convalidare poi con adrian
	 * 
	 * 
	 * 
	 * */
			
			
	//selezione coordinate di partenza da pescare
		public void selezionaPartenza() {
				
				printGrid();
				int x;
				int y;
				
				do {
					
					System.out.print("\ninserire la coordinata orizzontale della casella da prendere ");
					y=scanner();
					System.out.print("\ninserire la coordinata verticale della casella da prendere ");
					x=scanner();
					
					if(this.grid[x][y]==0||!this.PosizioniPossibili[x][y])
						System.out.println("Hai preso una casella vuota.\n Riscrivi le coordinate corrette ");
					if(!isSideFree(x,y))
						System.out.println("Questa casella non ha lato libero.\n Riscrivi le coordinate corrette");
					} while (this.grid[x][y]==0 || !(isSideFree(x,y))||!inGridBounds( x,  y)||!this.PosizioniPossibili[x][y]);   
				
					/**la coordianta non viene accettata se 
					 * 1) lo spazio fosse stato precedentemente svoutato
					 * 2) non fosse in una psizione consentita dai limiti della griglia
					 * 3) non fosse in una posizione consentita dal numero giocatori
					 * 4) non avesse lato libero /
					 */
				
				this.firstX=x;	//salvo localmente le variabili, passo direttamente il colore da inserire nella grid
				this.firstY=y;
				
			
				
				return;
			}
			
		

	
		public void opzioniDisponibili() {
				finalX = 0;
				finalY = 0;

				int firstX = this.firstX;
				int firstY = this.firstY;
				

				
				ArrayList<Integer> x = new ArrayList<Integer>();
				ArrayList<Integer> y = new ArrayList<Integer>();

				// se disponibili, elenco i seguenti vettori
				x.add(firstX); //aggiungo nella lista delle opzioni pescabili x
				y.add(firstY);//aggiungo nella lista delle opzioni pescabili y
				
				if (inGridBounds(firstX, firstY + 1) && this.grid[firstX][firstY + 1] != 0 && isSideFree(firstX, firstY + 1)) { //controllo che i valori indicati siano nei bordi dell'immagine, che la casella non sia vuota e che abbia almeno un lato libero
					System.out.println("dx");
					x.add(firstX); //aggiungo nella lista delle opzioni pescabili x
					y.add(firstY + 1); //aggiungo nella lista delle opzioni pescabili y
					if (inGridBounds(firstX, firstY + 2) && this.grid[firstX][firstY + 2] != 0  && isSideFree(firstX, firstY + 2)) {//controllo che i valori indicati siano nei bordi dell'immagine, che la casella non sia vuota e che abbia almeno un lato libero
						x.add(firstX); //aggiungo nella lista delle opzioni pescabili x
						y.add(firstY + 2); //aggiungo nella lista delle opzioni pescabili y
					}
				}
				if (inGridBounds(firstX, firstY - 1) && this.grid[firstX][firstY - 1] != 0 && isSideFree(firstX, firstY - 1)) {//controllo che i valori indicati siano nei bordi dell'immagine, che la casella non sia vuota e che abbia almeno un lato libero
					System.out.println("sx");
					x.add(firstX); //aggiungo nella lista delle opzioni pescabili x
					y.add(firstY - 1); //aggiungo nella lista delle opzioni pescabili y
					if (inGridBounds(firstX, firstY - 2) && this.grid[firstX][firstY - 2] != 0 && isSideFree(firstX, firstY - 2)) {//controllo che i valori indicati siano nei bordi dell'immagine, che la casella non sia vuota e che abbia almeno un lato libero
						x.add(firstX); //aggiungo nella lista delle opzioni pescabili x
						y.add(firstY - 2); //aggiungo nella lista delle opzioni pescabili y
					}
				}
				if (inGridBounds(firstX + 1, firstY) && this.grid[firstX + 1][firstY] != 0 && isSideFree(firstX+1, firstY)) {//controllo che i valori indicati siano nei bordi dell'immagine, che la casella non sia vuota e che abbia almeno un lato libero
					System.out.println("sotto");
					x.add(firstX + 1); //aggiungo nella lista delle opzioni pescabili x
					y.add(firstY); //aggiungo nella lista delle opzioni pescabili x
					if (inGridBounds(firstX + 2, firstY) && this.grid[firstX + 2][firstY] != 0&& isSideFree(firstX+2, firstY)) {//controllo che i valori indicati siano nei bordi dell'immagine, che la casella non sia vuota e che abbia almeno un lato libero
						x.add(firstX + 2); //aggiungo nella lista delle opzioni pescabili x
						y.add(firstY); //aggiungo nella lista delle opzioni pescabili y
					}
				}
				if (inGridBounds(firstX - 1, firstY) && this.grid[firstX - 1][firstY] != 0&& isSideFree(firstX-1, firstY)) {//controllo che i valori indicati siano nei bordi dell'immagine, che la casella non sia vuota e che abbia almeno un lato libero
					System.out.println("sopra");
					x.add(firstX - 1); //aggiungo nella lista delle opzioni pescabili x
					y.add(firstY); //aggiungo nella lista delle opzioni pescabili y
					if (inGridBounds(firstX - 2, firstY) && this.grid[firstX - 2][firstY] != 0&& isSideFree(firstX-2, firstY)) {//controllo che i valori indicati siano nei bordi dell'immagine, che la casella non sia vuota e che abbia almeno un lato libero
						x.add(firstX - 2); //aggiungo nella lista delle opzioni pescabili x
						y.add(firstY); //aggiungo nella lista delle opzioni pescabili x
					}
				}
				System.out.print("i vettori disponiblili sono in posizione X e Y: ");

				for (int i = 0; i  < x.size(); i++) { //stampo la lista dei valori possibili

					System.out.print("y"+x.get(i) + " x" + y.get(i) + ", ");
				}
				
				this.PossibleX=x;
				this.PossibleY=y;

				// chiedo all'utente le coordinate termine
				printGrid();
		}
		
		
		public ArrayList<Integer> manoDiGioco(){
			{
				
				ArrayList<Integer> mano = new ArrayList<Integer>(); //inizializzo la mano contenente gli elementi da inserire nella libreria
				

				do {//prendo l'ultima coordianta
					System.out.print("\nselezionare la coordinata finale X da prendere: ");
					

					finalX = scanner();//sc.nextInt();

					System.out.print("la Y finale da prendere: ");
					finalY = scanner();//sc.nextInt();

					
///////////////////////////////////swap
					if (!(Sceglibili(finalX, finalY, PossibleX,PossibleY))) { //la coordianta deve essere tra quelle elencate nella lista in x e y
						System.out.println("inserire i valori elencati nella lista ");
					}
				} while (!Sceglibili(finalX, finalY, PossibleX, PossibleY)); //continua a chiedere all'ultente fino a che la coordianta inserita non risulta corretta
				
				// compongo l'array contenente il primo elemento selezioanto
				
				
				mano.add(this.grid[firstX][firstY]);
				this.grid[firstX][firstY]=0;

				// pesco 2 elementi
				if (finalX == firstX + 1 && isSideFree(firstX + 1, firstY)) { //aggiungo all'array quasta posizione
					mano.add(this.grid[firstX + 1][firstY]); //pesco il colore in questa posizione

					this.grid[firstX + 1][firstY] = 0; //resetto a colore neutro questa posizione
				}
				if (finalX == firstX - 1 && isSideFree(firstX - 1, firstY)) { //aggiungo all'array quasta posizione
					mano.add(this.grid[firstX - 1][firstY]); //pesco il colore in questa posizione

					this.grid[firstX - 1][firstY] = 0; //resetto a colore neutro questa posizione
				}
				if (finalY == firstY + 1 && isSideFree(firstX, firstY+1)) { //...
					mano.add(this.grid[firstX][firstY + 1]); //...

					this.grid[firstX][firstY + 1] = 0;//...
				}
				if (finalY == firstY - 1 && isSideFree(firstX, firstY-1)) { //...
					mano.add(this.grid[firstX][firstY - 1]); //...

					this.grid[firstX][firstY - 1] = 0;//...
				}

				
				// pesco 3 elementi: per la pesca di tre elementi devo fare come prima, ma comprendendo anche la coordianta in mezzo
				if (finalX == firstX + 2 && isSideFree(firstX + 2, firstY)) {
					mano.add(this.grid[firstX + 1][firstY]);
					mano.add(this.grid[firstX + 2][firstY]);

					this.grid[firstX + 1][firstY] = 0;
					this.grid[firstX + 2][firstY] = 0;

				}
				if (finalX == firstX - 2 && isSideFree(firstX - 2, firstY)) {
					mano.add(this.grid[firstX - 1][firstY]);
					mano.add(this.grid[firstX - 2][firstY]);

					this.grid[firstX - 1][firstY] = 0;
					this.grid[firstX - 2][firstY] = 0;

				}
				if (finalY == firstY + 2 && isSideFree(firstX, firstY+2)) {
					mano.add(this.grid[firstX][firstY + 1]);
					mano.add(this.grid[firstX][firstY + 2]);

					this.grid[firstX][firstY + 1] = 0;
					this.grid[firstX][firstY + 2] = 0;
				}
				if (finalY == firstY - 2 && isSideFree(firstX, firstY-2)) {
					mano.add(this.grid[firstX][firstY - 1]);
					mano.add(this.grid[firstX][firstY - 2]);

					this.grid[firstX][firstY - 1] = 0;
					this.grid[firstX][firstY - 2] = 0;
				}
				
				return mano;
			}
			
			
			
			}

			private boolean inGridBounds(int x, int y) { //per controllare che le coordinate siano nei limiti della matrice
				if (1 <= x && x <= 9) {
					if (1 <= y && y <= 9) {
						return true;
					}
				}
				return false;
			}

			private boolean Sceglibili(Integer finalX, Integer finalY, ArrayList<Integer> x, ArrayList<Integer> y) { //controllo che gli elementi siano nell'arraylist finale
				
				
				for (int i=0; i<x.size(); i++) {
					x.get(i);
					y.get(i);
					
					int X=(int) finalX;				//la variabile final x viene trasformata in una variabile x
					int Y=(int) finalY;
					if (x.equals(X) && y.equals(Y)) {
						return true;
					}
					
					

				}
				return false;
			}
			
			private ArrayList<Integer> ColoriTotali(){
				ArrayList<Integer> colori=new ArrayList<Integer>();
				
				for(int i=1; i<=6; i++) {	//ripeto il processo per 6 colori
					for(int j=0; j<22; j++) { //aggiungo 22 tasselli x ciascun tipo
						colori.add(i);
					}
				}
				
				return colori;
			}

		}
/**
 * Main sul quale ho testato il codice
 * 
 import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		
		
		
		int player=4;
		Tavolo grid=new Tavolo(player);
		//grid.prendiColori();
		grid.selezionaPartenza(); 
		grid.opzioniDisponibili();
		ArrayList<Integer> hand=grid.manoDiGioco();
		
		for(int i=0; i<hand.size(); i++) {
			System.out.println(" -> vettore "+i+" "+hand.get(i));
		}
		grid.printGrid();
		
		

	}

}
*/