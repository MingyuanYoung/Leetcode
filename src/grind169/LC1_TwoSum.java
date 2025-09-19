package grind169;

import java.util.HashMap;

public class LC1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[] { -1, -1 };
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        LC1_TwoSum test = new LC1_TwoSum();
        int[] nums = new int[] { 2, 3, 4, 5 };
        int target = 7;
        int[] res = test.twoSum(nums, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
