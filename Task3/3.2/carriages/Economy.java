package com.oksana.zakharchenko.generics.carriages;

public class Economy extends Carriage {

    public Economy(int numPassengers, int baggage, int price) {
        super(numPassengers, CarriagesComfort.LOW, baggage, price);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" +
                "numPassengers='" + super.numPassengers +
                "comfort='" + super.comfortLevel +
                "price='" + super.price +
                '}'+"\n";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Economy(super.numPassengers, super.baggage, super.price);
    }
}
