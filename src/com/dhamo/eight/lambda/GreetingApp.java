package com.dhamo.eight.lambda;

public class GreetingApp {
    public static void main(String[] args) {
        // OOPS style
        Greetings greetings = new EnglishGreetings();
        wish(greetings);
        greetings = new TamilGreetings();
        wish(greetings);

      //Anonymous clss
        wish(new Greetings(){
            @Override
            public void greet() {
                System.out.println("Anonymous English greetings");
            }
        });

        wish(new Greetings(){
            @Override
            public void greet() {
                System.out.println("Anonymous Tamil greetings");
            }
        });

        //using Lambda expressions
        wish(()-> System.out.println("English Greetings"));
        wish(()-> System.out.println("Tamil Greetings"));
    }

    public static void wish(Greetings greetings){
        greetings.greet();
    }
}
