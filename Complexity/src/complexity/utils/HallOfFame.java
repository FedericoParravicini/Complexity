package complexity.utils;

import java.util.ArrayList;
import java.util.List;

import complexity.ga.Individual;

public class HallOfFame {
	
	public int n;
	public ArrayList<Individual> bestIndividuals = new ArrayList<>();
	
	public HallOfFame(int n) {
		super();
		this.n = n;
	}
	
	public void update(List<Individual> population) {
		bestIndividuals.addAll(population);
	}
}
