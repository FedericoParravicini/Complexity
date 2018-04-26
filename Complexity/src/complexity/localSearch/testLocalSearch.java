package complexity.localSearch;


import org.junit.jupiter.api.Test;

import complexity.ga.Individual;
import complexity.se.Constraint;
import complexity.se.Symex;
import complexity.utils.Config;
import complexity.utils.RandomSingleton;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class testLocalSearch {

	public Individual localSearch(Individual individual) {
		int index = RandomSingleton.getInstance().nextInt(individual.getConstraintSet().size() - 1) + 1;
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
				if(remainingAttempts < Config.localSearchRate) {
					remainingAttempts = 0;
				}
			} else if(newFitness == individual.getFitness()) {
				individual.setConstraintSet(pc);
				individual.setFitness(newFitness);
			}

            index = (index + 1) % individual.getConstraintSet().size();
		}
		return individual;
	}
	
	@Test
	@DisplayName("test")
	public void testLocalS() {
		Individual ind1 = Individual.randomIndividual();
		Individual ind2 = localSearch(ind1.cloneIndividual());
		
		System.out.print("ind1 " + ind1.toString());
		System.out.print("ind2 " + ind2.toString());
		
		assertNotEquals(ind1, ind2);
		
		
	}
	
}
