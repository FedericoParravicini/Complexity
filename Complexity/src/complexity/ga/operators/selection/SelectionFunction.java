package complexity.ga.operators.selection;

import java.util.ArrayList;
import java.util.List;

import complexity.ga.Individual;

public abstract class SelectionFunction {
	
	protected abstract Individual selectIndividual(List<Individual> individuals);
	
	public ArrayList<Individual> selection(ArrayList<Individual> population, int nPairs) {
		ArrayList<Individual> result = new ArrayList<Individual>();
		for (int i = 0; i < nPairs; i++){
		    Individual individual1 = selectIndividual(population);
		    population.remove(individual1);
		    Individual individual2 = selectIndividual(population);
		    population.add(individual1);
		    result.add(0, individual1);
		    result.add(1, individual2);
		}
		return result;
	}

	public ArrayList<Individual> survivalSelection(ArrayList<Individual> population, int n) {
        ArrayList<Individual> result = new ArrayList<Individual>();
        for(int i=0; i < n; i++) {
            Individual individual = selectIndividual(population);
            population.remove(individual);
            result.add(individual);
        }
        return result;
	}
	
}
