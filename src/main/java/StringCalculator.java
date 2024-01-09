public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        else if (numbers.contains(",")) {
            String[] numArray = numbers.split(",");
            return Integer.parseInt(numArray[0]) + Integer.parseInt(numArray[1]);
        }

        return Integer.parseInt(numbers);
    }

}
