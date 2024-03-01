package com.dhamo.dsa;

public class QueueMainApp {

        public static void main(String[] args) {
            System.out.println("Queue Main App!");
            CustomQueue queue = new CustomQueue(5);
            queue.add(10);
            queue.add(20);
            queue.add(30);
            queue.add(40);
            queue.add(50);
            queue.add(60);

            queue.printQueue();
            queue.dequeue();
            queue.printQueue();

            queue.enqueue(70);
            queue.printQueue();


        }
}
