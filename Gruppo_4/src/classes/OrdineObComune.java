package classes;

import java.util.ArrayList;

public class OrdineObComune {
	public ArrayList<Integer> numeroGiocatore;
	public int numeroTotaleGiocatori;
	
	
	public OrdineObComune(int numeroTotaleGiocatori){
		this.numeroTotaleGiocatori=numeroTotaleGiocatori;
		ArrayList<Integer> numeroGiocatore=new ArrayList<Integer>();
	}
	
	public int punteggioCorrispondente(int IDgiocatore){
		switch(numeroTotaleGiocatori){
		case 2:
			if(numeroGiocatore==null) {
				this.numeroGiocatore.add(IDgiocatore);
				return 8;
			} else if(numeroGiocatore.size()==1) {
				this.numeroGiocatore.add(IDgiocatore);
				return 4;
			}
			
		case 3:
			if(numeroGiocatore==null) {
				this.numeroGiocatore.add(IDgiocatore);
				return 8;
			} else if(numeroGiocatore.size()==1) {
				this.numeroGiocatore.add(IDgiocatore);
				return 6;
			} else if(numeroGiocatore.size()==2) {
				this.numeroGiocatore.add(IDgiocatore);
				return 4;
			}
		
		case 4:
			if(numeroGiocatore==null) {
				this.numeroGiocatore.add(IDgiocatore);
				return 8;
			} else if(numeroGiocatore.size()==1) {
				this.numeroGiocatore.add(IDgiocatore);
				return 6;
			} else if(numeroGiocatore.size()==2) {
				this.numeroGiocatore.add(IDgiocatore);
				return 4;
			}  else if(numeroGiocatore.size()==3) {
				this.numeroGiocatore.add(IDgiocatore);
				return 2;
			}
			
			
		}
		//in caso di errore
		return 0;
		
		
		
	}
	
}
