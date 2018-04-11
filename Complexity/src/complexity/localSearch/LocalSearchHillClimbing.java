package complexity.localSearch;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import complexity.ga.Individual;
import complexity.ga.algo.GeneticExecutor;
import complexity.se.*;
import complexity.utils.*;

public class LocalSearchHillClimbing extends LocalSearchAlgorithm { 
	
	@Override
	public Individual localSearch(Individual individual) {
		int index = ThreadLocalRandom.current().nextInt(1, individual.getConstraintSet().size() - 1);
		int remainingAttempts = Config.populationSize / 2;
		System.out.println("Local search starts at index " + index);		
		while(remainingAttempts > 0) {
			remainingAttempts --;
			List<Constraint> currentConstraints = individual.getConstraintSet();
			Constraint mutatedConstraint = currentConstraints.get(index).mkNot();
			currentConstraints.add(index, mutatedConstraint);
			Symex sym = Symex.makeEngine();
			
			List<Constraint> pc = sym.randomWalkSymbolicExecution(currentConstraints);
			int newFitness = sym.getInstructionCount();
			
			System.out.println("Local search at index " + index + ": " + individual.getFitness()+ " --> " + newFitness);
			if(newFitness > individual.getFitness()) {
				System.out.println("Successful");
				individual.setConstraintSet(pc);
				individual.setFitness(newFitness);
				if(remainingAttempts < 5) {
					remainingAttempts = 5;
				}
			} else if(newFitness == individual.getFitness()) {
				individual.setConstraintSet(pc);
				individual.setFitness(newFitness);
			}

            index = (index + 1) % individual.getConstraintSet().size();
		}
		return individual;
	}
}
