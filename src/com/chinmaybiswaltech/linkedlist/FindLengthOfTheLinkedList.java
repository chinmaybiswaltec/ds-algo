package com.chinmaybiswaltech.linkedlist;

public class FindLengthOfTheLinkedList {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private void lengthInIterativeMethod(Node head){
        Node currentNode = head;
        int length =0;
        while(currentNode != null){
            length++;
            currentNode = currentNode.next;
        }
        System.out.println("Length of Linked List is "+length);
        //Length of Linked List is 4
    }

    private void lengthInRecursiveMethod(Node head, int length ){
        if(head == null){
            System.out.println("Length of Linked List is "+length);
            //Length of Linked List is 4
            return;
        }
        lengthInRecursiveMethod(head.next, length+1);
    }



    private void printNodes(Node head){
        Node node = head;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        FindLengthOfTheLinkedList linkedlist = new FindLengthOfTheLinkedList();
        linkedlist.head = new Node(1);// HEAD
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        linkedlist.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null; // TAIL
        // pictorial representation
        // 1-->2-->3-->4-->null
        System.out.println("Nodes are");
        linkedlist.printNodes(linkedlist.head);// 1 2 3 4
        linkedlist.lengthInRecursiveMethod(linkedlist.head,0);
        linkedlist.lengthInIterativeMethod(linkedlist.head);
    }
}
