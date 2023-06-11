/**
 * 2023.06.05 - 06.11
 * Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
 */

public class MaximumProductSubarray_202306 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int answer = nums[0];

        for(int i = 1; i < nums.length; i++){
            int tmp = max;
            max = Math.max(nums[i], Math.max(nums[i]*max, nums[i]*min));
            min = Math.min(nums[i], Math.min(nums[i]*tmp, nums[i]*min));
            answer = Math.max(answer, max);
        }
        return answer;
    }
}
