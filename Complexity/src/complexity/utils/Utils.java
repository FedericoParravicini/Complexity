package complexity.utils;

import java.util.*;

public abstract class Utils {
	
	public void conjuncts() {
		//GeneticExecutor -> pc_to_constraint_set
	}
	
	public void toSmt2() {
		//Class INDIVIDUAL -> __reduce__
	}
	
	public void negate() {
		//CrossoverFunction -> union_crossover & MutationFunction -> negate_mutation
	}
			
	public void assertInRange() {
		
	}
	
	public void assertSorted() {
		
	}
	
	public void assertAllDifferent() {
		
	}
	
	public void assertAllPositive() {
		
	}
	
	public static void ppWcetProfiles(ArrayList<String> profiles) {
		/*
		 """Print the input profiles.

    	Args:
        profiles (:iterable:PathProfile): The profiles.
    	"""
    	for(int i=0; i < profiles.size(); i++){
        	System.out.println("id: i");
        	System.out.println("cost: {profile.cost!r}");
        	System.out.println("complete: {profile.complete!r}");
        	System.out.println("path: {profile.path!r}");
        	System.out.println("pc: {profile.pc!r}");
        	pp_model_dict(profile.model);
        	System.out.println();
        	}
		 */
	}
			
	public void mkNot() {
		//SelectionFunction -> localSearch
	}
	
	public void mkAnd() {
		//(GeneticExecutor)ga_wcet_generator -> pc = mk_and(best_profile.get("pc"))
	}
	
	public void mkImplies() {
		
	}
	
	public void solverAssert() {
		//(GeneticExecutor)ga_wcet_generator -> solver_assert(solver, pc)
	}
	
	public void isContradiction() {
		
	}
	
	public void isTautology() {
		
	}
	
	public void isImplied() {
		
	}
	
	public void isInconsistent() {
		//CrossoverFunction -> singlePointCrossover
	}

}
