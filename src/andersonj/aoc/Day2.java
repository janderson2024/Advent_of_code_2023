package andersonj.aoc;

import andersonj.helper.Helpers;
import andersonj.helper.Day2Game;

public class Day2 extends Day{

	private static final INPUT_FILE = "day2.txt";

	private static final int MAX_RED = 12;
	private static final int MAX_GREEN = 13;
	private static final int MAX_BLUE = 14;
	
	public Day2(){super();}

	public void solveProblem(){
		System.out.println("INFO: Starting problem...");
		String[] input = Helpers.getPuzzleInput(INPUT_FILE);
		System.out.println("INFO: Loaded input file...");

		String[] testCases = {
			"Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
			"Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
			"Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
			"Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
			"Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
		};

		Day2Game tempGame;

		int validGameSum = 0;

		System.out.println("INFO: Parsing each line...");

		for(String line : input){
			//System.out.println("DEBUG: " + line);

			tempGame = new Day2Game(line);
			int isValid = tempGame.isValidGame(MAX_RED, MAX_GREEN, MAX_BLUE);
			validGameSum += isValid;
		}

		System.out.println("INFO: Final count: " + validGameSum);

	}

	public void solveExtraProblem(){
		System.out.println("INFO: Starting problem...");
		String[] input = Helpers.getPuzzleInput(INPUT_FILE);
		System.out.println("INFO: Loaded input file...");

		String[] testCases = {
			"Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
			"Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
			"Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
			"Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
			"Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
		};

		Day2Game tempGame;

		int maxNeededCubeSums = 0;

		System.out.println("INFO: Parsing each line...");

		for(String line : input){
			System.out.println("DEBUG: " + line);

			tempGame = new Day2Game(line);
			
			int[] maxCounts = tempGame.maxNeededColors();


			System.out.println("DEBUG: Red Max: " + maxCounts[0] + ", Green Max: " + maxCounts[1] + ", Bluen Max: " + maxCounts[2]);

			int cubePower = maxCounts[0] * maxCounts[1] * maxCounts[2];
			System.out.println("Power: " + cubePower);
			maxNeededCubeSums += cubePower;
		}

		System.out.println("INFO: Final count: " + maxNeededCubeSums);


	}
}