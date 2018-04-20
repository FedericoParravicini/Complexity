package complexity.ga.operators.crossover;

import org.junit.jupiter.api.Test;

import complexity.ga.Individual;
import complexity.ga.algo.GeneticExecutor;
import complexity.utils.Config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Crossover test suite")
public class testCrossover {
	/*
	@Test
	@DisplayName("crossover returns ...")
	public void testSelection1() {
		ArrayList<Individual> population = new ArrayList<>();
		for (int i = 0; i < Config.populationSize; i++) {
			population.add(Individual.randomIndividual());
		}
		ArrayList<Individual> parents = Config.selectionFunction.selection(population, (int) Math.round(Config.populationSize / 2));
		
		for(int i = 0, j = 1; i < parents.size(); i++, j++) {
			System.out.println(parents.get(i).toString() + " - " + parents.get(j).toString());
			i++;
			j++;
		}
		System.out.println("");
		List<Individual> offspring = new ArrayList<>();
        Iterator<Individual> parentIterator = parents.iterator();
        while (parentIterator.hasNext()) {
        	Individual offspring1 = parentIterator.next().cloneIndividual();
        	Individual offspring2 = parentIterator.next().cloneIndividual();
        	offspring.addAll(Config.crossoverFunction.crossover(offspring1, offspring2));
        	//offspring.add(offspring1);
        	//offspring.add(offspring2);
        }
        
        
        
        offspring = GeneticExecutor.elitism(offspring, offspring.size());
        System.out.println("");
		for(int i = 0, j = 1; i < offspring.size(); i++, j++) {
			System.out.println(offspring.get(i).toString());
			System.out.println(offspring.get(j).toString());
			i++;
			j++;
		}
	}*/
	
}
