import controllers.HomeController;
import core.Controller;

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Controller c = new HomeController();
        c.run();
    }
}
