
import mvcpatients.Controller;
import mvcpatients.Model.Model;
import mvcpatients.Utils.LogMassages;
import mvcpatients.View;
import org.apache.log4j.Logger;


public class Main {
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info(LogMassages.START);
        Controller controller = new Controller(new View(), new Model());
        controller.processPatients();
    }
}
