import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        else if (numbers.contains(",")) {
            String[] numArray = numbers.split(",");
            List<Integer> numList = Arrays.stream(numArray).map(StringCalculator::getAnInt).collect(Collectors.toList());
            return numList.stream().reduce(Integer::sum).get();
        }
        return Integer.parseInt(numbers);
    }

    private static int getAnInt(String num) {
        return Integer.parseInt(num);
    }

}
