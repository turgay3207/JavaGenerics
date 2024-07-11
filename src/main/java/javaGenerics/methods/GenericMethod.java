package javaGenerics.methods;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {

        Integer[] intArr={2,3,8,99,55};
        Double[]  doubleArr={1.3,2.6,6.99,8.5};
        String[] stringArr={"Java","generics","hayatımızı","kolaylastırır"};

        printArr(intArr);
        printArr(doubleArr);
        printArr(stringArr);
        System.out.println("-----------generic methodlar--------------");
        printArray(doubleArr);
        printArray(intArr);
        printArray(stringArr);
        System.out.println("-----------sonuc döndüren generic methodlar--------------");
        System.out.println(getFirst(intArr));
        System.out.println(getFirst(doubleArr));
        System.out.println(getFirst(stringArr));
        System.out.println("----------iki parametreli generic method");
        printArrayAndObject(intArr,"object");
        printArrayAndObject(intArr,12);

    }
    //arraylari yazdırmak icin bir method
    public static void printArr(Integer[] arr){
        Arrays.stream(arr).forEach(t->System.out.print(t+" "));
        System.out.println();

    }
    public static void printArr(Double[] arr){
        Arrays.stream(arr).forEach(t->System.out.print(t+" "));
        System.out.println();

    }
    public static void printArr(String [] arr){
        Arrays.stream(arr).forEach(t->System.out.print(t+" "));
        System.out.println();

    }
    //generic method
    public static <T> void printArray(T[] arr){
        Arrays.stream(arr).forEach(t->System.out.print(t+" "));
        System.out.println();

    }

    // geriye sonuc döndüren bir method var ise generic olarak nasıl tanımlarız
    public static <T> T getFirst(T[] arr){
        T first=arr[0];
        return first;
    }
    // birden fazla parametreli generic method
    public static <T,U> void printArrayAndObject(T[] array, U object){

        Arrays.stream(array).forEach(t-> System.out.print(t+" "));
        System.out.print("-------------"+object);



    }
}
