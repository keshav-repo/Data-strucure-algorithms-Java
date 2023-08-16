package com.learning.tree;

import java.util.Collections;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class PartitionList {
    public static ListNode partition(ListNode head, int x) {

        if (head == null)
            return null;

        ListNode head2 = null;
        ListNode head2Ref = null;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (curr.val >= x) {

                if (head2 == null) {
                    head2 = new ListNode(curr.val);
                    head2Ref = head2;
                } else {
                    head2.next = new ListNode(curr.val);
                    head2 = head2.next;
                }
                prev = curr;
                if (curr.next != null) {
                    prev.next = curr.next;
                    curr.next = null;
                    curr = prev.next;
                } else {
                    prev.next = null;
                    curr = null;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        while (head2Ref != null) {
            System.out.print(head2Ref.val + " ");
            head2Ref = head2Ref.next;
        }

        System.out.println("");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

//        prev.next = head2Ref;

        return head;
    }

    public static void printList(ListNode head) {
        System.out.println("");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    /***
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition2(ListNode head, int x) {
        ListNode slist = new ListNode();
        ListNode blist = new ListNode();
        ListNode small = slist;
        ListNode big = blist;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }

            head = head.next;
        }

        small.next = blist.next;
        big.next = null;

        return slist.next;
    }


    public static ListNode partition3(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode before_curr = before;
        ListNode after_curr = after;

        while (head != null) {
            if (head.val < x) {
                before_curr.next = head;
                before_curr = before_curr.next;
            } else {
                after_curr.next = head;
                after_curr = after_curr.next;
            }
            head = head.next;
        }

        after_curr.next = null;
        before_curr.next = after.next;

        return before.next;
    }


    public static ListNode partition4(ListNode head, int x) {

        ListNode headRef = head;

        ListNode head2 = null;
        ListNode head2Ref = null;

        ListNode prev = head;
        if (prev.val >= x) {
            head2 = new ListNode(prev.val);
        }

        ListNode curr = head.next;

        while (curr != null) {
            if (curr.val >= x) {
                if (head2 == null) {
                    head2 = new ListNode(curr.val);
                    head2Ref = head2;
                } else {
                    head2.next = new ListNode(curr.val);
                    head2 = head2.next;
                }
                prev = curr;

                if (curr.next != null) {
                    prev.next = curr.next;
                    curr.next = null;
                    curr = prev.next;
                } else {
                    prev.next = null;
                    curr = null;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        while (head2Ref != null) {
            System.out.print(head2Ref.val + " ");
            head2Ref = head2Ref.next;
        }

        System.out.println("");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        return null;
    }

    public static ListNode partition5(ListNode head, int x) {
        ListNode slist = new ListNode();
        ListNode blist = new ListNode();
        ListNode small = slist;
        ListNode big = blist;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }

            head = head.next;
        }

        small.next = blist.next;
        big.next = null;

        return slist.next;
    }


    public static void main(String[] args) {
//        List<Integer> list = List.of(1, 4, 3, 2, 5, 2);
//        int x = 3;

        List<Integer> list = List.of(1, 4, 3, 0, 5, 2);
        int x = 2;

        ListNode head = null;
        ListNode headRef = null;
        for (int i = 0; i < list.size(); i++) {
            if (head == null) {
                head = new ListNode(list.get(i));
                headRef = head;
            } else {
                head.next = new ListNode(list.get(i));
                head = head.next;
            }
        }

        ListNode res = partition5(headRef, x);

          printList(res);
    }

}
