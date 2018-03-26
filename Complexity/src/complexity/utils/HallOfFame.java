package complexity.utils;

import java.util.ArrayList;

import complexity.ga.Individual;

public class HallOfFame {
	
	//__init__
	int n = 0;
	ArrayList<Individual> bestIndividuals = new ArrayList<Individual>();
	
	public HallOfFame(int n, ArrayList<Individual> bestIndividuals) {
		super();
		this.n = n;
		this.bestIndividuals = bestIndividuals;
	}
	
	public void update(ArrayList<Individual> population) {
		
	}
	
	public Individual bestIndividual() {
		return bestIndividuals.get(0);
	}
	
	public void repr() {
	
	}
	
}
