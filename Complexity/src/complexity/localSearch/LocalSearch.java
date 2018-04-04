package complexity.localSearch;

import java.util.*;

import complexity.ga.Individual;
import complexity.utils.Config;
import complexity.utils.Utils;

public class LocalSearch extends LocalSearchAlgorithm{

	@Override
	public Individual localSearch(Individual individual) {
		//TODO: PYTHON-> index = rng.randint(0, len(individual.constraint_set) - 1);
		int index = 0;
		int remainingAttempts = Config.populationSize / 2;
		System.out.println("Local search starts at index " + index);
		while(remainingAttempts > 0) {
			remainingAttempts --;
			List<String> currentConstraints = new ArrayList<>();
			currentConstraints = individual.getConstraintSet();
			Utils.mkNot(currentConstraints.get(index));
			/*
			PYTHON->
			se = RandomWalkSymbolicExecutor(rng)
            se.preconditions = current_constraints
			profiles = wcetpp(se, f, args, kwargs); 
			if profiles:
                profile = rng.choice(profiles)
				print("Local search at index ", index, ": ", individual.fitness, " --> ", profile.cost)
                if profile.cost > individual.fitness:
                    print("**Successful")
                    individual = Individual(pc_to_constraint_set(profile.pc), profile.cost)
                    if remaining_attempts < 5:
                        remaining_attempts = 5
                elif profile.cost == individual.fitness:
                    individual = Individual(pc_to_constraint_set(profile.pc), profile.cost)

            index = (index + 1) % len(individual.constraint_set)
            */
			
		}
		return null; //return individual
	}
	
}
