package recurrsion;

import java.util.ArrayList;
import java.util.List;

public class NbitBinaryNumber1GreaterThan0 {

    public static void main(String[] args) {
        List<String> opList = new ArrayList<>();
        int one = 0;
        int zero = 0;
        int n = 3;
        String op = "";
        nbitbinarynumber(one, zero, n, op, opList);

        System.out.println(opList);
    }

    public static void nbitbinarynumber(int one, int zero, int n, String op, List<String> list){
        if(n==0){
            list.add(op);
            return;
        }

        String op1 = op;
        op1 = op1 + "1";

        nbitbinarynumber(one+1, zero, n-1, op1, list);

        if(one>zero){
            String op2 = op;
            op2 = op2 + "0";

            nbitbinarynumber(one, zero+1, n-1, op2, list);
        }
        return;
    }

}
