package org.example;

import java.util.ArrayList;

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
        while(expression.size()>1 && expression.contains("+")) {
            int index = expression.indexOf("+");
            float curr = Float.parseFloat(expression.get(index-1)) + Float.parseFloat(expression.get((index+1)));
            expression.set(index, curr+"");
            expression.remove(index-1);
            expression.remove((index));
        }
    }

    private void difference() {
        while(expression.size()>1 && expression.contains("-")) {
            int index = expression.indexOf("-");
            float curr = Float.parseFloat(expression.get(index-1)) - Float.parseFloat(expression.get((index+1)));
            expression.set(index, curr+"");
            expression.remove(index-1);
            expression.remove((index));
        }
    }

    private void product() {
        while(expression.size()>1 && expression.contains("*")) {
            int index = expression.indexOf("*");
            float curr = Float.parseFloat(expression.get(index-1)) * Float.parseFloat(expression.get((index+1)));
            expression.set(index, curr+"");
            expression.remove(index-1);
            expression.remove((index));
        }
    }

    private void divide() {
        while(expression.size()>1 && expression.contains("/")) {
            int index = expression.indexOf("/");
            float curr = Float.parseFloat(expression.get(index-1)) / Float.parseFloat(expression.get((index+1)));
            expression.set(index, curr+"");
            expression.remove(index-1);
            expression.remove((index));
        }
    }

}
