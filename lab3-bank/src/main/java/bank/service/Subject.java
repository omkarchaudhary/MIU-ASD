package bank.service;

import bank.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class Subject {
    private Collection<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyObserver(Account account){
        for(Observer observer : observers){
            observer.update(account);
        }
    }
}
