package complexity.ga.operators.crossover;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import complexity.ga.Individual;
import complexity.se.Constraint;

public class SinglePointCrossover extends CrossoverFunction {

	@Override
	public void crossover(Individual p1, Individual p2) {
		
		List<Constraint> cons1 = p1.getConstraintSet();
		List<Constraint> cons2 = p2.getConstraintSet();
		int cp1;
		int cp2;
		
		if(cons1.size() > 1) {
			cp1 = ThreadLocalRandom.current().nextInt(1, cons1.size() - 1);
		}else {
			cp1 = 0;
		}
		if(cons2.size() > 1) {
			cp2 = ThreadLocalRandom.current().nextInt(1, cons2.size() - 1);
		}else {
			cp2 = 0;
		}
		
		//TODO:
		
	}
		
}
