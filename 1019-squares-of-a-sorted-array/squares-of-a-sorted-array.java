class Solution {
    public int[] sortedSquares(int[] nums) {
          int[] nums1 = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
          
            nums1[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums1);
        return nums1;
    }
}