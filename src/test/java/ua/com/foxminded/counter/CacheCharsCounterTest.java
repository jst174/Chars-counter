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
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CacheCharsCounterTest {

    @Mock
    private UniqueCharsCounter uniqueCharsCounter;
    @Mock
    private CacheCharsCounter cacheCharsCounter;
    private CharsCounter charsCounter;

    @Test
    public void countCharacters_ShouldReturnResultFromCache() {
        String text = "hello";
        charsCounter = new CacheCharsCounter(uniqueCharsCounter);
        charsCounter.countCharacters(text);
        charsCounter.countCharacters(text);

        verify(uniqueCharsCounter, times(1)).countCharacters(text);
        verify(cacheCharsCounter, times(1)).countCharacters(text);

    }
}
