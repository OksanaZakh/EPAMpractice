package com.oksana.zakharchenko.journalmvc.JornalModel;

import java.util.ArrayList;
import java.util.List;

public class Journal {
    private List<JournalEntry> entries;

    public Journal(){
        this.entries = new ArrayList<JournalEntry>();
    }

    public List<JournalEntry> getEntries() {
        return entries;
    }

    public void addEntry(JournalEntry entry){
        entries.add(entry);
    }

    public boolean contains(JournalEntry entry){
        if(entries.contains(entry)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Journal{" +
                "entries=" + entries +
                '}';
    }
}
