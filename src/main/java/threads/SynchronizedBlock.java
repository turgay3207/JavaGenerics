package threads;

//Aynı anda erisilen ortak kodlar sırası onemli olmayan kodlar da varsa
public class SynchronizedBlock {
    public static void main(String[] args) throws InterruptedException {

        Brackets brackets = new Brackets();
        long start=System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 9; i++) {
                    brackets.generateBrackets();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 9; i++) {
                    brackets.generateBrackets();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        long finish=System.currentTimeMillis();
        System.out.println("Metod sychronized iken Gecen süre= "+(finish-start));
        System.out.println("Block sychronized iken Gecen süre= "+(finish-start));
    }
}

class Brackets2 {
    public /*synchronized*/ void generateBrackets() throws InterruptedException {
        //bu bloga aynı anda sadece 1 thread erisebilir.
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                if (i <= 5) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
            }
            System.out.println(" - " + Thread.currentThread().getName());
        }
        //senkron olması gerekmeyen baska kodlarda varsa
        for (int i = 0; i < 5; i++) {
            Thread.sleep(50);
        }
    }
}
