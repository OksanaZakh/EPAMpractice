package com.company;

import com.company.mvcfigures.Controller;
import com.company.mvcfigures.Model.ModelManager;
import com.company.mvcfigures.View;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new ModelManager(), new View());
        controller.run();
    }
}
