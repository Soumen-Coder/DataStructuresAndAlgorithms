package recurrsion;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

    public static void main(String[] args) {
        int n = 11;
        int k = 7;
        int ans = -1;
        int indexSwords = 0;
        List<Integer> listOfPersonStanding = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            listOfPersonStanding.add(i);
        }
        k = k-1;
        int result = josephus(k, ans, listOfPersonStanding, indexSwords);
        System.out.println("The person with value :- "+result+" will not die");
    }


    public static int josephus(int k, int ans, List<Integer> listOfPeople, int index){
        int result=-1;
        if(listOfPeople.size() == 1){
            ans = listOfPeople.get(0);
            return ans;
        }

        index = (index + k) % listOfPeople.size();
        listOfPeople.remove(index);

        result = josephus(k, ans, listOfPeople, index);
        return result;
    }


}
