package com.chinmaybiswaltech.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LoopDetectionInTheLinkedList {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private void findLengthOfLoop(Node head){
        Node startOfLoop = floydLoopDetectionAlgo(head);
        int count =1;
        Node temp = startOfLoop.next;
        while(startOfLoop.data != temp.data  ){
             count++;
             temp = temp.next;
        }
        System.out.println("Count "+count);
    }


    private Node floydLoopDetectionAlgo(Node head){
        Node fast = head;
        Node slow = head;
        Node startOfLoop = null;
        int flag =0;
        while( slow != null && fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast.data == slow.data){
            startOfLoop = fast;
            flag=1;
            break;
        }
        }
        if (flag==1){
            System.out.println("Loop exists");
            //Loop exists
        }else{
            System.out.println("Loop does not exists");
        }
        return startOfLoop;
    }
    private boolean detectLoop(Node head){
        Set<Node> nodeSet = new HashSet<>();
        while(head != null){
           if(nodeSet.contains(head)){
               return true;
           }
            nodeSet.add(head);
            head=head.next;
        }
        return false;
    }


    public static void main(String[] args) {
        LoopDetectionInTheLinkedList linkedlist = new LoopDetectionInTheLinkedList();
        linkedlist.head = new Node(1);// HEAD
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        linkedlist.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = second;

        // pictorial representation
        // 1-->2-->3-->4-->5-->2

        System.out.println(linkedlist.detectLoop(linkedlist.head));
        //true
        linkedlist.floydLoopDetectionAlgo(linkedlist.head);
        linkedlist.findLengthOfLoop(linkedlist.head);
    }
}
