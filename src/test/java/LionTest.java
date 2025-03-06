import com.example.Lion;
import com.example.Predator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


class LionTest {

    @Test
     void testDoesHaveMane() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Lion lion = new Lion("Самец", predator);
        assertEquals(true, lion.doesHaveMane());
    }

    @Test
    void testGetFood() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", predator);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    void shouldThrowExceptionForInvalidSex() {
        Predator predator = Mockito.mock(Predator.class);
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Другое", predator);
        });

        assertEquals("Используйте допустимые значения пола животного - Самец или Самка", exception.getMessage());
    }
}