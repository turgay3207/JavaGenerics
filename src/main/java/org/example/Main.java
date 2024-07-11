package org.example;

import java.util.Scanner;
/*
Bir Java programı yazın, bu program verilen bir sayının asal olup olmadığını kontrol etsin.
 Kullanıcıdan bir sayı girmesini isteyin ve sayının asal olup olmadığını ekrana yazdırın.
 */
public class Main {
    public static void main(String[] args) {

        int sayi;
        Scanner input=new Scanner(System.in);
        System.out.println("Asal sayiyi bulacak kodu giriniz");

        sayi=input.nextInt();

        if (sayi <= 1) {
            System.out.println(sayi + " asal bir sayı değildir.");
        } else {
            boolean asalMi = true;

            for (int i = 2; i <= Math.sqrt(sayi); i++) {
                if (sayi % i == 0) {
                    asalMi = false;
                    break;
                }
            }

            if (asalMi) {
                System.out.println(sayi + " asal bir sayıdır.");
            } else {
                System.out.println(sayi + " asal bir sayı değildir.");
            }
        }
    }
}