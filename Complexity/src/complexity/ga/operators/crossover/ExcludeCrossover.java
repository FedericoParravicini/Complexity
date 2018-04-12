package complexity.ga.operators.crossover;

import java.util.ArrayList;
import java.util.List;

import complexity.ga.Individual;
import complexity.se.Constraint;
import complexity.utils.RandomSingleton;
import complexity.utils.Utils;

public class ExcludeCrossover extends CrossoverFunction{

	@Override
	public ArrayList<Individual> crossover(Individual parent1, Individual parent2) {

		List<Constraint> Constraints1 = parent1.getConstraintSet();
		List<Constraint> Constraints2 = parent2.getConstraintSet();
		
		List<Constraint> parent1Split1 = splitConstraints(Constraints1).get(0);
        List<Constraint> parent1Split2 = splitConstraints(Constraints1).get(1);
        List<Constraint> parent1Split3 = splitConstraints(Constraints1).get(2);
        List<Constraint> parent2Split1 = splitConstraints(Constraints2).get(0);
        List<Constraint> parent2Split2 = splitConstraints(Constraints2).get(1);
        List<Constraint> parent2Split3 = splitConstraints(Constraints2).get(2);
        
		/*TODO
        options = (
            (parent1_split1, parent2_split1),
            (parent1_split2, parent2_split2),
            (parent1_split3, parent2_split3),
        )

        choices = rng.sample(options, k=2); //usare (rng.nextBoolean() ? parent2Split1 : parent2Split2)
        child1_contraints = combine(choices[0][0], choices[1][1]);
        child2_contraints = combine(choices[1][0], choices[0][1]);

        child1 = evaluate(tuple(child1_contraints));
        child2 = evaluate(tuple(child2_contraints));
        return child1, child2;
		 */
		return null;
	}
	
	private List<List<Constraint>> splitConstraints(List<Constraint> constraints) {
		List<List<Constraint>> splitset = new ArrayList<>(3);
		List<Constraint> get0 = new ArrayList<>(1);
		get0.add(constraints.get(0));
		List<Constraint> get1 = new ArrayList<>(1);
		get1.add(constraints.get(0));
		List<Constraint> get2 = new ArrayList<>(1);
		get2.add(constraints.get(0));
		if(constraints.size() == 0){
			return splitset;
		}else if(constraints.size() == 1){
			splitset.add(constraints);
			return splitset;
        }else if(constraints.size() == 2){
        	splitset.add(get0);
            splitset.add(get1);
            return splitset;
        }else if(constraints.size() == 3){
        	splitset.add(get0);
            splitset.add(get1);
            splitset.add(get2);
            return splitset;
        }else if(constraints.size() > 2){
        	int point1 = RandomSingleton.getInstance().nextInt(constraints.size() - 2) + 1;
        	int point2 = RandomSingleton.getInstance().nextInt((constraints.size() - point1) + 1) + point1 + 1;
        	List<Constraint> set1 = new ArrayList<>();
        	List<Constraint> set12 = new ArrayList<>();
        	List<Constraint> set2 = new ArrayList<>();
        	for(int i = 0; i < point1; i++){
        		set1.add(constraints.get(i));
        		}
        	for(int i = point1; i <= point2; i++){
        		set12.add(constraints.get(i));
        		}
        	for(int i = point2; i < constraints.size(); i++){
        		set2.add(constraints.get(i));
        		}
        	splitset.add(set1);
            splitset.add(set12);
            splitset.add(set2);
            }
		return splitset;
	}
	
	private List<Constraint> combine(List<Constraint> constraints1, List<Constraint> constraints2) {
		List<Constraint> result = constraints1;
        for(int i = 0; i < constraints2.size(); i++){
        	result.add(constraints2.get(i));
        	if(Utils.isInconsistent(result)){
        		result.remove(constraints2.size() - 1);
        		}
        	}
        return result;
	}
	
	
}
