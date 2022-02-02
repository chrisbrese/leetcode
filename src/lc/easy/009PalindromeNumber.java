class Solution {
    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        for(int i = 0; i < xStr.length(); i++){
            String xi = xStr.substring(i,i+1);
            int compareI = xStr.length()-(i+1);
            
            if(!xi.equals(xStr.substring(compareI, compareI + 1))){
                return false;
            }
        }
        
        return true;
    }
}
