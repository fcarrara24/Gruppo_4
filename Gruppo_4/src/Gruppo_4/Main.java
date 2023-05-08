package Gruppo_4;

public class Main {

	public static void main(String[] args) {
		int numeroGiocatori;
		String nickname;
		int numeroDelGiocatore=1;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Quante persone giocano? [2,3 o 4]");
			numeroGiocatori = sc.nextInt();
		}while(numeroGiocatori<2||numeroGiocatori>4);
		
		Giocatore[] g = new Giocatore[numeroGiocatori];
		
		for(int i=0;i<numeroGiocatori;i++) {
			System.out.println("Inserisci il nickname del giocatore " + numeroDelGiocatore);
			numeroDelGiocatore++;
			nickname = sc.next();
			g[i] = new Giocatore(nickname, numeroGiocatori);
		}
		
		System.out.println("ELENCO PARTECIPANTI:");
		for(int q=0;q<numeroGiocatori;q++) {
			System.out.println(g[q].toString());
		}
		sc.close();
	}

	}

}
