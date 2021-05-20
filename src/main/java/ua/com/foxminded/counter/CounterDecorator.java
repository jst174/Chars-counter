package ua.com.foxminded.counter;

import java.util.Map;

public class CounterDecorator implements CharCountable {

    protected CharCountable counter;

    public CounterDecorator(CharCountable counter) {
        this.counter = counter;
    }

    @Override
    public Map<Character, Long> countCharacters(String text) {
        return counter.countCharacters(text);
    }

}
