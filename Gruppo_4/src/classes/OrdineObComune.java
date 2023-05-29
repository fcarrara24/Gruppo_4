package classes;

import java.util.ArrayList;

public class OrdineObComune {
	public int numeroTotaleGiocatori;
	public int ordineCompletamento;
	
	public OrdineObComune(int numeroTotaleGiocatori){
		this.numeroTotaleGiocatori=numeroTotaleGiocatori;
		this.ordineCompletamento=0;
	}
	
	public int punteggioCorrispondente(){
		switch(numeroTotaleGiocatori){
		case 2:
			if(ordineCompletamento==0) {
				ordineCompletamento++;
				return 8;
			} else if(ordineCompletamento==1) {
				ordineCompletamento++;
				return 4;
			}
			
		case 3:
			if(ordineCompletamento==0) {
				ordineCompletamento++;
				return 8;
			} else if(ordineCompletamento==1) {
				ordineCompletamento++;
				return 6;
			} else if(ordineCompletamento==2) {
				ordineCompletamento++;
				return 4;
			}
		
		case 4:
			if(ordineCompletamento==0) {
				ordineCompletamento++;
				return 8;
			} else if(ordineCompletamento==1) {
				ordineCompletamento++;
				return 6;
			} else if(ordineCompletamento==2) {
				ordineCompletamento++;
				return 4;
			} else if(ordineCompletamento==3) {
				ordineCompletamento++;
				return 2;
			}
			
			
		}
		//in caso di errore
		return 0;
		
		
		
	}
	
}
