////////////////////////////////////////////////////////////////////
// [Matteo] [Lattanzio] [1169566]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class TakeAwayManager implements TakeAwayBill {
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        double totalFood = 0.0;
        double totalDrink = 0.0;
        int nrPanini = 0;
        double paninoLessExpensive = Double.MAX_VALUE;

        for (MenuItem menuItem : itemsOrdered) {
            if(menuItem.getType() == MenuItem.items.Bevanda) {
                totalDrink += menuItem.getPrice();
            }
            else {
                totalFood += menuItem.getPrice();
            }

            if(menuItem.getType() == MenuItem.items.Panino) {
                nrPanini++;
                if(paninoLessExpensive > menuItem.getPrice()) {
                    paninoLessExpensive = menuItem.getPrice();
                }
            }
        }

        if(itemsOrdered.size() > 30){
            throw new TakeAwayBillException("Non ci possono essere più di 30 elementi nell'ordine");
        }

        if(nrPanini > 5){
            totalFood -= (paninoLessExpensive/2); 
        }

        if(totalFood > 50.0){
            totalFood -= (totalFood*0.1);
        }

        return totalDrink + totalFood;
    }
}