package complexity.localSearch;


import org.junit.jupiter.api.Test;

import complexity.ga.Individual;
import complexity.se.Constraint;
import complexity.se.Symex;
import complexity.utils.Config;
import complexity.utils.RandomSingleton;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class testLocalSearch {

	@Test
	@DisplayName("test")
	public void testLocalS() {
		LocalSearchAlgorithm ls = LocalSearchAlgorithm.makeLocalSearchHillClimbing();
		Individual ind1 = Individual.randomIndividual();
		Individual ind2 = ls.localSearch(ind1.cloneIndividual());
		
		System.out.print("ind1 " + ind1.toString());
		System.out.print("ind2 " + ind2.toString());
		
		assertNotEquals(ind1, ind2);
		
		
	}
	
}
