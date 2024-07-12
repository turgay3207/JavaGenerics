package javaGenerics.interfaces.example;

public interface Repository<T> {

    void save(T object);

    T find();


}
