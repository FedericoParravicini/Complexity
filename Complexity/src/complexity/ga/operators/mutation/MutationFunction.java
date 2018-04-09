package complexity.ga.operators.mutation;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import complexity.ga.FitnessFunction;
import complexity.ga.Individual;
import complexity.se.Constraint;
import complexity.utils.Config;
import complexity.utils.Utils;

public abstract class MutationFunction{
	
    private static Random rng = new Random();

	public static Individual deleteMutation(Individual individual, double ratio) {
		int nTargets = (int) Math.round(ratio * individual.getConstraintSet().size());
        List<Constraint> childConstraints = individual.getConstraintSet();
        for(int i = 0; i < nTargets; i++) {
            int index = ThreadLocalRandom.current().nextInt(0, childConstraints.size() - 1);
            childConstraints.remove(index);
            }
        Individual child = FitnessFunction.evaluate(childConstraints);
        return child;
        }
	
	public static Individual negateMutation(Individual individual, double ratio) {
		int nConstraints = individual.getConstraintSet().size();
		int nTargets = (int) Math.round(ratio * nConstraints);
		List<Constraint> childConstraints = individual.getConstraintSet();
		for(int i = ThreadLocalRandom.current().nextInt(0, nConstraints); i < nTargets; i++) { //TODO for index in rng.sample(range(nr_constraints), nr_targets)
			//Utils.negate(childConstraints.get(i));
			if(Utils.isInconsistent(childConstraints)) {
				//Utils.negate(childConstraints.get(i));
				}
			}
        Individual child = null; //TODO child = evaluate(tuple(child_constraints));
        return child;
		}

	public static List<Constraint> deleteMutationBis(List<Constraint> childConstraints, double ratio) {
		int nTargets = (int) Math.round(ratio * childConstraints.size());
        for(int i = 0; i < nTargets; i++){
            int index = ThreadLocalRandom.current().nextInt(0, childConstraints.size() - 1);
            childConstraints.remove(index);
            if(rng.nextBoolean() ? true : false){
                break;
                }
            }
        return childConstraints;
        }
	
	public static List<Constraint> mutationBis(List<Constraint> childConstraints) {
		Random rng = new Random();
		double ratio = 0.1;
        if(rng.nextInt() < Config.mutationProb) {
            return deleteMutationBis(childConstraints, ratio);
        }else {
        	return childConstraints;
        	}
        }
	
	public static Individual mutation(int seed, Individual individual) {
		Random rng = new Random();
		double ratio = 0.1;
		if(rng.nextInt(seed) < Config.mutationProb) {
            if(rng.nextBoolean() ? true : false){
                return deleteMutation(individual, ratio);
            }else {
                return negateMutation(individual, ratio);
                }
            }
        return individual;
        }
}
