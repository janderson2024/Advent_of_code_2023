package andersonj.aoc;

import andersonj.helper.Helpers;
import andersonj.helper.Day4Card;
import java.util.HashMap;

public class Day4 extends Day{

	private static final String INPUT_FILE = "day4.txt";


	public Day4(){super();}

	public void solveProblem(){
		System.out.println("INFO: Starting problem...");
		String[] input = Helpers.getPuzzleInput(INPUT_FILE);
		System.out.println("INFO: Loaded input file...");

		String[] testCases = {
			"Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
			"Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
			"Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
			"Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
			"Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
			"Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11",
		};

		int scratchCardPoints = 0;

		for(String line : input){
			Day4Card card = new Day4Card(line);
			int winningNumberCount = card.getWinningNumCount();

			int cardValue = (int)Math.pow(2, winningNumberCount-1);

			scratchCardPoints += cardValue;
		}

		
		System.out.println("Finished parsing...");
		System.out.println("INFO: Final count: " + scratchCardPoints);

	}

	public void solveExtraProblem(){
		System.out.println("INFO: Starting problem...");
		String[] input = Helpers.getPuzzleInput(INPUT_FILE);
		System.out.println("INFO: Loaded input file...");

		String[] testCases = {
			"Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
			"Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
			"Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
			"Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
			"Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
			"Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11",
		};

		

		HashMap<Integer,Day4Card> cardMap = new HashMap<Integer,Day4Card>();

		int numberOfTotalCards = 0;

		for(String line : input){
			Day4Card tempCard = new Day4Card(line);

			cardMap.put(tempCard.getCardNum(), tempCard);


		}

		for(Integer cardNum : cardMap.keySet()){

			Day4Card card = cardMap.get(cardNum);
			//System.out.println("I am card: " + cardNum + " and i have " + card.getAmountOfCards());

			numberOfTotalCards += card.getAmountOfCards();

			int copyCardMax = cardNum + card.getWinningNumCount();

			//System.out.println("Card Num: " + cardNum + " will edit up to Card: " + copyCardMax +
			//" and will add " + card.getAmountOfCards() + " to each of those!");

			for(int cardToEdit = cardNum+1; cardToEdit <= copyCardMax; cardToEdit++){
				cardMap.get(cardToEdit).addToNumOfCards(card.getAmountOfCards());
			}

		}

		// parse all Cards into hash map of Int (card num) and obj of Day2Card
		//day 2 card has the number of matching numbers and how many original/copy cards there are
		

		// for each card in the hashmap, add its number of cards to the total, and add the number of cards to each of its "copy cards"
		//get copy cards by cardnum + matching numbers



		
		System.out.println("Finished parsing...");
		System.out.println("INFO: Final count: " + numberOfTotalCards);


	}
}