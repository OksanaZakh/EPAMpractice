package com.oksana.zakharchenko.EPAMpractice.Task1;

public class Converter {
    public String convert(Object x) {
        String result = "";
        if (!(x instanceof Integer)) {
            return "This is not an integer!";
        } else {
            int num = (int) x;
            if (num < 0) {
                return "The number is negative!";
            } else {
                String binary = decimalToBinary(num);
                String oct = decimalToOct(num);
//                String sixteen=decimalToHexadecimal(num);

                result = binary + " " + oct/*+" "+sixteen*/;
            }
        }


        return result;
    }

    private String decimalToBinary(int num) {
        String result = "";
        while (num >= 1) {
            if (num % 2 == 0) {
                result = "0" + result;
            } else {
                result = "1" + result;
            }
            num = num / 2;
        }
        return result;
    }

    private String decimalToOct(int num) {
        String result = "";
        while (num >= 7) {
            int temp = num % 8;
            result = temp + result;
            num = num / 8;
        }

        int i = num % 8;
        String iStr = "" + i;
        result = iStr + result;
        return result;
    }

    private String decimalToHexadecimal(int num) {
        String result = "";

        return result;
    }

}
