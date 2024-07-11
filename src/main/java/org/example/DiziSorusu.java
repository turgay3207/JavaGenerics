package org.example;

import java.util.Scanner;

/*Soru 2:
Bir Java programı yazın, bu program bir dizideki (array) en büyük ve en küçük sayıları bulsun.
 Kullanıcıdan dizinin boyutunu ve elemanlarını girmesini isteyin ve ardından dizideki en büyük ve en küçük sayıları ekrana yazdırın.*/
public class DiziSorusu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Dizinin boyutunu giriniz?");

        int a = input.nextInt();

        if (a <= 0) {
            System.out.println("Geçersiz boyut");
            return;
        }
        int[] dizi = new int[a];
        System.out.println("Dizinin elemenlarini giriniz");
        for (int i = 0; i < a; i++) {
            dizi[i] = input.nextInt();
        }
            int max =dizi[0];
            int min =dizi[0];

            for(int i=1; i<a; i++){
                if(dizi[i]>max){
                    max=dizi[i];
                }
                if(dizi[i]<min){
                    min=dizi[i];
                }
            }

        System.out.println("En büyük eleman: "+max);
        System.out.println("En kücük eleman: "+min);
    }


}
