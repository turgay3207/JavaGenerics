package threads;

import java.util.SortedMap;

/*
Ölümcül kilitenme anlama gelir, iki veya daha fazla threadin calısmak için
aynı kaynaga erismek istemeleriyle olusur.
Kaynaga erismek için biribirlerini beklemesi sonucunda sistem kaynakları olumsuz etkilnir ve
uygulamanız cevap veremez hale gelebilir.

 */
public class DeadLock {

    public static void main(String[] args) {
        String seker="seker";
        String kahve="kahve";
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (kahve){

                    System.out.println(Thread.currentThread().getName()+" "+kahve+" i kullanıyor.");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" "+seker+" i istiyor.");



                    synchronized (seker){
                        System.out.println(Thread.currentThread().getName()+" "+seker+" i kullanıyor.");
                    }//kahve burada bırakıldı
                }//seker bırakıldı
                System.out.println(Thread.currentThread().getName()+" sıcak su ekledi ve kahvesini yudumluyor.");

            }
        },"Tom");
        thread1.start();
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (kahve) {
                    System.out.println(Thread.currentThread().getName()+" " +kahve+ " yi kullanıyor.");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + seker + " i istiyor.");
                    synchronized (seker) {
                        System.out.println(Thread.currentThread().getName() + " " + seker + " i ekledi.");
                    }//şekeri bıraktı
                }//kahveyi bıraktı
                System.out.println(Thread.currentThread().getName()+" sıcak su ekledi ve kahvesini içiyor.");
            }
        },"Jerry");
        thread2.start();

    }


}
