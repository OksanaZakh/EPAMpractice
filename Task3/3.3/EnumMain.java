package com.oksana.zakharchenko.customenum;

import java.util.Arrays;

public class EnumMain {

    public static void main(String[] args) {
        System.out.println(CustomEnum.LOW);
        System.out.println(CustomEnum.MEDIUM.ordinal());
        System.out.println(Arrays.toString(CustomEnum.values()));

        System.out.println(CustomEnum.valueOf("HIGH").ordinal());


        for (AbstractCustomEnum item : CustomEnum.values()) {
            CustomEnum curr = (CustomEnum) item;
            System.out.println(curr.name()+" "+curr.ordinal());
        }

        System.out.println(CustomEnum.MEDIUM.compareTo(CustomEnum.HIGH));
    }
}
