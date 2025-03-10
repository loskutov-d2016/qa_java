import com.example.Cat;
import com.example.Predator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CatTest {

    @Test
    void testGetSound() {
        Predator predator = Mockito.mock(Predator.class);
        Cat cat = new Cat(predator);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFood() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Cat cat = new Cat(predator);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}