package core;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Controller {
    protected static final JFrame mainFrame = new JFrame();
    private static final JPanel viewsViewer = new JPanel(new CardLayout());
    
    {
        mainFrame.add(viewsViewer);
    }
    
    public abstract void run();
    public static void addView(String viewName, Component view){
        viewsViewer.add(view, viewName);
    }
    
}
