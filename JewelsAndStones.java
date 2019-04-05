package com.leetcode.algo.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A". Example 1:
 * 
 * Input: J = "aA", S = "aAAbbbb" Output: 3 Example 2:
 * 
 * Input: J = "z", S = "ZZ" Output: 0 
 * Note: S and J will consist of letters and
 * have length at most 50. The characters in J are distinct.
 * 
 * @author psannapareddy
 *
 */

public class JewelsAndStones {

	public static void main (String[] args){
		
		String jewels = "aA";
		String stones = "aaAbbb";
		long t1 = System.currentTimeMillis();
		int myJewels1 = findJewelsBruteForce(jewels, stones);
		long t2 = System.currentTimeMillis();		
		System.out.println("I have "+ myJewels1 + " stones that are jewels By BruteForce in "+ (t2-t1) + " ms");
		
		long t3 = System.currentTimeMillis();
		int myJewels2 = findJewelsBetterThanBruteForce(jewels, stones);
		long t4 = System.currentTimeMillis();
		
		System.out.println("I have "+ myJewels2 + " stones that are jewels By BetterThanBruteForce in "+ (t4-t3) + " ms");
		
		//Awesome method is taking longer than other methods. 
		long t5 = System.currentTimeMillis();
		int myJewels3 = findJewelsByAwesomeMethod(jewels, stones);
		long t6 = System.currentTimeMillis();
		
		System.out.println("I have "+ myJewels3 + " stones that are jewels By awesome method in "+ (t6-t5) + " ms");
		
		
		
	}

	private static int findJewelsBetterThanBruteForce(String jewels,
			String stones) {
		List<Character> jewelList = getJewelList(jewels);
		int count=0;
		for(char c:stones.toCharArray()){
			if(jewelList.contains(c)){
				count++;
			}
		}
		
		return count;
	}

	private static List<Character> getJewelList(String jewels) {
		List<Character> characterList = new ArrayList<Character>();
		for(char c:jewels.toCharArray()){
			characterList.add(c);
		}
		return characterList;
	}

	private static int findJewelsBruteForce(String j, String s) {
		char[] jewelCharacters = j.toCharArray();
		char[] stoneCharacters = s.toCharArray();
		int count = 0;
		for(char stoneCharacter:stoneCharacters){	
			for(char jewelCharacter:jewelCharacters){
				if(stoneCharacter == jewelCharacter){
					count++;
				}
			}
		}
		return count;
	}
	
	private static int findJewelsByAwesomeMethod(String j, String s){
		    return s.replaceAll("[^" + j + "]", "").length();
	}
}
