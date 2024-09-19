package controllers;

import core.Controller;
import models.Guest;
import models.GuestModel;
import views.NewGuestView;

public class NewGuestController extends Controller{
    private NewGuestView newGuestView;
    
    public NewGuestController() {
        
    }
    
    @Override
    public void run() {
        newGuestView = new NewGuestView(this);
    }
    
    public void addGuest(Guest guest) {
        GuestModel guestModel = new GuestModel();
        guestModel.saveGuest(guest);
    }
    public NewGuestView getView() {
        return newGuestView;
    }
}
