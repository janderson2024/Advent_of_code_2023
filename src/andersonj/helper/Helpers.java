package andersonj.helper;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

import java.util.HashMap;

public class Helpers{
	
	public static ArrayList<String> getPuzzleInput(String filename){
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

		return puzzleinputs;
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
}