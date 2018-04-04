package complexity.localSearch;

import complexity.ga.Individual;

public abstract class LocalSearchAlgorithm {
	
	public abstract Individual localSearch(Individual individual);
	
	
	public static LocalSearchAlgorithm makeLocalSearch() {
		return new LocalSearch();
	}
	
}
