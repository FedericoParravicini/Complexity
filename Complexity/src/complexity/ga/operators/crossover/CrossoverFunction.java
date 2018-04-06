package complexity.ga.operators.crossover;

import java.util.ArrayList;

import complexity.ga.Individual;

public abstract class CrossoverFunction{
	
	public abstract ArrayList<Individual> crossover(Individual p1, Individual p2); //modificherà i genitori in base al risultato
}
