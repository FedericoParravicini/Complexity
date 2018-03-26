package complexity.ga.algo;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.*;
import java.lang.Math; 


import complexity.ga.FitnessFunction;
import complexity.ga.Individual;
import complexity.ga.operators.crossover.CrossoverFunction;
import complexity.ga.operators.mutation.MutationFunction;
import complexity.ga.operators.selection.SelectionFunction;
import complexity.utils.HallOfFame;
import complexity.utils.Utils;
import complexity.utils.Config;


public class GeneticExecutor {
	
	private FitnessFunction fitnessFunction = new FitnessFunction(null);
	private SelectionFunction selectionFunction;
	private CrossoverFunction crossoverFunction;
	private MutationFunction mutationFunction;
	
	private static ArrayList<Individual> population = new ArrayList<Individual>();
	private HallOfFame hof = new HallOfFame(0, null);
	
	public static void writeIndividualsToCsv(String csvWriter, int g, String string, ArrayList<Individual> population2) {
		//
	}
	
	public static void logPopulation(ArrayList<Individual> population) {
		//
	}
	
	public static void logPopulationStats(ArrayList<Individual> population) {
		ArrayList<Integer> fitnesses = new ArrayList<Integer>();
		int sum = 0;
		
		for(int i=0; i < population.size(); i++){
			fitnesses.add(population.get(i).fitness);
			sum += population.get(i).fitness;
			}
		
        int minFitness = Collections.min(fitnesses);
        int maxFitness = Collections.max(fitnesses);
        int avgFitness = sum / fitnesses.size();
        System.out.println("max: " + maxFitness + ", min: " + 
        	minFitness + ", avg: " + avgFitness);
	}
	
	public static void elitism(ArrayList<Individual> population, int n) {
		//population sorted by fitness
		Collections.sort(population, new Comparator<Individual>() {
			@Override
			public int compare (Individual ind2, Individual ind1) {
				Integer ind = new Integer(ind1.fitness); 
				return ind.compareTo(ind2.fitness);
			}
		});
        //return population[:n], population[n:] -> il primo contiene i primi n oggetti, il secondo gli ultimi n oggetti
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
		
		HashMap<String, Object> config = new HashMap<String, Object>(10);	
		config.put("generations", Config.generations);
		config.put("populationSize", Config.populationSize);
		config.put("crossover", Config.crossover);
		config.put("mutationProb", Config.mutationProb);
		config.put("eliteRatio", Config.eliteRatio);
		config.put("seed", Config.seed);
		config.put("evolutionCsv", Config.evolutionCsv);

		System.out.println("configuration: ");
		for (String name: config.keySet()){
			String key = name.toString();
	        String value = config.get(name).toString();  
	        System.out.println(key + " " + value);
	    }
		System.out.println("max estimated time: " + FitnessFunction.estimateHours(config) + "hours");
		System.out.println("max estimated fitness evaluations: " + FitnessFunction.estimateFitnessEvaluations(config));

		/*
		func = getattr(module_, configuration.function)

    	profiles = wcetGenerator(
        //func,
        //args,
        //kwargs,
        config,
    	)
    	ppWcetProfiles(profiles)

    	modelToInput = getattr(module_, configuration.modelToInput)
    	worstCaseModel = modelDictToString(profiles[0].model)
    	worstCaseInput = modelToInput(profiles[0].model, configuration.size)
    	worstCaseCost = countInstructions(func, *worst_case_input)
    	System.out.println(worstCaseModel);
    	System.out.println(worstCaseInput);
    	System.out.println(worstCaseCost);
		 */
		
	}
	

