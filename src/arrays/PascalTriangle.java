package arrays;

import java.util.ArrayList;
import java.util.List;

class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
		List<Integer> row, pre = null;
		for (int i = 0; i < numRows; ++i) {
			//create a separate arrayList for each row
			row = new ArrayList<>();
			for (int j = 0; j <= i; ++j) {
				if (j == 0 || j == i)
					row.add(1); // first and last element of each row is 1
				else
					row.add(pre.get(j - 1) + pre.get(j)); // get the values from previous row, for addition
			}
			pre = row; // keep track of previous row
			res.add(row); // add the row to the resultant
		}
		return res;
    }

	public static void main(String[] args) {
		List<List<Integer>> res = generate(5);
		System.out.println(res);
		//Printing the value from a specific row and column
		//Printing only the nth row, n passed as input
	}
}