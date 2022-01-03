package com.chinmaybiswaltech.linkedlist;

public class FindMiddleNodeInTheLinkedList {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private void findMiddleNodeUsingTwoPointerMethod(Node head){
        Node fastPointer = head;
        Node slowPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next ;
           slowPointer = slowPointer.next;
        }
        System.out.println(slowPointer.data);
    }

    private void findMiddleNodeUsingLengthOfLinkedList(Node head){
        int length = findLengthOfLinkedList(head);
        Node temp = head;
        int mid = length/2;
        for(int i=0;i<mid;i++){
            temp =temp.next;
        }
        System.out.println(temp.data);
    }
    private int findLengthOfLinkedList(Node head){
        int length =0;
        Node currentNode = head;
        while(currentNode != null){
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }


    private void printNodes(Node head){
        Node node = head;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        FindMiddleNodeInTheLinkedList linkedlist = new FindMiddleNodeInTheLinkedList();
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
        linkedlist.findMiddleNodeUsingLengthOfLinkedList(linkedlist.head);
        linkedlist.findMiddleNodeUsingTwoPointerMethod(linkedlist.head);
    }
}
