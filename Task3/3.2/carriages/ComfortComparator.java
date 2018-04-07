package com.oksana.zakharchenko.generics.carriages;

import java.util.Comparator;

public class ComfortComparator implements Comparator<Carriage> {
    @Override
    public int compare(Carriage o1, Carriage o2) {
        return o1.comfortLevel.ordinal()-o2.comfortLevel.ordinal();
    }
}
