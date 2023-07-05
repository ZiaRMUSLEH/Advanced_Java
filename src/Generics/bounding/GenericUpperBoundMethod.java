package Generics.bounding;

public class GenericUpperBoundMethod <T>{

public <T extends Comparable<T>> T findMax(T[] arr){
    T max = arr[0];
    for (int i = 1; i <arr.length ; i++) {
        if(arr[i].compareTo(max)>0){
            max = arr[i];
        }
    }
   return max;
}

    public static void main (String[] args) {

    Integer[] intArr={4,8,9,3,6,4,5,2,9};

    GenericUpperBoundMethod obj = new GenericUpperBoundMethod();
        System.out.println(obj.findMax(intArr));


    }


}
