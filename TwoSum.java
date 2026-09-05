import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < nums.length; secondIndex++) {
                if (nums[firstIndex] + nums[secondIndex] == target) {
                    return new int[]{firstIndex, secondIndex};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] firstInput = {2, 7, 11, 15};
        int[] secondInput = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum(firstInput, 9)));
        System.out.println(Arrays.toString(twoSum(secondInput, 6)));
    }
}