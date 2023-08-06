package counter;

import state.CounterState;

public class Counter extends Subject{
	
	private int count=0;

	private CounterState counterState;

	public void setCounterState(CounterState counterState) {
		this.counterState = counterState;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void increment(){
		count++;
    	donotify(count);
	}
	
	public void decrement(){
		count--;
    	donotify(count);
	}

}
