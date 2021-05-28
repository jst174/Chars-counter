package ua.com.foxminded.counter;

import java.util.Map;

public class CharsCounterDecorator implements CharsCounter {

    protected CharsCounter charsCounter;

    public CharsCounterDecorator(CharsCounter charsCounter) {
        this.charsCounter = charsCounter;
    }

    @Override
    public Map<Character, Long> countCharacters(String text) {
        return charsCounter.countCharacters(text);
    }

}
