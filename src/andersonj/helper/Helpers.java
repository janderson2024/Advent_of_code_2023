package andersonj.helper;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

import java.util.HashMap;

public class Helpers{
	
	public static String[] getPuzzleInput(String filename){
		ArrayList<String> puzzleinputs = new ArrayList<String>();

		String filePath = "res/day_inputs/" + filename;
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		   
			String line = br.readLine();

		    while (line != null) {
		        puzzleinputs.add(line);
		        line = br.readLine();
		    }

		} catch (IOException e){
			System.out.println("Could not find file!");
			e.printStackTrace();
		}

		return puzzleinputs.toArray(new String[puzzleinputs.size()]);
	}

	public static int[] getIntsFromString(String input){
		int[] nums = new int[input.length()];
		int count = 0;

		for(int i = 0; i < input.length(); i++){

				try {
					int number = Integer.parseInt(input.substring(i, i+1));
					nums[count] = number;
					count++;

				} catch(Exception e){

				}
			}
		return Arrays.copyOfRange(nums, 0, count);
	}

	public static int concatIntFromIntArray(int[] input){
		String temp = "";

		for(int i = 0; i < input.length; i++){
			temp += input[i];
		}

		return Integer.parseInt(temp);
	}

	public static long concatLongFromIntArray(int[] input){
		String temp = "";

		for(int i = 0; i < input.length; i++){
			temp += input[i];
		}

		return Long.parseLong(temp);
	}

	public static String replaceWordsWithInts(String input){
		HashMap<String, Integer> digitsToInt = new HashMap<String, Integer>();
		digitsToInt.put("one", 1);
		digitsToInt.put("two", 2);
		digitsToInt.put("three", 3);
		digitsToInt.put("four", 4);
		digitsToInt.put("five", 5);
		digitsToInt.put("six", 6);
		digitsToInt.put("seven", 7);
		digitsToInt.put("eight", 8);
		digitsToInt.put("nine", 9);

		for (int i = 0; i < input.length(); i ++){
			for (int j = i+1; j <= Math.min(i+5, input.length()); j++){
				String substring = input.substring(i, j);

				Integer digit = digitsToInt.get(substring);

				if(digit != null){
					input = input.substring(0, i) + digit + input.substring(i+1);
					break;
				}

			}

		}

		return input;

	}

	public static boolean hasSymbol(String[] lines, int lineNum, int charNum){
		boolean isSymbol = false;

		for(int i = -1; i <= 1; i++){
				try {
					char letterToCheck = lines[lineNum+i].charAt(charNum);

					boolean notNum = !Character.isDigit(letterToCheck);
					boolean notLetter = !Character.isLetter(letterToCheck);
					boolean notDot = letterToCheck != '.';

					isSymbol = isSymbol || (notNum && notLetter && notDot);
				} catch(Exception e){
					//System.out.println("Char we tried checking doesn't exist!");
					//oopsies i was checking out of bounds, but this is why we have catch blocks
				}
		}

		return isSymbol;
	}

	public static int[] hasSpecificSymbol(String[] lines, int lineNum, int charNum, char symbol){
		boolean isSymbol = false;

		for(int i = -1; i <= 1; i++){
				try {
					char letterToCheck = lines[lineNum+i].charAt(charNum);

					if(symbol == letterToCheck){
						return new int[] {lineNum+i, charNum};
					}
				} catch(Exception e){
					//System.out.println("Char we tried checking doesn't exist!");
					//oopsies i was checking out of bounds, but this is why we have catch blocks
				}
		}

		return new int[] {-1, -1};
	}

	public static int[] getIntArrayFromSpaceSeperatedString(String input){
		ArrayList<Integer> tempOutput = new ArrayList<Integer>();

		String[] splitOnSpace = input.split(" ");


		for(String splitEntry : splitOnSpace){
			try{
				tempOutput.add(Integer.parseInt(splitEntry));
			} catch(Exception e){
				//not a number, so its not added :)
			}
		}

		int[] output = new int[tempOutput.size()];
		for(int i = 0; i < tempOutput.size(); i++){
			output[i] = tempOutput.get(i).intValue();

		}
		return output;
	}

	public static int count(String haystack, String needle){
	    int count = 0;
	    for (int i=0; i < haystack.length(); i++){
	        if (haystack.charAt(i) == needle.charAt(0)){
	             count++;
	        }
	    }
	    return count;
}
}