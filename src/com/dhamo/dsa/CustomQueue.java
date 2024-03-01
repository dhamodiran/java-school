package com.dhamo.dsa;

import java.security.PublicKey;
import java.util.Arrays;

public class CustomQueue {

    int front;
    int rear;
    int []queue;
    int size;
    CustomQueue(int size){
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public boolean isFull(){
        return rear == size-1;
    }

    public void add(int value){
        if(isFull()){
            System.out.println("Queue is full");
        }else{
            queue[++rear] = value;
            if(front == -1){
                front = 0;
            }
        }
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }else{
            int value = queue[front];
            if(front == rear){
                front = -1;
                rear = -1;
            }else{
                front++;
            }
            return value;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }else{
            return queue[front];
        }
    }

    public void printQueue(){
        System.out.println("Queue Values");
       /* for(int i=front;i<=rear;i++){
            System.out.print(queue[i]+" ");
        }*/

        Arrays.stream(queue,front,rear+1).forEach(e -> System.out.print(e+" "));
        System.out.println();

    }

    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is full");
        }else{
            queue[++rear] = value;
            if(front == -1){
                front = 0;
            }
        }
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }else{
            int value = queue[front];
            if(front == rear){
                front = -1;
                rear = -1;
            }else{
                front++;
            }
            return value;
        }
    }

}
