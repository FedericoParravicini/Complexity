package complexity.ga;

import java.util.List;

import complexity.se.Constraint;
import complexity.se.Symex;

public class FitnessFunction{

	public static Individual evaluate(List<Constraint> constraintSet) {
		Symex se = Symex.makeEngine();
		
		List<Constraint> pc = se.randomWalkSymbolicExecution(constraintSet);
		
        return new Individual(pc, se.getInstructionCount());
	}
	
	//Returns the estimated number of fitness evaluations to run `ga_wcet_generator` with the given configuration
	public  static int estimateFitnessEvaluations(int generations, int populationSize, int mutationProb) {
	    int g = generations;
	    int p = populationSize;
	    int mp = mutationProb;
	    return Math.round(p * ((mp + 1) * g + 1));
	}
	
	public static int estimateSeconds(int generations, int popSize, int mutProb, int timeout) {
		return estimateFitnessEvaluations(generations, popSize, mutProb) * timeout;
	}
	
	public static int estimateHours(int generations, int popSize, int mutProb, int timeout) {
		return estimateSeconds(generations, popSize, mutProb, timeout) / 3600;
	}
	
}
