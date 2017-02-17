package test.crossover;

import org.junit.Test;

import base.Tour;
import crossover.SubTourExchangeCrossover;
import test.AbstractTest;

/**
 * Created by Max on 17.02.2017.
 */
public class SubTourExchangeCrossoverTest extends AbstractTest{

    @Test
    public void TestDoCrossover(){
        Tour tour01 = Tour.generateRandom();
        Tour tour02 = Tour.generateRandom();

        System.out.println("Parent 1:   "+ tour01);
        System.out.println("Parent 2:   "+ tour02);

        Tour[] testresult = new SubTourExchangeCrossover().doCrossover(tour01, tour02);

        System.out.println("Kind 1:     "+ testresult[0]);
        System.out.println("Kind 2:     "+ testresult[1]);

        Boolean equal = false;
        int index = 0;

        Tour child01 = testresult[0];
        Tour child02 = testresult[1];

        if(child01.getSize() != tour01.getSize() || child02.getSize() != tour02.getSize())
        {
            System.out.println("Zu wenig Zeichen!");
        }
        else {
            while (equal==true)
            {
                if((child01.getCity(index) != tour01.getCity(index))|| child02.getCity(index) != tour02.getCity(index))
                    equal = false;
                else equal = true;
            }
            if (equal == true)
            {
                System.out.println("Klasse fehlerhaft");
            }
            else System.out.println("Klasse!");
        }
        System.out.println("Equal= "+ equal);
    }
}
