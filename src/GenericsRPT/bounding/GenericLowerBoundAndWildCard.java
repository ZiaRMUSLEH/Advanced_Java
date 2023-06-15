package GenericsRPT.bounding;

import java.util.ArrayList;
import java.util.List;

public class GenericLowerBoundAndWildCard {

    public static void main (String[] args) {

        List<Object> objectList = new ArrayList<>();
        addElements(objectList);
        System.out.println(objectList);

        List<Number> numberList = new ArrayList<>();
        addElements(numberList);
        System.out.println(numberList);

        //List<Integer> integerList = new ArrayList<>();
        //addElements(integerList);
        //System.out.println(integerList);

        System.out.println("--------------------------------");

        List<String> stringList = new ArrayList<>();
        printElements(stringList);

        System.out.println("--------------------------------");

        //List<String > stringList1 = new ArrayList<>();
        //printObject(stringList1);

        List<Object > objList1 = new ArrayList<>();
        printObject(objList1);





    }

    public static void addElements (List<? super Double> list ){
        for(int i = 1; i<11; i++){
        list.add(Double.valueOf(i));
        }
    }

    public static void printElements (List<?> unknownList ){
        for(Object object: unknownList){
            System.out.println(object);

        }
    }

    public static void printObject (List<Object> objectList){
        objectList.add("Java");
        for(Object object: objectList ){
            System.out.println(objectList);
        }
    }

}
