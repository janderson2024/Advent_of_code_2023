package andersonj.aoc;

public abstract class Day{

	public Day(){
		System.out.println("We are running: " + this.getClass().getSimpleName());

	}
	
	public abstract void solveProblem();

	public abstract void solveExtraProblem();
}