	public static ArrayList<String> wcetGenerator(HashMap<String, Object> config){
		
		//Initialize the random number generator.
		//int rng = random.Random();
		//rng.seed(config.get("seed"));
			    
	    //Initialize the CSV writer.
		String csvWriter = null;
		/*
		if (config.get("evolutionCsv") != null)
			csvWriter = csv.DictWriter(config.evolution_csv, EVOLUTION_CSV_FIELDS, quoting=csv.QUOTE_NONNUMERIC,
			                                    lineterminator='\n');
		else csvWriter.writeheader();
		*/
		double eliteRatio = 0;
		double populationSize = 0;
		int eliteSize = (int) Math.round(eliteRatio * populationSize);
		HallOfFame hof = new HallOfFame(5, null);
		
		// if config.random_search:...
		// else
		
		System.out.println("generating initial population");
		
		/*
		random_seeds = [rng.getrandbits(32) for _ in range(config.population_size)]
		with NonDaemonicPool(config.pool_size) as p:
		     population = p.map(random_individual, random_seeds)
		*/
		
		hof.update(population);
		logPopulation(population);
		
		System.out.println("hall of fame:");
        System.out.println(hof);
        
        int g;
        int generations = 5;
        for(g = 0; g < generations; g++) {    	
        	System.out.println("generation {" + g + "}:");
            
            if(((g % 5) == 0) && (g > 0)) {
            	/*
                best = elite[0]
                optimized_best = local_search(best)
                if optimized_best.fitness > best.fitness:
                    population.remove(best)
                    population.add(optimized_best)
                */
                System.out.println("local search stats:");
                logPopulationStats(population);
            }
            
            if (config.get("evolutionCsv") != null){
            	writeIndividualsToCsv(csvWriter, g, "fitness", population);
                ((PrintStream) config.get("evolutionCsv")).flush();
            }
            
            //Selection
            
            ArrayList<Individual> parents;
            parents = SelectionFunction.selection(population, (int) Math.round(populationSize / 2));
            System.out.println("parents");

            for(int i = 0; i < parents.size(); i++) {
            	System.out.println("* " + parents.get(i).fitness + " - " + parents.get(i++).fitness);         
            }
            
            if (config.get("evolutionCsv") != null) {
            	ArrayList<Individual> parentsPopulation = new ArrayList<Individual>();
            	for(int i = 0; i < parents.size(); i++) {
            		parentsPopulation.add(parents.get(i));
            		}
            	writeIndividualsToCsv(csvWriter, g, "selection", parentsPopulation);
            	((PrintStream) config.get("evolutionCsv")).flush();
            } 
            
            //sistemare la CROSSOVER FUNCTION
            //random_seeds = [rng.getrandbits(32) for _ in parents];
            //with NonDaemonicPool(config.pool_size) as p:
            /*
                if config.crossover == 'singlepoint':
                    crossover_function = single_point_crossover
                elif config.crossover == 'prefix':
                    crossover_function = prefix_crossover
                elif config.crossover == 'exclude':
                    crossover_function = exclude_crossover
                elif config.crossover == 'union':
                    crossover_function = union_crossover
                offspring = list(chain.from_iterable(p.starmap(crossover_function, zip(random_seeds, parents))))
            hof.update(offspring);*/ 
            ArrayList<Individual> offspring = null;
            
            System.out.println("offspring after crossover and mutation:");
            //log_population(offspring)
            logPopulationStats(offspring);

            if(config.get("evolutionCsv") != null){
                writeIndividualsToCsv(csvWriter, g, "crossover", offspring);
                ((PrintStream) config.get("evolutioCsv")).flush();
                }
            
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
            
            //elite_size = config.population_size;
            //elite, population = elitism(population + offspring, n=elite_size);
            //population = survival_selection(population, n=(config.population_size - elite_size));
            //population.extend(elite);
            System.out.println("best: " /*+ elite[0]*/);

            System.out.println("generation summary:");
            //log_population(population);
            logPopulationStats(population);

            System.out.println("hall of fame:");
            //logger.debug(hof);

            if(config.get("evolutionCsv") != null) {
                writeIndividualsToCsv(csvWriter, g, "survivalSelection", population);
                ((PrintStream) config.get("evolutionCsv")).flush();
                }
        }
        
        /*
             if config.evolution_csv:
        write_individuals_to_csv(csv_writer, config.generations - 1, 'result', population)
        config.evolution_csv.flush()

    	best_individual = hof.best_individual()
    	logger.info('best individual: %s', best_individual)

    	best_profile = constrained_wcetpp(best_individual.constraint_set)
    	pc = mk_and(best_profile.get("pc"))

    	solver = z3.Solver()
    	solver.push()
    	solver_assert(solver, pc)
    	status = solver.check()
    	best_profile.put("model", solver.model())
    	solver.pop()
         */
        ArrayList<String> bestProfile = null;
        return bestProfile; //constrained_wcetpp(best_individual.constraint_set)
		
	}
}













