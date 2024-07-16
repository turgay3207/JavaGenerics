package threads;

public class Volatile {
    /*
 Birden fazla thread kullanan bir uygulamada değişkenler performans nedeniyle PCU chache in de tutulabilir
 PC nin birden fazla CPU su oldugunu dusunursek her thread farklı CPU uzerınde calsıabilir.
 bu neden her thread degıskenlerın degerını CPU chache ine farklı degerde yazabilir
 "volatile" keywordu değişken uzerınde bır degısıklık oldugunda diger thread ler tarafından gorulmesını garenti eder
"volatile" ile bir degisken CPU cache yerine pc nin main memerosinden okunur ve CPU chache yerine main memrisine yazılır
non-volatile değişkenler icin boyle bir garanti yoktur.
 */
    //flag degerinin main memory yazılıp yien mian memoryden okunması icin volatile keywordunu kullanırız
    // degerin main memoryden yazılıp okunmasını garanti eder
    public static int flag=0;//flag degerinin main memory e yazılıp main memory den okunması garanti eder.

    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable() {//core1
            @Override
            public void run() {
              while (flag==0){
                  System.out.println("Multithreading uygulamalar harika");
              }

            }
        });
        thread1.start();
        Thread thread2=new Thread(new Runnable() {//core2
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag++;
                System.out.println("Flag degeri artırıldı");
            }
        });
        thread2.start();
    }
}
