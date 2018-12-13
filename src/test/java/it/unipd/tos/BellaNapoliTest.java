////////////////////////////////////////////////////////////////////
// Matteo Ranzato 1153767
////////////////////////////////////////////////////////////////////

package it.unipd.tos;

import it.unipd.tos.business.BellaNapoli;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.itemType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BellaNapoliTest {
    private MenuItem food1 = new MenuItem(itemType.PIZZA, "margherita",4);
    private MenuItem food2 = new MenuItem(itemType.PIZZA, "diavola",5.50);
    private MenuItem food3 = new MenuItem(itemType.PIZZA, "viennese",5);
    private MenuItem food4 = new MenuItem(itemType.PRIMO, "spaghetti carbonara",9.60);
    private MenuItem food5 = new MenuItem(itemType.PRIMO, "risotto gamberi",11);
    private MenuItem food6 = new MenuItem(itemType.PRIMO, "bucatini matriciana",8.90);
    private MenuItem food7 = new MenuItem(itemType.PRIMO, "pasta ragu",6);
    private MenuItem food8 = new MenuItem(itemType.PIZZA, "capricciosa",7.20);
    private MenuItem food9 = new MenuItem(itemType.PIZZA, "verdure",6);
    private MenuItem food10 = new MenuItem(itemType.PRIMO, "pasta del piovego",98);

    BellaNapoli napoli;

    @Before
    public void createBill(){
        napoli = new BellaNapoli();
    }

    @Test
    public void testEmptyBill() throws RestaurantBillException {
        assertEquals(0, napoli.getOrderPrice(new ArrayList<MenuItem>()),0);
    }

    @Test(expected = RestaurantBillException.class)
    public void testMoreThan20Items() throws RestaurantBillException{
        List<MenuItem> lista = new ArrayList<>();

        lista.addAll(Arrays.asList(food2,food2,food2,food2,food2,food2,food2,food2,
                food2,food2,food2,food2,food2,food2,food2,food2,food2,
                food2,food2,food2,food2,food2));
        napoli.getOrderPrice(lista);
    }

    @Test
    public void testDiscountOver100Euros() throws RestaurantBillException{
        List<MenuItem> lista = new ArrayList<>();

        lista.addAll(Arrays.asList(food10,food3));
        assertEquals(97.85,napoli.getOrderPrice(lista),0.001);
    }

    @Test
    public void testOrderedMoreThan10Pizzas() throws RestaurantBillException {
        List<MenuItem> lista = new ArrayList<>();

        lista.addAll(Arrays.asList(food2,food2,food2,food2,food2,food2,food2,food2,
                food2,food2,food2,food2));
        assertEquals(60.50, napoli.getOrderPrice(lista),0);
    }
}
