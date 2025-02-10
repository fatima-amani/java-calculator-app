package org.example;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Calculator {
    private ArrayList<String> expression;

    Calculator(ArrayList<String> expression) {
        this.expression = expression;
    }

    public float calculate() {
        divide();
        product();
        sum();
        difference();

        return Float.parseFloat(expression.getFirst());
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

}
