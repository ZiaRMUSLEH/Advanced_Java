package Generics;

public class NonGenericsType {

    /*

            private Fileds

            Constructors

            Getter - Setter

            toString

     */

    private Object a;

    // Constructors
    public NonGenericsType(){       // Default

    }

    public NonGenericsType(Object a){       // Parameterized Constructor

    }

    // Getter - Setter
    public Object getA() {
        return a;
    }

    public void setA(Object a) {
        this.a = a;
    }


    public static void main(String[] args) {

        NonGenericsType obj1 = new NonGenericsType();
        NonGenericsType obj2 = new NonGenericsType();

        obj1.setA("Jace");
        obj2.setA(80);

        String str1 = (String) obj1.getA();
        System.out.println(str1);

        int num1 = (Integer) obj2.getA();
        System.out.println(num1);

        //String str2 = (String) obj2.getA(); // Throws Runtime Error

        // Int to String
        String intToStr = String.valueOf(55);
        System.out.println(intToStr);

        // Str to Int
        int strToInt = Integer.parseInt("80");
        System.out.println(strToInt);

    }
}