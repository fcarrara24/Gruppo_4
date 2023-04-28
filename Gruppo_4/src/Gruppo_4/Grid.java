package Gruppo_4;
import java.util.Scanner;



public class Grid {
			
			private static int row = 10;
			private static int column= 10;
			
			int [][] grid=new int [row][column];
			
			int [] hand=new int [2];
			private int player;
			private int temporaryValue2=0;   //salvo le carte in caso di libreria piena
			private int temporaryValue3=0;
			private int[] temporaryX=new int[2];
			private int[] temporaryY=new int[2];
	
	
	
	
	public Grid(int Nplayer)
	{
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				this.grid[i][j] = 0; 
			}
		}
		this.player=Nplayer;
		getGeneralGrid();
	}
		
		
		
		
		//grigliaGenerale
		
	public int[][] getGeneralGrid(){
			for (int i=1; i<=9; i++) {
				for (int j=1; j<=9; j++) {
					
					
					if (isPlaceRight (i,  j)&&(this.grid[i][j]==0)) {
						this.grid [i][j] = (int) (Math.random() * 6) +1;
						
					}
				}
			}
			
			return grid;
		}
		
		//seleziona il numero di giocaori per gestire la griglia
		private boolean isPlaceRight (int i, int j) {
			switch(this.player) {
				case 4:
					if (!adapt4Players (i, j))
						return false;
					break;
				case 3:
					if (!adapt3Players (i, j))
						return false;
					break;
				case 2:
					if (!adapt2Players (i, j))
						return false;
					break;
				default:
					System.out.println("errore: hai selezionato un numero di giocatori non compreso tra 2 e 4");
					return false;
			}
			
			
			return true;
		}
		
		
		
		
		private boolean adapt4Players (int i, int j){
			
					
					//inizio controlli e nullificazione cifre
				
					if (i==1 && (j!=4 && j!=5)) {
							return false;
						}
					
					
					if (i==2 && (j==1||j==2||j==3||j==7||j==8||j==9)) {
						return false; 
					}
					
					if ((i==3||i ==7) && (j==1||j==2||j==8||j==9))
						return false;
					
					if (i==4 && j==1) {
						return false;
					}
					
					if (i==6 && j==9) {
						return false;
					}
					
					if (i==8 && (j==1||j==2||j==3||j==7||j==8||j==9)) {
						return false; 
					}
					
					if (i==9 && (j==1||j==2||j==3||j==4||j==7||j==8||j==9)) {
						return false;
					}
					
					
				
			return true;
	}
		
		
		
	private boolean adapt3Players(int i, int j) {
		if (adapt4Players(i, j)) {

			if (i == 5 && (j == 1 || j == 9)) {
				return false;
			}

			if (j == 5 && (i == 1 || i == 9)) {
				return false;
			}
			if (i == 2 && j == 6) {
				return false;
			}
			if (i == 8 && j == 4) {
				return false;
			}
			if (i == 4 && j == 1) {
				return false;
			}
			if (i == 6 && j == 9) {
				return false;
			}

			return true;

		}
		return false;
	}

		private boolean adapt2Players (int i, int j) {
			if (adapt3Players (i, j)) {
				if ((i==3 || i ==7) && (j==3|| j==7)) {
					return false;
				}
				if (i==1 && j==4) {
					return false;
				}
				if (i==9 && j==6) {
					return false;
				}
				if (i==4 && j==9) {
					return false;
				}
				if (i==6 && j ==1) {
					return false;
				}	
				
				return true;
			}
		
			return false;
		}
		
		
		
		
		
		
		
		
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
		
		private boolean allSideFree(int x, int y) {
			if (this.grid[x+1][y]==0 && this.grid[x-1][y]==0 && this.grid[x][y+1]==0 && this.grid[x][y-1]==0) {
				return true;
			}
			return false;
		}
		

		 
		public void ripristinaTessereTolte(int tessereRifiutate) {
			if(tessereRifiutate==2) {
				this.grid[this.temporaryX[1]][this.temporaryY[1]]=this.temporaryValue3;
			}
				
			if(tessereRifiutate==2||tessereRifiutate==1) {
				this.grid[this.temporaryX[0]][this.temporaryY[0]]=this.temporaryValue2;
			}
			else {
				System.out.println("attenzione: non puoi rifiutare un numero di carte diverse da 1 o 2 ");
			}
				
			
		}
		
