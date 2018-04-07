import javafx.stage.DirectoryChooser;
import mvcpatients.Controller;
import mvcpatients.Model.Model;
import mvcpatients.View;

import javax.naming.spi.DirectoryManager;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new View(), new Model());
        controller.processPatients();

    }
}
