package complexity.ga.algo;
import java.util.ArrayList;

import complexity.ga.FitnessFunction;
import complexity.ga.Individual;
import complexity.ga.operators.crossover.CrossoverFunction;
import complexity.ga.operators.mutation.MutationFunction;
import complexity.ga.operators.selection.SelectionFunction;
import complexity.utils.HallOfFame;

public class GeneticExecutor {
	
	private FitnessFunction fitnessFunction = new FitnessFunction(null);
	private SelectionFunction selectionFunction;
	private CrossoverFunction crossoverFunction;
	private MutationFunction mutationFunction;
	private ArrayList<Individual> population = new ArrayList<Individual>();
	private HallOfFame hof = new HallOfFame(0, null);
	
	public void writeIndividualsToCsv() {
		//
	}
	
	public void logPopulation() {
		//
	}
	
	public void logPopulationStats() {
		//
	}
	
	public void elitism() {
		//
	}
	
	public void run(String configuration) {
		//inizializzare
	}
	
}
