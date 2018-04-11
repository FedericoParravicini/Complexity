package complexity.ga;
import java.util.*;

import complexity.se.Constraint;
import complexity.se.Model;
import complexity.utils.Utils;

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
		//TODO
	}

	public List<Constraint> pcToConstraintSet(int pc) {
		//TODO
		List<Constraint> formula = new ArrayList<>();
		return formula;
	}
	
	//Return the model stored by the given solver if it is available 
	public Model getModel() {
		return new Model(constraintSet);
	}
	
	//Clone an Individual object
	public Individual cloneIndividual() {
		Individual individualClone = new Individual();
		individualClone.setConstraintSet(this.getConstraintSet());
		individualClone.setFitness(this.getFitness());
		return individualClone;
	}
	
	public List<Constraint> minimize(List<Constraint> constraintSet) {
		int i = 0;
		while(i < constraintSet.size()) {
			//TODO
			if (Utils.isImplied(constraintSet.get(i)/*, constraint_set[:i] + constraint_set[i+1:]*/)) {
				constraintSet.remove(i);
			}else {
				i ++;
			}
		}
		return constraintSet;
	}
		
	public void countInstructions() {
		//TODO
	}

	public static Individual randomIndividual() {
		return null;//TODO
	}
	
}
