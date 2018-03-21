import java.util.ArrayList;

public class ExcludeCrossover extends CrossoverFunction{
	
	int rngSeed;
	ArrayList<Individual> parents = new ArrayList<Individual>(2);
	
	public ExcludeCrossover(int rngSeed, ArrayList<Individual> parents) {
		super();
		this.rngSeed = rngSeed;
		this.parents = parents;
	}
	
}
