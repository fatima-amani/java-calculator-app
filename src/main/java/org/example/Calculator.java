package org.example;

import java.util.ArrayList;

public class Calculator {
    ArrayList<String> expression;

    Calculator(ArrayList<String> expression) {
        this.expression = expression;
    }

    public float calculate() {

        divide();
        multiply();
        return Float.parseFloat(expression.getFirst());
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

    private void multiply() {
        while(expression.size()>1 && expression.contains("*")) {
            int index = expression.indexOf("*");
            float curr = Float.parseFloat(expression.get(index-1)) * Float.parseFloat(expression.get((index+1)));
            expression.set(index, curr+"");
            expression.remove(index-1);
            expression.remove((index));
        }
    }

}
