package base;

import java.util.ArrayList;
import java.util.Collections;

import main.Configuration;

public class Tour implements Comparable<Tour> {
	public Tour() {
	}

	public Tour(ArrayList<City> cities) {
		setCities(cities);
	}

	private ArrayList<City> cities = new ArrayList<>();

	public ArrayList<City> getCities() {
		return cities;
	}

	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}

	public City getCity(int index) {
		return cities.get(index);
	}

	public void addCity(City city) {
		cities.add(city);
	}

	public void addCity(int index, City city) {
		cities.set(index, city);
	}

	public int getSize() {
		return cities.size();
	}

	public boolean containsCity(City city) {
		return cities.contains(city);
	}

	public double getFitness() {
		double distance = 0.0;

		for (int i = 0; i < cities.size() - 1; i++) {
			double x1 = getCity(i).getX();
			double y1 = getCity(i).getY();
			double x2 = getCity(i + 1).getX();
			double y2 = getCity(i + 1).getY();
			distance = distance + euclideanDistance(x1, y1, x2, y2);
		}
        return 1/distance;
    }

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{ Tour : ");

		for (City city : cities)
			stringBuilder.append(city.getId()).append(" ");

		stringBuilder.append(" }");
		return stringBuilder.toString();
	}

	public static double euclideanDistance(double x1, double y1, double x2, double y2) {
		double xDistance = Math.abs(x1 - x2);
		double yDistance = Math.abs(y1 - y2);
		return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
	}

	public int compareTo(Tour otherTour) {
		if (getFitness() < otherTour.getFitness())
			return -1;
		else if (getFitness() > otherTour.getFitness())
			return 1;
		else
			return 0;
	}

	public static Tour generateRandom() {
		ArrayList<City> cities = new ArrayList<City>();
		for (City c : Configuration.instance.availableCities) {
			cities.add(c);
		}
		Collections.shuffle(cities, Configuration.instance.randomSeed);

		return new Tour(cities);
	}
}