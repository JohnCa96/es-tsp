package test.crossover;

import static org.junit.Assert.fail;

import java.util.HashMap;

import base.Pair;
import org.junit.Test;

import base.City;
import base.Tour;
import crossover.CycleCrossover;
import test.AbstractTest;

public class CycleCrossoverTest extends AbstractTest {

	@Test
	public void testDoCrossover() {
		System.out.println("CycleCrossovertest started.");
		Tour t1 = Tour.generateRandom();
		Tour t2 = Tour.generateRandom();
		System.out.println(t1);
		System.out.println(t2);
		Pair<Tour, Tour> tk = new CycleCrossover().doCrossover(t1, t2);
		System.out.println(tk.getFirst());
		System.out.println(tk.getSecond());
		HashMap<City, City> tmp = new HashMap<City, City>();
		for (City c : tk.getFirst().getCities()) {
			tmp.put(c, c);
		}
		if (tmp.size() != tk.getFirst().getSize())
			fail("Not all elements available!");
		for (int i = 0; i < tk.getFirst().getCities().size(); i++) {
			if (!tk.getFirst().getCity(i).equals(t1.getCity(i))) {
				return;
			}
		}
		for (City c : tk.getFirst().getCities()) {
			tmp.put(c, c);
		}
		if (tmp.size() != tk.getSecond().getSize())
			fail("Not all elements available!");
		for (int i = 0; i < tk.getSecond().getCities().size(); i++) {
			if (!tk.getSecond().getCity(i).equals(t1.getCity(i))) {
				return;
			}
		}
	}

}
