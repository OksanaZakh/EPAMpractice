package com.oksana.zakharchenko.dictionary;

public class DictionaryRunner {
    private Dictionary dictionary;
    private ScannerInput scanner;

    public DictionaryRunner() {
        dictionary = new Dictionary();
        scanner=new ScannerInput();
    }

    public void run() {
        boolean quit = false;
        printMenu();
        while (!quit) {
            int action = scanner.inputIntValueWithScanner();
            scanner.goForward();
            switch (action) {
                case 0:
                    System.out.println("Good bye!");
                    quit = true;
                    break;
                case 1:
                    addNewWords();
                    break;
                case 2:
                    translatePhrase();
                    break;
                case 3:
                    printDictionary();
                    break;
                case 4:
                    printMenu();
                    break;
                default:
                    System.out.println("Please enter the number in range 0-4");
                    printMenu();
                    break;
            }
        }


    }

    private void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - add new words\n" +
                "2 - translate the phrase\n" +
                "3 - get all words and its translations in dictionary\n" +
                "4 - print available actions.\n");
    }

    private void addNewWords(){
        System.out.println("Please enter english word you are going to add");
        String en=scanner.inputStringWithScanner();
        System.out.println("Please add russian translation of this word");
        String rus=scanner.inputStringWithScanner();
        if(dictionary.addWords(en, rus)){
            System.out.println("Done!");
        }else{
            System.out.println("This words already exist");
        }
    }

    private void printDictionary(){
        System.out.println("Dictionary:");
        for (String en: dictionary.getDictionary().keySet()){
            System.out.println(en+" -> "+dictionary.getDictionary().get(en));
        }
    }

    private void translatePhrase() {
        System.out.println("Please enter the phrase for translation!");
        String output = "";
        String input = scanner.inputStringWithScanner();
        String[] phrase = input.split(" ");
        for (String str : phrase) {
            if (dictionary.getTranslation(str) != null) {
                output = output + dictionary.getTranslation(str) + " ";
            }
        }
        System.out.println("Translation: " + output);
    }


}
