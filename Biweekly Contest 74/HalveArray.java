// Aditya tyagi
// Jaate jaate like follow kar dena
// While going going, do follow and like🤣

class Solution {
    public int halveArray(int[] nums) {
        int sum = 0;
        int count = 0;
        for(int i =0;i<nums.length;i++){
            sum = sum + nums[i];
        }
        int halfSum = sum/2;
        int p = 0;
        for(int j = nums.length-1;j>0;j--){
            while(nums[j-1]<=nums[j]){
                p = nums[j]/2;
                nums[j] = p;
                sum = sum - p;
                count = count+1;
                if(sum <= halfSum) return count;
            }
        }
        return count;
    }
}
