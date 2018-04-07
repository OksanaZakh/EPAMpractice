package com.oksana.zakharchenko.journalmvc.Utils;

import com.oksana.zakharchenko.journalmvc.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidate {

    private Pattern pattern = null;
    private Matcher matcher = null;

    public InputValidate() {
        this.pattern = null;
        this.matcher = null;

    }

    public boolean validate(String regex, String input) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input);
        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }
}
