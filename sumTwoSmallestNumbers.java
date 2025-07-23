    /*
    Description:
    Create a function that returns the sum of the two lowest positive numbers given an array of minimum 4 positive integers.
    No floats or non-positive integers will be passed.

    For Java, those integers will come as double precision (long).

    For example, when an array is passed like [19, 5, 42, 2, 77], the output should be 7.

    [10, 343445353, 3453445, 3453545353453] should return 3453455.
    */

class Kata {
    public static long sumTwoSmallestNumbers(long[] numbers) {
        long min1 = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;

        for (long n : numbers) {
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return min1 + min2;
    }
}
