package ua.com.foxminded.counter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CacheCharsCounterTest {

    @Mock
    CharsCounter counter;
    Map<String, Map<Character, Long>> cache;

    @Test
    public void countCharacters_ShouldReturnResultFromCache() {
        String text = "hello";
        cache = new LinkedHashMap<>();
        Map<Character, Long> resultOfCount = new LinkedHashMap<>();
        resultOfCount.put('h', 1l);
        resultOfCount.put('e', 1l);
        resultOfCount.put('l', 2l);
        resultOfCount.put('o', 1l);
        cache.put(text, resultOfCount);
        when(counter.countCharacters(text)).thenReturn(cache.get(text));

        CharsCounter charsCounter = new CacheCharsCounter(counter);

        assertEquals(cache.get(text), counter.countCharacters(text));
    }
}
