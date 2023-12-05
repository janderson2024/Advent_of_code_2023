package andersonj.aoc;

import andersonj.helper.Helpers;
import java.util.ArrayList;
import java.util.HashMap;

public class Day3 extends Day{

	private static final INPUT_FILE = "day3.txt";

	public Day3(){super();}

	public void solveProblem(){
		System.out.println("INFO: Starting problem...");
		String[] input = Helpers.getPuzzleInput(INPUT_FILE);
		System.out.println("INFO: Loaded input file...");

		/*String[] testCases = {
			"467..114..",
			"...*......",
			"..35..633.",
			"......#...",
			"617*......",
			".....+.58.",
			"..592.....",
			"......755.",
			"...$.*....",
			".664.598.."
		};*/

		/*String [] testCases = {
			"...698.......*..........329.....$....*......92........................203..........168.....................*..346....*..........*...........",
			".......470........68/..............263.....*.........337..................433............................666........92......20..784..978*194",
			".........%................465-.............297..............193.259.............................................17.........*................"
		};*/

		int fullCount = 0;


		System.out.println("INFO: Parsing lines...");
		for(int lineNum = 0; lineNum < input.length; lineNum++){
			String line = input[lineNum];

			boolean lastHadSymbol = false;

			boolean numHasSymbol = false;

			String currentNum = "";

			boolean currentCharHasSymbol = false;

			for(int charNum = 0; charNum < line.length(); charNum++){

				//get the char.
				//if its a number, add that number to the current num
				//check if top or bottom is a symbol

				//num has symbol is last had symbol OR num has sumbol
				//lastHadSymbol == check if top or bottom is a symbol

				//if its is not a number,
				//check if top or bottom is a symbol

				//if it is, add the current num to a list of "part numbers"

				//if it isn't, ignore it

				//clear the current num

				//set lastHadSymbol = check if top or bottom is a symbol	

				currentCharHasSymbol = Helpers.hasSymbol(input, lineNum, charNum);

				numHasSymbol = numHasSymbol || lastHadSymbol || currentCharHasSymbol;

				char currentChar = line.charAt(charNum);

				if(Character.isDigit(currentChar)){
					currentNum+= currentChar;
				}

				if(!Character.isDigit(currentChar) || charNum+1 == line.length()){
					//this is not a number or its the end

					//checks if there was a number
					if(currentNum.length() > 0){
						if(numHasSymbol){
							//System.out.println("Good Num! : " + currentNum);
							fullCount += Integer.parseInt(currentNum);
						}
					}
					numHasSymbol = false;
					currentNum = "";
				}

				lastHadSymbol = currentCharHasSymbol;
			}
		}




		
		System.out.println("Finished parsing...");
		System.out.println("INFO: Final count: " + fullCount);

	}

	public void solveExtraProblem(){
		System.out.println("INFO: Starting problem...");
		String[] input = Helpers.getPuzzleInput(INPUT_FILE);
		System.out.println("INFO: Loaded input file...");

		String[] testCases = {
			"467..114..",
			"...*......",
			"..35..633.",
			"......#...",
			"617*......",
			".....+.58.",
			"..592.....",
			"......755.",
			"...$.*....",
			".664.598.."
		};

		/*String [] testCases = {
			"...698.......*..........329.....$....*......92........................203..........168.....................*..346....*..........*...........",
			".......470........68/..............263.....*.........337..................433............................666........92......20..784..978*194",
			".........%................465-.............297..............193.259.............................................17.........*................"
		};*/

		int gearSum = 0;

		HashMap<String, ArrayList<String>> gearsToArray = new HashMap<String, ArrayList<String>>();

		//input = testCases;

		System.out.println("INFO: Parsing lines...");
		for(int lineNum = 0; lineNum < input.length; lineNum++){
			String line = input[lineNum];

			boolean lastHadSymbol = false;

			boolean numHasSymbol = false;

			String currentNum = "";

			String currentGearHash = "";

			for(int charNum = 0; charNum < line.length(); charNum++){
				boolean currentCharHasSymbol = false;

				int[] possibleGearLocation = Helpers.hasSpecificSymbol(input, lineNum, charNum, '*');

				if(possibleGearLocation[0] != -1){
					//System.out.println(possibleGearLocation[0] + "     " + possibleGearLocation[1]); 
					currentGearHash = "X:"+possibleGearLocation[0]+"Y:"+possibleGearLocation[1];
					currentCharHasSymbol = true;
				}

				numHasSymbol = numHasSymbol || lastHadSymbol || currentCharHasSymbol;

				char currentChar = line.charAt(charNum);

				if(Character.isDigit(currentChar)){
					currentNum+= currentChar;
				}

				if(!Character.isDigit(currentChar) || charNum+1 == line.length()){
					//this is not a number or its the end

					//checks if there was a number
					if(currentNum.length() > 0){
						if(numHasSymbol){

							//full num next to 
							//System.out.println("Good Num! : " + currentNum);

							if(gearsToArray.get(currentGearHash) == null){
								gearsToArray.put(currentGearHash, new ArrayList<String>());
							}
							gearsToArray.get(currentGearHash).add(currentNum);
						}
					}
					numHasSymbol = false;
					currentNum = "";
					
				}

				lastHadSymbol = currentCharHasSymbol;
				//lastGearHash = currentGearHash;
			}
		}

		//System.out.println(gearsToArray);

		for(String location : gearsToArray.keySet()){
			if(gearsToArray.get(location).size() == 2){
				gearSum += Integer.parseInt(gearsToArray.get(location).get(0)) * Integer.parseInt(gearsToArray.get(location).get(1));
			}
		}


		
		System.out.println("Finished parsing...");
		System.out.println("INFO: Final count: " + gearSum);


	}
}