/**
 * @author Pablo Herrera
 * @since February 1st, 2022
 * @Version 1.0
 *
 * My calculator allows to calculate some expression in postfix notation
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MyCalculator implements  Calculator{
    /**
     * Calculates the result of a postfix operation
     * @param operation String containing the operation to be calculated.
     * @return double calculated
     */
    @Override
    public double calculate(String operation) {
        String[] operacion = operation.split("");
        ArrayList<String> Arr_for_Stack = new ArrayList<>(Arrays.asList(operacion));

        ArrayList<Double> num_array = new ArrayList<>();
        ArrayList<String> op_array = new ArrayList<>();

        for (String s : Arr_for_Stack) {
            try {
                double constant = Double.parseDouble(s);
                num_array.add(constant);
            } catch (NumberFormatException e) {
                op_array.add(s);
            }
        }
        Collections.reverse(num_array);
        Collections.reverse(op_array);
        //elements were added to their respective Arrays so they can be manipulated with Stacks
        MyStack num_stack = new MyStack(num_array);
        MyStack op_stack = new MyStack(op_array);

        //stacks were created, it is time to calculate
        while(num_stack.size() > 1){
            String operador = String.valueOf(op_stack.remove());
            String N1 = String.valueOf(num_stack.remove());
            String N2 = String.valueOf(num_stack.remove());

            double A = Double.parseDouble(N1);
            double B = Double.parseDouble(N2);
            double result;

            if(operador.equals("+")){
                result = A+B;
                num_stack.add(result);
            }
            if(operador.equals("-")){
                result = A-B;
                num_stack.add(result);
            }
            if(operador.equals("*")){
                result = A*B;
                num_stack.add(result);
            }
            if(operador.equals("/")){
                result = A/B;
                num_stack.add(result);
            }
        }
        String Result = String.valueOf(num_stack.remove());
        double FinalResult = Double.parseDouble(Result);
        return FinalResult;
    }

}