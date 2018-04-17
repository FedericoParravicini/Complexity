package complexity.utils;

import java.util.*;

import complexity.ga.Individual;
import complexity.se.Constraint;

public abstract class Utils {
	
	//Extract a random Individual from an ArrayList
	public static Individual getRandom(ArrayList<Individual> individuals) {
	    int rnd = new Random().nextInt(individuals.size());
	    return individuals.get(rnd);
	}
	
	
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
	
	public static List<Constraint> mkAnd(List<Constraint> refs) {
		//TODO: (GeneticExecutor)ga_wcet_generator -> pc = mkAnd(bestProfile.get("pc"))
		return null;
	}
	
	public static void mkImplies() {
		//TODO:
	}
	
	public static void solverAssert() {
		//TODO: (GeneticExecutor)ga_wcet_generator -> solver_assert(solver, pc)
	}
	
	public static boolean isContradiction(Constraint constraint) {
		//TODO: return quick_check([c]) == z3.unsat
		return true;
	}
	
	public static boolean isTautology(Constraint constraint) {
		//TODO: return quick_check([mk_not(c)]) == z3.unsat
		return true;
	}
	
	public static boolean isImplied(Constraint constraint) {
		//TODO: return is_tautology(mk_implies(mk_and(constraint_set), c))
		return true;
	}
	
}
