package javaGenerics.classes;

public class GenericClassTwoParam<S,U> {

    private S field;
    private U value;

    public GenericClassTwoParam(S s, U v) {

    }

    //getter-setter
    public S getField() {
        return field;
    }

    public void setField(S field) {
        this.field = field;
    }

    public U getValue() {
        return value;
    }

    public void setValue(U value) {
        this.value = value;
    }
}
