package GenericsRPT.classes;

public class GenericsRunner {
    public static void main (String[] args) {

        GenericClass<String> obj1 = new GenericClass<>();
        obj1.setT("Hello");
        String str = obj1.getT();

        GenericClass<Integer> obj2 = new GenericClass<>();
        obj2.setT(1234);
        int num = obj2.getT();

        GenericClass<Double> obj3 = new GenericClass<>();
        obj3.setT(23.4);
        double d = obj3.getT();


        GenericTypeTwoParams <String, Integer> obj4 = new GenericTypeTwoParams<>("Java",3);
        GenericTypeTwoParams<Integer, String> obj5 = new GenericTypeTwoParams<>(34, "Generics");
        System.out.println(obj4.getS() + " " + obj5.getU());



    }
}
