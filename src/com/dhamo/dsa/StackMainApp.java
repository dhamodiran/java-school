package com.dhamo.dsa;

public class StackMainApp {

    public static void main(String[] args) {
        System.out.println("Stack Main App!");
        CustomStack stack = new CustomStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        System.out.println("Peek: "+ stack.peek());
        stack.printStack();
        System.out.println("Pop: "+stack.pop());
        stack.printStack();
        System.out.println("Pop: "+stack.pop());
        stack.printStack();
    }
}