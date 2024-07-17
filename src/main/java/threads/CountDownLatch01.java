package threads;

import java.util.concurrent.CountDownLatch;

//Bazu threadlerin önce calısmasını bu arada diger threadlerin ve main threadin de beklemesini istedigimiz
//COuntdownlatch ile bir sayac olusturulur ve öncelik verdigimiz her bir thread işini tammaladıgında sayac bir azaltılır
//son olarak sayac 0 oldugunda diğer threadlerin ve main threadin calısmaya deva metmesine izin verilir.
public class CountDownLatch01 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName()+"  Main thread basladı");

        CountDownLatch latch=new CountDownLatch(4);

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"  threadi calısmaya basladı.");
                try {
                    latch.await();//countdown metodu ile sayac=0 olana kadar bekler
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " calısmaya devam ediyor...");
            }
        }, "Car");//new Thread(Runnable target,String name)
        thread1.start();

        WorkerThreads worker1=new WorkerThreads("worker1",6000,latch);
        WorkerThreads worker2=new WorkerThreads("worker2",5000,latch);
        WorkerThreads worker3=new WorkerThreads("worker3",4000,latch);
        WorkerThreads worker4=new WorkerThreads("worker4",3000,latch);

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        latch.await();//worker threadleri bekle
        System.out.println(" main threadi calısıyor.....");

    }
}

class WorkerThreads extends Thread {
    private int duration;//bekleme suresini dinamik olarak belilemek icin

    private CountDownLatch latch;

    public WorkerThreads(String name, int duration, CountDownLatch latch) {
        super(name);
        this.duration = duration;
        this.latch = latch;
    }


    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName() + " calısmaya basladı.");
            Thread.sleep(duration);

            System.out.println(Thread.currentThread().getName() + " calısmayı bitirdi...");
            latch.countDown();//4-3-2-1-->0 oldugunda diger threadlere izin verecek
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}