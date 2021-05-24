package ua.com.foxminded.counter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

public class UniqueCharsCounter implements CharsCounter {

    protected CharsCounter charsCounter;

    public Map<Character, Long> countCharacters(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        return text.chars().mapToObj(e -> (char) e)
                .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()));
    }
}
