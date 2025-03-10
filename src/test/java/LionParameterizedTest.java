import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LionParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void testDoesHaveMane(String sex, boolean expected) throws Exception {
        Predator predator = new Feline();
        Lion lion = new Lion(sex, predator);
        assertEquals(expected, lion.doesHaveMane());
    }
}