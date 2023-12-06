package andersonj.aoc;

import andersonj.helper.Helpers;
import java.util.ArrayList;


public class Day6 extends Day{

	private static final String INPUT_FILE = "day6.txt";


	public Day6(){super();}

	public void solveProblem(){
		System.out.println("INFO: Starting problem...");
		String[] input = Helpers.getPuzzleInput(INPUT_FILE);
		System.out.println("INFO: Loaded input file...");

		String[] testCases = {
			"Time:      7  15   30",
			"Distance:  9  40  200"
		};

		//input = testCases;

		int[] times = Helpers.getIntArrayFromSpaceSeperatedString(input[0]);

		int[] records = Helpers.getIntArrayFromSpaceSeperatedString(input[1]);

		int allRecordValue = 1;

		for(int i = 0; i < times.length; i++){
			int time = times[i];
			int record = records[i];

			int recordsBeaten = 0;

			int millisecondPassed = 0;


			while(millisecondPassed <= time){
				int totalDist = millisecondPassed * (time - millisecondPassed);

				if(totalDist > record){
					recordsBeaten++;
				}
				millisecondPassed++;
			}

			allRecordValue *= recordsBeaten;
		}

		
		System.out.println("Finished parsing...");
		System.out.println("INFO: Final count: " + allRecordValue);

	}

	public void solveExtraProblem(){
		System.out.println("INFO: Starting problem...");
		String[] input = Helpers.getPuzzleInput(INPUT_FILE);
		System.out.println("INFO: Loaded input file...");

		String[] testCases = {
			"Time:      7  15   30",
			"Distance:  9  40  200"
		};

		//input = testCases;

		long time = Helpers.concatLongFromIntArray(Helpers.getIntArrayFromSpaceSeperatedString(input[0]));

		long record = Helpers.concatLongFromIntArray(Helpers.getIntArrayFromSpaceSeperatedString(input[1]));

		long waysToBeatRecords = 0L;

		long millisecondPassed = 1L;

		while(millisecondPassed <= time){
			long totalDist = millisecondPassed * (time - millisecondPassed);

			if(totalDist > record){
				waysToBeatRecords++;
			}
			millisecondPassed++;
		}


		
		System.out.println("Finished parsing...");
		System.out.println("INFO: Final count: " + waysToBeatRecords);
	}
}