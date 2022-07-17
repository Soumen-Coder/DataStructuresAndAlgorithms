package recurrsion;

import java.util.*;

public class Permutations {

	public static void main (String args[]) {

		// Check usage
		if (args.length < 1) {
			System.out.println("Usage: java Permutations [word]");
			return;
		}

		// Get word
		String word = args[0];

		// Create empty indices ArrayList
		ArrayList<Integer> indices = new ArrayList<Integer>();

		// Get the permutations
		ArrayList<String> permutations = Permutations.getPermutations(word, indices);

		// Display the permutations
		System.out.println(permutations);

		return;
	}

	// Takes a word and an ArrayList of already considered indices
	// Input: word (String), indices (ArrayList<Integer>)
	// Output: ArrayList<String> containing all possible permutations
	public static ArrayList<String> getPermutations (String word, ArrayList<Integer> indices) {
		System.out.println("***********FUNCTION GETPERMUTATIONS IS CALLED**********");
		int length = word.length();

		// Create the empty ArrayList to return
		ArrayList<String> answer = new ArrayList<String>();

		// If all characters are considered, we are done. Return empty ArrayList
		if (indices.size() == length) {
			System.out.println("Base condition met. indices list size == length of string");
			System.out.println("Adding empty string to answer list");
			answer.add("");
			System.out.println("Returning answer list from base condition :- "+answer);
			return answer;
		}

		// Iterate over each character to find the permutation
		for (int i = 0; i < length; i++) {

			// Skip if index is already considered
			System.out.println("If indices contains the value of "+i+"? = "+indices.contains(i));
			if (indices.contains(i)) continue;

			// Create and populate a duplicate ArrayList of indices that have already been considered
			ArrayList<Integer> newIndices = new ArrayList<Integer>();


			for (int index : indices) {
				System.out.println("Adding list of indices value to the newIndices list");
				newIndices.add(index);
				System.out.println("NewIndices that is being copied from indices and storing value of "+i+" as well is :-"+newIndices);
			}
			System.out.println("Adding value of "+i+" to newIndices list");
			// Add current index
			newIndices.add(i);

			System.out.println("Indices list having values :-"+indices);
			System.out.println("--------------------------------------");
			System.out.println("NewIndices final value before function getPermutations is called :-"+newIndices);
			// Calculate permutations

			System.out.println("Calling function with Params :: getPermutations(word,  :-"+newIndices+")");
			ArrayList<String> permutations = Permutations.getPermutations(word, newIndices);

			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Function getPermutations returned the list of permutation string :-"+permutations);

			// Add the current character before the permutations of the rest of the word
			for (String str : permutations) {
				System.out.println("For every string "+str+" in permutation, we are adding the word at "+i+"location");
				System.out.println("Thus making the string as :-"+word.charAt(i)+str);
				answer.add(word.charAt(i) + str);
			}

		}

		System.out.println("Returning answer to the method getPermutations :-" +answer);
		// Return
		return answer;

	}

}