import java.util.ArrayList;

public class HallOfFame {
	
	//__init__
	int n = 0;
	ArrayList<Individual> bestIndividuals = new ArrayList<Individual>();
	
	public HallOfFame(int n, ArrayList<Individual> bestIndividuals) {
		super();
		this.n = n;
		this.bestIndividuals = bestIndividuals;
	}
	
	public void update(int population) {
		//
		//
	}
	
	public Individual bestIndividual() {
		return bestIndividuals.get(0);
	}
	
	public void repr() {
		//
	}
	
}
