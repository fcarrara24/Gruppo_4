package myshelfie;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Grigliapersonale {
	
				
				
			      
			         
			      

	
		   public static void main(String[] args) {
			   Scanner input = new Scanner(System.in);
			   
			   
			   int righe =6;
			   int colonne =5;
			   
			   int[][] matrice = new int[righe][colonne];
			   
			   for (int r = 0; r < righe; r++) {
		            for (int c = 0; c < colonne; c++) {
		                matrice[r][c] = 0;
		            }
			   }
			   System.out.println("la tua libreria è:");
		        stampaMatrice(matrice);
		        
		        //ce da spostare di 1 i numeri perche prende da 0 a 4 
		        System.out.println("scegli il numero della colonna che vuoi utilizzare da 1-5");
				int ColonnaScelta = input.nextInt();
				
				System.out.println("Gli elementi nella colonna " + ColonnaScelta + " sono:");
		        for (int riga = 0; riga < 6; riga++) {
		            System.out.println(matrice[riga][ColonnaScelta]);
		        }
				
		        int indiceUltimoZero = trovaUltimoZeroColonna(matrice, ColonnaScelta);
		        
		        System.out.println("Indice ultimo zero: " + indiceUltimoZero);
		        
		        
		        //inserire metodo per ottenere valori
		        
		        int [] numeri =Carte.getNumeri();
		        
		        for (int i= indiceUltimoZero; i>= 0 ; i-- ) {
		        	
		        
		        
		        System.out.println("inserici il valore nella casella: " + i );
		        }
		        while (true) {
		        System.out.println("scegli quale di questi valori mettere: " + Arrays.toString(numeri));
		        
		 
		        int ValoreScelto =input.nextInt();
		        
		        
		        if (Arrays.asList(numeri).contains(ValoreScelto)) {
		        	matrice[indiceUltimoZero][ColonnaScelta]= ValoreScelto;
		        	break;
		        }
		        else { 
		        	System.out.println("il valore scelto non è compreso tra quelli disponibili scegliene uno tra quelli compresi");
		        }
		        
		        
		        
		        }
		        System.out.println("la tua libreria è:");
		        stampaMatrice(matrice);
		        
		        
		        
		        
		        
		        
		      
		        
		        
		        
		        
		        		
		        		
		        
		        	
		        
		        
	
		        
		        
		        	
		        
		        
		        
		        
		        
		        
		        		
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		   }
		        
		        
		        
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
		   public static int trovaUltimoZeroColonna(int[][] matrice, int colonna) {
			   int UltimoZero= -1;
			   for(int riga=0; riga<matrice.length; riga++ ) {
				  int cont = matrice.length-1 - riga;
				   if( matrice[cont][colonna]==0) {
					   UltimoZero=riga;
					   break;
					   
				   } 
			   }
				 return UltimoZero;  
			    
		   }
		   
		   
		   
			   
			   
			   
			   
			   
			   
			   
			   
		        public static void stampaMatrice(int[][] matrice) {
		            for (int[] riga : matrice) {
		                for (int valore : riga) {
		                    System.out.print(valore + " ");
		                }
		                System.out.println();
		            }
		        }
		   

		   class Carte {
			    public static int[] getNumeri() {
			   
			        int[] numeri = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
			        
			        return numeri;
			    }
			}
		   
}
			   
		   
			   
			   
			   
			   
			   
			 
		
		
		
		
		
		   
		            
		      
		      
		   
		   
		   
