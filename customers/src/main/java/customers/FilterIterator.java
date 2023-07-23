package customers;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class FilterIterator implements Iterator {
    private final List<Customer> list;
    private int position;
    private Predicate<Customer> predicate;

    public FilterIterator(List<Customer> list, Predicate<Customer> predicate) {
        this.list = list;
        this.predicate = predicate;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        int tempPosition = position;
        while(tempPosition < list.size()){
            Customer nextCustomer = list.get(tempPosition);
            if(predicate.test(nextCustomer)){
                return true;
            }else{
                tempPosition++;
            }
        }
        return false;
    }

    @Override
    public Customer next() {
        int tempPosition = position;
        while(tempPosition < list.size()){
            Customer nextCustomer = list.get(tempPosition);
            if(predicate.test(nextCustomer)){
                position=tempPosition+1;
                return nextCustomer;
            }else{
                tempPosition++;
            }
        }
        return null;
    }
}
