package complexity.ga;
import java.util.ArrayList;

public class Individual {
	
	//__init__
	public ArrayList<String> constraintSet = new ArrayList<String>();
	public int fitness;
	
	public Individual(ArrayList<String> constraintSet, int fitness) {
		super();
		this.constraintSet = constraintSet;
		this.fitness = fitness;
	}

	public ArrayList<String> getConstraintSet() {
		return constraintSet;
	}

	public void setConstraintSet(ArrayList<String> constraintSet) {
		this.constraintSet = constraintSet;
	}

	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	public Individual fromStrings(String smt2_strings, int fitness) {
		//Args: smt2_strings (:iterable:string): An iterable of strings describing constraints in SMTLIB v2 format.
        //      fitness (int): The fitness of the individual.
		//RETURN: An individual with the given constraints and fitness.
		constraintSet.add("test");
		Individual individual = new Individual(constraintSet, 1);
		return individual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((constraintSet == null) ? 0 : constraintSet.hashCode());
		result = prime * result + fitness;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Individual other = (Individual) obj;
		if (constraintSet == null) {
			if (other.constraintSet != null)
				return false;
		} else if (!constraintSet.equals(other.constraintSet))
			return false;
		if (fitness != other.fitness)
			return false;
		return true;
	}
	
	public void reduce() {
		//
		//
	}
	
	public void repr() {
		System.out.println("Individual: " + this.fitness + this.constraintSet);
	}
	

	public void pcToConstraintSet(int pc) {
		
	}
	
	public void getModel() {
		
	}
	
	public void minimize() {
		
	}
		
	public void countInstructions() {
		
	}

	public void randomIndividual() {
		
	}
	
}
