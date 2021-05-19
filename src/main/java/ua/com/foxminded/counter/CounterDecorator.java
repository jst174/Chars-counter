package ua.com.foxminded.counter;

import java.util.Map;

public class CounterDecorator implements Counter {

    Counter counter;

    public CounterDecorator(Counter counter) {
        super();
        this.counter = counter;
    }

    @Override
    public Map<Character, Integer> countCharacters(String input) {
        return counter.countCharacters(input);
    }

}
