package classes;

import java.util.Scanner;

public class Regolamento {
	
	
	/**
	 * scegliere una regola in generale
	 */
	public void scegliRegola() {
		System.out.println("sei nella sezione del regolamento del gioco: selezionare uno dei seguenti indici per le istruzioni");
		System.out.println(" 1-regole generali del gioco \n 2-corrisopndenza tra numero e tassello "
				+ "\n 3-visualizzazione obiettivi comuni" + "\n 4- visualizzazione obiettivi personali "
				+ "\n 5- sistema punti delle tiles adiacenti \n ?- (numero diverso dai sopracitati) uscire dal menù di selezione");
		Scanner sc=new Scanner(System.in);
		sc.reset();
		int menu=sc.nextInt();
		switch(menu) {
		case 1:
			regoleGenerali();
			break;
		case 2:
			numeroAColore();
			break;
		case 3:
			listaObComuni();
			break;
		case 4:
			listaObPersonali();
			break;
		case 5:
			puntiTilesAdiacenti();
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
	public void listaObComuni() {
		System.out.println("viene assegnato un punteggio in base all'ordine di competamento degli obiettivi comuni");
		System.out.println("    2 giocatori: 1° - 8 punti;  2° - 4 punti");
		System.out.println("    3 giocatori: 1° - 8 punti;  2° - 6 punti; 3° - 4 punti");
		System.out.println("    4 giocatori: 1° - 8 punti;  2° - 6 punti; 3° - 4 punti; 4° - 2 punti");
		
		// completare
	}
	
	/**
	 * lista obiettivi personali
	 */
	public void listaObPersonali() {
		//completare mettendo le griglie coi colori in numeri
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
