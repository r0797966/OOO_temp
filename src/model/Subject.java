package model;

import model.facade.MetroEventsEnum;

public interface Subject {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(MetroEventsEnum event);

}
