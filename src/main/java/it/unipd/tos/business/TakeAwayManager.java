////////////////////////////////////////////////////////////////////
// [Matteo] [Lattanzio] [1169566]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class TakeAwayManager implements TakeAwayBill{
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        double total = 0.0;
        int nrPanini = 0;
        double paninoLessExpensive = Double.MAX_VALUE;

        for (MenuItem menuItem : itemsOrdered) {
            total += menuItem.getPrice();

            if(menuItem.getType() == MenuItem.items.Panino){
                nrPanini++;
                if(paninoLessExpensive > menuItem.getPrice()){
                    paninoLessExpensive = menuItem.getPrice();
                }
            }
        }

        if(nrPanini > 5){
            total = total - (paninoLessExpensive/2); 
        }

        return total;
    }
}