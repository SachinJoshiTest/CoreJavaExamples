package com.ksj.fourthclass;

import java.util.*;

public class CollectionsApiExamples {
    public static void main(String args[]) {

        //Vector
        Vector languages = new Vector(5, 3);
        languages.add("Java");
        languages.add("Python");
        languages.add("Javascript");
        languages.add("Kotlin");
        languages.add("C");
        languages.add("C++");
        languages.add("R");
        languages.add("Scala");
        languages.add(".Net");
        languages.add("php");
        languages.add("Golang");
        System.out.println("Languages : " + languages);

        languages.remove(5);
        languages.remove("Python");


        System.out.println("Languages After Delete : " + languages);

        System.out.println(languages.get(5));

        //List
        List<String> countries = new ArrayList<>();
        countries.add("India");
        countries.add("USA");
        countries.add("Russia");
        countries.add("China");

        countries.remove(2);


        //LinkedList
        List<String> a = new LinkedList<>();
        a.add("First");
        a.add(0, "Second");
        System.out.println("\nLinkedList: " + a);


        //Set
        Set<String> sportsmen = new HashSet<>();
        sportsmen.add("Roger Federer");
        sportsmen.add("Sachin Tendulkar");
        sportsmen.add("Roger Federer");
        sportsmen.add("Neeraj Chopra");

        System.out.println("Size of set is " + sportsmen.size());

        System.out.println("\nSportsmen are : " + sportsmen);

        sportsmen.remove("Sachin Tendulkar");
        System.out.println("Sportsmen after delete are : " + sportsmen);

        //HashMap
        Map<String, String> locationHotelMapping = new LinkedHashMap<>();
        locationHotelMapping.put("Mumbai", "Taj");
        locationHotelMapping.put("Jaipur", "Lalit");
        locationHotelMapping.put("Delhi", "ITC");
        locationHotelMapping.put("Mumbai", "Oberoi");

        locationHotelMapping.get("Mumbai");
        //Generate hashcode to find bucket
        //Using equals
        System.out.println("\nItinerary : " + locationHotelMapping);

        locationHotelMapping.remove("Mumbai");
        System.out.println("Itinerary After Remove : " + locationHotelMapping);

        Queue<String> customers = new PriorityQueue<>();
        customers.add("John");
        customers.add("smith");
        customers.add("Mark");

        String customer = customers.remove();
        System.out.println("\nServing Customer: " + customer + " In waiting List are: " + customers);


    }

}
