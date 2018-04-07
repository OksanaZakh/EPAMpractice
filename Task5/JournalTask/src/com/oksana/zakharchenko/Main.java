package com.oksana.zakharchenko;

import com.oksana.zakharchenko.journalmvc.Controller;
import com.oksana.zakharchenko.journalmvc.JornalModel.ModelManager;
import com.oksana.zakharchenko.journalmvc.View;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new ModelManager(), new View());
        controller.run();
    }
}
