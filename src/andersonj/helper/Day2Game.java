package andersonj.helper;

import java.util.ArrayList;


class Day2Round{

	private int redCount;
	private int greenCount;
	private int blueCount;

	public Day2Round(String roundInput){
		this.redCount = 0;
		this.greenCount = 0;
		this.blueCount = 0;
		this.parseRoundInput(roundInput);
	}

	private void parseRoundInput(String roundInput){
		String[] cubes = roundInput.split(", ");

		for(String cube : cubes){
			String[] cubeData = cube.split(" ");

			int cubeCount = Integer.parseInt(cubeData[0]);

			String cubeColor = cubeData[1];

			switch(cubeColor){
				case "red":
					redCount+= cubeCount;
					break;
				case "green":
					greenCount+= cubeCount;
					break;
				case "blue":
					blueCount+= cubeCount;
					break;
				default:
					System.out.println(cubeColor + " is not a properly caught color!");

			}
		}
	}

	public int getRed(){
		return this.redCount;
	}

	public int getGreen(){
		return this.greenCount;
	}

	public int getBlue(){
		return this.blueCount;
	}


	public String toString(){
		return "I have " + this.redCount + " reds, " + this.greenCount + " greens, and " +this.blueCount + " blues.";
	}
}




public class Day2Game{
	

	private int gameID;

	private ArrayList<Day2Round> rounds;



	public Day2Game(String gameInput){
		this.rounds = new ArrayList<Day2Round>();
		this.parseGameInput(gameInput);
	}

	private void parseGameInput(String gameInput){

		String[] parts = gameInput.split(": ");


		this.gameID = Integer.parseInt(parts[0].split(" ")[1]);

		//System.out.println("DEBUG: GameID = " + this.gameID + "  rounds: " + parts[1]) ;

		gameInput = parts[1];

		String[] roundsInput = gameInput.split("; ");

		for(String roundInput : roundsInput){
			this.rounds.add(new Day2Round(roundInput));
		}

	}

	//returns 0 if any of the rounds aren't valid, and returns the gameID if everything checks out
	public int isValidGame(int maxRedCount, int maxGreenCount, int maxBlueCount){
		for(Day2Round round : this.rounds){
			if(maxRedCount < round.getRed() || maxGreenCount < round.getGreen() || maxBlueCount < round.getBlue()){
				return 0;
			}

		}

		return this.gameID;
	}

	//returns red max in 0, green max in 1, and blue max in 2
	public int[] maxNeededColors(){
		int[] maxColorCount = {0, 0, 0};

		for(Day2Round round : this.rounds){
			maxColorCount[0] = Math.max(maxColorCount[0], round.getRed());
			maxColorCount[1] = Math.max(maxColorCount[1], round.getGreen());
			maxColorCount[2] = Math.max(maxColorCount[2], round.getBlue());

		}

		return maxColorCount;

	}

}