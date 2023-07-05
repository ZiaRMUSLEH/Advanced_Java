package GenericsRPT.classes;

public class NoneGenericClass {

    private Object obj;

    public Object getObj () {
        return obj;
    }

    public void setObj (Object obj) {
        this.obj = obj;
    }

    public static void main (String[] args) {

        NoneGenericClass obj1 = new NoneGenericClass();
        NoneGenericClass obj2 = new NoneGenericClass();

        obj1.setObj("Hello");
        obj2.setObj(1234);

        String str = (String) obj1.getObj();
        int num = (int) obj2.getObj();

    }
}