public int[] prendiColori() {
			
			int[] hand= new int[3];
			int x;
			int y;
			int scelta;
			Scanner sc1=new Scanner(System.in);
			Scanner sc= new Scanner(System.in);
			
			
			
			//primo tassello
			
			do {
			
			System.out.println("\ninserire la coordinata verticale della casella da prendere ");
			x=sc1.nextInt();
			System.out.println("inserire la coordinata orizzontale della casella da prendere ");
			y=sc1.nextInt();
			
			if(this.grid[x][y]==0)
				System.out.println("Hai preso una casella vuota.\n Riscrivi le coordinate corrette ");
			if(!isSideFree(x,y))
				System.out.println("Questa casella non ha lato libero.\n Riscrivi le coordinate corrette");
			} while (this.grid[x][y]==0 || !(isSideFree(x,y)));
										//per essere presa deve esistere e avere almeno 1 lato libero
			
			hand[0]=this.grid[x][y];
			this.hand=hand;
			this.grid[x][y]=0;			
			
			//continuare o terminare
			System.out.print("prendere il secondo elemento? (<1> per continuare)");
			scelta=sc.nextInt();
			
			
			if(scelta!=1) { 
				sc.close();
				System.out.println("hai preso 1 elemento: "+hand[0]);
				return hand;
			}
				do {
				System.out.println("scegliere se prendere l'elemento sopra(2), sotto(3), a destra(4) o a sinistra(5)");
					scelta=sc.nextInt();
				if(scelta==2&&this.grid[x-1][y]!=0) {
					x=x-1;
				}
				if(scelta==3&&this.grid[x+1][y]!=0) {
					x=x+1;
				}
				if(scelta==4&&this.grid[x][y+1]!=0) {
					y=y+1;
				}
				if(scelta==5&&this.grid[x][y-1]!=0) {
					y=y-1;
				}
				if(this.grid[x][y]==0) {
					System.out.println("non hai scritto correttamente, \n oppure hai preso un elemento vuoto");
				}
			} while (this.grid[x][y]==0);
			
			
			hand[1]=this.grid[x][y];
			this.hand=hand;
			this.temporaryValue2=hand[1];
			this.temporaryX[0]=x;
			this.temporaryY[0]=y;			//salvo il codice in caso di libreria piena
			this.grid[x][y]=0;				//cancello
			
			//continuare
			System.out.println("prendere il terzo elemento? (<1> per continuare)\n");
			int continua=sc.nextInt();
			
			
			if(continua!=1) {
				sc.close();
				System.out.println("\nhai preso 2 elementi: "+hand[1]+" e "+hand[2]);
				return hand;
			}
			
			
			//-------------pesca 3 elementi
			
			if(scelta==3&&this.grid[x+1][y]!=0) {
					x=x+1;
					hand[2]=this.grid[x][y];
					this.hand=hand;
					this.temporaryValue3=hand[2];
					this.temporaryX[1]=x;
					this.temporaryY[1]=y;			//salvo il codice in caso di libreria piena
					this.grid[x][y]=0;				//cancello l'elemento
			}
			
			else if(scelta==2&&this.grid[x-1][y]!=0) {
					x=x-1;
					hand[2]=this.grid[x][y];
					this.hand=hand;
					this.temporaryValue3=hand[2];
					this.temporaryX[1]=x;
					this.temporaryY[1]=y;			//salvo il codice in caso di libreria piena
					this.grid[x][y]=0;				//cancello l'elemento
			}
			
			else if(scelta==4&&this.grid[x][y+1]!=0) {
					y=y+1;
					hand[2]=this.grid[x][y];
					this.hand=hand;
					this.temporaryValue3=hand[2];
					this.temporaryX[1]=x;
					this.temporaryY[1]=y;			//salvo il codice in caso di libreria piena
					this.grid[x][y]=0;				//cancello l'elemento
			}	
			
			else if(scelta==5&&this.grid[x][y-1]!=0) {
					y=y-1;
					hand[2]=this.grid[x][y];
					this.hand=hand;
					this.temporaryValue3=hand[2];
					this.temporaryX[1]=x;
					this.temporaryY[1]=y;			//salvo il codice in caso di libreria piena
					this.grid[x][y]=0;				//cancello l'elemento
			}
			
			
			
			sc.close();
			if(hand.length==2)
				System.out.println("\nhai preso 2 elementi: "+hand[0]+" e "+hand[1]);
			else
				System.out.println("\nhai preso 3 elementi: "+hand[0]+", "+hand[1]+" e "+hand[2]);
			return hand;
			
		}
			
		
		
		
		
		
		
		public void caselleSeparate() { //contiene anche il refresh della griglia
			for (int i=1; i<=9; i++) {
				for (int j=1; j<=9; j++) {
					if (allSideFree(i, j)) {
						return;
					}
				}
			}
			getGeneralGrid();
		}

		public void printGrid() {
			System.out.println();
			for (int i = 1; i <= 9; i++) {
				System.out.print("\n" + (i) + ": ");
				for (int j = 1; j <= 9; j++) {
					System.out.print(this.grid[i][j] + " ");
				}
			}
		}
		
		
	}





/* package Gruppo_4;

public class Main {

	public static void main(String[] args) {
		
		int player=4;
		Grid grid=new Grid(player);
		grid.printGrid();
		grid.prendiColori();
		int[] vettore=grid.hand;
		for(int i=0; i<grid.hand.length; i++) {
			System.out.println(" -> vettore "+i+" "+vettore[i]);
		}
		grid.printGrid();
		grid.ripristinaTessereTolte(2);
		grid.printGrid();

	}

}*/
