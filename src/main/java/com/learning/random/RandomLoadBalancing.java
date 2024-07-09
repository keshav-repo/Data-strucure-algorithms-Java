package com.learning.random;

import java.util.Scanner;

public class RandomLoadBalancing {
    private int noOFHost;
    public RandomLoadBalancing( int noOFHost) {
        this.noOFHost = noOFHost;
    }
    public int randomHost(){
        return  -1;
    }
    public static void main(String[] args) {
        RandomLoadBalancing randomLoadBalancing = new RandomLoadBalancing(5);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println("Do you want next host: (yes/no)");
            String input = scanner.next();
            if (input.equalsIgnoreCase("no")) {
                break;
            }
            System.out.println(randomLoadBalancing.randomHost());
        }
    }
}
