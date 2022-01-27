package com.company;

import java.awt.event.KeyEvent;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Isim giriniz : ");
            String ad=sc.next().toUpperCase(Locale.ROOT);
            Oyuncu oyuncu=new Oyuncu(ad);
            String d=oyuncu.getFile();
            Dosya oyuncuDosya=new Dosya(d);
            Adam adam = new Adam();
            cls();
            char harf,secim;
            while (true) {
                boolean kazandimi = false;
                Kelime kelime = new Kelime();
                while (!kazandimi && !adam.getDurum()) {
                    cls();
                    System.out.println("Oyuncu: "+oyuncu.getName());
                    System.out.println(adam.Kontrol());
                    kelime.getBulunan(oyuncu);
                    System.out.print("Harf giriniz : ");
                    harf = sc.next().charAt(0);
                    kelime.setTahminler(harf,adam,oyuncu);
                    kazandimi = kelime.KelimeKontrol();
                }
                cls();
                if (adam.getDurum() == false) {
                    System.out.println(adam.bitis(oyuncu));
                    System.out.println(kelime.getKelime());
                    System.out.println("Tebrikler "+oyuncu.getName()+"! Kazandiniz...");
                }
                else {
                    System.out.println(adam.Kontrol());
                    System.out.println(kelime.getKelime());
                    kelime.getTahminler();
                    System.out.println("Skor="+oyuncu.getSkor());
                    System.out.println("Uzgunum "+oyuncu.getName()+" Kaybettiniz...");
                }
                System.out.print("çıkmak icin 'q' harfi, devam etmek için herhangi bir harf girin : ");
                secim=sc.next().toUpperCase(Locale.ROOT).charAt(0);
                if(secim=='Q'){
                    oyuncuDosya.DosyayaYaz(oyuncu);
                    cls();
                    break;
                }
                adam.sıfırla(kelime);
                cls();
            }
        }
    }

    static void cls(){
        for (int i = 0; i < 500; i++)
            System.out.println("\b");
    }
}


