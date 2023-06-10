/**
 * 2023.05.29 - 06.04
 * Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 */

public class LinkedListCycle_202306 {
    public boolean hasCycle(ListNode head) {
        //two pointer
        ListNode onestep = head;
        ListNode twostep = head;

        while(twostep != null && twostep.next != null){
            onestep = onestep.next;
            twostep = twostep.next.next;
            if(onestep == twostep) return true;
        }

        return false;
    }
}

//Definition for singly-linked list.
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}