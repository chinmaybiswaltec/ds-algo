package com.chinmaybiswaltech.linkedlist;

public class LinkedListDriver {
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node addFirst(int  data,Node head){
        if (head==null){
            head = new Node(data);
            return head;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    private Node addLast(int data, Node head){
        if (head==null){
            head = new Node(data);
            return head;
        }
        Node endNode = findEndNode(head);
        Node newNode = new Node(data);
        endNode.next = newNode;
        return head;
    }
    private Node findEndNode(Node head){
        Node currentNode = head;
        Node previousNode = head;
        while(currentNode != null){
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return previousNode;
    }
    private Node addNodeAt(int data, Node head, int after){
        if (head==null){
            head = new Node(data);
            return head;
        }
        Node destNode = findNodeAfter(head, after);
        // Finds the node after which new node should be added
        Node currentNodeAfterDest = destNode.next;
        //Getting the reference to the node after the destination node
        Node newNode = new Node(data);
        destNode.next = newNode;
        // adding the new node after destination node
        newNode.next = currentNodeAfterDest;
        //pointing newly added node to the node after the destination node
        return head;
    }
    private Node findNodeAfter(Node head, int after){
        Node currentNode = head;
        while(currentNode.data != after){
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    private void printNodes(Node head){
        Node node = head;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedListDriver linkedlist = new LinkedListDriver();
        linkedlist.head = new Node(1);// HEAD
        Node second = new Node(2);
        Node third = new Node(3);

        linkedlist.head.next = second;
        second.next = third;
        third.next = null; // TAIL
        // pictorial representation
        // 1-->2-->3-->null
        System.out.println("Nodes before adding at first");
        linkedlist.printNodes(linkedlist.head);// 1 2 3
        //adding Node at the start
        Node newHead = linkedlist.addFirst(4, linkedlist.head);
        System.out.println("Nodes After adding at first"); //4 1 2 3
        linkedlist.printNodes(newHead);

        //adding Node at the end
        Node newHead2 = linkedlist.addLast(5, newHead);
        System.out.println("Nodes After adding at last");
        linkedlist.printNodes(newHead2); //4 1 2 3 5

        //adding Node after 2
        Node newHead3 = linkedlist.addNodeAt(6, newHead2, 2);
        System.out.println("Nodes After adding after 2");
        linkedlist.printNodes(newHead3); //4 1 2 6 3 5
    }
}
