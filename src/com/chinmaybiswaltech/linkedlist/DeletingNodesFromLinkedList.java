package com.chinmaybiswaltech.linkedlist;

public class DeletingNodesFromLinkedList {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node deleteNode(Node head, int dataOnNodeToBeDeleted){
        Node previousNode = getPreviousNodeOfNodeToBeDeleted(head, dataOnNodeToBeDeleted);
        Node nodeToBeDeleted = previousNode.next;

        //If node to be deleted is HEAD itself. Then make the next node of HEAD node as HEAD
        if (head.data == dataOnNodeToBeDeleted){
            head = head.next;
            return head;
        }
        // If the Node to be deleted is last Node
        if (nodeToBeDeleted.next == null){
            previousNode.next =null;
            nodeToBeDeleted =null;
            return head;
        }
        // Deleting a node in between two node. Point the previous node of the node to be deleted to
        // Node after the node to be deleted. And free the memory of node to be deleted.
        previousNode.next = nodeToBeDeleted.next;
        nodeToBeDeleted =null;
        return head;

    }

    private Node getPreviousNodeOfNodeToBeDeleted(Node head, int dataOnNodeToBeDeleted){
        Node currentNode = head;
        Node previousNode = head;
        while(currentNode.data != dataOnNodeToBeDeleted){
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return previousNode;
    }


    private void printNodes(Node head){
        Node node = head;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DeletingNodesFromLinkedList linkedlist = new DeletingNodesFromLinkedList();
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
        System.out.println("Nodes before deleting");
        linkedlist.printNodes(linkedlist.head);// 1 2 3 4
        linkedlist.deleteNode(linkedlist.head, 3);
        System.out.println("Nodes after deleting");
        linkedlist.printNodes(linkedlist.head);// 1 2 4
        //Delete the last Node
        linkedlist.deleteNode(linkedlist.head, 4);
        System.out.println("Nodes after deleting last node");
        linkedlist.printNodes(linkedlist.head);// 1 2
        //Delete the HEAD Node
        Node newHead = linkedlist.deleteNode(linkedlist.head, 1);
        System.out.println("Nodes after deleting HEAD node");
        linkedlist.printNodes(newHead);//  2
    }
}
