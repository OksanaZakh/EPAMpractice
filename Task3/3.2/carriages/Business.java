package com.oksana.zakharchenko.generics.carriages;

public class Business extends Carriage {

    private boolean meal;

    public Business(int numPassengers, int price, boolean meal) {
        super(numPassengers, CarriagesComfort.MEDIUM, 1000, price);
        this.meal=meal;
    }

    public boolean isMeal() {
        return meal;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Business(super.numPassengers, super.price, isMeal());
    }

    @Override
    public String toString() {
        return "Business{" +
                "meal=" + meal +
                ", numPassengers=" + numPassengers +
                ", comfortLevel=" + comfortLevel +
                ", baggage=" + baggage +
                ", price=" + price +
                '}';
    }
}
