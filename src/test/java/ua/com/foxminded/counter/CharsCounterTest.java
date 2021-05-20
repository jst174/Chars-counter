package ua.com.foxminded.counter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CharsCounterTest {

    private CharsCounter counter;

    @BeforeEach
    void setUp() {
        counter = new CharsCounter();
    }
    
    @Test
    void countCharacters_argumentIsNull_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> counter.countCharacters(null));
    }

    @Test
    void countCharacters_shouldReturnsNembersOfUniqueCharacters() {
        String input = "hello world!";
        Map<Character, Long> expected = new LinkedHashMap<>();
        expected.put('h', 1l);
        expected.put('e', 1l);
        expected.put('l', 3l);
        expected.put('o', 2l);
        expected.put(' ', 1l);
        expected.put('w', 1l);
        expected.put('r', 1l);
        expected.put('d', 1l);
        expected.put('!', 1l);

        assertEquals(expected, counter.countCharacters(input));
    }

}
