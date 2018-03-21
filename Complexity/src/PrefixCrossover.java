import java.util.ArrayList;

public abstract class PrefixCrossover extends CrossoverFunction{
	
	int rngSeed;
	ArrayList<Individual> parents = new ArrayList<Individual>(2);
	
	public PrefixCrossover(int rngSeed, ArrayList<Individual> parents) {
		super();
		this.rngSeed = rngSeed;
		this.parents = parents;
	}
	
}
