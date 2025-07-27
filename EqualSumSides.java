public class Kata {

    /**
     Returns the index where the sum of the integers to the left of the index 
     is equal to the sum of the integers to the right.
     
     @param arr the array of integers
     @return the index if found; otherwise, -1
     
     Example:
     findEvenIndex([1,2,3,4,3,2,1]) ➜ 3
     Because: 1+2+3 = 6 and 2+1+3 = 6
     */
    public static int findEvenIndex(int[] arr) {
        int totalSum = 0;
        int leftSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += arr[i];
        }

        return -1;
    }
}
