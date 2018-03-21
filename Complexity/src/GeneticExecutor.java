import java.util.ArrayList;

public class GeneticExecutor {
	
	public FitnessFunction fitnessFunction = new FitnessFunction(null);
	public SelectionFunction selectionFunction;
	public CrossoverFunction crossoverFunction;
	public MutationFunction mutationFunction;
	public ArrayList<Individual> population = new ArrayList<Individual>();
	public HallOfFame hof = new HallOfFame(0, null);
	
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
