package model.observer;

import model.facade.MetroEventsEnum;

import java.io.IOException;

public interface Observer {
    void update(MetroEventsEnum event) throws IOException;
}
