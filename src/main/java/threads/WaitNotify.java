package threads;
/*
 bir öğrencinin banka hesabı icin para yatırma(deposit) ve cekme (withraw) icin uygulama
 hesapta para yoksa para yatırılması  bakıyenın artması beklensin
 bakite artınca yeterli olunca para cemke gerceklessin.
 */
public class WaitNotify {
    public static int balance=2000;

    public static void main(String[] args) {
        WaitNotify obj=new WaitNotify();
Thread thread1=new Thread(new Runnable() {
    @Override
    public void run() {
        obj.withraw(1000);
    }
});
thread1.setName("ögrenci");
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
    }
});
thread2.setName("Veli");
thread2.start();

    }
    //Para Yatırma
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor.");
        balance=balance+amount;
        System.out.println("Para yatırma islemi basarıyla gerceklesti. Mevcut Bakiye: "+balance);
        notify();//wait ile bekleyen threadi uyandırır, harekete gecirir
      //  notifyAll();// bekleyen tüm threadleri uyarır


    }
    //Para Cekme
    public synchronized void withraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para cekmek istiyor.");
        if (balance<=0 || balance<amount){
            System.out.println("Bakiye yetersiz, mevcut bakiyeniz: "+balance);
            System.out.println("Bakiyenin guncellenmesi bekleniyor...");
            try {
                wait();//thread1 bekleyecek: thread2 nin isini yapmasını. notify cagrılana kadar
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
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
