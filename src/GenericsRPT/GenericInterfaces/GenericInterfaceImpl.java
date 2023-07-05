package GenericsRPT.GenericInterfaces;

public class GenericInterfaceImpl<T> implements GenericInterface<T>{
    public static void main (String[] args) {
        GenericInterfaceImpl obj1 = new GenericInterfaceImpl();
        obj1.setValue("java");
        System.out.println(obj1.getValue());
        obj1.setValue(454654);
        System.out.println(obj1.getValue());


    }
    private T t;

    @Override
    public void setValue (T t) {
    this.t = t;
    }

    @Override
    public T getValue () {
        return this.t;
    }
}
