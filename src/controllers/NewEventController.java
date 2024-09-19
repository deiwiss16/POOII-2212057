package controllers;

import core.Controller;
import models.Event;
import models.NewEventModel;
import views.NewEventView;

public class NewEventController extends Controller{
    private NewEventView newEventView;
    
    public NewEventController() {
    }
    
    @Override
    public void run() {
        newEventView = new NewEventView(this);
    }
    public void addEvent(Event event) {
        NewEventModel newEventModel = new NewEventModel();
        newEventModel.saveEvent(event);
    }    
    public NewEventView getView(){
        return newEventView;
    }
}
