package ua.com.foxminded.counter;

import java.util.Map;

public interface CharsCounter {

    public Map<Character, Long> countCharacters(String text);

}
