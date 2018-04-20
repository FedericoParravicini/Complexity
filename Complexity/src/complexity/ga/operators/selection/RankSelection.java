package complexity.ga.operators.selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import complexity.ga.Individual;
import complexity.utils.RandomSingleton;

public class RankSelection extends SelectionFunction {

	private ArrayList<Integer> rankSelection(List<Individual> population) {
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
	
	@Override
	protected Individual selectIndividual(List<Individual> individuals) {
		Collections.sort(individuals, new Comparator<Individual>() {
			@Override
			public int compare (Individual ind2, Individual ind1) {
				Integer ind = new Integer(ind1.fitness); 
				return ind.compareTo(ind2.fitness);
				}
			});
        ArrayList<Integer> ranking = rankSelection(individuals);
        int rankSum = 0;
        for(int i = 0; i < ranking.size(); i++){
        	rankSum = rankSum + ranking.get(i);
        }
        int pick = RandomSingleton.getInstance().nextInt(rankSum + 1);
        int current = 0;
        Individual indSelected = individuals.get(0); //TODO
        for(int i = 0; i < ranking.size(); i++){
            current += ranking.get(i);
            if(current > pick) {
                indSelected = individuals.get(i);
            }	
        }
        return indSelected;
	}


}
