import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int firstIndex = 0;
        int secondIndex = 0;
        int mergedIndex = 0;

        while (firstIndex < arr1.length && secondIndex < arr2.length) {
            if (arr1[firstIndex] <= arr2[secondIndex]) {
                mergedArray[mergedIndex++] = arr1[firstIndex++];
            } else {
                mergedArray[mergedIndex++] = arr2[secondIndex++];
            }
        }
        while (firstIndex < arr1.length) {
            mergedArray[mergedIndex++] = arr1[firstIndex++];
        }
        while (secondIndex < arr2.length) {
            mergedArray[mergedIndex++] = arr2[secondIndex++];
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArrays(
                new int[]{1, 3, 5}, new int[]{2, 4, 6})));
        System.out.println(Arrays.toString(mergeSortedArrays(
                new int[]{}, new int[]{1, 2, 3})));
    }
}