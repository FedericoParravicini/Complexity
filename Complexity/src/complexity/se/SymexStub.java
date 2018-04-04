package complexity.se;

import java.util.ArrayList;
import java.util.List;

public class SymexStub implements Symex {

	@Override
	public List<Constraint> randomWalkSymbolicExecution(List<Constraint> precondition) {
		List<Constraint> fakePathCondition = new ArrayList<>(precondition);
		
		fakePathCondition.addAll(randomWalkSymbolicExecution());
		
		return fakePathCondition;
	}

	@Override
	public List<Constraint> randomWalkSymbolicExecution() {
		List<Constraint> fakePathCondition = new ArrayList<>();
		
		int n = 1 + (int) (Math.random() * 30);
		for (int i = 0; i < n; i++) {
			fakePathCondition.add(new ConstraintStub());
		}

		return fakePathCondition;
	}

	@Override
	public List<Constraint> formulaSlicing(List<Constraint> formula, Constraint target) {
		return formula;
	}

}
