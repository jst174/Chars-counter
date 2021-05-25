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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CacheCharsCounterTest {

    @Mock
    private UniqueCharsCounter uniqueCharsCounter;
    @InjectMocks
    private CacheCharsCounter cacheCharsCounter;

    @Test
    public void countCharacters_ShouldReturnResultFromCache() {
        String text = "hello";
        Map<Character, Long> resultOfCount = new LinkedHashMap<>();
        resultOfCount.put('h', 1l);
        resultOfCount.put('e', 1l);
        resultOfCount.put('l', 2l);
        resultOfCount.put('o', 1l);

        when(uniqueCharsCounter.countCharacters(text)).thenReturn(resultOfCount);

        Map<Character, Long> resultOfCounter = uniqueCharsCounter.countCharacters(text);
        Map<Character, Long> resultOfCache = cacheCharsCounter.countCharacters(text);

        assertSame(resultOfCounter, resultOfCache);

    }
}
