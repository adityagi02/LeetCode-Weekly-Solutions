// Aditya Tyagi
// agar code chale to mujhe follow kar diyo, 👍🏻


class Solution {
    public boolean divideArray(int[] nums) {
        if(nums.length%2 != 0) return false;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;){
            if(nums[i] != nums[i+1]) return false;
            else {
                i=i+2;
            }
        }
        return true;
    }
}
