package com.chinmaybiswaltech.linkedlist;

public class CountOccurrenceOfNodeInTheLinkedList {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private void occurrenceOfNode(Node head, int data){
        Node temp = head;
        int count = 0;
        while( temp != null){
            if(temp.data == data){
                count++;
            }
            temp= temp.next;
        }
        System.out.println("Node "+data+" has occurred "+ count+" times");
        //Node 6 has occurred 2 times
    }

    private int occurrenceInRecursiveMethod(Node head,int data,int count){
        if(head == null){
            return count;
        }
        if(head.data == data){
            count = count +1;
        }
        return occurrenceInRecursiveMethod(head.next, data, count);
    }


    private void printNodes(Node head){
        Node node = head;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        CountOccurrenceOfNodeInTheLinkedList linkedlist = new CountOccurrenceOfNodeInTheLinkedList();
        linkedlist.head = new Node(1);// HEAD
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(6);
        Node fifth = new Node(5);
        Node sixth = new Node(6);

        linkedlist.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = null ; // TAIL
        // pictorial representation
        // 1-->2-->3-->6-->5-->6-->null
        System.out.println("Nodes are");
        linkedlist.printNodes(linkedlist.head);// 1 2 3 6 5 6
        linkedlist.occurrenceOfNode(linkedlist.head, 6);
        int count = linkedlist.occurrenceInRecursiveMethod(linkedlist.head, 6, 0);
        System.out.println("Count is "+count);//Count is 2
    }
}
