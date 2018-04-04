package complexity.se;

public abstract class Constraint {

	@Override
	public abstract String toString(); 
	
	public abstract Constraint mkNot();
	

}
