package Generics.InterfaceType;

public class GenericClassStringImpl implements GenericInterface<String>{

    // 2nd: If you don't want to make your class generic, but still use a Generic Interface, specifying the Data type for the interface is needed.

    @Override
    public void setValue(String value) {

    }

    @Override
    public String getValue() {
        return null;
    }
}