package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter expression: (or exit)");
            String exp = sc.nextLine();
            if(exp.equals("exit")) {
                exit(0);
            }
            String[] expArr = exp.split("\\s+");
            Calculator c = new Calculator(new ArrayList<>(Arrays.asList(expArr)));
            c.calculate();
        }



    }
}