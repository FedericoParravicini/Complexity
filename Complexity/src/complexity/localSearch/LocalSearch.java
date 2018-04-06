package complexity.localSearch;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import complexity.ga.Individual;
import complexity.ga.algo.GeneticExecutor;
import complexity.se.*;
import complexity.utils.*;

public class LocalSearch extends LocalSearchAlgorithm{
	
	@Override
	public Individual localSearch(Individual individual) {
		int index = ThreadLocalRandom.current().nextInt(1, individual.getConstraintSet().size() - 1);
		int remainingAttempts = Config.populationSize / 2;
		System.out.println("Local search starts at index " + index);		
		while(remainingAttempts > 0) {
			remainingAttempts --;
			List<Constraint> currentConstraints = individual.getConstraintSet();
			currentConstraints.get(index).mkNot();
			Symex sym = Symex.makeEngine();
			List<Constraint> se = sym.randomWalkSymbolicExecution(currentConstraints);
			ArrayList<Individual> profiles = new GeneticExecutor().wcetGenerator();  
			if(profiles != null) {
				Individual profile = Utils.getRandom(profiles);
				System.out.println("Local search at index " + index + ": " + individual.getFitness()+ " --> " + profile.getFitness());
                if(profile.getFitness() > individual.getFitness()) {
                    System.out.println("Successful");
                    individual.setConstraintSet(se);
                    individual.setFitness(profile.getFitness());
                    if(remainingAttempts < 5) {
                        remainingAttempts = 5;
                        }
                    }
                else if(profile.getFitness() == individual.getFitness()) {
                	individual.setConstraintSet(se);
                    individual.setFitness(profile.getFitness());
                    }
				}
				//TODO: else if(profile.getFitness() < individual.getFitness())
            index = (index + 1) % individual.getConstraintSet().size();
		}
		return individual;
	}
}
