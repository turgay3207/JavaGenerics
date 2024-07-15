package threads;

public class MultiThreading02 {

    public static int counter=0;
    public static void main(String[] args) {

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                Counter01.count();
                //ortak kaynagı kullanmayan baska görevler

            }
        });
        thread1.setName("Tom");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                Counter01.count();
                //ortak kaynagı kullanmayan baska görevler
            }
        });
        thread2.setName("Jerry");
        thread2.start();

    }
}

class Counter01{

    public synchronized static void count(){//synchronized ile threadlerin metoda erismesini sıraya koymus olduk.
        //Metod icine sadece 1 thread girebilsin

        for (int i=1;i<=1000;i++){

            MultiThreading02.counter++;//1000
            System.out.println(Thread.currentThread().getName()+"counter  : "+MultiThreading02.counter);
        }

    }

}