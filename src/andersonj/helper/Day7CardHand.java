package andersonj.helper;

import andersonj.helper.Helpers;

import java.util.Arrays;
import java.util.Set;
import java.util.Iterator;
import java.lang.Comparable;
import java.util.HashMap;

public class Day7CardHand implements Comparable<Day7CardHand>{

	private String[] cards;

	private int bid;

	private int strengh;


	private HashMap<String, String> cardHash = new HashMap<String,String>();

	public Day7CardHand(String input){
		this.parseInput(input);
		
		this.cardHash.put("A", "14");
		this.cardHash.put("K", "13");
		this.cardHash.put("Q", "12");
		this.cardHash.put("J", "11");
		this.cardHash.put("T", "10");

	}


	private void parseInput(String input){
		String[] split = input.split(" ");

		String strCards = split[0];

		this.cards = strCards.split("");
		this.bid = Integer.parseInt(split[1]);

		Set<String> cardSet = Set.copyOf(Arrays.asList(this.cards));

		if(cardSet.size() == 5){
			//high card
			this.strengh = 1;
		}
		if(cardSet.size() ==  4){
			//one pair
			this.strengh = 2;
		}
		if(cardSet.size() == 1){
			//five of a kind
			this.strengh = 7;
		}
		if(cardSet.size() == 3){
			Iterator<String> setIt = cardSet.iterator();
			if(Helpers.count(strCards, setIt.next()) == 3 || Helpers.count(strCards, setIt.next()) == 3 || Helpers.count(strCards, setIt.next()) == 3){	
				//three of a kind
				this.strengh = 4;
			} else {
				//two pair
				this.strengh = 3;
			}
		}

		if(cardSet.size() == 2){
			Iterator<String> setIt = cardSet.iterator();
			if(Helpers.count(strCards, setIt.next()) == 4 || Helpers.count(strCards, setIt.next()) == 4){
				//4 of a kind
				this.strengh = 6;
			} else {
				//full houses
				this.strengh = 5;
			}

		}
	}

	public String toString(){
		return Arrays.toString(this.cards) + " :  " + this.strengh;
	}

	public int compareTo(Day7CardHand otherHand){
		System.out.println("Sorting " + this + " and " + otherHand);
		if(this.strengh != otherHand.strengh){
			return this.strengh - otherHand.strengh;
		}

		for(int i = 0; i < this.cards.length; i ++){
			int myCard;
			int otherCard;
			try{
				myCard = Integer.parseInt(this.cardHash.get(this.cards[i]));
			}catch(Exception e){
				myCard = Integer.parseInt(this.cards[i]);
			}
			try{
				otherCard = Integer.parseInt(this.cardHash.get(otherHand.cards[i]));
			}catch(Exception e){
				otherCard = Integer.parseInt(otherHand.cards[i]);
			}


			if(myCard != otherCard){
				return  myCard - otherCard;
			}
		}

		return 0;
	}

	public int getBid(){
		return this.bid;
	}
}