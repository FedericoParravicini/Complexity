package complexity.ga;
import java.util.ArrayList;
import java.util.*;

public class FitnessFunction{
	
	ArrayList<String> constraintSet = new ArrayList<String>();

	public FitnessFunction(ArrayList<String> constraintSet) {
		super();
		this.constraintSet = constraintSet;
	}

	public void evaluate(String constraintSet) {
		
	}
	
	public  static int estimateFitnessEvaluations(HashMap<String, Object> config) {
		/*
		"""Returns the estimated number of fitness evaluations to run `ga_wcet_generator` with the given configuration.

	    Returns:
	        (int): The estimated number of fitness evaluations to run `ga_wcet_generator` with the given configuration.
	    """*/
		
	    int g = (int) config.get("generations");
	    int p = (int) config.get("populationSize");
	    int mp = (int) config.get("mutationProb");
	    return Math.round(p * ((mp + 1) * g + 1));
	}
	
	public static int estimateSeconds(HashMap<String, Object> config) {
		return estimateFitnessEvaluations(config) * (int) config.get("timeout");
	}
	
	public static int estimateHours(HashMap<String, Object> config) {
		return estimateSeconds(config) / 3600;
	}
	
}
