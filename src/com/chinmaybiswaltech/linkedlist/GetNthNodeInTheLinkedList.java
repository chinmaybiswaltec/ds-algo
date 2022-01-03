package com.chinmaybiswaltech.linkedlist;

public class GetNthNodeInTheLinkedList {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
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


    private int findNthElementInRecursiveMethod(Node head, int position, int currentPosition){
      if(head == null) {
          return 0;
      }
      if(currentPosition == position){
          return head.data;
      }
        currentPosition =currentPosition+1;
     return findNthElementInRecursiveMethod(head.next,position,currentPosition);
    }

    private void printNodes(Node head){
        Node node = head;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        GetNthNodeInTheLinkedList linkedlist = new GetNthNodeInTheLinkedList();
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
        int nthElement = linkedlist.findNthElementInIterativeMethod(linkedlist.head,4);
        System.out.println("4th element in the linked list is "+nthElement);
        //4th element in the linked list is 4
        int nthRecurElement = linkedlist.findNthElementInRecursiveMethod(linkedlist.head,2, 1);
        System.out.println("2nd element in the linked list is "+nthRecurElement);
        //2nd element in the linked list is 2
        int nthRecurElement2 = linkedlist.findNthElementInRecursiveMethod(linkedlist.head,6, 1);
       if(nthRecurElement2 ==0){
           System.out.println("6th element is not in  the linked list");
       }
    }
}
