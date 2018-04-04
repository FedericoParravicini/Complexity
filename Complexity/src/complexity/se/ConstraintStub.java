package complexity.se;

public class ConstraintStub extends Constraint {
	
	private static final String chars = "abcdefghijklmnopkrstuvwxyzabcdefghijklmnopkrstuvwxyzabcdefghijklmnopkrstuvwxyzabcdefghijklmnopkrstuvwxyz";
	private static int nextChar = 0;

	private final String theConstraint; 
	
	public ConstraintStub() {
		super();
		theConstraint = chars.charAt(nextChar++) + " > 0";
	}

	@Override
	public String toString() {
		return theConstraint;
	}	

}
