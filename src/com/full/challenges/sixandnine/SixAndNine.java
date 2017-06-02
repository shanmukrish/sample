package com.full.challenges.sixandnine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SixAndNine {

	private static final int MAX = 100;
	private static final int MIN = 1;
	private static final int NO_OF_INTEGERS = 10000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> ints = new ArrayList<>();

		int countOfNine = 0;
		int countOfSix = 0;
		int countOfConsecutiveSixes = 0;
		int countOfConsecutiveNines = 0;
		int previousValue = -1;
        boolean isDoingConsecutiveCount=false;
		System.out.println(System.currentTimeMillis());
		for (int i = 0; i < NO_OF_INTEGERS; i++) {
			int value = ThreadLocalRandom.current().nextInt(MIN, MAX);
			
			if (value == 6) {
				countOfSix++;
			}
			if (value == 9) {
				countOfNine++;
			}

			if (previousValue == 6 && value == 6) {
				isDoingConsecutiveCount=true;
				countOfConsecutiveSixes++;
			} else if (previousValue == 9 && value == 9) {
				isDoingConsecutiveCount=true;
				countOfConsecutiveNines++;
			} else {
				if(isDoingConsecutiveCount)
				{
					if(previousValue==6)
					{
						countOfConsecutiveSixes++;
					}
					else if(previousValue==9)
					{
						countOfConsecutiveNines++;
					}
				}
				previousValue = value;
				isDoingConsecutiveCount=false;
			}

			ints.add(value);
			
		}
		System.out.println(System.currentTimeMillis());
		System.out.println("No of Sixes: " + countOfSix);
		System.out.println("No of Nines: " + countOfNine);
		
		System.out.println("Number of Consecutive Sixes: "+countOfConsecutiveSixes);
		System.out.println("Number of Consecutive Nines: "+countOfConsecutiveNines);
		
		try(FileWriter writer=new FileWriter(new File("C:\\Users\\shanm\\Desktop\\NinesAndSix.txt")))
		{
			writer.write(ints.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
