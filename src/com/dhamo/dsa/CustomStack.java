package com.dhamo.dsa;

import java.util.Arrays;

public class CustomStack {

    int top;
    int []stack;
    int size;
    CustomStack(int size){
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size-1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("Stack is full");
        }else{
            stack[++top] = value;
        }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
          //  int currentSize = top;
           // int value = stack[top--];
           // stack = Arrays.copyOfRange(stack,0,currentSize);;
            return stack[top--];
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
            return stack[top];
        }
    }

    public void printStack(){
        System.out.println("Stack Values");
       // Arrays.stream(stack).limit(top+1).forEach(e -> System.out.print(e+" "));
        Arrays.stream(stack,0,top+1).forEach(e -> System.out.print(e+" "));
        System.out.println();
    }


}
