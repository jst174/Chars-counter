package ua.com.foxminded.counter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

public class ExecutingCharsCounter implements CharsCounter {

    protected CharsCounter counter;

    public Map<Character, Long> countCharacters(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        return text.chars().mapToObj(e -> (char) e)
                .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()));
    }
}
