import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFrequencies = new HashMap<>();
        prefixFrequencies.put(0, 1);
        int prefixSum = 0;
        int matchingSubarrays = 0;

        for (int number : nums) {
            prefixSum += number;
            matchingSubarrays += prefixFrequencies.getOrDefault(prefixSum - k, 0);
            prefixFrequencies.put(prefixSum, prefixFrequencies.getOrDefault(prefixSum, 0) + 1);
        }
        return matchingSubarrays;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
    }
}