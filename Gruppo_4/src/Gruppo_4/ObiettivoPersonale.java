import java.util.Random;


public class ObiettivoPersonale { 

	public static int[][] generaObiettivoPersonale() {	//va chiamato per ogni giocatore
		int[][] obiettivoPersonale = new int[5][6];
		 
		for (int i = 0; i < 5; i++) {	//crea una matrice 6*5 di zeri
			for (int j = 0; j < 6; j++) {
				obiettivoPersonale[i][j] = 0;
			}
		}


	        int cont=1; //identificativo della tessera
	        while(cont<7) {
	        	Random rand = new Random();
	        	int riga = rand.nextInt(5);
	        	int colonna = rand.nextInt(6);
	        	
	        	while(obiettivoPersonale[riga][colonna]==0) {
	        		obiettivoPersonale[riga][colonna] = cont;
	        		cont++;
	        	}
	        }
	        
		return obiettivoPersonale;
	}
}

//parte che andra messa nel main che mostra al giocatore il suo obiettivo personale (da associare al giocatore)
public class MainProva {
    public static void main(String[] args) {
        int[][] obiettivoPersonale = ObiettivoPersonale.generaObiettivoPersonale();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(obiettivoPersonale[i][j] + " ");
            }
            System.out.println();
        }
    }
}
