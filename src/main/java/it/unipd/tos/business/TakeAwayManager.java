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

        for (MenuItem menuItem : itemsOrdered) {
            total += menuItem.getPrice();
        }
        
        return total;
    }
}