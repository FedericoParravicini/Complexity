package complexity.utils;

import java.util.ArrayList;
import java.util.List;

import complexity.ga.Individual;

public class HallOfFame {
	
	public int n = 0; //TODO:
	public ArrayList<Individual> bestIndividuals = new ArrayList<Individual>();
	
	public HallOfFame(int n, ArrayList<Individual> bestIndividuals) {
		super();
		this.n = n;
		this.bestIndividuals = bestIndividuals;
	}
	
	public void update(List<Individual> offspring) {
		//TODO:
	}
	
	public Individual bestIndividual() {
		return bestIndividuals.get(0);
	}
	
}
