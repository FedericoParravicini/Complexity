package complexity.ga.operators.crossover;

import complexity.ga.Individual;

public abstract class CrossoverFunction{
	
	public abstract void crossover(Individual p1, Individual p2); //modificherà i geneitori in base al risultato
}
