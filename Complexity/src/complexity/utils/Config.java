package complexity.utils;

import complexity.ga.operators.crossover.CrossoverFunction;
import complexity.ga.operators.crossover.SinglePointCrossover;
import complexity.ga.operators.selection.RankSelection;
import complexity.ga.operators.selection.SelectionFunction;

public class Config {
	
	public static final int generations = 0; //n° di generazioni che l’algoritmo deve eseguire
	public static final int populationSize = 0; //n° di individui presenti nella popolazione
	public static final CrossoverFunction crossoverFunction = new SinglePointCrossover(); //quale funzione di crossover sarà usata (prefix, exclude, singlepoint, union)
	public static final SelectionFunction selectionFunction = new RankSelection(); //quale funzione di crossover sarà usata (prefix, exclude, singlepoint, union)
	public static final int mutationProb = 0; //probabilità di applicare o meno l’operatore di mutazione agli individui generati
	public static final int eliteRatio = 0; //n° individui migliori che vengono preservati (elite) in percentuale rispetto alla popolazione
	public static final int seed = 0; //un numero da usare come seed per il generatore di numeri random		   
	public static final String evolutionCsv = null; //nome di un file per scrivere i risultati, per adesso potremmo ignorarlo	
	public static final int timeout = 0;	
	//int pool_size;
	//random_search;
	public static final int localSearchRate = 5;
		
}
