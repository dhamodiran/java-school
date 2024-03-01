package com.dhamo.dsa.linkedlist;

import org.w3c.dom.Node;
import org.w3c.dom.Node;

public class SinglyLinkedList {

    class Node {

        int data;
        Node next;

    }

    Node headNode;
    int size;

    SinglyLinkedList(){
        headNode = null;
        size = 0;
    }

    public void insertAtHead(int data){
       Node newNode = new Node();
       newNode.data = data;
       newNode.next = headNode;
       headNode = newNode;
       size++;
    }

    public void insertAtEnd(int data){

        if(isEmpty()){
            insertAtHead(data);
            return;
        }
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        Node last = headNode;
        while (last.next != null){
            last = last.next;
        }
        last.next = newNode;
        size++;
    }

    public void insertAfter(int data, int after){

        Node currentNode = headNode;
        while(currentNode != null && currentNode.data != after){
            currentNode = currentNode.next;
        }
        if(currentNode != null){
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }else{
            System.out.println(after + " data is not found");
        }


    }

    public boolean deleteAtHead(){
        if(isEmpty()){
            System.out.println("Delete : List is empty");
            return false;
        }
        Node tempNode = headNode;
        if(tempNode != null){
            headNode = tempNode.next;
            tempNode.next = null;
        }
        return true;
     }

     public boolean deleteAtEnd(){
         if(isEmpty()){
             System.out.println("Delete at end : List is empty");
             return false;
         }
         Node currentNode = headNode;
         while(currentNode !=null){
             //currentNode
         }
        return true;
     }

    public void printList(){
        if(isEmpty()){
            System.out.println("Print : List is empty");
        }
        Node temp = headNode;
        while(temp != null){
            System.out.print("->"+ temp.data);
            temp = temp.next;
        }
        System.out.println(" ");
    }

    public Boolean isEmpty(){
        if(headNode == null){
            return true;
        }
        return false;
    }
}
