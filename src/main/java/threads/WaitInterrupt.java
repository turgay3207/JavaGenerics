package threads;
/*
 bir öğrencinin banka hesabı icin para yatırma(deposit) ve cekme (withraw) icin uygulama
 hesapta para yoksa para yatırılması  bakıyenın artması beklensin
 bakite artınca yeterli olunca para cemke gerceklessin.
 */
public class WaitInterrupt {
    public static int balance=0;

    public static void main(String[] args) {
        WaitInterrupt obj=new WaitInterrupt();
Thread thread1=new Thread(new Runnable() {
    @Override
    public void run() {
        obj.withraw(1000);
    }
});
thread1.setName("tüketici"); //consuer
thread1.start();
Thread thread2=new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        obj.deposit(2000);
        thread1.interrupt();//thread1 in yapmakta oldugu isi kesintiye ugratır.
    }
});
thread2.setName("Üretici"); //producer
thread2.start();

    }
    //Para Yatırma
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor.");
        balance=balance+amount;
        System.out.println("Para yatırma islemi basarıyla gerceklesti. Mevcut Bakiye: "+balance);

      //  notifyAll();// bekleyen tüm waitler uyarır


    }
    //Para Cekme
    public synchronized void withraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para cekmek istiyor.");
        if (balance<=0 || balance<amount){
            System.out.println("Bakiye yetersiz, mevcut bakiyeniz: "+balance);
            System.out.println("Bakiyenin guncellenmesi bekleniyor...");
            try {
                wait();//interrupt metodu cagrıldıgında bekleme kesilir ve InterruptedException fırlatılır
            }catch (InterruptedException e){
                System.out.println("Bekleme işi kesildi ");
                System.out.println("Bakiye yeniden kontrol ediliyor");
            }
        }
        if (amount<=balance){
            balance=balance-amount;
            System.out.println("Para cekme islemi basarıyla tamamlandı. Mevcut bakiye:"+balance);

        }else {
            System.out.println("Bakiye yetersiz, mevcut bakiyeniz: "+balance);
            System.out.println("Beklemeye devam edin");
        }

    }
}
