package com.oksana.zakharchenko.generics.carriages;

public class Lux extends Carriage {

    private boolean addServices;

    public Lux(int price, boolean addServices) {
        super(10, CarriagesComfort.HIGH, 1000, price);
        this.addServices=addServices;
    }

    public boolean isAddServices() {
        return addServices;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Lux(super.price, isAddServices());
    }

    @Override
    public String toString() {
        return "Lux{" +
                "addServices=" + addServices +
                ", numPassengers=" + numPassengers +
                ", comfortLevel=" + comfortLevel +
                ", baggage=" + baggage +
                ", price=" + price +
                '}';
    }
}
