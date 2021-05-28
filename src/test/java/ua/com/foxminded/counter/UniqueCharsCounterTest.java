package ua.com.foxminded.counter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UniqueCharsCounterTest {

    private UniqueCharsCounter counter;

    @BeforeEach
    void setUp() {
        counter = new UniqueCharsCounter();
    }

    @Test
    void countCharacters_argumentIsNull_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> counter.countCharacters(null));
    }

    @Test
    void countCharacters_shouldReturnsNembersOfUniqueCharacters() {
        String text = "hello world!";
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

        assertEquals(expected, counter.countCharacters(text));
    }

    @Test
    void countCharacters_argumentContainsUppercaseChars_ShoudCountHowUniqueCharacter() {
        String text = "Hello, human!";
        Map<Character, Long> expected = new LinkedHashMap<>();
        expected.put('H', 1l);
        expected.put('e', 1l);
        expected.put('l', 2l);
        expected.put('o', 1l);
        expected.put(',', 1l);
        expected.put(' ', 1l);
        expected.put(' ', 1l);
        expected.put('h', 1l);
        expected.put('u', 1l);
        expected.put('m', 1l);
        expected.put('a', 1l);
        expected.put('n', 1l);
        expected.put('!', 1l);

        assertEquals(expected, counter.countCharacters(text));
    }

    @Test
    void counCharacters_argumentIsEmpty_ShouldReturnNothing() {
        String text = "";
        Map<Character, Long> expected = new LinkedHashMap<>();

        assertEquals(expected, counter.countCharacters(text));
    }

}
