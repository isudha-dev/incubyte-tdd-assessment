import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroForEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void shouldReturnNumberForNumber() {
        assertEquals(1, StringCalculator.add("1"));
    }

}
