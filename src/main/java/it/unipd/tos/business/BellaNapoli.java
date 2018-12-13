////////////////////////////////////////////////////////////////////
// Matteo Ranzato 1153767
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.itemType;

import java.util.List;

public class BellaNapoli implements RestaurantBill{

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        if (itemsOrdered.size() > 20 ) {
            throw new RestaurantBillException("Non puoi ordinare più di 20 prodotti");
        }


        if (itemsOrdered.size() == 0) {
            return 0;
        }

        double totale = 0;

        totale = getPrezzoTotale(itemsOrdered);
        if (getPizzaNumber(itemsOrdered) > 10){
            totale -= getCheapestPizzaPrice(itemsOrdered);
        }
        if (totale >100){
            totale -= totale*0.05;
        }
        return totale;

    }


    double getPrezzoTotale (List<MenuItem> lista) {
        double price=0;
        for (MenuItem item : lista)
            price+= item.getPrice();
        return price;
    }

    int getPizzaNumber(List<MenuItem> lista){
        int number = 0;
        for(MenuItem pizza: lista){
            if (pizza.getType().equals(itemType.PIZZA)) {
                number++;
            }
        }
        return number;
    }

    double getCheapestPizzaPrice(List<MenuItem> lista){
        double price=100000000;
        for (MenuItem item:lista){
            if (item.getType().equals(itemType.PIZZA)){
                if (item.getPrice()<price) {
                    price = item.getPrice();
                }
            }
        }
        return price;
    }
}
