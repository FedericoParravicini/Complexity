package complexity.se;

public class ConstraintStub extends Constraint {
	
	private static final String chars = "abcdefghijklmnopkrstuvwxyzabcdefghijklmnopkrstuvwxyzabcdefghijklmnopkrstuvwxyzabcdefghijklmnopkrstuvwxyz";
	private static int nextChar = 0;

	private final String theConstraint; 
	
	public ConstraintStub() {
		super();
		theConstraint = chars.charAt(nextChar++) + " > 0";
	}

	private ConstraintStub(String constraint) {
		theConstraint = constraint;
	}

	@Override
	public String toString() {
		return theConstraint;
	}

	@Override
	public Constraint mkNot() {
		return new ConstraintStub("not (" + this.theConstraint + ")");
	}	

}