package it.unipd.tos.business;

import it.unipd.tos.business.TakeAwayManager;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TakeAwayManagerTest{
    @Test
    public void SimpleTotalSumOfItems_Test(){
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        TakeAwayManager testBill = new TakeAwayManager();

        itemsOrdered.add(new MenuItem("Panino primavera", MenuItem.items.Panino, 4.00));
        itemsOrdered.add(new MenuItem("Coca cola", MenuItem.items.Bevanda, 1.50));
        itemsOrdered.add(new MenuItem("Patatine fritte", MenuItem.items.Fritto, 2.50));

        try{
            assertEquals(8.00, testBill.getOrderPrice(itemsOrdered), 0.0);
        } 
        catch (TakeAwayBillException exc){
            exc.getMessage();
        }
    }

    @Test
    public void HalfDiscountLessExpensivePaninoWith5PlusPaninoOrder_Test() throws TakeAwayBillException{
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        TakeAwayManager testBill = new TakeAwayManager();

        itemsOrdered.add(new MenuItem("Panino primavera", MenuItem.items.Panino, 4.00));
        itemsOrdered.add(new MenuItem("Coca cola" , MenuItem.items.Bevanda, 1.50));
        itemsOrdered.add(new MenuItem("Panino vegetariano", MenuItem.items.Panino, 3.50));
        itemsOrdered.add(new MenuItem("Hot dog" , MenuItem.items.Panino, 4.00));
        itemsOrdered.add(new MenuItem("Olive ascolane" , MenuItem.items.Fritto, 3.00));
        itemsOrdered.add(new MenuItem("Panino primavera", MenuItem.items.Panino, 4.00));
        itemsOrdered.add(new MenuItem("Coca cola" , MenuItem.items.Bevanda, 1.50));
        itemsOrdered.add(new MenuItem("Panino vegetariano", MenuItem.items.Panino, 3.50));
        itemsOrdered.add(new MenuItem("Hot dog" , MenuItem.items.Panino, 4.00));
        itemsOrdered.add(new MenuItem("Olive ascolane" , MenuItem.items.Fritto, 3.00));

        try {
            assertEquals(30.25, testBill.getOrderPrice(itemsOrdered), 0.0);
        } 
        catch (TakeAwayBillException exc){
            exc.getMessage();
        }
    }
}