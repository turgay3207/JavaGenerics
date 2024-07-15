package threads;

public class SynchronizedKeyword {
    public static void main(String[] args) {

        Brackets brackets=new Brackets();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=9;i++){
                    brackets.generateBrackets();
                }
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=9;i++){
                    brackets.generateBrackets();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}

//Her iki thread de aynı obje ile aynı metoda erismeye calıstıgı icin istedigimiz göruntu olusmadı bu sebeple metoda erisen objenin metoda erisimi senkron haline getirdik
class Brackets{
    public synchronized void generateBrackets(){
        for (int i=1;i<=10;i++){
            if (i<=5){
                System.out.print("[");
            }else {
                System.out.print("]");
            }
        }
        System.out.println();
    }
}