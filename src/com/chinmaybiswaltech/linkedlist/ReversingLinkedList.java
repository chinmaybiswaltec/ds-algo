package com.chinmaybiswaltech.linkedlist;

public class ReversingLinkedList {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

   private Node reverseLinkedList(Node head){
     Node current = head;
     Node next = null;
     Node previous = null;

     while(current != null){
         next = current.next;
         current.next=previous;
         previous =current;
         current=next;
     }
     return previous;
   }

   private Node reverseLinkedListInRecursiveWay(Node current, Node previous){
        if(current == null){
            return current;
        }
       if (current.next == null){
           current.next = previous;
           return current;
       }
        Node next = current.next;
        current.next = previous;
        return reverseLinkedListInRecursiveWay(next,current);
   }


    private void printNodes(Node head){
        Node node = head;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ReversingLinkedList linkedlist = new ReversingLinkedList();
        linkedlist.head = new Node(1);// HEAD
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);

        linkedlist.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = null ; // TAIL
        // pictorial representation
        // 1-->2-->3-->4-->5-->6-->null
        System.out.println("Nodes are");
        linkedlist.printNodes(linkedlist.head);// 1 2 3 4 5 6
       // Node newHead = linkedlist.reverseLinkedList(linkedlist.head);
        System.out.println("Nodes in reverse are ");

        Node newHead =linkedlist.reverseLinkedListInRecursiveWay(linkedlist.head, null);
        linkedlist.printNodes(newHead);// 6 5 4 3 2 1
    }
}
