package ua.com.foxminded.counter;

import java.util.Map;

public class CounterDecorator implements CharsCounter {

    protected CharsCounter counter;

    public CounterDecorator(CharsCounter counter) {
        this.counter = counter;
    }

    @Override
    public Map<Character, Long> countCharacters(String text) {
        return counter.countCharacters(text);
    }

}
