package com.oksana.zakharchenko.dictionary;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dictionary;

    public Dictionary() {
        dictionary=new HashMap<>();
    }

    public boolean addWords(String en, String rus){
        if (!dictionary.containsKey(en)){
            dictionary.put(en, rus);
            return true;
        }
        else {
            return false;
        }
    }

    public String getTranslation(String en){
        if (dictionary.containsKey(en)){
            return dictionary.get(en);
        }
        else return null;
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }
}
