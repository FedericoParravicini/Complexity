package complexity.utils;

import java.util.Random;

public class RandomSingleton {
	private static RandomSingleton instance;
	private Random rng;

    private RandomSingleton() {
        rng = new Random();
    }

    public static RandomSingleton getInstance() {
        if(instance == null) {
            instance = new RandomSingleton();
        }
        return instance;
    }

    public int nextInt() {
         return rng.nextInt();
    }
    
    public int nextInt(int bound) {
    	return rng.nextInt(bound);
    }
    
    public void setSeed(long seed) {
    	rng.setSeed(seed);
    }

	public boolean nextBoolean() {
		return rng.nextBoolean();
	}
    
}
