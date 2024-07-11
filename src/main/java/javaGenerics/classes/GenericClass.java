package javaGenerics.classes;

//generic olarak PRIMITIVE data tipleri KULLANILAMAZ
public class GenericClass<T> {
/*
    En sık kullanılan parametre adları:
    E:Eleman        T:Tip      V:Değer(value)
    K:Anahtar(key)              N:Sayı(number)
*/
    private T field; // field ın referansı her data tiinde olabilir.
    //getter and setter

    public T getField() {
        return field;
    }

    public void setField(T field) {
        this.field = field;
    }
}
