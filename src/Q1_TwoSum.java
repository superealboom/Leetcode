import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
    public class Q1_TwoSum {

    @Test
    public void solution() {
        int nums[] = {2,7,11,15};
        int target = 9;
        int result[] = twoSum2(nums, target);
        for (int i: result) {
            System.out.println(i);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length-1;i++) {
            for (int j=i+1;j<nums.length;j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //思路：新建一个map，<key, value> = <nums的值，nums的下标>。每次存的时候，都要查一下是否满足 i + j = target
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=0;i<nums.length;i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);

        }
        return null;
    }

}
