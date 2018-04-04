package complexity.ga;
import java.util.*;

import complexity.se.Constraint;

public class Individual {

	public List<Constraint> constraintSet = new ArrayList<>();
	public int fitness;
	
	public Individual() {
		super();
	}
	
	public Individual(List<Constraint> constraintSet, int fitness) {
		super();
		this.constraintSet = constraintSet;
		this.fitness = fitness;
	}

	public List<Constraint> getConstraintSet() {
		return constraintSet;
	}

	public void setConstraintSet(List<Constraint> constraintSet) {
		this.constraintSet = constraintSet;
	}

	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	public Individual fromStrings(String smt2Strings, int fitness) {
		//Args: smt2_strings (:iterable:string): An iterable of strings describing constraints in SMTLIB v2 format.
        //      fitness (int): The fitness of the individual.
		//RETURN: An individual with the given constraints and fitness.
		//TODO:
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
		//TODO:
	}

	public void pcToConstraintSet(int pc) {
		
	}
	
	//Return the model stored by the given solver if it is available 
	public String getModel() {
		try {
			return "test"; //TODO: return solver.model()
		}
		catch(Exception e) {
			return null;
		}
	}
	
	//Clone an Individual object
	public Individual cloneIndividual() {
		Individual individualClone = new Individual();
		individualClone.setConstraintSet(this.getConstraintSet());
		individualClone.setFitness(this.getFitness());
		return individualClone;
	}
	
	public void minimize() {
		
	}
		
	public void countInstructions() {
		
	}

	public static Individual randomIndividual() {
		return null;//TODO
	}
	
}
