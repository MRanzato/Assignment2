////////////////////////////////////////////////////////////////////
// Matteo Ranzato 1153767
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class RestaurantBillException extends Exception{
    public String message;
    public RestaurantBillException(String m){
        message=m;
        System.out.println(message);
    }
}
