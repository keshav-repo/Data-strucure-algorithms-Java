package com.learning.random;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class Max5InputStream {
    Comparator<Integer> comparator = ((o1, o2) -> Integer.compare(o1, o2));
    private PriorityQueue<Integer> query = new PriorityQueue<>(5, comparator);
    public void  insert(int number){
        if (query.size() < 5) {
            query.offer(number);
        } else if (number > query.peek()) {
            query.poll();
            query.offer(number);
        }
    }

    public List<Integer> getTop5(){
        return query.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Max5InputStream max5InputStream = new Max5InputStream();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.next();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            max5InputStream.insert(Integer.parseInt(input));
            System.out.println(max5InputStream.getTop5());
        }
    }
}
