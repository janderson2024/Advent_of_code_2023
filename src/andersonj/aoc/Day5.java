package andersonj.aoc;

import andersonj.helper.Helpers;
import andersonj.helper.Day5Map;



public class Day5 extends Day{

	private static final String INPUT_FILE = "day5.txt";


	public Day5(){super();}

	public void solveProblem(){
		long test = 3305253869L;
		System.out.println(test);
		System.out.println("INFO: Starting problem...");
		String[] input = Helpers.getPuzzleInput(INPUT_FILE);
		System.out.println("INFO: Loaded input file...");

		String[] testCases = {
			"seeds: 79 14 55 13",
			"",
			"seed-to-soil map:",
			"50 98 2",
			"52 50 48",
			"",
			"soil-to-fertilizer map:",
			"0 15 37",
			"37 52 2",
			"39 0 15",
			"",
			"fertilizer-to-water map:",
			"49 53 8",
			"0 11 42",
			"42 0 7",
			"57 7 4",
			"",
			"water-to-light map:",
			"88 18 7",
			"18 25 70",
			"",
			"light-to-temperature map:",
			"45 77 23",
			"81 45 19",
			"68 64 13",
			"",
			"temperature-to-humidity map:",
			"0 69 1",
			"1 0 69",
			"",
			"humidity-to-location map:",
			"60 56 37",
			"56 93 4"
		};

		//input = testCases;


		//ok this solution doesn't work. My computer isn't good enough for that
		//i gotta save the info for each "mapping", and do the math in the getCorrespondant method

		//-Xms2g -Xmx4g for more Dedotated Wam






		String[] seeds = input[0].substring(7).split(" ");
		//input 1 is a blank

		Day5Map seedToSoil = new Day5Map();
		Day5Map soilToFert = new Day5Map();
		Day5Map fertToWater = new Day5Map();
		Day5Map waterToLight = new Day5Map();
		Day5Map lightToTemp = new Day5Map();
		Day5Map tempToHumid = new Day5Map();
		Day5Map humidToLoc = new Day5Map();

		Day5Map currentMap = seedToSoil;

		System.out.println("INFO: Starting Map Parsing/Creation...");
		for(int i = 2; i < input.length; i++){
			String line = input[i];
			switch (line){
			case "seed-to-soil map:":
				currentMap = seedToSoil;
				System.out.println("INFO: Map set to seed-soil...");
				break;
			case "soil-to-fertilizer map:":
				currentMap = soilToFert;
				System.out.println("INFO: Map set to soil-fert...");
				break;
			case "fertilizer-to-water map:":
				currentMap = fertToWater;
				System.out.println("INFO: Map set to fert-water...");
				break;
			case "water-to-light map:":
				currentMap = waterToLight;
				System.out.println("INFO: Map set to water-light...");
				break;
			case "light-to-temperature map:":
				currentMap = lightToTemp;
				System.out.println("INFO: Map set to light-temp...");
				break;
			case "temperature-to-humidity map:":
				System.out.println("INFO: Map set to temp-humid...");
				currentMap = tempToHumid;
				break;
			case "humidity-to-location map:":
				System.out.println("INFO: Map set to humid-loc...");
				currentMap = humidToLoc;
				break;
			case "":
				//dont do anything
				break;

			default:
				currentMap.parseMapLine(line);

			}
		}
		System.out.println("INFO: Map Created. Solving seeds...");


		Long smallestLocation = Long.MAX_VALUE;
		for(String seed : seeds){
			long seedNum = Long.parseLong(seed);

			long soilNum = seedToSoil.getCorrespondant(seedNum);
			long fertNum = soilToFert.getCorrespondant(soilNum);
			long waterNum = fertToWater.getCorrespondant(fertNum);
			long lightNum = waterToLight.getCorrespondant(waterNum);
			long tempNum = lightToTemp.getCorrespondant(lightNum);
			long humidNum = tempToHumid.getCorrespondant(tempNum);
			long locationNum = humidToLoc.getCorrespondant(humidNum);

			System.out.println("Seed: " + seedNum + " Location: " + locationNum);

			smallestLocation = Math.min(smallestLocation, locationNum);
 
		}
		
		System.out.println("Finished parsing...");
		System.out.println("INFO: Final count: " + smallestLocation);

	}

	public void solveExtraProblem(){
		System.out.println("INFO: Starting problem...");
		String[] input = Helpers.getPuzzleInput(INPUT_FILE);
		System.out.println("INFO: Loaded input file...");

		String[] testCases = {
			"seeds: 79 14 55 13",
			"",
			"seed-to-soil map:",
			"50 98 2",
			"52 50 48",
			"",
			"soil-to-fertilizer map:",
			"0 15 37",
			"37 52 2",
			"39 0 15",
			"",
			"fertilizer-to-water map:",
			"49 53 8",
			"0 11 42",
			"42 0 7",
			"57 7 4",
			"",
			"water-to-light map:",
			"88 18 7",
			"18 25 70",
			"",
			"light-to-temperature map:",
			"45 77 23",
			"81 45 19",
			"68 64 13",
			"",
			"temperature-to-humidity map:",
			"0 69 1",
			"1 0 69",
			"",
			"humidity-to-location map:",
			"60 56 37",
			"56 93 4"
		};

		

		
		System.out.println("Finished parsing...");
		//System.out.println("INFO: Final count: " + numberOfTotalCards);


	}
}