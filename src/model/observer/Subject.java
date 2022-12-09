package model.observer;

import model.facade.MetroEventsEnum;
import model.observer.Observer;

public interface Subject {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(MetroEventsEnum event);

}
