package andersonj.helper;

import java.util.HashMap;


public class Day5Map{

	private HashMap<Long, Long> seedMap;


	public Day5Map(){
		this.seedMap = new HashMap<Long, Long>();
	}

	public void parseMapLine(String input){
		String[] inputs = input.split(" ");

		long sourceStart = Long.parseLong(inputs[1]);
		long destStart = Long.parseLong(inputs[0]);
		long rangeAmount = Long.parseLong(inputs[2]);

		for(long i = 0; i < rangeAmount; i++){
			seedMap.put(sourceStart+i, destStart+i);
		}

	}

	public long getCorrespondant(long input){

		Long value = seedMap.get(input);

		if(value != null){
			return value;
		}

		return input;
	}

	public String toString(){
		return this.seedMap.toString();
	}

}