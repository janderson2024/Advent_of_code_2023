package andersonj;

import andersonj.aoc.*;

class Launcher{

	public static void main(String[] args) {
		
		Day day = new Day7();

		System.out.println("INFO: Starting problem");
		day.solveProblem();
		System.out.println("-----------------------");
		System.out.println("INFO: Starting extra problem");
		day.solveExtraProblem();
	}
}