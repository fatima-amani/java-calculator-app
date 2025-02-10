package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression: ");
        String exp = sc.nextLine();
        String[] expArr = exp.split("\\s+");

        Calculator c = new Calculator(new ArrayList<>(Arrays.asList(expArr)));
        System.out.println(c.calculate());


    }
}