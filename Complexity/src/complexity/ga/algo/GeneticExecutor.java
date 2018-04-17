package complexity.ga.algo;
import java.util.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.Math; 

import complexity.ga.FitnessFunction;
import complexity.ga.Individual;
import complexity.localSearch.*;
import complexity.utils.HallOfFame;
import complexity.utils.RandomSingleton;
import complexity.utils.Utils;
import complexity.utils.Config;

public class GeneticExecutor {
	//Setting the logger level go to -> log4j2.xml -> configuration -> loggers -> logger -> level
	//and set one from: ALL > DEBUG > ERROR > FATAL > INFO > OFF > TRACE > WARN
	
	private static final Logger logger = LogManager.getLogger(GeneticExecutor.class);
	
	public static void writeIndividualsToCsv(String csvWriter, int g, String string, ArrayList<Individual> population2) {
		//
	}
	
	public static void logPopulation(ArrayList<Individual> population) {
		for(int i = 0; i < population.size(); i++) {
			logger.debug(i + " " + population.get(i).toString());
		}
	}
	
	public static void logPopulationStats(List<Individual> offspring) {
		ArrayList<Integer> fitnesses = new ArrayList<Integer>();
		int sum = 0;
		
		for(int i=0; i < offspring.size(); i++){
			fitnesses.add(offspring.get(i).fitness);
			sum += offspring.get(i).fitness;
			}
		
        int minFitness = Collections.min(fitnesses);
        int maxFitness = Collections.max(fitnesses);
        int avgFitness = sum / fitnesses.size();
        logger.info("max: " + maxFitness + ", min: " + 
        	minFitness + ", avg: " + avgFitness);
	}
	
	//Sort population by fitness value and return the first n individuals of the population
	private static ArrayList<Individual> elitism(List<Individual> offspring, int n) {
		ArrayList<Individual> populationSorted = new ArrayList<>();
		Collections.sort(offspring, new Comparator<Individual>() {
			@Override
			public int compare (Individual ind2, Individual ind1) {
				Integer ind = new Integer(ind1.fitness); 
				return ind.compareTo(ind2.fitness);
			}
		});
		for(int i = 0; i < n; i++) {
			populationSorted.add(offspring.get(i));
		}
        return populationSorted;
	}
	
	public static void main (String[] args){
		/*
		args = getattr(module_, configuration.args_gen)(configuration.size);
		kwargs = getattr(module_, configuration.kwargs_gen)(configuration.size);*/
		
		RandomSingleton.getInstance().setSeed(Config.seed);
		
		logger.info("Configuration: ");
		logger.info("Generations: " + Config.generations);
		logger.info("Max estimated time: " + 
				FitnessFunction.estimateHours(Config.generations, Config.populationSize, Config.mutationProb, Config.timeout) + " hours");
		logger.info("Max estimated fitness evaluations: " +
				FitnessFunction.estimateFitnessEvaluations(Config.generations, Config.populationSize, Config.mutationProb));
		
		ArrayList<Individual> profiles = new ArrayList<>();
		profiles = wcetGenerator(); 
		Utils.ppWcetProfiles(profiles);
		
    	System.out.println("Worst case input: " + profiles.get(0).getConstraintSet().toString());
    	System.out.println("Worst case model: " + profiles.get(0).getModel().toString());
    	System.out.println("Worst case cost: " + profiles.get(0).getFitness());
		
	}
	

