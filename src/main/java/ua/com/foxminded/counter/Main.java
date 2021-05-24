package ua.com.foxminded.counter;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            CharsCounter charsCounter = new CacheCharsCounter(new UniqueCharsCounter());
            while (true) {
                System.out.println("Enter your line or enter \"quit\" to terminate the execution of the program");
                String text = scanner.nextLine();
                if (text.equals("quit")) {
                    break;
                }
                for (Map.Entry<Character, Long> entry : charsCounter.countCharacters(text).entrySet()) {
                    System.out.println("\"" + entry.getKey() + "\"" + " - " + entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
