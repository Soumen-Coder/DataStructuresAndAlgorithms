package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommonElements {
    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        int[] array1A = {1, 3, 4, 6, 7, 9};
        int[] array2A = {1, 2, 4, 5, 9, 10};
        System.out.println(Arrays.toString(commonElements(array1A, array2A)));// should return [1, 4, 9] (an array).

        int[] array1B = {1, 2, 9, 10, 11, 12};
        int[] array2B = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};
        System.out.println(Arrays.toString(commonElements(array1B, array2B)));// should return [1, 2, 9, 10, 12] (an array).

        int[] array1C = {0, 1, 2, 3, 4, 5};
        int[] array2C = {6, 7, 8, 9, 10, 11};
        System.out.println(Arrays.toString(commonElements(array1C, array2C)));// should return [] (an empty array).
    }

    // Implement your solution below.
    // NOTE: Remember to return an Integer array, not an int array.
    public static Integer[] commonElements(int[] array1, int[] array2) {
        Integer[] resultInArray = new Integer[0];
        ArrayList<Integer> numList = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : array1){
            if(hm.containsKey(i)){
                hm.put(i, hm.get(i)+1);
            }else{
                hm.put(i,1);
            }
        }
        for(int i : array2){
            if(hm.containsKey(i)){
                hm.put(i, hm.get(i)+1);
            }else{
                hm.put(i,1);
            }
        }
        for(Map.Entry<Integer, Integer> map : hm.entrySet()){
            if(map.getValue()>1){
                numList.add(map.getKey());
            }
        }
        return numList.toArray(resultInArray);
    }
}
