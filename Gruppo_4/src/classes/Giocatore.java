
package classes;

import java.util.Scanner;


public class Giocatore {
    public static int ID;
    public String nome;
    public ObiettivoPersonale obiettivoPersonale;
    public Shelf shelf;
    public Punti puntiGiocatore;
    public boolean flagObiettivoComune;

    public Giocatore(int ID, int numeroObiettivoPersonale) {
        Scanner sc = new Scanner(System.in);
        sc.reset();
        Giocatore.ID = ID;
        System.out.println("Inserire il nome del giocatore " + ID + ": ");
        this.nome = sc.nextLine();
        this.obiettivoPersonale = new ObiettivoPersonale(numeroObiettivoPersonale);
        this.shelf = new Shelf();
        this.puntiGiocatore = new Punti();
        this.flagObiettivoComune=true;
    }
}