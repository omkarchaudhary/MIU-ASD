package customers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class CustomerCollection {
	List<Customer> customers = new ArrayList<Customer>();
	
	public void add(Customer customer) {
		customers.add(customer);
	}
	
	public void print() {
		Iterator<Customer> iterator = ageIteraotor();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

	public Iterator<Customer> ageIteraotor(){
		return  new AgeIterator(customers);
	}

	public void printFilterIterator(Predicate<Customer> predicate){
		Iterator<Customer> iterator = filterIterator(predicate);
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

	public Iterator<Customer> filterIterator(Predicate<Customer> predicate){
		return new FilterIterator(customers,predicate);
	}

	public void printSkipCustomer() {
		Iterator<Customer> iterator = skipIteraotor();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

	public Iterator<Customer> skipIteraotor(){
		return  new SkipIterator(customers);
	}

}
