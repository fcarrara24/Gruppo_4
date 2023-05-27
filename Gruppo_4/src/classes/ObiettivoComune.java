package classes;

import java.util.Random;

public class ObiettivoComune {
	
	public int numeroObiettivo;
	/**
	 * selector obiettivo comune
	 */
	
	public  ObiettivoComune(){
		 
		Random rand =new Random();
		this.numeroObiettivo=rand.nextInt(12)+1;
		
	 }
	 
	/*
	 * Obiettivo numero 1
	 * 
	 * Due gruppi separati di 4 tessere dello stesso tipo che formano un quadrato
	 * 2x2. Le tessere dei due gruppi devono essere dello stesso tipo.
	 */
	boolean ObiettivoComune1(int[][] libreria) {
		int contatore = 0;
		for (int i = 0; i < 5; i++) { // i riga, che faccio scorrere
			for (int j = 0; j < 4; j++) { // j colonna, che faccio scorrere
				if (libreria[i][j] == libreria[i][j + 1] && libreria[i][j] == libreria[i + 1][j]
						&& libreria[i][j] == libreria[i + 1][j + 1]) {
					contatore++; // serve a controllare quante volte la condizione dell'if è vera
				}
			}
		}
		if (contatore >= 2) { // vedere quante volte è presente la condizione dell'obiettivo
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Obiettivo numero 2
	 * 
	 * Due colonne formate ciascuna da 6 diversi tipi di tessere.
	 */
	boolean ObiettivoComune2(int[][] libreria) {
		int contatore = 0; // inizializzo contatore per vedere quante volte viene eseguito questo obiettivo
		for (int j = 0; j < 4; j++) { // facciamo scorrere le colonne
			for (int numColonne = 0; numColonne < 4; numColonne++) { // facciamo scorrere le righe
				int coloriUguali = 0;
				for (int colori = 1; colori <= 6; colori++) { // vediamo se ci sono colori uguali
					if (libreria[numColonne][j] == colori) {
						coloriUguali++;
					}
				}
				if (coloriUguali == 1) { // controlliamo qunati colori ci sono uguali nella matrice e vediamo qunanti ce
											// ne sono
					contatore++;
				}

			}
		}
		if (contatore >= 2) { // controlli se l'obiettivo è stato raggiunto
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Obiettivo numero 3
	 * 
	 * Quattro gruppi separati formati ciascuno da quattro tessere adiacenti dello
	 * stesso tipo (non necessariamente come mostrato in figura). Le tessere di un
	 * gruppo possono essere diverse da quelle di un altro gruppo.
	 */
	public boolean obiettivo3(int[][] libreria) {
		/**
		 * inserimento dell'obiettivo 3 di conta caselle: ad ogni scansione controlla
		 * tutti i casi possibili; per ciascuno di questi controlli verifico che tutte
		 * le caselle adiacenti (escludendo quelle messe in diagonale) siano di colori
		 * diversi (i tipi di coordinate sono specificati sotto)
		 */
		int contatore = 0;
		// righe 6
		// colonne 5
		for (int i = 0; i < 6; i++) { // scorrimento righe
			for (int j = 0; j < 5; j++) { // scorrimento colonne
				if (neiConfini(i, j + 1) & libreria[i][j] == libreria[i][j + 1] & neiConfini(i, j + 2)
						& libreria[i][j] == libreria[i][j + 2] & neiConfini(i, j + 3)
						& libreria[i][j] == libreria[i][j + 3]) { // controllo a lato se c'è lo stesso colore

					// controllo che i lati adiacenti ai gruppi da 4 (orizzontali) siano diversi dal
					// colore trovato
					if ((!neiConfini(i, j + 4) | libreria[i][j] != libreria[i][j + 4]) && // controllo destra
							(!neiConfini(i, j - 1) | libreria[i][j] != libreria[i][j - 1]) && // controllo sinistra
							(!neiConfini(i + 1, j) | libreria[i][j] != libreria[i + 1][j]) && // controllo elemento
																								// sotto primo
							(!neiConfini(i + 1, j + 1) | libreria[i][j] != libreria[i + 1][j + 1]) && // controllo
																										// elemento
																										// sotto secondo
							(!neiConfini(i + 1, j + 2) | libreria[i][j] != libreria[i + 1][j + 2]) && // controllo
																										// elemento
																										// sotto terzo
							(!neiConfini(i + 1, j + 3) | libreria[i][j] != libreria[i + 1][j + 3]) && // controllo
																										// elemento
																										// sotto quarto
							(!neiConfini(i - 1, j) | libreria[i][j] != libreria[i - 1][j]) && // controllo elemento
																								// sopra primo
							(!neiConfini(i - 1, j + 1) | libreria[i][j] != libreria[i - 1][j + 1]) && // controllo
																										// elemento
																										// sopra secondo
							(!neiConfini(i - 1, j + 2) | libreria[i][j] != libreria[i - 1][j + 2]) && // controllo
																										// elemento
																										// sopra terzo
							(!neiConfini(i - 1, j + 3) | libreria[i][j] != libreria[i - 1][j + 3])) { // controllo
																										// elemento
																										// sopra quarto
						contatore++;
					}

				} else if (neiConfini(i + 1, j) & libreria[i][j] == libreria[i + 1][j] & neiConfini(i + 2, j)
						& libreria[i][j] == libreria[i + 2][j] & neiConfini(i + 3, j)
						& libreria[i][j] == libreria[i + 3][j]) { // controllo se c'è sotto lo stesso colore

					// controllo che i lati adiacenti ai gruppi da 4 (verticali) siano diversi dal
					// colore trovato
					if ((!neiConfini(i - 1, j) | libreria[i][j] != libreria[i - 1][j]) && // sopra
							(!neiConfini(i + 4, j) | libreria[i][j] != libreria[i + 4][j]) && // sotto
							(!neiConfini(i, j + 1) | libreria[i][j] != libreria[i][j + 1]) && // destra primo
							(!neiConfini(i + 1, j + 1) | libreria[i][j] != libreria[i + 1][j + 1]) && // destra secondo
							(!neiConfini(i + 2, j + 1) | libreria[i][j] != libreria[i + 2][j + 1]) && // destra terzo
							(!neiConfini(i + 3, j + 1) | libreria[i][j] != libreria[i + 3][j + 1]) && // destra quarto
							(!neiConfini(i, j - 1) | libreria[i][j] != libreria[i][j - 1]) && // sinistra primo
							(!neiConfini(i + 1, j - 1) | libreria[i][j] != libreria[i + 1][j - 1]) && // sinistra
																										// secondo
							(!neiConfini(i + 2, j - 1) | libreria[i][j] != libreria[i + 2][j - 1]) && // sinistra terzo
							(!neiConfini(i + 3, j - 1) | libreria[i][j] != libreria[i + 3][j - 1])) { // sinistra quarto
						contatore++;
					}
				}
			}
		}
		if (contatore >= 4) {
			return true;
		}
		return false;
	}

	/*
	 * Obiettivo numero 4
	 * 
	 * Sei gruppi separati formati ciascuno da due tessere adiacenti dello stesso
	 * tipo (non necessariamente come mostrato in figura). Le tessere di un gruppo
	 * possono essere diverse da quelle di un altro gruppo.
	 */
	public boolean obiettivo4(int[][] libreria) {
		/**
		 * inserimento dell'obiettivo 4 di conta caselle: ad ogni scansione controlla
		 * due casi possibili: il tassello sotto e il tassello a destra per ciascuno di
		 * questi controlli verifico che tutte le caselle adiacenti (non diagonalmente)
		 * siano di colori diversi (i tipi di coordinate sonospecificati sotto)
		 */
		int contatore = 0;
		// righe 6
		// colonne 5
		for (int i = 0; i < 6; i++) {// scorrimento righe
			for (int j = 0; j < 5; j++) { // scorrimento colonne
				if (neiConfini(i + 1, j) & libreria[i][j] == libreria[i + 1][j]) { // controllo sotto se c'è lo stesso
																					// colore

					// controllo che i lati adiacenti ai gruppi da 2 siano diversi dal colore
					// trovato
					if ((!neiConfini(i, j + 1) | libreria[i][j] != libreria[i][j + 1]) && // controllo destra
							(!neiConfini(i, j - 1) | libreria[i][j] != libreria[i][j - 1]) && // controllo sinistra
							(!neiConfini(i + 1, j - 1) | libreria[i][j] != libreria[i + 1][j - 1]) && // controllo
																										// elemento
																										// sotto a
																										// sinistra
							(!neiConfini(i + 1, j + 1) | libreria[i][j] != libreria[i + 1][j + 1]) && // controllo
																										// elemento
																										// sotto a
																										// destra
							(!neiConfini(i - 1, j) | libreria[i][j] != libreria[i - 1][j]) && // controllo elemento
																								// sopra
							(!neiConfini(i + 2, j) | libreria[i][j] != libreria[i + 2][j])) {// controllo elemento sotto
						contatore++;
					}

				} else if (neiConfini(i, j + 1) & libreria[i][j] == libreria[i][j + 1]) {

					// controllo che i lati adiacenti ai gruppi da 2 siano diversi dal colore
					// trovato
					if ((!neiConfini(i + 1, j) | libreria[i][j] != libreria[i + 1][j]) && // sopra primo
							(!neiConfini(i - 1, j) | libreria[i][j] != libreria[i - 1][j]) && // sotto primo
							(!neiConfini(i, j + 2) | libreria[i][j] != libreria[i][j + 2]) && // destra
							(!neiConfini(i, j - 1) | libreria[i][j] != libreria[i][j - 1]) && // sinistra
							(!neiConfini(i + 1, j + 1) | libreria[i][j] != libreria[i + 1][j + 1]) && // sopra secondo
							(!neiConfini(i + 1, j - 1) | libreria[i][j] != libreria[i + 1][j - 1])) {// sotto secondo
						contatore++;
					}
				}
			}
		}
		if (contatore >= 6) {
			return true;
		}
		return false;
	}

	private boolean neiConfini(int i, int j) {
		if (0 <= i && i < 6 && 0 <= j && j < 5) {
			return true;
		}
		return false;
	}

	/*
	 * Obiettivo numero 5
	 * 
	 * Tre colonne formate ciascuna da 6 tessere di uno, due o tre tipi differenti.
	 * Colonne diverse possono avere combinazioni diverse di tipi di tessere.
	 */
	public boolean ObiettivoComune5(int[][] libreria) {
		int contaColonne = 0;

		for (int j = 0; j < 5; j++) { // scorro le colonne
			int contaColori = 0;
			if (libreria[0][j] != 0) { // vedo se la colonna è piena
				for (int colori = 1; colori <= 6; colori++) { // vediamo se ci sono colori uguali //scorro le righe
					boolean colorePresente = false;
					for (int i = 0; i < 6; i++) { // scorro le righe
						if (libreria[i][j] == colori) {
							colorePresente = true;
						}
					}
					if (colorePresente == true) {
						contaColori++; // conta quanti colori sono presenti in una colonna
					}
				}
				if (contaColori <= 3) {
					contaColonne++; // conta quante colonne rispettano la condizione dell'obiettivo
				}
			}
		}

		if (contaColonne >= 3) { // controlli se l'obiettivo è stato raggiunto
			return true;
		} else {
			return false;
		}

	}

	/*
	 * Obiettivo numero 6
	 * 
	 * Due righe formate ciascuna da 5 diversi tipi di tessere.
	 */
	boolean ObiettivoComune6(int[][] libreria) {
		int contatore = 0; // inizializzo contatore per vedere quante volte viene eseguito questo obiettivo
		for (int i = 0; i < 5; i++) { // facciamo scorrere le colonne
			for (int numRighe = 0; numRighe < 6; numRighe++) { // facciamo scorrere le righe
				int coloriUguali = 0;
				for (int colori = 1; colori <= 6; colori++) { // vediamo se ci sono colori uguali
					if (libreria[i][numRighe] == colori) {
						coloriUguali++;
					}
				}
				if (coloriUguali == 1) { // controlliamo qunati colori ci sono uguali nella matrice e vediamo qunanti ce
											// ne sono
					contatore++;
				}

			}
		}
		if (contatore >= 2) { // controlli se l'obiettivo è stato raggiunto
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Obiettivo numero 7
	 * 
	 * Quattro righe formate ciascuna da 5 tessere di uno, due o tre tipi
	 * differenti. Righe diverse possono avere combinazioni diverse di tipi di
	 * tessere.
	 */
	public boolean ObiettivoComune7(int[][] libreria) {
		int contaRighe = 0;
		for (int i = 0; i < 6; i++) { // scorro le righe
			int contaColori = 0;
			if (libreria[i][0] != 0 && libreria[i][1] != 0 && libreria[i][2] != 0 && libreria[i][3] != 0
					&& libreria[i][4] != 0) { // vedo se la riga è piena
				for (int colori = 1; colori <= 6; colori++) { // vediamo se ci sono colori uguali
					boolean colorePresente = false;
					for (int j = 0; j < 5; j++) { // scorro le colonne
						if (libreria[i][j] == colori) {
							colorePresente = true;
						}
					}
					if (colorePresente == true) {
						contaColori++; // conta quanti colori sono presenti in una riga
					}
				}
				if (contaColori <= 3) {
					contaRighe++; // conta quante righe rispettano la condizione dell'obiettivo
				}
			}
		}

		if (contaRighe >= 4) { // controlli se l'obiettivo è stato raggiunto
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Obiettivo numero 8
	 * 
	 * Quattro tessere dello stesso tipo ai quattro angoli della Libreria.
	 */
	boolean ObiettivoComune8(int[][] libreria) {

		if (libreria[0][0] == libreria[0][4] && libreria[0][0] == libreria[5][0] && libreria[0][0] == libreria[5][4]) {
			return true; // vedo sela condizione dell'if e quindi l'obiettivo sia vera
		} else {
			return false;
		}
	}

	/*
	 * Obiettivo numero 9
	 * 
	 * Otto tessere dello stesso tipo. Non ci sono restrizioni sulla posizione di
	 * queste tessere.
	 */
	boolean ObiettivoComune9(int[][] libreria) {
		for (int colori = 1; colori <= 6; colori++) { // vediamo se ci sono colori uguali
			int coloriUguali = 0;
			for (int i = 0; i < 6; i++) { // i riga, che faccio scorrere
				for (int j = 0; j < 5; j++) { // j colonna, che faccio scorrere
					if (libreria[i][j] == colori) {
						coloriUguali++;
					}
				}
			}
			if (coloriUguali == 8) { // il ciclo finisce quando vengono trovate le 8 le caselle uguali
				return true;
			}
		}
		return false;

	}

	/*
	 * Obiettivo numero 10
	 * 
	 * Cinque tessere dello stesso tipo che formano una X.
	 */
	boolean ObiettivoComune10(int[][] libreria) {
		int contatore = 0;
		for (int i = 0; i < 3; i++) { // i riga, che faccio scorrere
			for (int j = 0; j < 2; j++) { // j colonna, che faccio scorrere
				if (libreria[i][j] == libreria[i][j + 2] && libreria[i][j] == libreria[i + 2][j]
						&& libreria[i][j] == libreria[i + 1][j + 1] && libreria[i][j] == libreria[i + 2][j + 2]) {
					contatore++; // serve a controllare quante volte la condizione dell'if è vera
				}
			}
		}
		if (contatore >= 1) { // vedere quante volte è presente la condizione dell'obiettivo
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Obiettivo numero 11
	 * 
	 * Cinque tessere dello stesso tipo che formano una diagonale.
	 */
	boolean ObiettivoComune11(int[][] libreria) {
		int contatore = 0;
		int i = 0; // j colonna, che faccio scorrere
		int j = 0;

		// vari casi dell'obiettivo numero 11

		if (libreria[i][j] == libreria[i + 1][j + 1] && libreria[i][j] == libreria[i + 2][j + 2]
				&& libreria[i][j] == libreria[i + 3][j + 3] && libreria[i][j] == libreria[i + 4][j + 4]) {
			contatore++; // serve a controllare quante volte la condizione dell'if è vera
		} else if (libreria[i + 1][j] == libreria[i + 2][j + 1] && libreria[i + 1][j] == libreria[i + 3][j + 2]
				&& libreria[i + 1][j] == libreria[i + 4][j + 3] && libreria[i + 1][j] == libreria[i + 5][j + 4]) {
			contatore++;
		} else if (libreria[i][j + 4] == libreria[i + 1][j + 3] && libreria[i][j + 4] == libreria[i + 2][j + 2]
				&& libreria[i][j + 4] == libreria[i + 3][j + 1] && libreria[i][j + 4] == libreria[i + 4][j]) {
			contatore++;
		} else if (libreria[i + 1][j + 4] == libreria[i + 2][j + 3] && libreria[i + 1][j + 4] == libreria[i + 3][j + 2]
				&& libreria[i + 1][j + 4] == libreria[i + 4][j + 1] && libreria[i + 1][j + 4] == libreria[i + 5][j]) {
			contatore++;
		}

		if (contatore >= 1) { // vedere quante volte è presente la condizione dell'obiettivo
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Obiettivo numero 12
	 * 
	 * Cinque colonne di altezza crescente o decrescente: a partire dalla prima
	 * colonna a sinistra o a destra, ogni colonna successiva deve essere formata da
	 * una tessera in più. Le tessere possono essere di qualsiasi tipo.
	 */
	public boolean ObiettivoComune12(int[][] libreria) {
		int contatore = 0;

		if (libreria[1][0] != 0 && libreria[1][0] == libreria[2][1] && libreria[1][0] == libreria[3][2]
				&& libreria[1][0] == libreria[4][3] && libreria[1][0] == libreria[5][4]) { // controllo che le caselle
																							// siano piene
			if (libreria[0][0] == 0 && libreria[0][0] == libreria[1][1] && libreria[0][0] == libreria[2][2]
					&& libreria[0][0] == libreria[3][3] && libreria[0][0] == libreria[4][4]) {
				contatore++; // controllo che le caselle sopra quelle controllate precedentemente siano vuote
			}
		} else if (libreria[1][4] != 0 && libreria[1][4] == libreria[2][3] && libreria[1][4] == libreria[3][2]
				&& libreria[1][4] == libreria[4][1] && libreria[1][4] == libreria[5][0]) { // controllo che le caselle
																							// siano piene
			if (libreria[0][4] == 0 && libreria[0][4] == libreria[1][3] && libreria[0][4] == libreria[2][2]
					&& libreria[0][4] == libreria[3][1] && libreria[0][4] == libreria[4][0]) {
				contatore++; // controllo che le caselle sopra quelle controllate precedentemente siano vuote
			}
		}

		if (contatore != 1) {
			return false; // non è vera nessuna condizione degli if
		} else {
			return true; // è vero almeno uno dei due cicli if
		}

	}

}