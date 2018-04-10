package complexity.ga.operators.crossover;

import java.util.ArrayList;
import java.util.List;

import complexity.ga.FitnessFunction;
import complexity.ga.Individual;
import complexity.se.Constraint;

public class UnionCrossover extends CrossoverFunction{

	@Override
	public ArrayList<Individual> crossover(Individual parent1, Individual parent2) {
		
		List<Constraint> constraints1 = parent1.getConstraintSet();
		List<Constraint> constraints2 = parent2.getConstraintSet();
		
		/*TODO
		//all_constraints = constraints1 | constraints2

        List<Constraint> childConstraints1 = new ArrayList<>();
        List<Constraint> childConstraints2 = new ArrayList<>();
        while(all_constraints) {
            c = all_constraints.pop();
            not_c = negate(c);
            if(not_c in all_constraints){
                all_constraints.remove(not_c);
                genes = [c, not_c];
                config.random.shuffle(genes);
                child_constraints1.append(genes[0]);
                child_constraints2.append(genes[1]);
            }else{
                child_constraints1.addAll(c)
                child_constraints2.addAll(c)
                }
		}
		
		Individual child1 = FitnessFunction.evaluate(childConstraints1);
        Individual child2 = FitnessFunction.evaluate(childConstraints2);
        
        ArrayList<Individual> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        return children; //return child1, child2
		 */
		return null;
	}
	
}
