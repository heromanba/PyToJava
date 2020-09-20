
import java.lang.Math;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * File: formats.py
 * Various specialized string display formatting utilities.
 * Test me with canned self-test or command-line argumnets.
 * To do: add parans for negative money, and more feature.
 */
public class Formats {
    public static void main(String[] args) {
        ArrayList<Number> tests = new ArrayList<>();
        tests.addAll(Arrays.asList(
                0, 1, 12, 123, 1234, 12345, 123456, 1234567,
                Math.pow(2, 32), Math.pow(2, 100)
        ));

        for (Number test : tests)
            // Use BigInteger to cover big numbers.
            System.out.println(Formats.commas(BigInteger.valueOf(test.longValue())));

        System.out.println("-".repeat(80));
        for (Number test : tests)
            System.out.println(Formats.commas1(BigInteger.valueOf(test.longValue())));
        System.out.println("-".repeat(80));

        tests = new ArrayList<>();
        tests.addAll(Arrays.asList(
                0, 1, -1, 1.23, 1., 1.2, 3.1341,
                12, 123, 1234, 12345, 123456, 1234567,
                Math.pow(2, 32), Math.pow(2, 100) + 0.2342,
                1.2324, 1.2, 0.2345,
                -1.242, -1.2, -15.2,
                -Math.pow(2, 32), -(Math.pow(2, 32) + 0.2324),
                Math.pow(2, 100), -Math.pow(2, 100)
        ));
        for (Number test : tests)
            System.out.println(String.format(
                    "%s [%s]",
                    Formats.money(BigInteger.valueOf(test.longValue()), 17),
                    BigInteger.valueOf(test.longValue()).toString()
            ));

    }

    /**
     * Format positive integer-like N for display with
     * commas between digits grouping: "XXX, YYY, ZZZ"
     * @param N
     * @return a formatted string
     */
    private static String commas(BigInteger N) {
        String digits = N.toString();

        // turn on assert with "-ea" in VM options.
        assert digits.matches("[0-9]+") : "Not all characters are digits";

        String result = "";

        // loop until digits is empty.
        while (digits != null && !digits.trim().isEmpty()) {
            String last3;

            // check if digits is longer than 3 characters.
            if (digits.length() - 3 > 0) {
                last3 = digits.substring(digits.length()-3);
                digits = digits.substring(0, digits.length()-3);
            } else {
                last3 = digits;
                digits = "";
            }

            // check if result is empty.
            if (result != null && !result.trim().isEmpty())
                result = last3 + "," + result;
            else
                result = last3;
        }
        return result;
    }

    /**
     * The easier way to format digits.
     * @param N
     * @return a formatted string
     */
    private static String commas1(BigInteger N) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(N);
    }

    /**
     *
     * Format number N for display with commas, 2 decimal digits,
     * leading $ and sign, and optional padding: "$ -xxx,yyy.zz".
     * numwidth=0 for no space padding, currency='' to omit symbol,
     * and non-ASCII for others (e.g., pound=u'\xA3' or u'\u00A3').
     *
     * Note:
     *     Java doesn't allow default arguments, so we will use method
     *     overloading. You can also try other methods mentioned in
     *     https://stackoverflow.com/a/19719701
     */
    private static String money(BigInteger N, int numwidth, String currency) {
        String sign = N.intValue() < 0 ? "-" : "";
        N = N.abs();

        // No need to convert N to int.
        String whole = Formats.commas(N);
        String fract = String.format("%2f", N.floatValue());
        fract = fract.substring(fract.length()-2);
        String number = String.format("%s%s.%s", sign, whole, fract);
        return String.format("%s%s%s", currency, numwidth, number);
    }

    private static String money(BigInteger N, int numwidth) {
        return Formats.money(N, numwidth, "$");
    }

    private static String money(BigInteger N, String currency) {
        return Formats.money(N, 0, currency);
    }

    private static String money(BigInteger N) {
        return Formats.money(N, 0, "$");
    }
}