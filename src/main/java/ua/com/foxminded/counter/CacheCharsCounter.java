package ua.com.foxminded.counter;

import java.util.HashMap;
import java.util.Map;

public class CacheCharsCounter extends CharsCounterDecorator {

    Map<String, Map<Character, Long>> cache = new HashMap<>();

    public CacheCharsCounter(CharsCounter charsCounter) {
        super(charsCounter);
    }

    @Override
    public Map<Character, Long> countCharacters(String text) {
        return cache.computeIfAbsent(text, b -> super.countCharacters(text));
    }

}
