package Generics.bounding;

import java.util.ArrayList;
import java.util.List;

public class GenericLowerBoundAndWildCard {

    public static void main (String[] args) {

        List<Object> objList = new ArrayList<>();
        addElements(objList);
        System.out.println(objList);

        List<Number> numList = new ArrayList<>();
        addElements(numList);
        System.out.println(numList);

        List<Integer> intList = new ArrayList<>();
        addElements(intList);
        System.out.println(intList);

        List<Double> dList = new ArrayList<>();
        //addElements(dList);

        System.out.println("----------------------------");

        List<String> strList = new ArrayList<>();
        printElement(strList);

        System.out.println("----------------------------");
        List<String> strList1 = new ArrayList<>();
        //printObj(strList); // if we use Object data type in method cant use the method for other data types


        List<Object> objectList = new ArrayList<>();
        printObj(objectList);



    }

    public static void addElements(List<? super Integer> list){
        // ?: --> WildCard (Unknown Type)
        // super Integer  --> Give me the parents of Integer.

        for(int i = 1; i<11; i++){
            list.add(i);
        } }

        //WildCard Disadvantages
        public static void printElement (List<?> listOfUnknown){
        //if we don't mention any data type with wildcards, "adding" won't work on it's own.
        //listOfUnknown.add("java");

            //if data type is unknown we have to use Object
            for (Object object: listOfUnknown){
                System.out.println(object);
            }
        }

        public static void printObj(List<Object> objectList){
        objectList.add("Java");
        for(Object object: objectList){
            System.out.println(object);
        }
        }

        /*

        extends --> Defining a parent
        super   --> Referring to the parent

         */



}
