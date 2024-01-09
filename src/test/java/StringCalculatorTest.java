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

    @Test
    public void shouldReturnSumForTwoNumberWithCommaDelimiter() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void shouldReturnSumForMultipleNumbers() {
        assertEquals(10, StringCalculator.add("1,2,3,4"));
    }

}
