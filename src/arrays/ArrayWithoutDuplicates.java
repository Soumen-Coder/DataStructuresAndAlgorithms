package arrays;

import java.util.*;

public class ArrayWithoutDuplicates {

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,5,6,7,8,9};
        int[] resultArray = removeDuplicates(arr);
        System.out.println(Arrays.toString(resultArray));
    }

    public static int[] removeDuplicates(int[] arr) {
            if(arr.length==0 || arr.length==1){
                return arr;
            }
            int count=0;
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<arr.length; i++){
                if(map.containsKey(arr[i])){
                    map.put(arr[i], count+1);
                }
                map.put(arr[i], count);
            }
            for(int i : map.keySet()){
                list.add(i);
            }
            return list.stream().mapToInt(i->i).toArray();
    }

}
