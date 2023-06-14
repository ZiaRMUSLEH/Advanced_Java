package Generics.InterfaceType;


public class GenericClassImpl<T> implements GenericInterface<T>{

        // 1st: If a generic interface implemented, the class needed to be generic too.

        @Override
        public void setValue(T value) {

        }

        @Override
        public T getValue() {
            return null;
        }
    }

