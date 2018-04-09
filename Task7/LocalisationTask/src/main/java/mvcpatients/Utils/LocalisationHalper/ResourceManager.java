package mvcpatients.Utils.LocalisationHalper;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public enum  ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resName="text";

    ResourceManager() {
        this.resourceBundle = ResourceBundle.getBundle(resName, Locale.getDefault());
    }
    public void changeResource(Locale locale){
        resourceBundle=ResourceBundle.getBundle(resName, locale);
    }
    public String getString(String key){
        return resourceBundle.getString(key);
    }
    public Enumeration getKeySet(){
        return resourceBundle.getKeys();
    }
}
