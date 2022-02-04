class Solution {
    public String longestCommonPrefix(String[] strs) {
        String compare = strs[0];
        int compareIndex = compare.length();
        
        while(compare.length() > 0){
            boolean notFound = false;
            for(int i = 1; i < strs.length; i++){
                if(!strs[i].startsWith(compare)){
                    notFound = true;
                    break;
                }
            }
            
            if(!notFound){
                return compare;
            }
            
            compare = compare.substring(0, compareIndex);
            compareIndex--;
        }
        
        return "";
    }
}
