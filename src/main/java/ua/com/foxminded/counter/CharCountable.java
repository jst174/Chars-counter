package ua.com.foxminded.counter;

import java.util.Map;

public interface CharCountable {

    public Map<Character, Long> countCharacters(String text);

}
