package state;

import counter.Counter;

public class OneCounter implements CounterState{

    private Counter counter;

    public OneCounter(Counter counter) {
        this.counter = counter;
    }

    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void increment() {
        int count = counter.getCount();
        count++;
        counter.setCount(count);
        setNextCounter();
    }

    @Override
    public void decrement() {
        int count = counter.getCount();
        count--;
        counter.setCount(count);
        setNextCounter();
    }

    private void setNextCounter(){
        if (String.valueOf(counter.getCount()).length() == 2) {
            TwoCounter twoCounter = new TwoCounter(counter);
            counter.setCounterState(twoCounter);
        }
        if (String.valueOf(counter.getCount()).length() == 3) {
            ThirdCounter thirdCounter = new ThirdCounter(counter);
            counter.setCounterState(thirdCounter);
        }
        System.out.println(counter);
    }
}
