package com.chinmaybiswaltech.linkedlist;

import java.util.Stack;

public class CheckPalindromeLinkedList {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private void checkIfLinkedListIsPalindrome(Node head){
        Stack<Node> stack = new Stack<>();
        Node temp =head;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
      int flag =0;
        while(head != null){
          Node node = stack.pop();
          if(node.data != head.data){
              flag =1;
              break;
          }
           head = head.next;
        }
        if (flag==1){
            System.out.println("Not palindrome");
            //Palindrome
        }else{
            System.out.println("Palindrome");
        }
    }


    private void printNodes(Node head){
        Node node = head;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        CheckPalindromeLinkedList linkedlist = new CheckPalindromeLinkedList();
        linkedlist.head = new Node(1);// HEAD
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(2);
        Node fifth = new Node(1);

        linkedlist.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        // pictorial representation
        // 1-->2-->3-->2-->1-->null
        System.out.println("Nodes are");
        linkedlist.printNodes(linkedlist.head);// 1 2 3 2 1
        linkedlist.checkIfLinkedListIsPalindrome(linkedlist.head);
    }
}
