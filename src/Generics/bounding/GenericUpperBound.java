package Generics.bounding;

// Bounding from the Top

// Just using Integer, Double, etc. etc.
public class GenericUpperBound <T extends Number>{

    private T[] numberArray;

    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }

    // Method, which finds the average value of an array
    public double findAverage(){
        double sum = 0;
        for (T t : numberArray){
            sum += t.doubleValue();
        }

        double avg = sum/numberArray.length;
        return avg;


    }

    public static void main(String[] args) {

        Integer[] intArr = {1,2,3,4,5};
        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>(intArr);
        System.out.println(obj1.findAverage());

        Double[] doubleArr = {2.5, 4.1, 5.5, 1.2};
        GenericUpperBound<Double> obj2 = new GenericUpperBound<>(doubleArr);
        System.out.println(obj2.findAverage());

        String[] strArr = {"A","B","C","D"};
        //GenericUpperBound<String> obj3 = new GenericUpperBound<String>(strArr);

    }

}
