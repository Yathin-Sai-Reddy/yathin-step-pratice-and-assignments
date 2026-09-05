import java.util.Arrays;

public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int rotation = k % nums.length;
        if (rotation < 0) {
            rotation += nums.length;
        }
        int[] rotatedArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rotatedArray[(i + rotation) % nums.length] = nums[i];
        }
        return rotatedArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2}, 3)));
    }
}