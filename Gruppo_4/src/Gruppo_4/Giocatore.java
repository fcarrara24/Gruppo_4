package Progetto_gruppo_4; 

import java.util.Scanner;

public class Giocatore {
	private static int COUNTER=1;
	private final int id;
	private String nickname;
	private int numGiocatore;
	
	public Giocatore(String nickname, int numGiocatore) {
		this.nickname = nickname;
		this.numGiocatore = numGiocatore;
		this.id= COUNTER;
		COUNTER ++;
	}
	
	public String toString() {
		return "Il giocatore inserito è: " + nickname + ", il suo numero è il: " + numGiocatore + ", il suo Id è: " + id;
	}
	
	public String insertName() {
		Scanner scanner;

		scanner = new Scanner(System.in);
		
		
		
		scanner.close();
		
		return "";
		

	}
	
	
}
// per ora lìoperazione è tutto ok
