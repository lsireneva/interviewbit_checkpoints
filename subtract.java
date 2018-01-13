package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);

        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        subtract(a);
    }

    public static void printlist(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println(" ");
    }

    /* Reverse single linked list, by moving head element
     * through the list and reattaching next to the head. E,g,:
     * 1->2->3->4
     * 2->1->3->4
     * 3->2->1->4
     * 4->3->2->1
     * */
    public static ListNode reverse(ListNode node) {
        ListNode head = node, newhead = node;
        while (head.next != null) {
            ListNode tmp = head.next.next; /*  ->3 */
            head.next.next = newhead;      /* 2->1  */
            newhead = head.next;           /* 2 is new head */
            head.next = tmp;               /* 1->3 */
            printlist(newhead);
        }
        return newhead;
    }

    /* Subtract head from tail */
    public static ListNode subtract(ListNode node) {

        ListNode head = node;

        /* 1. Find middle by using two pointers, first (middlenode) goes one node at a time,
         second one (endnode) goes two. Finally, first will point at the middle and second at the end */
        ListNode middlenode = node;
        ListNode endnode = node;

        // if list is empty or contains only single node
        if (node.next == null)
            return node;

        while (endnode.next != null) {
            if (endnode.next.next != null) {
                endnode = endnode.next.next;
                middlenode = middlenode.next;
                if (endnode.next == null) { /* odd elements, skip one more */
                    middlenode = middlenode.next;
                }
            } else {
                System.out.println("Попал в else");
                endnode = null; /* Even elements in the array */
                middlenode = middlenode.next;
                break;
            }
        }

        System.out.println("After split: middlenode:" + middlenode.val);

        /* 2. Reverse second part in order to subtract from it later */
        ListNode rev_right = reverse(middlenode);

        /* 3. Walk the reversed list and store in the left part the difference */
        ListNode leftn = head;
        ListNode rightn = rev_right;
        do {
            leftn.val = rightn.val - leftn.val;
            leftn = leftn.next;
            rightn = rightn.next;
        } while (rightn != null);

        /* 4. Reverse right part once again */
        reverse(rev_right);

        System.out.println("Final result:");

        printlist(head);

        return node;
    }

}

