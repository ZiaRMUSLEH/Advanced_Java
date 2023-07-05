package GenericsRPT.Bounding;

public class GenericUpperBound<T extends Number> {

    private T[] numberArr;

    public GenericUpperBound (T[] numberArr) {
        this.numberArr = numberArr;
    }
    public double getAvg(){
        double sum = 0;
        for(T w:numberArr){
            sum+=w.doubleValue();
        }
        return sum/numberArr.length;
    }

    public static void main (String[] args) {

        Integer[] intArr = {1,2,3,4,5,6};

        GenericUpperBound obj1 = new GenericUpperBound(intArr);
        System.out.println(obj1.getAvg());

        Double[]dblArr = {4.8,8.6,2.3};

        GenericUpperBound obj2 = new GenericUpperBound(dblArr);
        System.out.println(obj2.getAvg());

        String [] strArr = {"sdf","sdafa","asfs"};
        //GenericUpperBound obj3 = new GenericUpperBound(strArr);
        //System.out.println(obj3.getAvg());


    }

}
