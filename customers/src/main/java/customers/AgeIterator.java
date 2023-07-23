package customers;

import java.util.*;

public class AgeIterator implements Iterator {
    private final List<Customer> list;
    private int position;

    public AgeIterator(List list) {
        this.list = list;
        this.position = 0;
        Collections.sort(list, Comparator.comparing(Customer::getAge));
    }

    @Override
    public boolean hasNext() {
        return list.size()-1 > position;
    }

    @Override
    public Customer next() {

        return list.get(position++);
    }
}
