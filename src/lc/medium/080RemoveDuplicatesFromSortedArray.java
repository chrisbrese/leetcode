class Solution {
    public int removeDuplicates(int[] nums) {
        int nextAvailIndex = 2;
        int lastUniqueIndex = 1;
        
        int uniqueNums = 2;
        for(int i = 2; i < nums.length; i++){
            boolean proceed = false;
            
            if(nums[i] != nums[lastUniqueIndex] || 
               (nums[i] == nums[lastUniqueIndex] && nums[i] != nums[lastUniqueIndex-1])){
                proceed = true;
            }
            
            if(proceed){
                nums[nextAvailIndex] = nums[i];
                lastUniqueIndex++;
                nextAvailIndex++;
                uniqueNums++;
            }
        }
        
        return uniqueNums;
    }
}
