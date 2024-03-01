package com.dhamo.eight.stream.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class WidgetApp {
    public static void main(String[] args) {

        final String RED = "RED";
        List<Widget> widgets = new ArrayList<>();
        widgets.add(new Widget("RED",10));
        widgets.add(new Widget("Greed",11));
        widgets.add(new Widget("RED",12));
        widgets.add(new Widget("Blue",15));

        //filter all RED widgets
        List<Widget> listWidgets = widgets.stream().filter(b-> b.getColour().equals(RED)).collect(Collectors.toList());
        listWidgets.forEach(l -> System.out.println("Colour: "+l.getColour()+" Weight: "+l.getWeight()));

        // sum weight of all RED widgets
        var sum = widgets.stream().filter(b -> b.getColour().equals(RED)).collect(Collectors.summingInt(Widget::getWeight));
        System.out.println("sum of red widgets:"+sum);

        //filter-map-reduce
        var reduceSum = widgets.stream().filter(b -> b.getColour().equals(RED)).map(e -> e.getWeight()).reduce(0, (a, b) -> a + b);
        System.out.println("sum using reduce method: "+ reduceSum);

        // map to intstream and sum
        var sumIntStream1 = widgets.stream().filter(b -> b.getColour().equals(RED)).mapToInt(Widget::getWeight).sum(); // using method reference
        // var sumIntStream = widgets.stream().filter(b -> b.getColour().equals(RED)).mapToInt(e -> e.getWeight()).sum();
        System.out.println("sum using Int stream: "+sumIntStream1);

        //sum using summarizing int
        var sumSummarizingInt = widgets.stream().filter(b -> b.getColour().equals(RED)).collect(Collectors.summarizingInt(e -> e.getWeight()));
        System.out.println("sum using summarizing int:"+ sumSummarizingInt);

        //filter map tolist
        var integerList = widgets.stream().filter(b -> b.getColour().equals(RED)).map(e -> e.getWeight()).toList();
        System.out.println(integerList);

        Object []integerList1 = widgets.stream().filter(b -> b.getColour().equals(RED)).map(e -> e.getWeight()).toArray();
        System.out.println(integerList1);

    }
}
