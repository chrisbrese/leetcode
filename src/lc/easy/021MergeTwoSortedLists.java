/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    private void loop(ListNode cur){
        while(cur != null){
            if(map.containsKey(cur.val)){
                map.put(cur.val, map.get(cur.val) + 1);
            }
            else{
                map.put(cur.val, 1);
            }
            
            cur = cur.next;
        }
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {        
        loop(list1);
        loop(list2);
        
        ListNode ret = null;
        if(map.size() > 0){
            TreeMap<Integer, Integer> sorted = new TreeMap<Integer, Integer>();
            sorted.putAll(map);
            
            ret = new ListNode();
            ListNode cur = ret;
            int count = 1;
            for(Map.Entry<Integer, Integer> entry : sorted.entrySet()){
                for(int i = 0; i < entry.getValue(); i++){
                    cur.val = entry.getKey();

                    ListNode next = new ListNode();                
                    if(i == (entry.getValue() - 1) && count == sorted.size()){                    
                        cur.next = null;                    
                    }
                    else{
                        cur.next = next;
                    }
                    cur = next;
                }
                count++;
            }
        }
        
        return ret;
    }
}
