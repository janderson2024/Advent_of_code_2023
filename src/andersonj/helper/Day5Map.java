package andersonj.helper;

import java.util.ArrayList;

class Day5MapEntry{
	private long destStart;
	private long sourceStart;
	private long sourceEnd;

	public Day5MapEntry(long sourceStart, long destStart, long range){
		this.destStart = destStart;
		this.sourceStart = sourceStart;
		this.sourceEnd = sourceStart + range-1;
	}

	public long tryToConvert(long input){

		if(input >= this.sourceStart && input <= this.sourceEnd){
			long offset = input - this.sourceStart;
			return this.destStart + offset;
		}

		return -1L;
	}
}


public class Day5Map{

	private ArrayList<Day5MapEntry> entries;


	public Day5Map(){
		this.entries = new ArrayList<Day5MapEntry>();
	}

	public void parseMapLine(String input){
		String[] inputs = input.split(" ");

		long sourceStart = Long.parseLong(inputs[1]);
		long destStart = Long.parseLong(inputs[0]);
		long rangeAmount = Long.parseLong(inputs[2]);

		entries.add(new Day5MapEntry(sourceStart, destStart, rangeAmount));

	}

	public long getCorrespondant(long input){

		for(Day5MapEntry entry : this.entries){
			long output = entry.tryToConvert(input);

			if(output != -1L){
				return output;
			}
		}
		return input;
			
	}

	public String toString(){
		return this.entries.toString();
	}

}