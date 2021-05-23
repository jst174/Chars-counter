package ua.com.foxminded.counter;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CacheCharsCounter extends CounterDecorator {

    private Map<String, Map<Character, Long>> cache = new HashMap<>();
    private CharsCounter counter;

    public CacheCharsCounter(CharsCounter counter) {
        super(counter);
    }

    @Override
    public Map<Character, Long> countCharacters(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        return cache.merge(text, super.countCharacters(text), (a, b) -> a);
    }

}
