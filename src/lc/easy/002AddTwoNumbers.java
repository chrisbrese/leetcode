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
import java.math.BigInteger;

class Solution {
    private ListNode recursiveList(ListNode last, String sumStr, int curIndex){
        if(curIndex >= 0){
            if(last == null){
                last = new ListNode();
            }
            
            if(curIndex == sumStr.length()-1){
                last.val = Integer.valueOf(sumStr.substring(curIndex));
            }
            else{
                last.val = Integer.valueOf(sumStr.substring(curIndex, 1));
            }
            
            last.next = recursiveList(last, sumStr, curIndex--);
        }
        
        return last;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String l1StrReversed = String.valueOf(l1.val);
        ListNode next = l1.next;
        while(next != null){
            l1StrReversed = String.valueOf(next.val) + l1StrReversed;
            next = next.next;
        }
        
        String l2StrReversed = String.valueOf(l2.val);
        next = l2.next;
        while(next != null){
            l2StrReversed = String.valueOf(next.val) + l2StrReversed;
            next = next.next;
        }
        
        String sumStr = String.valueOf(new BigInteger(l1StrReversed).add(new BigInteger(l2StrReversed)));
               
        ListNode first = new ListNode();
        
        int curIndex = sumStr.length()-1;
        
        ListNode cur = first;
        while(curIndex >= 0){
            if(curIndex == sumStr.length()-1){
                cur.val = Integer.valueOf(sumStr.substring(curIndex));
            }
            else{
                cur.val = Integer.valueOf(sumStr.substring(curIndex, curIndex+1));
            }
            
            if(curIndex > 0){
                next = new ListNode();
                cur.next = next;
                cur = next;
            }
            curIndex--;
        }
        
        return first;
    }
}
