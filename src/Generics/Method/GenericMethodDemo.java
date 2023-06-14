package Generics.Method;

public class GenericMethodDemo {
    public static   void main (String[] args) {

        GenericMethodDemo obj1 = new GenericMethodDemo();

        Integer[] arr = {1,2,3,4,5,10,25};
        obj1.print(arr);

        Integer[] dArr = {1,2,3,4,5,10,25};
        obj1.print(dArr);

        String [] strArr = {"A", "B", "C", "D"};

        obj1.print(strArr);


    }
    public void print(Integer[] arr){
        //***
    }

    public void print(Double[] arr){
        //***
    }

    public  <T> void print (T[] array){
        for(T t:array){
            System.out.println(t+" ");
        }
    }
}


