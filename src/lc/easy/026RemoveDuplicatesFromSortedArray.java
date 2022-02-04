class Solution {
    public int removeDuplicates(int[] nums) {
        int nextAvailIndex = 1;
        int lastUniqueIndex = 0;
        
        int uniqueNums = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[lastUniqueIndex]){
                nums[nextAvailIndex] = nums[i];
                lastUniqueIndex = i;
                nextAvailIndex++;
                uniqueNums++;
            }
        }
        
        return uniqueNums;
    }
}
