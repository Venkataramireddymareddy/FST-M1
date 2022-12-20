package Package_Activities;

import java.util.HashSet;

        public class Activity10 {
            public static void main(String[] args) {
                HashSet<String> hs = new HashSet<String>();
                // Adding element to HashSet
                hs.add("A");
                hs.add("B");
                hs.add("C");
                hs.add("D");
                hs.add("E");
                hs.add("F");

                //Print HashSet
                System.out.println("Original HashSet: " + hs);
                //Print size of HashSet
                System.out.println("Size of HashSet: " + hs.size());

                //Remove element
                System.out.println("Removing A from HashSet: " + hs.remove("A"));
                //Remove element that is not present
                if(hs.remove("Z")) {
                    System.out.println("Z removed from the Set");
                } else {
                    System.out.println("Z is not present in the Set");
                }

                //Search for element
                System.out.println("Checking if C is present: " + hs.contains("C"));
                //Print updated HashSet
                System.out.println("Updated HashSet: " + hs);
            }
        }

