// Aditya Tyagi
// 11:16pm Sun 13 March, 2022

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == key){
                list1.add(i);
            }
        }
        
        List<Integer> list2 = new ArrayList<>();
        int counter = 0;
        for(int j : list1) {
            int i = Math.max(counter, j-k);
            for(; i< nums.length && i <= j+k; i++){
                list2.add(i);
            }
            counter = i;
        }
        return list2;
    }
}
