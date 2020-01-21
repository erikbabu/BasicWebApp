package com.develogical;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class QueryProcessor {

    private static final Map<String, String> word_assoc= new HashMap<>();

    static {
        word_assoc.put("eiffel tower", "Paris");
        word_assoc.put("banana", "yellow");
        word_assoc.put("james bond", "Sean Connery");
        word_assoc.put("theresa may", "2016");
    }

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                "English poet, playwright, and actor, widely regarded as the greatest " +
                "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.toLowerCase().contains("what is your team name")) {
            return "The LADS️";
        }

        if (query.toLowerCase().contains("erik")) {
            return "Erik Babu (23 October 1996 - Present) is an awesome " +
                "DevOps engineer with a keen eye on how to deploy.";
        }

        if (query.toLowerCase().contains("plus")) {
            String[] words = query.split(" ");
            return String.valueOf(Integer.parseInt(words[2]) + Integer.parseInt(words[4]));
        }

        if (query.toLowerCase().contains("multiplied")) {
            String[] words = query.split(" ");
            return String.valueOf(Integer.parseInt(words[2]) * Integer.parseInt(words[5]));
        }


        if (query.toLowerCase().contains("numbers is the largest")) {
            String queryLower = query.toLowerCase();
            String numbers = queryLower.substring(query.lastIndexOf(':') + 1);
            Integer maximum = Arrays.asList(numbers.split(","))
                                    .stream()
                                    .map(String::trim)
                                    .mapToInt(Integer::parseInt)
                                    .max()
                                    .getAsInt();
            return maximum.toString();
        }


        if (query.toLowerCase().contains("both a square and a cube")) {
            String queryLower = query.toLowerCase();
            String numbers = queryLower.substring(query.lastIndexOf(':') + 1);
            int[] maximum = Arrays.asList(numbers.split(","))
                .stream()
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .filter(this::isSquareAndCube)
                .toArray();

            return Arrays.toString(maximum);
        }

        if (query.toLowerCase().contains("are prime")) {
            String queryLower = query.toLowerCase();
            String numbers = queryLower.substring(query.lastIndexOf(':') + 1);
            int[] primes = Arrays.stream(numbers.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .filter(this::isPrime)
                .toArray();

            return Arrays.toString(primes);
        }

        for (String key:
             word_assoc.keySet()) {
            if (query.toLowerCase().contains(key)) {
                return word_assoc.get(key);
            }
        }

        return "";
    }

    public boolean isSquareAndCube(int x) {
        int cubeRoot = (int) Math.round(Math.pow(x, 1.0/3.0));
        boolean isCube = x == (cubeRoot * cubeRoot * cubeRoot);

        int squareRoot = (int) Math.round(Math.pow(x, 1.0/2.0));
        boolean isSquare = x == (squareRoot * squareRoot);

        return isCube && isSquare;
    }

    public boolean isPrime(int x) {
        for (int divisor = 2; divisor <= x / 2; divisor++) {
            if (x % divisor == 0) {
                return false;
            }
        }

        return true;
    }

}
