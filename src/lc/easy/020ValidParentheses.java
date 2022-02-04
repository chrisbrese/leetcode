class Solution {
    public boolean isValid(String s) {
        if(s.length() %2 == 0){ // line must have even number of characters
            Stack<String> lastOpenChars = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                String nextChar = s.substring(i, i+1);
                boolean found = false;

                if(nextChar.equals(")") || nextChar.equals("]") || nextChar.equals("}")) {
                    if(!lastOpenChars.empty()){
                        String curChar = lastOpenChars.pop();
                        if(nextChar.equals(")") && curChar.equals("(")) {
                            found = true;
                        }
                        else if(nextChar.equals("]") && curChar.equals("[")) {
                            found = true;
                        }
                        else if(nextChar.equals("}") && curChar.equals("{")) {
                            found = true;
                        }
                    }
                    else{
                        return false;
                    }
                }
                else {
                    found = true;
                    lastOpenChars.push(nextChar);
                }

                if(!found){
                    return false;
                }
            }

            if(lastOpenChars.empty()){
                return true;
            }
        }
        
        return false;
    }
}
