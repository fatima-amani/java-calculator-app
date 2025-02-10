package org.example;

import javax.security.auth.callback.TextInputCallback;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.System.exit;

public class Calculator {
    private ArrayList<String> expression;

    Calculator(ArrayList<String> expression) {
        this.expression = expression;
    }

    public float calculate() {
        try {
            if(! isValid()) {
                throw new RuntimeException("Invalid Expression: Contains invalid characters");
            }
            divide();
            product();
            sum();
            difference();

            return Float.parseFloat(expression.getFirst());
        } catch (Exception e){
            System.out.println(e.getMessage());
            exit(0);
        }
        return 0f;
    }

    private void sum() {
        try {
            while(expression.size()>1 && expression.contains("+")) {
                int index = expression.indexOf("+");
                float curr = Float.parseFloat(expression.get(index-1)) + Float.parseFloat(expression.get((index+1)));
                expression.set(index, curr+"");
                expression.remove(index-1);
                expression.remove((index));
            }
        } catch (Exception e) {
            System.out.println("Exception in Sum: "+e.getMessage());
        }

    }

    private void difference() {
        try {
            while(expression.size()>1 && expression.contains("-")) {
                int index = expression.indexOf("-");
                float curr = Float.parseFloat(expression.get(index-1)) - Float.parseFloat(expression.get((index+1)));
                expression.set(index, curr+"");
                expression.remove(index-1);
                expression.remove((index));
            }
        } catch (Exception e) {
            System.out.println("Exception in Difference: "+e.getMessage());
        }
    }

    private void product() {
        try {
            while(expression.size()>1 && expression.contains("*")) {
                int index = expression.indexOf("*");
                float curr = Float.parseFloat(expression.get(index-1)) * Float.parseFloat(expression.get((index+1)));
                expression.set(index, curr+"");
                expression.remove(index-1);
                expression.remove((index));
            }
        } catch (Exception e) {
            System.out.println("Exception while Product: "+e.getMessage());
        }
    }

    private void divide() {
        try {
            while(expression.size()>1 && expression.contains("/")) {
                int index = expression.indexOf("/");
                float curr = Float.parseFloat(expression.get(index-1)) / Float.parseFloat(expression.get((index+1)));
                expression.set(index, curr+"");
                expression.remove(index-1);
                expression.remove((index));
            }
        } catch (Exception e) {
            System.out.println("Exception while Divding: "+e.getMessage());
        }
    }

    private boolean isValid() {
        for(String str: expression) {
//            if (Pattern.matches("[^+\\-*/]", str)) {
            if(! (str.matches("[^+\\-*/]") || str.matches("[0-9]"))) {
                return false;
            }
        }
        return true;
    }

}
