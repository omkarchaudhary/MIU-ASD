package counter;

import java.util.ArrayList;
import java.util.Collection;

public class Subject {
    Collection<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notify(int count){
        for(Observer observer: observers){
            observer.update(count);
        }
    }
}
