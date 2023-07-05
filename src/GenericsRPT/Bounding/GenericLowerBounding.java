package GenericsRPT.Bounding;

import java.util.ArrayList;
import java.util.List;

public class GenericLowerBounding {
    public static void main (String[] args) {

        List<Integer> integerList = new ArrayList<>();
        addElements(integerList);
        System.out.println("integerList = " + integerList);
        System.out.println("--------************--------------");

        List<Number> numberList = new ArrayList<>();
        addElements(numberList);
        System.out.println("numberList = " + numberList);
        System.out.println("--------************--------------");

        List<Object> objectList = new ArrayList<>();
        addElements(objectList);
        System.out.println("objectList = " + objectList);
        System.out.println("--------************--------------");
        multiplyBy2(integerList);

        System.out.println("--------************--------------");
        multiplyBy2(numberList);

        System.out.println("--------************--------------");
        //multiplyBy2(objectList);
        List <Double> doubleList = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            doubleList.add(Double.valueOf(i));
        }
        System.out.println("--------************--------------");
        System.out.println("doubleList = " + doubleList);
         multiplyBy2(doubleList);
        System.out.println("--------************--------------");
        printElements(objectList);
        System.out.println("--------************--------------");
        printElements(numberList);
        System.out.println("--------************--------------");
        printElements(doubleList);
        System.out.println("--------************--------------");
        printElements(integerList);
        System.out.println("--------************--------------");

    }

    public static void addElements(List<? super Integer> list){
        for (int i = 1; i < 11; i++) {
            list.add(i);
        }
    }


    public static void multiplyBy2(List<? extends Number> list){
        list.stream().map(t->2*t.intValue()).forEach(t-> System.out.println(t+" "));
        }

        public static void printElements (List<?> unknownList){
            unknownList.forEach(System.out::println);
        }



    }

