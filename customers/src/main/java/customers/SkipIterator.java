package customers;

import java.util.Iterator;
import java.util.List;

public class SkipIterator implements Iterator {
    private final List<Customer> list;
    private int position;

    public SkipIterator(List<Customer> list) {
        this.list = list;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return list.size()-1 > position;
    }

    @Override
    public Customer next() {
        position = position+2;
        return list.get(position);
    }
}
