////////////////////////////////////////////////////////////////////
// Matteo Ranzato 1153767
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {
    private itemType tipo;
    private String nome;
    private double prezzo;

    public MenuItem(itemType t, String n, double p){
        tipo = t;
        nome = n;
        prezzo = p;
    }

    public double getPrice(){
        return prezzo;
    }
    public itemType getType(){
        return tipo;
    }
}
