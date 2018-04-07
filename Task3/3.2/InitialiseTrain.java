package com.oksana.zakharchenko.generics;


import com.oksana.zakharchenko.generics.carriages.Business;
import com.oksana.zakharchenko.generics.carriages.Carriage;
import com.oksana.zakharchenko.generics.carriages.Economy;
import com.oksana.zakharchenko.generics.carriages.Lux;

import java.util.ArrayList;
import java.util.List;

public class InitialiseTrain {
    public static Train initialise() {
        List<Carriage> carriages = new ArrayList<>();
        carriages.add(new Economy(54, 500, 100));
        carriages.add(new Economy(54, 700, 120));
        carriages.add(new Business(30, 100, false));
        carriages.add(new Business(30, 120, true));
        carriages.add(new Lux(250, true));

        Train train=new Train(101, carriages);
        return train;
    }

}
