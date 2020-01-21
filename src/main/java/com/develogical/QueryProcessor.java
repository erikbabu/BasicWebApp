package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                "English poet, playwright, and actor, widely regarded as the greatest " +
                "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.toLowerCase().contains("what is your team name")) {
            return "The LADS™️";
        }

        if (query.toLowerCase().contains("erik")) {
            return "Erik Babu (23 October 1996 - Present) is an awesome " +
                "DevOps engineer with a keen eye on how to deploy.";
        }

        if (query.toLowerCase().contains("plus")) {
            String[] words = query.split(" ");
            return String.valueOf(Integer.parseInt(words[2]) + Integer.parseInt(words[4]));
        }

        return "";
    }

}
