package mvcfigures;


import mvcfigures.Model.ModelManager;

public class Controller {
    ModelManager modelManager;
    View view;
    Utils utils;

    public Controller(ModelManager modelManager, View view) {
        this.modelManager = modelManager;
        this.view = view;
        utils = new Utils(view);
    }


    public void run() {
        boolean quit = false;
        view.printMenu();
        while (!quit) {
            int action = utils.inputIntValueWithScanner();
            utils.goForward();
            switch (action) {
                case 0:
                    view.printData(Constants.EXIT);
                    quit = true;
                    break;
                case 1:
                    view.printArray(modelManager.getShapes());
                    break;
                case 2:
                    view.printData(modelManager.calculateTotalArea() + "");
                    break;
                case 3:
                    getAreaOfParticularShape();
                    break;
                case 4:
                    getSortedByAreaArray();
                    break;
                case 5:
                    getSortedByColorArray();
                    break;
                case 6:
                    view.printMenu();
                    break;
                default:
                    view.printData(Constants.NUMBERS_IN_RANGE);
                    view.printMenu();
                    break;
            }
        }
    }

    private void getAreaOfParticularShape() {
        view.printData(Constants.AVAILABLE_SHAPES);
        String name = "";
        switch (utils.inputIntValueWithScanner()) {
            case 1:
                name = Constants.CIRCLE;
                System.out.println(name);
                break;
            case 2:
                name = Constants.RECTANGLE;
                System.out.println(name);
                break;
            case 3:
                name = Constants.TRIANGLE;
                System.out.println(name);
        }
        view.printData(modelManager.calculateAreaOfParticularShape(name) + "");
    }

    private void getSortedByAreaArray() {
        view.printData(Constants.SORTED_BY_AREA);
        view.printArray(modelManager.sortByArea());
    }

    private void getSortedByColorArray() {
        view.printData(Constants.SORTED_BY_COLORS);
        view.printArray(modelManager.sortByColor());
    }
}
