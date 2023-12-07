package andersonj.aoc;

import andersonj.helper.Helpers;
import andersonj.helper.Day7CardHand;

import java.util.Arrays;


public class Day7 extends Day{

	private static final String INPUT_FILE = "day7.txt";


	public Day7(){super();}

	public void solveProblem(){
		System.out.println("INFO: Starting problem...");
		String[] input = Helpers.getPuzzleInput(INPUT_FILE);
		System.out.println("INFO: Loaded input file...");

		String[] testCases = {
			"32T3K 765",
			"T55J5 684",
			"KK677 28",
			"KTJJT 220",
			"QQQJA 483",
		};

		//input = testCases;

		System.out.println("INFO: Parsing input....");
		Day7CardHand[] hands = new Day7CardHand[input.length];

		for(int i = 0; i < input.length; i++){
			hands[i] = new Day7CardHand(input[i]);
		} 
		
		System.out.println("INFO: Sorting...");
		Arrays.sort(hands);


		int totalWinnings = 0;

		for(int i = 0; i < hands.length; i ++){
			totalWinnings += (hands[i].getBid() * (i+1));

		}
		System.out.println("Finished parsing...");
		System.out.println("INFO: Final count: " + totalWinnings);


	}

	public void solveExtraProblem(){
		System.out.println("INFO: Starting problem...");
		String[] input = Helpers.getPuzzleInput(INPUT_FILE);
		System.out.println("INFO: Loaded input file...");

		String[] testCases = {
			"32T3K 765",
			"T55J5 684",
			"KK677 28",
			"KTJJT 220",
			"QQQJA 483",
		};

		input = testCases;

		
		System.out.println("Finished parsing...");
		//System.out.println("INFO: Final count: " + numberOfTotalCards);


	}
}