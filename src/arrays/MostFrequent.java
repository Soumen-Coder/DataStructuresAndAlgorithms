package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class MostFrequent {
    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        // mostFrequent(array1) should return 1.
        int[] array1 = {1, 3, 1, 3, 2, 1};
        System.out.println(mostFrequent(array1));
        // mostFrequent(array2) should return 3.
        int[] array2 = {3, 3, 1, 3, 2, 1};
        System.out.println(mostFrequent(array2));
        // mostFrequent(array3) should return null.
        int[] array3 = {};
        System.out.println(mostFrequent(array3));
        // mostFrequent(array4) should return 0.
        int[] array4 = {0};
        System.out.println(mostFrequent(array4));
        // mostFrequent(array5) should return -1.
        int[] array5 = {0, -1, 10, 10, -1, 10, -1, -1, -1, 1};
        System.out.println(mostFrequent(array5));
    }

    // Implement your solution below.
    public static Integer mostFrequent(int[] givenArray) {
        Integer maxItem = null;
        int high = -1;
        HashMap<Integer,Integer> hm = new HashMap<>();
        if(givenArray.length==0){
            return null;
        }
        for(int element: givenArray){
            if(hm.containsKey(element)){
                hm.put(element,hm.get(element)+1);
            }else{
                hm.put(element,1);
            }
            if(hm.get(element)>high){
                high = hm.get(element);
                maxItem = element;
            }
        }
        return maxItem;
    }
}
