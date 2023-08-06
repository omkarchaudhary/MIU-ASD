package state;

import counter.Counter;

public class ThirdCounter implements CounterState {
    private Counter counter;

    public ThirdCounter(Counter counter) {
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

    private void setNextCounter() {
        if (String.valueOf(counter.getCount()).length() == 1) {
            OneCounter oneCounter = new OneCounter(counter);
            counter.setCounterState(oneCounter);
        }
        if (String.valueOf(counter.getCount()).length() == 2) {
            TwoCounter twoCounter = new TwoCounter(counter);
            counter.setCounterState(twoCounter);
        }
        System.out.println(counter);
    }
}
