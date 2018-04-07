import mvcfigures.Controller;
import mvcfigures.Model.ModelManager;
import mvcfigures.View;

public class Main {
    public static void main(String[] args){

        Controller controller = new Controller(new ModelManager(), new View());
        controller.run();
    }
}
