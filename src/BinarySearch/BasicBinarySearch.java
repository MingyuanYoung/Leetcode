package BinarySearch;

public class BasicBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 7, 9, 11, 15 };
        int target = 9;
        int res = basicBinarySearch(arr, target);
        System.out.println(res);
    }

    public static int basicBinarySearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // return index of the target element
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
