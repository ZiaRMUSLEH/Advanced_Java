package Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericsType <T>{

        /*

            E   --> Element, used in collection structures, etc.
            K   --> Key
            V   --> Value
            N   --> Number, numeric values
            T   --> Type, general use

            FOR MORE:
                S,U,V   etc.    --> FOR 2nd, 3rd, 4th..

     */

    private T type;

    public GenericsType () {
    }

    public GenericsType (T type) {
        this.type = type;
    }

    public T getType () {
        return type;
    }

    public void setType (T type) {
        this.type = type;
    }

    @Override
    public String toString () {
        return "GenericsType{" +
                "type=" + type +
                '}';
    }

    public static void main (String[] args) {

        // TASK: Create two objects with different types by using GenericType class.
        GenericsType<String> obj1 = new GenericsType<>();
        GenericsType<Integer> obj2 = new GenericsType<>();

        // QUICK TIP: We cannot use primitive data type inside the diamonds. (Cannot use int, use Integer instead)
        //GenericsType<int> test = new GenericsType<int>();

        obj1.setType("Generics");
        //obj2.setType(80);

        // Question: How to get rid of the Cast problem?
        GenericsType<Integer> obj3 = new GenericsType<>();
        obj3.setType(80);

        int a = obj3.getType();
        System.out.println(a);

        // Question: How to get rid of ClassCastException?
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        //list.add(80);


        // Example:
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "A");
        //map.put("B", 10);


    }
}

class GenericTypeWithParams<S, U>{

    private S s;
    private U u;

    public S getS () {
        return s;
    }

    public void setS (S s) {
        this.s = s;
    }

    public U getU () {
        return u;
    }

    public void setU (U u) {
        this.u = u;
    }

    public GenericTypeWithParams (S s, U u) {
        this.s = s;
        this.u = u;
    }

    public GenericTypeWithParams () {
    }

    @Override
    public String toString () {
        return "GenericTypeWithParams{" +
                "s=" + s +
                ", u=" + u +
                '}';
    }

    public static void main (String[] args) {

        GenericTypeWithParams<String, Integer> obj1 = new GenericTypeWithParams<>("Java", 10);
        GenericTypeWithParams<Integer, String> obj2 = new GenericTypeWithParams<>(1, "Spring");

        System.out.println(obj1.getS());
        System.out.println(obj1.getU());



    }
}
