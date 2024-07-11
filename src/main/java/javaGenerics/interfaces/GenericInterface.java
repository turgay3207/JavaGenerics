package javaGenerics.interfaces;
//generic interface i implament eden class da generic olmalı
//interface kullanırken data tipine karar vermemiz gerekiyor.
public interface GenericınterfaceImp implements GenericInterface <T> {

    @Override
    public void print(T value){

    }
@Override
    public T find(){
        return null;
}


}
