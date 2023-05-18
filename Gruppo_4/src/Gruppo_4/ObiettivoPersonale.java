import java.util.Random;


public class ObiettivoPersonale { //va chiamato per ogni giocatore

	public static int[][] generaMatriceZeri() {
		int[][] obiettivoPersonale = new int[5][6];
		 
		for (int i = 0; i < 5; i++) {	//crea una matrice 6*5 di zeri
			for (int j = 0; j < 6; j++) {
				obiettivoPersonale[i][j] = 0;
			}
		}


	        int cont=1; //identificativo della tessera
	        while(cont<7) {
	        	Random rand = new Random();
	        	int riga = rand.nextInt(7);
	        	int colonna = rand.nextInt(6);
	        	
	        	while(obiettivoPersonale[riga][colonna]==0) {
	        		obiettivoPersonale[riga][colonna] = cont;
	        		cont++;
	        	}
	        }
	        
		return obiettivoPersonale;
	}
}