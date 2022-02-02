class Solution {
   private enum RomanSymbols{
        I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
        
        private int value;
        
        private RomanSymbols(int value) {
            this.value = value;
        }
       
        public static int fromString(String symbol){
            for (RomanSymbols sym : RomanSymbols.values()){
                if(sym.toString().equals(symbol)){
                    return sym.value;
                }
            }
            
            return 0;
        }
    }
    
    public int romanToInt(String s) {
        int sum = 0;
        
        for(int i = 0; i < s.length(); i++){
            String next;
            if(i != s.length()-1){
                next = s.substring(i+1, i+2);
            }
            else{
                next = "I";
            }
            
            String cur = s.substring(i, i+1);
            if(RomanSymbols.fromString(cur) < RomanSymbols.fromString(next)){
                sum += RomanSymbols.fromString(next) - RomanSymbols.fromString(cur);
                i++;
            }
            else{
                sum += RomanSymbols.fromString(cur);
            }
        }
        
        return sum;
    }
}
