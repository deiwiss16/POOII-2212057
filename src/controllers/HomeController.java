package controllers;

import core.Controller;
import views.EventListView;
import views.HomeView;
import views.NewEventView;
import views.NewGuestView;

public class HomeController extends Controller{
    private final NewEventController newEventController = new NewEventController();
    private final EventListController eventListController = new EventListController();
    private final NewGuestController newGuestController = new NewGuestController();
    
    @Override
    public void run() {
        newEventController.run();
        eventListController.run();
        newGuestController.run();
        
        
        HomeView homeView = new HomeView(this, mainFrame);
        addView("Home", homeView);
        mainFrame.setVisible(true);
    }
    
    public NewEventView getNewEventView() {
        return newEventController.getView();
    }
    public EventListView getEventListView() {
        return eventListController.getView();
    }
    public NewGuestView getNewGuestView() {
        return newGuestController.getView();
    }
}
