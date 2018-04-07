package com.oksana.zakharchenko.journalmvc.JornalModel;

public class ModelManager {
    private Journal journal;

    public ModelManager() {
        this.journal = new Journal();
    }

    public boolean addEntry(JournalEntry entry){
        if(!journal.contains(entry)){
            journal.addEntry(entry);
            return true;
        }
        else return false;
    }

    public Journal getJournal() {
        return journal;
    }
}
