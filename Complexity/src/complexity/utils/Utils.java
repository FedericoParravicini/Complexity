package complexity.utils;

import java.util.*;

import complexity.ga.Individual;
import complexity.se.Constraint;

public abstract class Utils {
	
	public static void conjuncts() {
		//TODO:
	}
	
	public static void toSmt2() {
		//TODO:
	}
	
	public static void negate() {
		//TODO: CrossoverFunction -> unionCrossover & MutationFunction -> negateMutation
	}
			
	public static void assertInRange() {
		//TODO:
	}
	
	public static void assertSorted() {
		//TODO:
	}
	
	public static void assertAllDifferent() {
		//TODO:
	}
	
	public static void assertAllPositive() {
		//TODO:
	}
	
	//Print the input profiles
	public static void ppWcetProfiles(ArrayList<Individual> profiles) {
    	for(int i = 0; i < profiles.size(); i++){
        	System.out.println("id: " + i);
        	System.out.println("cost: " + profiles.get(i).getFitness());
        	//TODO:
        	//System.out.println("complete: {profile.complete!r}");
        	//System.out.println("path: {profile.path!r}");
        	//System.out.println("pc: {profile.pc!r}");
        	System.out.println(profiles.get(i).getModel());
        	System.out.println();
        	}
	}
	
	//return the negation of the given constraint
	public static void mkNot(Constraint constraint) {
		//TODO:
	}
	
	public static void mkAnd() {
		//TODO: (GeneticExecutor)ga_wcet_generator -> pc = mkAnd(bestProfile.get("pc"))
	}
	
	public static void mkImplies() {
		//TODO:
	}
	
	public static void solverAssert() {
		//TODO: (GeneticExecutor)ga_wcet_generator -> solver_assert(solver, pc)
	}
	
	public static void isContradiction() {
		//TODO:
	}
	
	public static void isTautology() {
		//TODO:
	}
	
	public static void isImplied() {
		//TODO:
	}
	
	public static void isInconsistent() {
		//TODO: CrossoverFunction -> singlePointCrossover
	}

}
