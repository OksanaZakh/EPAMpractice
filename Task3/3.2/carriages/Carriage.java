package com.oksana.zakharchenko.generics.carriages;

public abstract class Carriage implements Cloneable{
    protected int numPassengers;
    protected CarriagesComfort comfortLevel;
    protected int baggage;
    protected int price;
    private static int num=1;

    public Carriage(int numPassengers, CarriagesComfort comfortLevel, int baggage, int price) {
        this.numPassengers = numPassengers;
        this.comfortLevel = comfortLevel;
        this.baggage = baggage;
        this.price = price;
        num++;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public CarriagesComfort getComfortLevel() {
        return comfortLevel;
    }

    public int getBaggage() {
        return baggage;
    }

    public int getPrice() {
        return price;
    }

    public static int getNum() {
        return num;
    }

    public abstract String toString();

    @Override
    public abstract Object clone() throws CloneNotSupportedException;
}
