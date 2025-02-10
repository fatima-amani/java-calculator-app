package org.example;

import java.util.ArrayList;
import java.util.HashSet;


public class Calculator {
    private ArrayList<String> expression;

    Calculator(ArrayList<String> expression) {
        this.expression = expression;
    }

    public float calculate() {
        try {
            checkValidExpression();
            divide();
            product();
            sum();
            difference();

            float ans = Float.parseFloat(expression.getFirst());
            System.out.println(ans);
            return ans;
        } catch (Exception e){
            System.out.println(e.getMessage());
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

    private boolean checkValidExpression() {
        HashSet<Character> set = new HashSet<>();
        set.add('+'); set.add('-');
        set.add('/');set.add('*');

        if(expression.size()>1 && ! expression.getFirst().matches("[0-9]+")) {
            throw new RuntimeException("Error: Operator detected at start");
        }

        for (int i=1;i<expression.size();i++) {
            if(expression.get(i).matches("[0-9]+")){
                if (expression.get(i-1).matches("[0-9]+")) {
                    throw new RuntimeException("Error: Two consecutive numbers without operator detected");
                }
            } else if (set.contains(expression.get(i).charAt(0))) {
                if (set.contains(expression.get(i-1).charAt(0))) {
                    throw new RuntimeException("Error: Two consecutive operators detected");
                }
            } else {
                throw new RuntimeException("Invalid Expression: Contains invalid characters");
            }
        }
        return true;
    }

}
