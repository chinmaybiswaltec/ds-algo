package com.chinmaybiswaltech.linkedlist;

public class GetNthNodeFromTleEndInTheLinkedList {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private int findNthNodeFromEndUsingTwoPointerMethod(Node head, int positionFromEnd){
        Node first = head;
        Node second = head;
        //Move the first pointer by n steps
        for(int i=0;i<positionFromEnd;i++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        return second.data;
    }

    private int findNthNodeFromEndUsingLengthOfLinkedList(Node head, int positionFromEnd){
        int length = findLengthOfLinkedList(head);
        int positionFromStart = length - positionFromEnd+1;
        return findNthElementInIterativeMethod(head, positionFromStart);
    }

    private int findNthElementInIterativeMethod(Node head, int position){
        int currentPosition =0;
        Node currentNode = head;
        while(currentNode != null){
            currentPosition++;
            if (currentPosition == position){
                return currentNode.data;
            }
            currentNode = currentNode.next;
        }
        return 0;
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
        GetNthNodeFromTleEndInTheLinkedList linkedlist = new GetNthNodeFromTleEndInTheLinkedList();
        linkedlist.head = new Node(1);// HEAD
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        linkedlist.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null; // TAIL
        // pictorial representation
        // 1-->2-->3-->4-->5-->null
        System.out.println("Nodes are");
        linkedlist.printNodes(linkedlist.head);// 1 2 3 4 5
        int secondElementFromLast = linkedlist.findNthNodeFromEndUsingLengthOfLinkedList(linkedlist.head,2);
        System.out.println("Second element from the end is "+secondElementFromLast);
        //Second element from the end is 4
        int thirdElementFromLast = linkedlist.findNthNodeFromEndUsingTwoPointerMethod(linkedlist.head,3);
        System.out.println("Third element from the end is "+thirdElementFromLast);
        //Third element from the end is 3
    }
}
