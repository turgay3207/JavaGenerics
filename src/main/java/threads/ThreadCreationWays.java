package threads;

public class ThreadCreationWays {
    public static void main(String[] args) {

        //Her java uygulaması en az bir thread kullanır:main thread
        System.out.println("Mevcut thread:  "+Thread.currentThread().getName());

        MyThread thread1=new MyThread();
        thread1.run();//sadece kodları calıstırır, thread olusmaz, main thread devam eder.
        thread1.start();//run metodu cagırır ve threadi baslatir.

        //2.yol Runnable
        MyRunnable myRunnable=new MyRunnable();
        Thread thread2=new Thread(myRunnable);
        thread2.start();

        //anonymous class:isimsiz class
        Thread thread3=new Thread(new Runnable() { // class ismi vermeden bu şekilde implements ederek olusturulan classlara anonymous class denir.
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Calisan thread: "+Thread.currentThread().getName());
                System.out.println("Bu thread anonymous olusan class ile olustu...");
            }
        });
        thread3.setName("threadciiikk");//Thread e isim vermek icin kullanılır
        thread3.start();

        //runnable:functional interface
        Thread thread4=new Thread(()->{
            System.out.println("Calisan thread: "+Thread.currentThread().getName());
            System.out.println("Bu thread lambda expression ile olustu...");
        });

        thread4.start();

        System.out.println("Burada main metodu sona erdi");


    }
}
//thread olusturmanın  iki tane yolu var
//1.Yol:Thread classını extend ederek

class MyThread extends Thread{
    @Override
   public void run(){
       //thread a yaptırmak istedigimiz isleri veriyoruz.
        System.out.println("Calisan thread: "+Thread.currentThread().getName());
        System.out.println("MyThread threadi calisiyor....");
   }

}

//2.YOL:Runnable Interfaceini implement ederek
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Calisan thread: "+Thread.currentThread().getName());
        System.out.println("Runnable interfacesinden olusan thread calisiyor....");

    }
}