package complexity.utils;

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
	
	public void ppWcetProfiles() {
		//GenticExecutor -> run
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
