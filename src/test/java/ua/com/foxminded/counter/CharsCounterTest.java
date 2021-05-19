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
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('h', 1);
        expected.put('e', 1);
        expected.put('l', 3);
        expected.put('o', 2);
        expected.put(' ', 1);
        expected.put('w', 1);
        expected.put('r', 1);
        expected.put('d', 1);
        expected.put('!', 1);

        assertEquals(expected, counter.countCharacters(input));
    }

}
