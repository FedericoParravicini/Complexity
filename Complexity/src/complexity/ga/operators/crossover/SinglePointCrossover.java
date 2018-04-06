package complexity.ga.operators.crossover;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import complexity.ga.FitnessFunction;
import complexity.ga.Individual;
import complexity.ga.operators.mutation.MutationFunction;
import complexity.se.Constraint;

public class SinglePointCrossover extends CrossoverFunction {

	@Override
	public ArrayList<Individual> crossover(Individual parent1, Individual parent2) {
		List<Constraint> constraints1 = parent1.getConstraintSet();
		List<Constraint> constraints2 = parent2.getConstraintSet();
		int cp1;
		int cp2;
		
		if(constraints1.size() > 1) {
			cp1 = ThreadLocalRandom.current().nextInt(1, constraints1.size() - 1);
		}else {
			cp1 = 0;
		}
		if(constraints2.size() > 1) {
			cp2 = ThreadLocalRandom.current().nextInt(1, constraints2.size() - 1);
		}else {
			cp2 = 0;
		}
		
		List<Constraint> constr1 = new ArrayList<>();
		List<Constraint> constr2 = new ArrayList<>();
		int i = 0, j = 0;
		while(i <= cp1) {
			constr1.add(constraints1.get(i));
			i++;
		}
		while(j <= cp2) {
			constr2.add(constraints2.get(i));
			j++;
		}
		
        List<Constraint> childConstraints1 = combine(constr1, constr2);
        List<Constraint> childConstraints2 = combine(constr2, constr1);
        
        MutationFunction.mutationBis(childConstraints1);
        MutationFunction.mutationBis(childConstraints2);

        Individual child1 = FitnessFunction.evaluate(childConstraints1);
        Individual child2 = FitnessFunction.evaluate(childConstraints2);
        
        ArrayList<Individual> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        
        return children;
	}
	
	private List<Constraint> combine(List<Constraint> constraints1, List<Constraint> constraints2){
            List<Constraint> result = constraints1;
            /*
            resultAsClauses = [PcClause(constraint, False) for constraint in result];
            for c in constraints2:
                List<Constraint> slice = formulaSlicing(resultAsClauses, c);
                if not slice:
                    result.add(c);
                    resultAsClauses.add(PcClause(c, False));
                elif slice[0] == True:
                    pass;
                elif slice[0] == False:
                    pass;
                else:
                    consistencyCheck = [clause.conditional for clause in slice];
                    consistencyCheck.append(c);
                    if not isInconsistent(consistencyCheck):
                        result.add(c);
                        resultAsClauses.add(PcClause(c, False));
                        */
            return result;
	}
		
}
