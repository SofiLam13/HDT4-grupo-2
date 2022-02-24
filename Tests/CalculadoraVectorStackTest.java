import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraVectorStackTest {

    @Test
    void Calculate(){
        String postfix = "12+4*3+";

        String[] op = postfix.split("");
        ArrayList<String> arr = new ArrayList<String>(Arrays.asList(op));

        Vector<String> signs = new Vector<String>();
        Vector<Double> nums = new Vector<Double>();

        for(int i = 0;i<arr.size();i++){
            try{
                double n = Double.parseDouble(arr.get(i));
                nums.add(n);
            }catch (NumberFormatException e){
                signs.add(arr.get(i));
            }
        }
        Collections.reverse(nums);
        Collections.reverse(signs);

        while(nums.size()>1){
            String operator = signs.remove(signs.size()-1);
            double A = nums.remove(nums.size()-1);
            double B = nums.remove(nums.size()-1);
            double result = 0;

            if(operator.equals("+")){
                result = A+B;
                nums.add(result);
            }else
            if(operator.equals("-")){
                result = A-B;
                nums.add(result);
            }
            else
            if(operator.equals("/")){
                result = A/B;
                nums.add(result);
            }
            else
            if(operator.equals("*")){
                result = A*B;
                nums.add(result);
            }
        }
        double result1 = nums.get(0);
        double result_comp = 15.0;
    }
}