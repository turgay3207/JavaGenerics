package javaGenerics.bounding;

//Parametre olarak aldıgımız datqa tipini üstten sınırlandırabiliriz
//Bu sınıfta sadece Number class ının alt sınıfları kullanılsın.Integer, Double, Long, Float
public class GenericUpperBound<T extends Number> {

    private T[] nummberArrar;

    public GenericUpperBound(T[] nummberArrar) {
        this.nummberArrar = nummberArrar;
    }

    private double getAvarege() {

        double sum = 0;
        for (T t : nummberArrar) {
            sum += t.doubleValue();// t degerini doubke a dönusturur
        }
        double avarage = sum / this.nummberArrar.length;
        return avarage;
    }

    public static void main(String[] args) {

        Integer[] intArr={1,2,3};
        Double[] doubleArr={1.2,2.3,3.6};
        String [] stringArr={"genericleri","ustten","sınırlayabiliriz"};

        GenericUpperBound<Integer> obj1=new GenericUpperBound<>(intArr);
        System.out.println(obj1.getAvarege());

        GenericUpperBound<Double> obj2=new GenericUpperBound<>(doubleArr);

        System.out.println(obj2.getAvarege());

      //  GenericUpperBound<String> obj3=new GenericUpperBound<>(stringArr);
     // Generic data tiplerini üstten sınırlanırabiliriz,







    }
}
