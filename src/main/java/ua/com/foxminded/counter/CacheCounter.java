package ua.com.foxminded.counter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CacheCounter extends CounterDecorator {

    private Map<String, Map<Character, Long>> cache = new HashMap<>();
    private CharCountable counter;

    public CacheCounter(CharCountable counter) {
        super(counter);
    }

    @Override
    public Map<Character, Long> countCharacters(String text) {
        Map<Character, Long> resultOfCount = super.countCharacters(text);
        Map<Character, Long> result = cache.getOrDefault(text, resultOfCount);
        cache.putIfAbsent(text, resultOfCount);
        return result;
    }

}
