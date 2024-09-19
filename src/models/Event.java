package models;

import java.util.Date;

public class Event {
    private String eventDescription;
    private String forwardEmail;
    private Date date;
    private String frequency;
    private boolean alarm;

    public Event() {
    }
    public Event(String eventDescription, String forwardEmail, Date date, String frequency, boolean alarm) {
        this.eventDescription = eventDescription;
        this.forwardEmail = forwardEmail;
        this.date = date;
        this.frequency = frequency;
        this.alarm = alarm;
    }
    
    public String getEventDescription() {
        return eventDescription;
    }
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getForwardEmail() {
        return forwardEmail;
    }
    public void setForwardEmail(String forwardEmail) {
        this.forwardEmail = forwardEmail;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getFrequency() {
        return frequency;
    }
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    
    public boolean getAlarm() {
        return alarm;
    }
    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }
}
