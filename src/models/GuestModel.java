package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class GuestModel {
    private static final String DIRECTORY = ".";
    private static final String FILE = "guests.txt";
    
    public void saveGuest(Guest guest) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(DIRECTORY, FILE),true));
            
            writer.write(
                guest.getNombre() + ";" + 
                guest.getNumero() + ";" + 
                guest.getGenero() + ";" + 
                sdf.format(guest.getDate())+ ";" + 
                guest.getDireccion() + ";" +
                guest.getTerminosCondiciones()
            );
            writer.newLine();
            writer.close();
        } catch(FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
        } catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}
