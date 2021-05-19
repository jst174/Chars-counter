package ua.com.foxminded.counter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache extends CounterDecorator {

    private Map<String, Map<Character, Integer>> cache = new LinkedHashMap<>();
    private Counter counter;

    public Cache(Counter counter) {
        super(counter);
    }

    @Override
    public Map<Character, Integer> countCharacters(String input) {
        Map<Character, Integer> result;
        if (!cache.containsKey(input)) {
            result = super.countCharacters(input);
            cache.put(input, result);
        } else {
            result = cache.get(input);
        }
        return result;
    }

    public Map<String, Map<Character, Integer>> getCache() {
        return cache;
    }
    
    
}
