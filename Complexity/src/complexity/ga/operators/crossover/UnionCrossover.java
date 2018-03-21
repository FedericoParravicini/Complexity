package complexity.ga.operators.crossover;
import complexity.ga.Individual;

public class UnionCrossover extends CrossoverFunction{
	
	Individual individual1;
	Individual individual2;
	
	public UnionCrossover(Individual individual1, Individual individual2) {
		super();
		this.individual1 = individual1;
		this.individual2 = individual2;
	}
	
}
