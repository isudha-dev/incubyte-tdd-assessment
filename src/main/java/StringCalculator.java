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
            handleNegativeNumbers(numList);
            return numList.stream().reduce(Integer::sum).get();
        }
    }

    private static void handleNegativeNumbers(List<Integer> numList) {
        List<Integer> negativeNumList = numList.stream().filter(i -> i < 0).collect(Collectors.toList());
        if (!negativeNumList.isEmpty()) {
            List<String> numbersStr = negativeNumList.stream().map(Object::toString).collect(Collectors.toList());
            throw new RuntimeException("Negatives not allowed: " + String.join(", ", numbersStr));
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
