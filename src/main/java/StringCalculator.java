import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        else {
            String[] numArray = getNumbers(numbers);
            List<Integer> numList = Arrays.stream(numArray).map(StringCalculator::getAnInt).collect(Collectors.toList());
            if (numList.stream().anyMatch(i -> i < 0)) {
                throw new RuntimeException("negatives not allowed");
            }
            return numList.stream().reduce(Integer::sum).get();
        }
    }

    private static String[] getNumbers(String numbers) {
        if (numbers.startsWith("//")) {
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
            m.matches();
            String customDelimited = m.group(1);
            numbers = m.group(2);
            return numbers.split(Pattern.quote(customDelimited));
        }
        return numbers.split("[,\n]");
    }

    private static int getAnInt(String num) {
        return Integer.parseInt(num);
    }

}
