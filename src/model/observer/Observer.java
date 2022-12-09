package model.observer;

import model.facade.MetroEventsEnum;

public interface Observer {
    void update(MetroEventsEnum event);
}
