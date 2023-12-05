package andersonj.helper;

import java.util.ArrayList;
import java.util.HashSet;


public class Day4Card{

	private int cardNum;

	private int winningNumCount;

	private int amountOfCards;


	public Day4Card(String input){
		this.winningNumCount = 0;
		this.amountOfCards = 1;
		this.parseCard(input);
	}

	private void parseCard(String input){

		String[] splitIDFromNums = input.split(": ");

		String[] splitGameInfo = splitIDFromNums[0].split(" ");

		cardNum = Integer.parseInt(splitGameInfo[splitGameInfo.length-1]);

		String numsToParse = splitIDFromNums[1];

		String[] splitNums = numsToParse.split("\\|");

		HashSet<Integer> cardWinningNums = new HashSet<Integer>();

		//get Winning Nums
		for(String num : splitNums[0].split(" ")){
			try {
				cardWinningNums.add(Integer.parseInt(num));
			}catch(Exception e){
				//its not a number. It's a space
			}
		}

		//compare my nums to the winning nums
		for(String myNum : splitNums[1].split(" ")){
			try {
				if(cardWinningNums.contains(Integer.parseInt(myNum))){
					this.winningNumCount++;
				}
			} catch(Exception e){
				//theres no number... it's a space
			}
		}
	}

	public int getCardNum(){
		return this.cardNum;
	}

	public int getWinningNumCount(){
		return this.winningNumCount;
	}

	public int getAmountOfCards(){
		return this.amountOfCards;
	}

	public void addToNumOfCards(int amt){
		this.amountOfCards+= amt;
	}

	public String toString(){
		return "Winning Number Count: " + this.winningNumCount + ", with this amount of cards: " + this.amountOfCards;
	}

}