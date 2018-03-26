package complexity.ga.operators.selection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import complexity.ga.Individual;

public abstract class SelectionFunction{
	
	ArrayList<Individual> population = new ArrayList<Individual>();
	int n;
	
	public SelectionFunction(ArrayList<Individual> population, int n) {
		super();
		this.population = population;
		this.n = n;
	}

	public static ArrayList<Individual> selection(ArrayList<Individual> population, int n) {
		ArrayList<Individual> result = new ArrayList<Individual>();
		for (int i = 0; i < n; i++){
		    Individual individual1 = rouletteSelection(population);
		    population.remove(individual1);
		    Individual individual2 = rouletteSelection(population);
		    population.add(individual1);
		    result.add(0, individual1);
		    result.add(1, individual2);
		}
		return result;
	}
	
	/*
	public void constrainedWcetpp() {
		
	}
	*/
	
	public static void localSearch(Individual individual) {
		//????
	}
	
	public static ArrayList<Integer> rankSelection(ArrayList<Individual> population) {
		ArrayList<Integer> ranking = new ArrayList<Integer>();
        int currRank = 0;
        int currFitness = 0;
        for(int i=0; i < population.size(); i++){
            if (population.get(i).fitness > currFitness) {
                currFitness = population.get(i).fitness;
                currRank = i + 1;
                }
            ranking.add(currRank);
            }
        return ranking;
	}
	
	public static Individual rouletteSelection(ArrayList<Individual> population) {
		//population = sorted(population, key=lambda individual: individual.fitness)
		Collections.sort(population, new Comparator<Individual>() {
		@Override
		public int compare (Individual ind2, Individual ind1) {
		Integer ind = new Integer(ind1.fitness); 
			return ind.compareTo(ind2.fitness);
			}
		});
        ArrayList<Integer> ranking = rankSelection(population);
        int rankSum = 0;
        for(int i = 0; i < ranking.size(); i++){
        	rankSum = rankSum + ranking.get(i);
        }
        int pick = 0; //rng.uniform(0, rank_sum)
        int current = 0;
        Individual indSelected = new Individual(null, 0);
        for(int i = 0; i < ranking.size(); i++){
            current += ranking.get(i);
            if(current > pick) {
                indSelected = population.get(i);
                }
            }
        return indSelected;
	}

	public static ArrayList<Individual> survivalSelection(ArrayList<Individual> population, int n) {
        ArrayList<Individual> result = new ArrayList<Individual>();
        for(int i=0; i < n; i++) {
            Individual individual = rouletteSelection(population);
            population.remove(individual);
            result.add(individual);
            }
        return result;
	}
	
}
