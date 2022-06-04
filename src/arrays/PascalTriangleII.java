package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
      List<Integer> res = new ArrayList<>();
      long val=1;
      /*if(rowIndex==0){
          res.add(1);
          return res;
      }
      if(rowIndex==1){
            res.add(1);
            res.add(1);
            return res;
        }*/
        //rowIndex = rowIndex+1;
        for (int i = 0; i <= rowIndex; i++) {
            /*//rowIndexCi
            if(i==0) {
                res.add(1);
            }else {
                val = val * (rowIndex - i) / i;
                res.add((int)val);
            }*/
            res.add((int)val);
            val = val * (rowIndex-i)/(i+1);
        }
      return res;
    }

    public static void main(String[] args) {
        List<Integer> res = getRow(4);
        System.out.println(res);
    }
}
