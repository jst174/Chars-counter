package ua.com.foxminded.counter;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CacheCharsCounter extends CharsCounterDecorator {

    private Map<String, Map<Character, Long>> cache = new HashMap<>();
    private CharsCounter charsCounter;

    public CacheCharsCounter(CharsCounter charsCounter) {
        super(charsCounter);
    }

    @Override
    public Map<Character, Long> countCharacters(String text) {
        return cache.merge(text, super.countCharacters(text), (a, b) -> a);
    }

}
