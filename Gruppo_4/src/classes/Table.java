package classes;

import java.io.Console;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Table {

	private static int row = 10; // aggiungo una linea e una colonna finte in modo da gestire i colori
									// correttamente
	private static int column = 10;

	public int[][] grid; // la libreria dei valori prendibili
	private boolean[][] PosizioniPossibili = new boolean[row][column]; // serve per caprire se quaesti spot sono
																		// prendibili
	private ArrayList<Integer> colori; // aggiungo un arraylist di colori

	private int size;
	private int startX;
	private int startY;
	private int endX;
	private int endY;

	private boolean takeTurn;

	private final int[][] grigliaGiocatori = { { 5, 5, 5, 3, 4, 5, 5, 5, 5 }, { 5, 5, 5, 2, 2, 4, 5, 5, 5 },
			{ 5, 5, 3, 2, 2, 2, 3, 5, 5 }, { 5, 4, 2, 2, 2, 2, 2, 2, 3 }, { 4, 2, 2, 2, 2, 2, 2, 2, 4 },
			{ 3, 2, 2, 2, 2, 2, 2, 4, 5 }, { 5, 5, 3, 2, 2, 2, 3, 5, 5 }, { 5, 5, 5, 4, 2, 2, 5, 5, 5 },
			{ 5, 5, 5, 5, 4, 3, 5, 5, 5 }, };

	/**
	 * costruttore da usare a inizio partita, passa alla griglia di giocatori e
	 * controlla la posizione specifica; se il valore in tale coordinata è minore o
	 * uguale al numero giocatori, allora quella sarà una posizione possibile per la
	 * matrice
	 * 
	 * @param Nplayer
	 */
	public Table(int Nplayer) // costruttore: crea per la prima volta un tavolo, controllando il numero
								// giocatori
	{
		this.colori = ColoriTotali();
		this.grid = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (Nplayer >= this.grigliaGiocatori[i][j])
					this.PosizioniPossibili[i][j] = true;
			}
		}
		this.grid = getGeneralTavolo();
	}

	// grigliaGenerale

	public int[][] getGeneralTavolo() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if ((this.PosizioniPossibili[i][j])) { // controllo di essere in una posizione legale per il numero di
														// giocatori
					int rand = (int) (Math.random() * this.colori.size()); // prendo una posizione random per ciascun
																			// colore inserito
					this.grid[i][j] = colori.get(rand); // posiziono nell'array il colore estratto randomicamente
					this.colori.remove(rand); // rimuovo l'elemento pescato dall'arraylist delle posizioni pescabili
				} else {
					this.grid[i][j] = 0;
				}
			}
		}

		return grid;
	}

	// funzione da chiamare alla fine di ogni giocata: nel caso in cui la griglia
	// generale fosse completamente vuota permette di fare il refresh

	public void caselleSeparate() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (this.grid[i][j] != 0) {
					if (!(this.grid[i + 1][j] == 0 && this.grid[i - 1][j] == 0 && this.grid[i][j + 1] == 0
							&& this.grid[i][j - 1] == 0)) { // controlla se le caselle adiacenti un punto sono vuote
															// sono tutte vuote, se si
						return;
					}
				}
			}
		}
		getGeneralTavolo();
	}

	/**
	 * stampa della griglia fenerale: fa scorrere la griglia per stampare le
	 * coordinate corrette
	 */
	public void printGrid() {
		for (int i = 0; i < 9; i++) {
			System.out.print("\n" + (i + 1) + ": ");
			for (int j = 0; j < 9; j++) {
				System.out.print(this.grid[i][j] + " ");
			}
		}
		System.out.println("\n\n   1" + " 2" + " 3" + " 4" + " 5" + " 6" + " 7" + " 8" + " 9\n");
	}

	/**
	 * costruttore chiamato all'inizio: permette di creare una bag nuova di colori
	 * dalla quale pescare i colori sono 6 (ciclo for esterno) e aggiunge 22
	 * tasselli dello stesso tipo per ciascuno di questi(for interno)
	 * 
	 * @return
	 */
	private ArrayList<Integer> ColoriTotali() {
		ArrayList<Integer> colori = new ArrayList<Integer>();

		for (int i = 1; i <= 6; i++) { // ripeto il processo per 6 colori
			for (int j = 0; j < 22; j++) { // aggiungo 22 tasselli x ciascun tipo
				colori.add(i);
			}
		}

		return colori;
	}

	/**
	 * per la nuova griglia è possibile resettare i valori però bisogna svuotare il
	 * campo
	 */
	void checkAndResetTable() {

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				if (!(i != 0 || grid[i - 1][j] == 0)) {
					return;
				}
				if (!(j != 0 || grid[i][j - 1] == 0)) {
					return;
				}
				if (!(i != grid.length || grid[i + 1][j] == 0)) {
					return;
				}
				if (!(i != grid[0].length || grid[i][j + 1] == 0)) {
					return;
				}

			}

		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				if (this.grid[i][j] != 0)
					this.colori.add(this.grid[i][j]);
			}
		}

		getGeneralTavolo();
	}

	public ArrayList<Integer> extractTiles(int[][] matrix, int size, int startX, int startY, int endX, int endY,
			boolean takeTurn) {
		this.takeTurn = takeTurn;
		this.grid = matrix;
		this.size = size;
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;

		ArrayList<Integer> extractedTiles = new ArrayList<>();

		System.out.println("input confirm");
		if (isValidInput()) {
			System.out.println("input approved");

			if (this.endX > this.startX) {
				// System.out.println("right");
				extractedTiles = extractRight();
			} else if (this.startX > this.endX) {
				// System.out.println("left");
				extractedTiles = extractLeft();
			} else if (this.startY > this.endY) {
				// System.out.println("up");
				extractedTiles = extractUp();
			} else if (this.endY > this.startY) {
				// System.out.println("down");
				extractedTiles = extractDown();
			} else {
				if (grid[endX][endY] != 0 && endY == startY && endX == startX) {
					extractedTiles.add(grid[endX][endY]);
					if (takeTurn) {
						this.grid[endX][endY] = 0;
					}
				}
			}
		}
		return extractedTiles;
	}

	private boolean isValidInput() {
		return startX >= 0 && startX < grid.length && startY >= 0 && startY < grid[0].length && endX >= 0
				&& endX < grid.length && endY >= 0 && endY < grid[0].length && size >= 0 && grid[endX][endY] != 0;
		// && direction >= 0 && direction <= 3;
	}

	private ArrayList<Integer> extractRight() {
		ArrayList<Integer> extractedTiles = new ArrayList<>();

		int currentX = startX;
		int currentY = startY;

		while (currentX <= endX && extractedTiles.size() <= size && adjacentFree(startX, currentY)) {
			int tile = grid[currentX][currentY];

			extractedTiles.add(tile);

			if (takeTurn) {
				this.grid[currentX][currentY] = 0;
			}

			currentX++;
		}

		return extractedTiles;
	}

	private ArrayList<Integer> extractDown() {
		ArrayList<Integer> extractedTiles = new ArrayList<>();

		int currentX = startX;
		int currentY = startY;

		while (currentY <= endY && extractedTiles.size() <= size && adjacentFree(startY, currentX)) {
			int tile = grid[currentX][currentY];

			extractedTiles.add(tile);

			if (takeTurn) {
				this.grid[currentX][currentY] = 0;
			}

			currentY++;
		}

		return extractedTiles;
	}

	private ArrayList<Integer> extractLeft() {
		ArrayList<Integer> extractedTiles = new ArrayList<>();

		int currentX = startX;
		int currentY = startY;

		while (currentX >= endX && extractedTiles.size() <= size && adjacentFree(startX, currentY)) {
			int tile = grid[currentX][currentY];

			extractedTiles.add(tile);

			if (takeTurn) {
				this.grid[currentX][currentY] = 0;
			}

			currentX--;
		}

		return extractedTiles;
	}

	private ArrayList<Integer> extractUp() {
		ArrayList<Integer> extractedTiles = new ArrayList<>();

		int currentX = startX;
		int currentY = startY;

		while (currentY >= endY && extractedTiles.size() <= size && adjacentFree(currentX, startY)) {
			int tile = grid[currentX][currentY];

			extractedTiles.add(tile);

			if (takeTurn) {
				this.grid[currentX][currentY] = 0;
			}
			currentY--;
		}

		return extractedTiles;
	}

	private boolean adjacentFree(int x, int y) {
		if (grid[x][y] == 0) {
			return false;
		}

		if (x >= 8 || grid[x + 1][y] == 0) {

			return true;
		}
		if (y >= 8 || grid[x][y + 1] == 0) {

			return true;
		}
		if (x == 0 || grid[x - 1][y] == 0) {

			return true;
		}
		if (y == 0 || grid[x][y - 1] == 0) {

			return true;
		}

		return false;
	}

	/**
	 * la seguente funzione permette di aggiungere alla comboBox di partenza la
	 * prima Y, che diventerà il punto di partenza per poi attivare la comboBox
	 * della X di partenza
	 * 
	 * @return
	 */
	public ArrayList<Integer> showFirstY() {
		ArrayList<Integer> ListPossibleY = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (adjacentFree(i, j)) {
					ListPossibleY.add(j);
					break;
				}
			}
		}
		return ListPossibleY;
	}

	/**
	 * completa la funzione precedente mostrando le possibili X prendibili dopo aver
	 * selezionato @param chosenY mostrando all'utente la lista di possibili X
	 * sceglibili.
	 * 
	 * @param chosenY
	 * @return
	 */
	public ArrayList<Integer> showFirstX(int chosenX) {

		ArrayList<Integer> ListPossibleY = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			if (adjacentFree(i, chosenX)) {
				ListPossibleY.add(i + 1);
			}
		}
		return ListPossibleY;
	}

	/**
	 * scannerizzo in tutte le direzioni possibili dati i parametri di
	 * partenza @param firstX e @param firstY, una volta terminato lo scanner salvo
	 * le possibili opzioni in una stringa, contenente anche i colori. Nella
	 * funzione successiva estrapolo le coordinate dalla stringa
	 * 
	 * @param firstX
	 * @param firstY
	 * @param MaxItems
	 * @return
	 */
	public ArrayList<String> scanPossibleOptions(int firstX, int firstY, int MaxItems) {
		ArrayList<String> scanPossibleOptions = new ArrayList<String>();

		for (int i = firstX - (MaxItems - 1); i <= firstX + (MaxItems - 1); i++) {
			// pongo i limiti della funzione
			if (i >= 0 && i < 9) {
				ArrayList<Integer> extractor = extractTiles(grid, MaxItems, firstX, firstY, i, firstY, false);
				if (extractor.size() - 1 == firstX - i || extractor.size() - 1 == i - firstX) {
					int fX = firstX + 1;
					int fY = i + 1;
					String testo;
					testo = "(" + fX + ", " + fY + "): " + extractor;
					scanPossibleOptions.add(testo);
				}
			}
		}
		for (int j = firstY - (MaxItems - 1); j <= firstY + (MaxItems - 1); j++) {
			if (j != firstY && j >= 0 && j < 9) {
				ArrayList<Integer> extractor = extractTiles(grid, MaxItems, firstX, firstY, firstX, j, false);
				if (extractor.size() - 1 == firstY - j || extractor.size() - 1 == j - firstY) {
					int fX = firstY + 1;
					int fY = j + 1;
					String testo;
					testo = "(" + fX + ", " + fY + "): " + extractor;
					scanPossibleOptions.add(testo);
				}
			}
		}
		return scanPossibleOptions;
	}

	public int[] getStarterCoordinates() {
		int[] coords = new int[2];
		Scanner sc = new Scanner(System.in);
		do {
			sc.reset();
			System.out.print("inserire coordinate da pescare dalla board:\n X ");
			// x

			coords[1] = sc.nextInt() - 1;
			sc.reset();

			// y
			System.out.print(" Y ");
			coords[0] = sc.nextInt() - 1;
			sc.reset();

		} while (!adjacentFree(coords[0], coords[1]));

		return coords;

	}

	/**
	 * la funzione prende in input le varie coordinate pescabili e stampa una lista
	 * di opzioni pescabili (in ciascuna di queste viene specificato il valore
	 * finale), successivamente, viene chiesto direttamente all'utente l'inserimento
	 * delle coordinate finali e dopo aver controllato che ricadano nella lista
	 * delle opzioni disponibili ritornando, quando corrette, le coordinate finali
	 * 
	 * @param startCoords
	 * @param maxItems
	 * @return
	 */
	public int[] getEndingCoordinates(int startCoords[], int maxItems) {
		int[] coords = new int[2];

		System.out.print("inserire coordinate finali da pescare " + "\ndalla board tra le scelte disponibili: ");
		ArrayList<String> listaOpzioni = scanPossibleOptions(startCoords[0], startCoords[1], maxItems);

		for (int i = 0; i < listaOpzioni.size(); i++) {
			System.out.println("opzione " + (i + 1));
			System.out.println(listaOpzioni.get(i));
		}

		boolean ripeti = true;
		Scanner sc = new Scanner(System.in);
		do {
			// x
			sc.reset();
			System.out.print("X: ");
			;
			coords[0] = sc.nextInt() - 1;
			// y
			System.out.print("Y: ");
			sc.reset();
			coords[1] = sc.nextInt() - 1;

			for (int i = 0; i < listaOpzioni.size(); i++) {
				if (listaOpzioni.get(i).charAt(2) == coords[0] && listaOpzioni.get(i).charAt(4) == coords[1]) {
					ripeti = false;
				}
			}

		} while (ripeti);

		return coords;

	}

	/**
	 * data la coordinata iniziale firstX, la coordinata iniziale firstY, e la
	 * stringa @finalCoord (dalla quale estrapola le coordinate finali), chiama una
	 * funzione matrix extractor per ottenere l'array di numeri corretto e
	 * rimuoverlo dalla matrice iniziale.
	 * 
	 * @param finalCoord
	 * @param firstX
	 * @param firstY
	 * @return
	 */
	public ArrayList<Integer> takeItem(String finalCoord, int firstX, int firstY) {
		int finalX = finalCoord.charAt(0);
		int finalY = finalCoord.charAt(4);

		ArrayList<Integer> extractor = extractTiles(grid, 3, firstX, firstY, finalX, finalY, true);
		return extractor;
	}

	/**
	 * nuova classe x la gestione dei numeri da estrarre, chiede come
	 * parametri @param maxItems, ritorna già i colori da inserire
	 * 
	 * @param maxItems
	 * @return
	 */
	public ArrayList<Integer> getColors(int maxItems) {
		int Y1;
		int X1;
		ArrayList<Integer> extractedTiles = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		do {
			sc.reset();
			System.out.print("inserire coordinate del primo elemento da pescare dalla board:\n X ");
// x
			X1 = sc.nextInt();
			X1--;
			sc.reset();
			

// y
			System.out.print(" Y ");
			
			Y1 = sc.nextInt();
			Y1--;
			sc.reset();

		} while (!adjacentFree(Y1, X1));

		extractedTiles.add(grid[Y1][X1]);
		this.grid[Y1][X1] = 0;

		int Y2 = 0;
		int X2 = 0;

		if (maxItems >= 2) {
			System.out.println("desideri continuare? (true = si, false = no)");
			sc.reset();
			boolean continua = sc.nextBoolean();
			if (continua) {
				do {
					sc.reset();
					System.out.print("inserire coordinate del secondo elemento da pescare dalla board:\n X ");
					// x
					X2 = sc.nextInt();
					X2--;
					sc.reset();
					
					// y
					System.out.print(" Y ");
					
					Y2 = sc.nextInt();
					Y2--;
					sc.reset();

				} while ((!adjacentFree(Y2, X2) || java.lang.Math.abs((Y1 - Y2) + (X1 - X2)) != 1));

				extractedTiles.add(grid[Y2][X2]);
				this.grid[Y2][X2] = 0;

				if (maxItems >= 3) {
					System.out.println("desideri continuare? (true = si, false = no)");
					sc.reset();
					if (Y2 > Y1 && adjacentFree(Y2 + 1, X2)) {
						// right
						extractedTiles.add(grid[Y2 + 1][X2]);
						this.grid[Y2 + 1][X2] = 0;
					} else if (Y1 > Y2 && adjacentFree(Y2 - 1, X2)) {
						// left
						extractedTiles.add(grid[Y2 - 1][X2]);
						this.grid[Y2 - 1][X2] = 0;
					} else if (X2 > X1 && adjacentFree(Y2, X2 + 1)) {
						// down
						extractedTiles.add(grid[Y2][X2 + 1]);
						this.grid[Y2][X2 + 1] = 0;
					} else if (X1 > X2 && adjacentFree(Y2, X2 - 1)) {
						// up
						extractedTiles.add(grid[Y2][X2 - 1]);
						this.grid[Y2][X2 - 1] = 0;
					}
				}
			}
		}
		
		return extractedTiles;
	}

}

/*
 * //classe da esportare esternamente public String numberToName(int n) { if
 * (n==1) { return "cornice"; } else if (n==2) { return "gatto"; } else if
 * (n==3) { return "gioco"; } else if (n==4) { return "libro"; } else if (n==3)
 * { return "pianta"; } else if (n==3) { return "trofeo"; } else { return
 * "(vuoto)"; } }
 */
