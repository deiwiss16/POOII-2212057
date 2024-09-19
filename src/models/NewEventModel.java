/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewEventModel {
    private static final String DIRECTORY = ".";
    private static final String FILE = "events.txt"; // conexion //service API
    
    public void saveEvent(Event event) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(DIRECTORY, FILE),true));
            
            writer.write(
                event.getEventDescription() + ";" + 
                event.getForwardEmail() + ";" + 
                sdf.format(event.getDate()) + ";" + 
                event.getFrequency()+ ";" + 
                event.getAlarm()
            );
            writer.newLine();
            writer.close();
        } catch(FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
        } catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }

    // aqui iria el metodo para obtener los events de un txt
    /*public List<Event> getEvents() {
        List<Event> eventList = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(DIRECTORY, FILE)));
            String linea  = reader.readLine();
            while (linea != null) {
                String[] eventDetails = linea.split(";");
                if (eventDetails.length == 5) {
                    String eventDescription = eventDetails[0];
                    String forwardEmail = eventDetails[1];
                    
                    String dateString = eventDetails[2];
                    Date date = SchedulerUtil.getDateFromString(dateString);
                    
                    String frequency = eventDetails[3];
                    boolean alarm = Boolean.parseBoolean(eventDetails[4]);
                    Event event = new Event(eventDescription, forwardEmail, date, frequency, alarm);
                    eventList.add(event);
                }
            }
            reader.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        return eventList;
    }*/
}
