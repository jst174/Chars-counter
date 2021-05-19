package ua.com.foxminded.counter;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Counter counter = new Cache(new CharsCounter());
            while (true) {
                System.out.println("Enter your line or enter \"quit\" to terminate the execution of the program");
                String input = scanner.nextLine();
                if (input.equals("quit")) {
                    break;
                }
                for (Map.Entry<Character, Integer> entry : counter.countCharacters(input).entrySet()) {
                    System.out.println("\"" + entry.getKey() + "\"" + " - " + entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
