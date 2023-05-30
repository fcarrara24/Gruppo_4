package classes;

import java.util.Scanner;

public class Regolamento {
	
	
	/**
	 * scegliere una regola in generale
	 */
	public void scegliRegola(int numeroObComune) {
		System.out.println("sei nella sezione del regolamento del gioco: selezionare uno dei seguenti indici per le istruzioni");
		System.out.println(" 1 - regole generali del gioco \n 2 - corrisopndenza tra numero e tassello "
				+ "\n 3 - visualizzazione punteggi obiettivi comuni" + "\n 4 - sistema punti delle tiles adiacenti "
						+ "\n 5 - visualizza obiettivo comune \n ? - uscire dal menù di selezione\n");
		Scanner sc=new Scanner(System.in);
		int menu;
		try {
			sc.reset();
			menu=sc.nextInt();
			
		} catch (Exception e) {
			menu=6;
		}
		
		switch(menu) {
		case 1:
			regoleGenerali();
			break;
		case 2:
			numeroAColore();
			break;
		case 3:
			punteggiObiettiviComuni();
			break;
		case 4:
			puntiTilesAdiacenti();
			break;
		case 5:
			listaObComuni(numeroObComune);
			break;
		default:
			return;
		}
	}
	
	/**
	 * regole generali del gioco
	 */
	public void regoleGenerali() {
		System.out.println("benvenuto nel gioco di MyShelfie,ad ogni turno bisogna \\n\r\n"
				+ " riempire una colonna della propria libreria prendendo dei \\n \r\n"
				+ "tiles dalla shelf generale (si possono pescare un massimo di 3 tiles per volta, \\n\r\n"
				+ "devono formare una linea retta e devono avere almeno un lato libero)\\n\r\n"
				+ "una volta pescati, è possiblile inserirli nell'ordine desiderato nella colonna di\\n\r\n"
				+ "destinazione\\n\\n\r\n"
				+ "\r\n"
				+ "l'obiettivo è fare il punteggio più alto tra i giocatori, tenendo conto che vengono  \\n\r\n"
				+ "assegnati punti in base all'ordine di completamento dell'obiettivo comune, al numero \\n\r\n"
				+ "al numero di tasselli occupati per ogni obiettivo personale, al numero di tiles adia \\n\r\n"
				+ "_acenti e dall'essere il primo giocatore a riempire la grid \n\n");
	}
	
	/**
	 * corrisopndenza tra numeri e colori
	 */
	public void numeroAColore() {
		System.out.println("il gioco originale assegna per ciascuno dei seguenti numeri il colore: ");
		System.out.println("0-  vuoto  ,\r\n"
				         + "1-  BLU    ,\r\n"
				         + "2-  VERDE  ,\r\n"
				         + "3-  GIALLO ,\r\n"
				         + "4-  BIANCO ,\r\n"
				         + "5-  VIOLA  ,\r\n"
				         + "6-  AZZURRO;");
		
	}
	
	/**
	 * lista ob comuni 
	 */
	public void punteggiObiettiviComuni() {
		System.out.println("viene assegnato un punteggio in base all'ordine di competamento degli obiettivi comuni");
		System.out.println("    2 giocatori: 1° - 8 punti;  2° - 4 punti");
		System.out.println("    3 giocatori: 1° - 8 punti;  2° - 6 punti; 3° - 4 punti");
		System.out.println("    4 giocatori: 1° - 8 punti;  2° - 6 punti; 3° - 4 punti; 4° - 2 punti");
		
		// completare
	}
	

	/**
	 * lista ob comuni 
	 */
	public void listaObComuni(int numero) {
		System.out.println("viene assegnato un punteggio in base all'ordine di competamento degli obiettivi comuni");
		System.out.println("    2 giocatori: 1° - 8 punti;  2° - 4 punti");
		System.out.println("    3 giocatori: 1° - 8 punti;  2° - 6 punti; 3° - 4 punti");
		System.out.println("    4 giocatori: 1° - 8 punti;  2° - 6 punti; 3° - 4 punti; 4° - 2 punti");
		
		// completare
		
		switch(numero) {
		
		case 1:
			System.out.println("Due gruppi separati di 4 tessere dello stesso tipo che formano un quadrato 2x2. Le tessere dei due gruppi devono essere dello stesso tipo.");
			
			break;
			
		case 2:
			
			System.out.println("Due colonne formate ciascuna da 6 diversi tipi di tessere.");
			
			break;
			
		case 3:
			
			System.out.println("Quattro gruppi separati formati ciascuno da quattro tessere adiacenti dello"
					+ " stesso tipo (non necessariamente come mostrato in figura). Le tessere di un"
					+ " gruppo possono essere diverse da quelle di un altro gruppo.");
			
			break;
			
		case 4:
			
			System.out.println("Sei gruppi separati formati ciascuno da due tessere adiacenti dello stesso"
					+ "	tipo (non necessariamente come mostrato in figura). Le tessere di un gruppo"
					+ "	possono essere diverse da quelle di un altro gruppo.");
			
			break;
			
		case 5:
			
			System.out.println(" Tre colonne formate ciascuna da 6 tessere di uno, due o tre tipi differenti."
					+ "	Colonne diverse possono avere combinazioni diverse di tipi di tessere.");
			
			break;
			
		case 6:
	
			System.out.println("Due righe formate ciascuna da 5 diversi tipi di tessere.");
	
			break;
	
		case 7:
	
			System.out.println("Quattro righe formate ciascuna da 5 tessere di uno, due o tre tipi"
					+ "	differenti. Righe diverse possono avere combinazioni diverse di tipi di"
					+ "	tessere.");
	
			break;
			
		case 8:
			
			System.out.println("Quattro tessere dello stesso tipo ai quattro angoli della Libreria.");
			
			break;
			
		case 9:
			
			System.out.println("Otto tessere dello stesso tipo. Non ci sono restrizioni sulla posizione di"
					+ " queste tessere");
			
			break;
			
		case 10:
			
			System.out.println("Cinque tessere dello stesso tipo che formano una X.");
			
			break;
			
		case 11:
			
			System.out.println("Cinque tessere dello stesso tipo che formano una diagonale.");
			
			break;
			
		case 12:
			
			System.out.println("Cinque colonne di altezza crescente o decrescente: a partire dalla prima"
					+ " colonna a sinistra o a destra, ogni colonna successiva deve essere formata da"
					+ " una tessera in più. Le tessere possono essere di qualsiasi tipo.");
			
			break;
			
			default:
				System.out.println("non esiste un obiettivo con quel numero");
				
				
			
			
		}
	}
	
