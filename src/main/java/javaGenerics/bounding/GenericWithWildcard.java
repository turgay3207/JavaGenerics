package javaGenerics.bounding;

import javaGenerics.classes.GenericClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//wildcard(joker:?)  Bilinmeyen data tiplerini olustururken kullanırız.
public class GenericWithWildcard {

    public static void main(String[] args) {

        List<Object> listObject = new ArrayList<>();
        List<String> listString = new ArrayList<>();
        List<Number> listNumber = new ArrayList<>();
        List<Integer> listInteger = new ArrayList<>();
        List<Double> listDouble = new ArrayList<>();


        System.out.println("-------wildcard ile alttan sınırlama");
        addElements(listInteger);
        System.out.println(listInteger);
        addElements(listObject);
        System.out.println(listObject);
        addElements(listNumber);
        System.out.println(listNumber);
        // addElements(listString);//String Integerın parenttı degil
        //  addElements(listDouble);//Double Integerın parentı degil

        GenericClass<? super Double> object = new GenericClass<>();//double ve superlarını kullanabiliriz.

        object.setField(12.0);

        multiplByTwo(listDouble);
        multiplByTwo(listInteger);
        multiplByTwo(listNumber);
        //   multiplByTwo(listObject);
        //   multiplByTwo(listString);

        printElements(listDouble);
        printElements(listNumber);
        printElements(listInteger);
        printElements(listString);


    }
    //Integer veya integer ın parentralıryla olusturulan listeye 1 den 10 a kadar eleman ekleyen bir method
    //Integer,Number,Object
    //alttan sınırlama lowerbond

    public static void addElements(List<? super Integer> list) {

        for (int i = 1; i <= 10; i++) {

            list.add(i);
        }

    }

    //lower bound alttan sınırlama
    public static void multiplByTwo(List<? extends Number> list) {

        list.stream().map(t -> 2 * t.doubleValue()).forEach(t -> System.out.println("t = " + t));


    }

    public static void printElements(List<?> unknownlist) {
        //unknownlist.add("Java");
        //wildcard sebebiyle data türü net olmadıgı icin add gibi metodlara izin vermez

        unknownlist.add(null);// buna izin vermesinin sebebi bir data tipi belirtmemesinden kaynaklanıyor
        for (Object o : unknownlist) {
            System.out.println(o);
        }
        System.out.println(unknownlist.size());
//Data tipinden bagımsız metodlar kullanılabilir size, remove,clear gibi

    }
    //NOT:List<T> ile List<?> tamamen aynı degildir.

}
