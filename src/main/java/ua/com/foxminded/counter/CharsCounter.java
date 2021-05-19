package ua.com.foxminded.counter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CharsCounter implements Counter {

    public Map<Character, Integer> countCharacters(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        List<Character> characters = input.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        Map<Character, Integer> result = characters.stream().collect(LinkedHashMap::new, (m, k) -> {
            if (m.containsKey(k)) {
                m.put(k, m.get(k) + 1);
            } else {
                m.put(k, 1);
            }
        }, LinkedHashMap::putAll);
        return result;
    }
}
