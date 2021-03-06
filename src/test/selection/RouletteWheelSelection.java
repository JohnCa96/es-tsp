package test.selection;

import base.Pair;
import base.Population;
import base.Tour;
import main.Application;
import main.Configuration;
import org.junit.Test;
import random.MersenneTwisterFast;
import selection.ISelection;

import java.util.List;

import static org.junit.Assert.*;

public class RouletteWheelSelection {
    @Test
    public void doSelection() throws Exception {
        Application application = new Application();
        application.loadData();
        Population population = new Population();
        ISelection selector = new selection.TournamentSelection(new MersenneTwisterFast());

        int arrayLength = (int) (Configuration.instance.populataionSize * (Configuration.instance.tourBorder * 0.01));
        if (arrayLength % 2 != 0) arrayLength++;

        for(int i = 0; i < Configuration.instance.maxIterations; i++) {
            population.generateRandom();
            List<Pair<Tour, Tour>> tourPairs = selector.doSelection(population);

            assertEquals(arrayLength / 2, tourPairs.size());

            // Internal List Test
            tourPairs.forEach(pair -> {
                assertNotNull(pair.getFirst());
                assertNotNull(pair.getSecond());
            });

            System.out.println(i);
        }
    }
}