package com.chinmaybiswaltech.linkedlist;

public class FindElementInTheLinkedList {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private void findElementInIterativeMethod(Node head, int element){
        if(head ==null){
            System.out.println("Linked list is empty");
            return;
        }
        Node currentNode = head;
        while( currentNode != null && currentNode.data != element){
            currentNode = currentNode.next;
        }
        if(currentNode != null){
            System.out.println("Element found in the Linked List");
        }else{
            System.out.println("Element not found in the Linked List");
        }
    }

    private boolean findElementInRecursiveMethod(Node head, int element){

        if(head == null){
            return false;
        }
        if(head.data == element){
            return true;
        }
        return findElementInRecursiveMethod(head.next,element);
    }

    private void printNodes(Node head){
        Node node = head;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        FindElementInTheLinkedList linkedlist = new FindElementInTheLinkedList();
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
        //boolean isElementPresent = linkedlist.findElementInRecursiveMethod(linkedlist.head,4);
        //Output : Found the element in the Linked List
       boolean isElementPresent = linkedlist.findElementInRecursiveMethod(linkedlist.head,5);
        //Output : Not Found the element in the Linked List
        if (isElementPresent){
            System.out.println("Found the element in the Linked List");
        }else {
            System.out.println("Not Found the element in the Linked List");
        }
        linkedlist.findElementInIterativeMethod(linkedlist.head, 4);
        //Output : Element found in the Linked List
        linkedlist.findElementInIterativeMethod(linkedlist.head, 5);
        //Output : Element not found in the Linked List
    }
}
