import mvcpatients.Controller;
import mvcpatients.Model.Model;
import mvcpatients.View;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new View(), new Model());
        controller.processPatients();
    }
}