	/**
	 * lista obiettivi personali
	 */
	public void listaObPersonali(int numero) {
		switch(numero) {
		case 1:
			
		
		//completare mettendo le griglie coi colori in numeri
		//1
		System.out.println("1: 5 - 1 - -");
		System.out.println("2: - - - - 2");
		System.out.println("3: - - - 4 -");
		System.out.println("4: - 3 - - -");
		System.out.println("5: - - - - -");
		System.out.println("6: - - 6 - -");
		break;
		
		case 2:
		System.out.println("1: - - - - -");
		System.out.println("2: - 5 - - -");
		System.out.println("3: 2 - 3 - -");
		System.out.println("4: - - - - 4");
		System.out.println("5: - - - 6 -");
		System.out.println("6: - - - - 1");
		
		break;
		
		case 3:
		System.out.println("1: - - - - -");
		System.out.println("2: 1 - - 3 -");
		System.out.println("3: - - 5 - -");
		System.out.println("4: - 2 - - 6");
		System.out.println("5: - - - - -");
		System.out.println("6: 4 - - - -");
		
		break;
		
		case 4:
		//4
		System.out.println("1: - - - - 3");
		System.out.println("2: - - - - -");
		System.out.println("3: 6 - 1 - -");
		System.out.println("4: - - - 5 -");
		System.out.println("5: - 4 2 - -");
		System.out.println("6: - - - - -");
		
		break;
		
		case 5:
		
		//5
		System.out.println("1: - - - - -");
		System.out.println("2: - 6 - - -");
		System.out.println("3: - - - - -");
		System.out.println("4: - 1 4 - -");
		System.out.println("5: - - - - 5");
		System.out.println("6: 3 - - 2 -");
		
		break;
		
		case 6:
		
		//6
		System.out.println("1: - - 6 - 2");
		System.out.println("2: - - - - -");
		System.out.println("3: - - - 4 -");
		System.out.println("4: - - - - -");
		System.out.println("5: - 3 - 1 -");
		System.out.println("6: 5 - - - -");
		
		break;
		
		case 7:
		//7
		System.out.println("1: 2 - - - -");
		System.out.println("2: - - - 1 -");
		System.out.println("3: - 5 - - -");
		System.out.println("4: 6 - - - -");
		System.out.println("5: - - - - 3");
		System.out.println("6: - - 4 - -");
		
		break;
		
		case 8:
		//8
		System.out.println("1: - - - - 1");
		System.out.println("2: - 2 - - -");
		System.out.println("3: - - 6 - -");
		System.out.println("4: 5 - - - -");
		System.out.println("5: - - - 4 -");
		System.out.println("6: - - - 3 -");
		
		break;
		
		case 9:
		//9
		System.out.println("1: - - 3 - -");
		System.out.println("2: - - - - -");
		System.out.println("3: - - 2 - -");
		System.out.println("4: - - - - 4");
		System.out.println("5: - 6 - - 5");
		System.out.println("6: 1 - - - -");
		
		break;
		
		case 10:
		//10
		System.out.println("1: - - - - 6");
		System.out.println("2: - 3 - - -");
		System.out.println("3: 4 - - - -");
		System.out.println("4: - - - 2 -");
		System.out.println("5: - 1 - - -");
		System.out.println("6: - - - 5 -");
		
		break;
		
		case 11:
		//11
		System.out.println("1: - - 5 - -");
		System.out.println("2: - 4 - - -");
		System.out.println("3: 3 - - - -");
		System.out.println("4: - - 1 - -");
		System.out.println("5: - - - - 2");
		System.out.println("6: - - - 6 -");
		
		break;
		
		case 12:
		//12
		System.out.println("1: - - 4 - -");
		System.out.println("2: - 5 - - -");
		System.out.println("3: - - 1 - -");
		System.out.println("4: - - - 6 -");
		System.out.println("5: - - - - 3");
		System.out.println("6: 2 - - - -");
		
		break;
		
		default:
			System.out.println("non esiste un obiettivo con quel numero");
		}
	}
	
	
	/**
	 * regola dei tiles adiacenti
	 */
	public void puntiTilesAdiacenti() {
		System.out.println("a fine gioco, in base ai raggruppamenti (non vuoti) adiacenti dello stesso colore \n"
						 + "riceverai i seguenti punti: 3 tiles- 2 punti; 4 tiles- 3 punti; 5 tiles- 5 punti  \n"
						 + "6 o più tiles- 8 punti");
	}
}
