package com.oksana.zakharchenko.generics;

import com.oksana.zakharchenko.generics.carriages.Carriage;
import com.oksana.zakharchenko.generics.carriages.ComfortComparator;


public class TrainHandler {
    private Train<?> train;

    public TrainHandler() {
        this.train = InitialiseTrain.initialise();
    }

    public void run() {
        sortByComfort();
        System.out.println("Train: ");
        System.out.println(train);
        System.out.println("Total num of baggage: " + getTotalBaggage());
        System.out.println("Total num of passengers: " + getTotalPassengers());
    }


    public void sortByComfort() {
        train.getCarriages().sort(new ComfortComparator());
    }

    public int getTotalPassengers() {
        int count = 0;
        for (Carriage carriage : train.getCarriages()) {
            count += carriage.getNumPassengers();
        }
        return count;
    }

    public int getTotalBaggage() {
        int count = 0;
        for (Carriage carriage : train.getCarriages()) {
            count += carriage.getBaggage();
        }
        return count;
    }

}
