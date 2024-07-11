package javaGenerics.classes;

public class RunnerNonGeneric {
    public static void main(String[] args) {

        // 2 farklı obje olusturalım

        NonGenericsType obj1=new NonGenericsType();
        NonGenericsType obj2=new NonGenericsType();

        obj1.setField("Advanced JAva");// field degiskenini String ile set ettik
        obj2.setField(123);// int bir ifade ile set ettik.

        String string=(String) obj1.getField(); // CTE--> CAST problemi var
        System.out.println(string);

        String str=(String) obj2.getField();
        System.out.println(str);//ClassCastException







    }
}
