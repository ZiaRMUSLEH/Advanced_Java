package GenericsRPT.method;

import java.util.Arrays;

public class GenericMethodDemo {
    public static void main (String[] args) {

        Integer[] intArr = {4,5,8,3};

        Double[] dblArr = {4.5,7.8,2.1,3.9};

        String[] strArr = {"java ","is ","easy ","to ","develop"};

        arrayPrinter(intArr);
        System.out.println("---------------------");
        arrayPrinter(dblArr);
        System.out.println("---------------------");
        arrayPrinter(strArr);
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println(getFirstElement(intArr));
        System.out.println("---------------------");
        System.out.println(getFirstElement(dblArr));
        System.out.println("---------------------");
        System.out.println(getFirstElement(strArr));
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("---------------------");
        printArrayAnObj(intArr,"Generics");
        printArrayAnObj(dblArr,45878);
        printArrayAnObj(strArr,45.89);


    }

    public static <T> void arrayPrinter(T[] arr){

        Arrays.stream(arr).forEach(System.out::println);

        System.out.println(Arrays.toString(arr));



    }

    public static <T> T getFirstElement(T[] arr){

        return arr[0];
    }

    public static <S,U> void printArrayAnObj(S[] arr , U obj){
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println();
        System.out.println(obj);

    }



}
