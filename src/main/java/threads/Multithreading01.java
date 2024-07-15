package threads;

public class Multithreading01 {
    public static void main(String[] args) throws InterruptedException {

        //TASK1: 1 den 10 a kadar sayıları ekrana 2 defa yazdırma
        long start=System.currentTimeMillis();
        Counter counte1=new Counter("Abdullah");
        counte1.countMe();
        Counter counter2=new Counter("Halil");
        counter2.countMe();
        long finish=System.currentTimeMillis();

        System.out.println("Thread kullanmadan gcen sue: "+(finish-start));//10230
        System.out.println("---------MultiThreading--------------");
        long startTime=System.currentTimeMillis();
        CounterWithMultiThread counter3=new CounterWithMultiThread("Turgay");
        CounterWithMultiThread counter4=new CounterWithMultiThread("Muhammet");
        counter3.start();
        counter4.start();
        counter3.join(); //hangi thread icinde cagrılmıssa bu threadi counter3 threadi isini bitirene kadar bekler
        long finishTime=System.currentTimeMillis();
        System.out.println("MultiThread ile gecen sure: "+(finishTime-startTime));//

    }
}
class Counter{

    private String name;

    //parametreli const


    public Counter(String name) {
        this.name = name;
    }

    //thread kullnmadan 1...10 kadaqr yazdırma
    public void countMe() throws InterruptedException {
        for(int i=1;i<=10;i++){
            Thread.sleep(500);//main thread 0.5 sn uyusun
            System.out.println(i+"  -  "+name);
        }
    }

}
class CounterWithMultiThread extends Thread{
    private String name;

    public CounterWithMultiThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            countMe();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void countMe() throws InterruptedException {
        for(int i=1;i<=10;i++){
            Thread.sleep(500);//main thread 0.5 sn uyusun
            System.out.println(i+"  -  "+name);
        }
    }
}