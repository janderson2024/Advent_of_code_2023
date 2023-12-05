package andersonj.aoc;

import andersonj.helper.Helpers;

public class Day1 extends Day{
	
	public Day1(){super();}

	public void solveProblem(){
		System.out.println("INFO: Starting problem...");
		String[] input = Helpers.getPuzzleInput("day1.txt");
		System.out.println("INFO: Loaded input file...");

		int fullCount = 0;

		String[] testCases = {"1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"};

		for(String line : input){

			int[] numbers = Helpers.getIntsFromString(line);

			int lineValue = Helpers.concatIntFromIntArray(new int[]{numbers[0], numbers[numbers.length-1]});


			fullCount += lineValue;
		}

		System.out.println("INFO: Full count = " + fullCount);
	}

	public void solveExtraProblem(){
		System.out.println("INFO: Starting extra problem...");
		String[] input = Helpers.getPuzzleInput("day1.txt");
		System.out.println("INFO: Loaded input file...");

		int fullCount = 0;

		String[] testCases = {"two1nine","eightwothree","abcone2threexyz","xtwone3four","4nineeightseven2","zoneight234","7pqrstsixteen"};
		
		for(String line : input){

			line = Helpers.replaceWordsWithInts(line);

			int[] numbers = Helpers.getIntsFromString(line);


			int lineValue = Helpers.concatIntFromIntArray(new int[]{numbers[0], numbers[numbers.length-1]});


			fullCount += lineValue;


		}
		System.out.println("INFO: Full extra count = " + fullCount);
	}
}