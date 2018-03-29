package complexity.ga.algo;
import java.util.*;
import java.lang.Math; 

import org.apache.log4j.Logger;

import complexity.ga.FitnessFunction;
import complexity.ga.Individual;
import complexity.utils.HallOfFame;
import complexity.utils.Utils;
import complexity.utils.Config;

public class GeneticExecutor {
	
	//TODO: static Logger log = Logger.getLogger(GeneticExecutor.class); -> JAVA EXCEPTION
	
	private static ArrayList<Individual> population = new ArrayList<Individual>();
	
	public static void writeIndividualsToCsv(String csvWriter, int g, String string, ArrayList<Individual> population2) {
		//
	}
	
	public static void logPopulation(ArrayList<Individual> population) {
		//
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
        System.out.println("max: " + maxFitness + ", min: " + 
        	minFitness + ", avg: " + avgFitness);
	}
	
	//Sort population by fitness value and return the first n individuals of the population
	private ArrayList<Individual> elitism(ArrayList<Individual> population, int n) {
		ArrayList<Individual> populationSorted = new ArrayList<>();
		//population sorted by fitness
		Collections.sort(population, new Comparator<Individual>() {
			@Override
			public int compare (Individual ind2, Individual ind1) {
				Integer ind = new Integer(ind1.fitness); 
				return ind.compareTo(ind2.fitness);
			}
		});
		for(int i = 0; i < n; i++) {
			populationSorted.add(population.get(i));
		}
        return populationSorted;
	}
	
	public static void main (String[] args){
		/*
		args = getattr(module_, configuration.args_gen)(configuration.size);
		kwargs = getattr(module_, configuration.kwargs_gen)(configuration.size);

	    # Set the logger to DEBUG level to capture intermediate output.
	    formatter = logging.Formatter(fmt='[%(asctime)s] %(message)s', datefmt='%m/%d/%Y %H:%M:%S')
	    handler = logging.StreamHandler()
	    handler.setFormatter(formatter)

	    logger.addHandler(handler)
	    logger.setLevel(logging.DEBUG)
		*/
		
		//Config config;
		
		System.out.println("configuration: ");
		System.out.println("generations: " + Config.generations);
		System.out.println("max estimated time: " + 
				FitnessFunction.estimateHours(Config.generations, Config.populationSize, Config.mutationProb, Config.timeout) + "hours");
		System.out.println("max estimated fitness evaluations: " +
				FitnessFunction.estimateFitnessEvaluations(Config.generations, Config.populationSize, Config.mutationProb));
		
		ArrayList<Individual> profiles = new GeneticExecutor().wcetGenerator(); 
		Utils.ppWcetProfiles(profiles);
		
    	System.out.println("worst case input: " + profiles.get(0).getConstraintSet().toString());
    	//TODO: System.out.println("Worst case model: " + profiles[0].getModel().toString());
    	System.out.println("Worst case cost: " + profiles.get(0).getFitness());
		
	}
	

	public ArrayList<Individual> wcetGenerator(){
		
		//Initialize the random number generator.
		//int rng = random.Random();
		//rng.seed(config.get("seed"));
			    
	    //Initialize the CSV writer.
		//TODO: String csvWriter = null;
		/*
		if (config.get("evolutionCsv") != null)
			csvWriter = csv.DictWriter(config.evolution_csv, EVOLUTION_CSV_FIELDS, quoting=csv.QUOTE_NONNUMERIC,
			                                    lineterminator='\n');
		else csvWriter.writeheader();
		*/
		int eliteSize = (int) Math.round(Config.eliteRatio * Config.populationSize);
		HallOfFame hof = new HallOfFame(5, null);
		
		System.out.println("generating initial population");
		
		/*
		random_seeds = [rng.getrandbits(32) for _ in range(config.population_size)]
		with NonDaemonicPool(config.pool_size) as p:
		     population = p.map(random_ind.vidual, random_seeds)
		*/
		for (int i = 0; i < Config.populationSize; i++) {
			population.add(Individual.randomIndividual());
		}
		
		
		hof.update(population);
		logPopulation(population);
		
		System.out.println("hall of fame:");
        System.out.println(hof);
        
        for(int g = 0; g < Config.generations; g++) {    	
        	System.out.println("generation {" + g + "}:");
            
        	ArrayList<Individual> elite = null;
            if(g % Config.localSearchRate == 0 && g > 0) {
            	
                Individual best = elite.get(0);
                Individual optimizedBest = best; //TODO: local_search(best)
                if (optimizedBest.getFitness() > best.getFitness()) {
                    population.remove(best);
                    population.add(optimizedBest);
                }
                System.out.println("local search stats:");
                logPopulationStats(population);
            }
            
            /*if (config.get("evolutionCsv") != null){
            	writeIndividualsToCsv(csvWriter, g, "fitness", population);
                ((PrintStream) config.get("evolutionCsv")).flush();
            }*/
            
            //Selection
            
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

            List<Individual> offspring = new ArrayList<>();
            Iterator<Individual> parentIterator = parents.iterator();
            while (parentIterator.hasNext()) {
            	Individual offspring1 = parentIterator.next().cloneIndividual();
            	Individual offspring2 = parentIterator.next().cloneIndividual();
            	Config.crossoverFunction.crossover(offspring1, offspring2);
            	offspring.add(offspring1);
            	offspring.add(offspring2);
            }
            hof.update(offspring);
            
            System.out.println("offspring after crossover and mutation:");
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
            
            population.addAll(offspring);
            elite = elitism(population, eliteSize);
            population.removeAll(elite);
            population = Config.selectionFunction.survivalSelection(population, Config.populationSize - eliteSize);
            population.addAll(elite);
            System.out.println("best: " + elite.get(0));

            System.out.println("generation summary:");
            //log_population(population);
            logPopulationStats(population);

            System.out.println("hall of fame:");
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
    	
        Individual bestIndividual = hof.bestIndividual();
    	System.out.println("Best individual: " + bestIndividual);//logger.info('best individual: %s', best_individual); 
        //TODO: implementare la libreria log4j e sostituire i System.out con i logger (info, debug, ...)
        																

        return hof.bestIndividuals; //constrained_wcetpp(best_individual.constraint_set)
		
	}
}













