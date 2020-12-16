import java.util.Arrays;
import java.util.HashSet;

public class Validator {
    public long validateArray(long[] input, int preambleLength) {
        for (int i = preambleLength; i < input.length; i++) {

            long preamble[] = Arrays.copyOfRange(input, i - preambleLength, i);
            if (!isNumberValid(preamble, input[i])) {
                return input[i];
            }
        }
        return 0;
    }
    public void getEncryptionWeakness(long[] input, long invalidValue) {
        
        //int maxSubArrayLength = 6;
        // subArray[0] = input[j];
        // subArray[1] = input[j+1];
        // subArray[2] = input[j+2];
        for (int maxSubArrayLength = 2; maxSubArrayLength < 20; maxSubArrayLength++) {
            for (int j = 0; j < input.length - maxSubArrayLength + 1; j++) {
                long[] subArray = new long[maxSubArrayLength];

                for (int i = 0; i < maxSubArrayLength; i++) {
                    subArray[i] = input[j + i];
                }
                // System.out.print(sumArray(subArray));
                // printArray(subArray);
                if (sumArray(subArray) == invalidValue) {
                    System.out.println(getSmallest(subArray) + getLargest(subArray));
                }
            }
        }
    }
    private boolean isNumberValid(long[] preamble, long number) {
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < preamble.length; i++) {
            long temp = number - preamble[i]; 
            if (set.contains(temp)) {
                return true;
            }
            set.add(preamble[i]);
        }
        return false;
    }    
    private void printArray(long[] arr) {
        System.out.print("["); 
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+","); 
        }
        System.out.println("]"); 
    }
    private long sumArray(long[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    private long getLargest(long[] arr) {
        long max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    private long getSmallest(long[] arr) {
        long max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
