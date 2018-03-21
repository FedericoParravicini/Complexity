import java.util.ArrayList;

public abstract class SelectionFunction{
	
	ArrayList<Individual> population = new ArrayList<Individual>();
	int n;
	
	public SelectionFunction(ArrayList<Individual> population, int n) {
		super();
		this.population = population;
		this.n = n;
	}
	public void selection() {
		
	}
	/*
	public void constrainedWcetpp() {
		
	}
	*/
	public void localSearch() {
		//????
	}
	
	public void rankSelection() {
		
	}
	
	public void rouletteSelection() {
		
		/*
		public void rouletteWheelOld() {
			
		}
		
		public void rouletteWheelDeltas() {
			
		}
		*/
	}

	public void survivalSelection() {
		
	}
	
}
