package crossover;

import base.Pair;
import base.Tour;
import base.City;

import java.util.*;

// author 1174535

public class SubTourExchangeCrossover implements ICrossover {
    public Pair<Tour, Tour> doCrossover(Tour tour01, Tour tour02) {
    int size = tour01.getSize();

    Random rn = new Random();

    int sizestour = rn.nextInt(size)+1;
    int boundarystart = rn.nextInt(size-sizestour);
    Tour temptour = tour02;

    for (int i=0; i<sizestour; i++)
    {
        int index = boundarystart+i;
        City temp =  tour01.getCity(index);
        tour02.getCities().set(index, temp);
    }

    int boundarystart02 = rn.nextInt(size-sizestour);
    for (int i=0; i<sizestour; i++)
    {
        int index = boundarystart02+i;
        City temp = temptour.getCities().get(index);
        tour01.getCities().set(index, temp);
    }

        return new Pair<Tour, Tour>(tour01, tour02);
    }
//pdf seite 96
    public String toString() {
        return getClass().getSimpleName();
    }
}