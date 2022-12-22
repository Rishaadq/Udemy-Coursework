package com.in28minutes.rest.webservices.restfulwebservices.functionalprogramming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {

        printAllNumbersInListFunctional(List.of(12,9,13,4,5,2,4,12,15));

        printEvenNumbersInListFunctional(List.of(12,9,13,4,5,2,4,12,15));

        printSquaredEvenNumbersInListFunctional(List.of(12,9,13,4,5,2,4,12,15));

        printOddNumbersInListFunctional(List.of(12,9,13,4,5,2,4,12,15));

        printIndividualCourses(List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes"));

        printCoursesContainingSpring(List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes"));

        printCoursesWithMoreThanFourLetters(List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes"));

    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {

        System.out.println("PRINTING ALL NUMBERS \n" );
        numbers.forEach(System.out::println); //method reference
        System.out.println();

    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {

        System.out.println("PRINTING EVEN NUMBERS \n");
        numbers.stream().filter(number -> number % 2 == 0).forEach(System.out::println); //method reference
        System.out.println();

    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {

        System.out.println("PRINTING ODD NUMBERS \n");
        numbers.stream().filter(number -> number % 2 == 1).forEach(System.out::println); //method reference
        System.out.println();

    }

    private static void printIndividualCourses(List<String> courses) {

        System.out.println("PRINTING INDIVIDUAL COURSES \n");
        courses.forEach(System.out::println);
        System.out.println();
    }

    private static void printCoursesContainingSpring(List<String> courses) {

        System.out.println("PRINTING COURSES CONTAINING SPRING \n");
        courses.stream().filter(course -> course.equals("Spring")).forEach(System.out::println);
        System.out.println();
    }

    private static void printCoursesWithMoreThanFourLetters(List<String> courses) {

        System.out.println("PRINTING COURSES WITH MORE THAN FOUR LETTERS \n");
        courses.stream().filter(course -> course.length() >= 4).forEach(System.out::println);
        System.out.println();
    }

    private static void printSquaredEvenNumbersInListFunctional(List<Integer> numbers) {
        System.out.println("PRINTING EVEN NUMBERS SQUARED \n");
        numbers.stream().filter(number -> number % 2 == 0).map(number -> (int)Math.pow(number, 2)).forEach(System.out::println); //method reference
        System.out.println();
    }



}
