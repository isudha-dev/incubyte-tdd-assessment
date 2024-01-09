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

    @Test
    public void shouldAllowNewLineAsDelimiter() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void shoudAllowForCustomDelimiter() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void shouldAllowForCustomDelimiterWhichAreEscapeChar() {
        assertEquals(3, StringCalculator.add("//.\n1.2"));
    }
}
