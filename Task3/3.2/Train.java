package com.oksana.zakharchenko.generics;

import com.oksana.zakharchenko.generics.carriages.Carriage;

import java.util.List;

public class Train<T extends Carriage> implements Cloneable {
    private int num;
    private List<T> carriages;

    public Train(int num, List<T> carriages) {
        this.num = num;
        this.carriages = carriages;
    }

    public int getNum() {
        return num;
    }

    public List<T> getCarriages() {
        return carriages;
    }


    @Override
    public String toString() {
        return "Train{" +
                "num=" + num +
                ", carriages=" + carriages +
                '}';
    }

}
