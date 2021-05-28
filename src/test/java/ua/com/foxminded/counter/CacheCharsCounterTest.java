package ua.com.foxminded.counter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.times;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CacheCharsCounterTest {

    @Mock
    private CharsCounter charsCounter;
    @InjectMocks
    private CacheCharsCounter cacheCharsCounter;

    @Test
    public void countCharacters_ShouldReturnResultFromCache() {
        String text = "hello";
        Map<Character, Long> expected = new LinkedHashMap<>();
        expected.put('h', 1l);
        expected.put('e', 1l);
        expected.put('l', 2l);
        expected.put('o', 1l);

        when(charsCounter.countCharacters(text)).thenReturn(expected);

        Map<Character, Long> actual = cacheCharsCounter.countCharacters(text);
        cacheCharsCounter.countCharacters(text);

        verify(charsCounter).countCharacters(text);
        assertEquals(expected, actual);

    }
}
