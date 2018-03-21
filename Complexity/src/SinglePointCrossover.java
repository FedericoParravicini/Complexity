import java.util.ArrayList;

public class SinglePointCrossover extends CrossoverFunction{
	
	int rngSeed;
	ArrayList<Individual> parents = new ArrayList<Individual>(2);
	
	public SinglePointCrossover(int rngSeed, ArrayList<Individual> parents) {
		super();
		this.rngSeed = rngSeed;
		this.parents = parents;
	}
	
}