	public static ArrayList<Individual> wcetGenerator(){
			    
	    //Initialize the CSV writer.
		//TODO: String csvWriter = null;
		/*
		if (config.get("evolutionCsv") != null)
			csvWriter = csv.DictWriter(config.evolution_csv, EVOLUTION_CSV_FIELDS, quoting=csv.QUOTE_NONNUMERIC,
			                                    lineterminator='\n');
		else csvWriter.writeheader();
		*/
		
		ArrayList<Individual> population = new ArrayList<Individual>();
		
		int eliteSize = (int) Math.round(Config.eliteRatio * Config.populationSize);
		HallOfFame hof = new HallOfFame(5);
		
		logger.debug("Generating initial population");
		
		for (int i = 0; i < Config.populationSize; i++) {
			population.add(Individual.randomIndividual());
		}
		
		
		logPopulation(population);
		population = elitism(population, Config.populationSize);
		hof.update(population);
		
		logger.debug("hall of fame:");
		for(int i = 0; i < hof.bestIndividuals.size(); i++) {
			logger.debug(hof.bestIndividuals.get(i).toString());
		}

        for(int g = 0; g < Config.generations; g++) {    	
        	logger.info("generation " + g + "}:");       //TODO ELITE???
            if(g % Config.localSearchRate == 0 && g > 0) {     	
                Individual best = hof.bestIndividuals.get(0);
           
                LocalSearchAlgorithm lsa = LocalSearchAlgorithm.makeLocalSearchHillClimbing();              
                Individual optimizedBest = lsa.localSearch(best);
                
                if (optimizedBest.getFitness() > best.getFitness()) {
                    population.remove(best);
                    population.add(optimizedBest);
                }
                logger.debug("local search stats:");
                logPopulationStats(population);
            }
            
            /*if (config.get("evolutionCsv") != null){
            	writeIndividualsToCsv(csvWriter, g, "fitness", population);
                ((PrintStream) config.get("evolutionCsv")).flush();
            }*/
            
            //SELECTION 
            ArrayList<Individual> parents;
            parents = Config.selectionFunction.selection(population, (int) Math.round(Config.populationSize / 2));
            System.out.println("parents");

            for(int i = 0; i < parents.size(); i++) {
            	System.out.println("* " + parents.get(i).fitness + " - " + parents.get(i++).fitness);         
            }
            
            /*if (config.get("evolutionCsv") != null) {
            	ArrayList<Individual> parentsPopulation = new ArrayList<Individual>();
            	for(int i = 0; i < parents.size(); i++) {
            		parentsPopulation.add(parents.get(i));
            		}
            	writeIndividualsToCsv(csvWriter, g, "selection", parentsPopulation);
            	((PrintStream) config.get("evolutionCsv")).flush();
            }*/      
            
            //CROSSOVER
            List<Individual> offspring = new ArrayList<>();
            Iterator<Individual> parentIterator = parents.iterator();
            while (parentIterator.hasNext()) {
            	Individual offspring1 = parentIterator.next().cloneIndividual();
            	Individual offspring2 = parentIterator.next().cloneIndividual();
            	Config.crossoverFunction.crossover(offspring1, offspring2);
            	offspring.add(offspring1);
            	offspring.add(offspring2);
            }
            offspring = elitism(offspring, offspring.size());
            
            logger.debug("offspring after crossover and mutation:");
            //log_population(offspring)
            logPopulationStats(offspring);

            /*if(config.get("evolutionCsv") != null){
                writeIndividualsToCsv(csvWriter, g, "crossover", offspring);
                ((PrintStream) config.get("evolutioCsv")).flush();
                }*/
            
			/*
            #random_seeds = [rng.getrandbits(32) for _ in offspring]
            #with NonDaemonicPool(config.pool_size) as p:
            #    offspring = p.starmap(mutation, zip(random_seeds, offspring))
            #hof.update(offspring)

            #logger.debug('offspring after mutation:')
            ##log_population(offspring)
            #print (len(offspring))
            #log_population_stats(offspring)

            #if config.evolution_csv:
            #    write_individuals_to_csv(csv_writer, g, 'mutation', offspring)
            #    config.evolution_csv.flush()
			*/
            
            ArrayList<Individual> elite = new ArrayList<>();
            elite = elitism(population, eliteSize);
            population.addAll(offspring);
            population.removeAll(elite);
            population = Config.selectionFunction.survivalSelection(population, Config.populationSize - eliteSize);
            population.addAll(elite);
            System.out.println("best: " + elite.get(0));

            logger.debug("generation summary: ");
            //log_population(population);
            logPopulationStats(population);

            logger.debug("hall of fame: ");
            //logger.debug(hof);

            /*if(config.get("evolutionCsv") != null) {
                writeIndividualsToCsv(csvWriter, g, "survivalSelection", population);
                ((PrintStream) config.get("evolutionCsv")).flush();
                }
                */
        }
        
        /*
             if config.evolution_csv:
        write_individuals_to_csv(csv_writer, config.generations - 1, 'result', population)
        config.evolution_csv.flush()
		*/
    	
        logger.info("Best individual: " + hof.bestIndividuals.get(0));
        																
        return hof.bestIndividuals; //constrained_wcetpp(best_individual.constraint_set)
		
	}
}













