package recurrsion;

import java.util.ArrayList;
import java.util.List;

public class BalancedParenthesis {

    public static void main(String[] args) {
          List<String> opList = new ArrayList<>();

          balanced(3, 3, "", opList);

        System.out.println(opList);
    }


    public static void balanced(int open, int close, String op, List<String> list){
        if(open==0 && close==0){
            list.add(op);
            return;
        }

        if(open!=0){
            String op1 = op;
            op1 = op1 + "(";

            balanced(open-1, close, op1, list);
        }

        if(close>open){
            String op2 = op;
            op2 = op2 + ")";

            balanced(open, close-1, op2, list);
        }
      return;
    }
}
