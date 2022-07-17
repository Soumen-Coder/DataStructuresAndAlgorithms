package recurrsion;

import java.util.*;
import java.util.stream.Collectors;

class SubsetOfNumbersWithArrayList {
	public static void findSubsets(Set<List<Integer>> answer, int[] arr, List<Integer> output, int index)
	{
	// Base Condition
		if (index == arr.length) {
			answer.add(output);
			System.out.println(new ArrayList<>(answer));
			return;
		}

		findSubsets(answer, arr, new ArrayList<>(output), index + 1);

		// Including Value which is at Index
		output.add(arr[index]);
		findSubsets(answer, arr, new ArrayList<>(output), index + 1);

	}

	public static void main(String[] args) {

		//Main List for storing all subsets
		Set<List<Integer>> subset = new HashSet<>();

		// Input ArrayList
		int[] arr = new int[]{1,3,1};

		Arrays.sort(arr);
		System.out.println("Input provided is :-"+arr);
		findSubsets(subset, arr, new ArrayList<>(), 0);

	}
}
