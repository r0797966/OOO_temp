package model.observer;

import model.facade.MetroEventsEnum;
import model.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    List<Observer> observers = new ArrayList<Observer>();

    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(MetroEventsEnum event);
}
