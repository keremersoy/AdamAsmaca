package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Kelime {
    private String[] Hayvan;
    private String[] Bitki;
    private String[] Ulke;
    private String Kelime;
    private String Kategori;
    private char[] Bulunan;
    private char[] Tahminler;
    private char[] Tahmin;
    private int Deneme;
    private File file;

    public Kelime(){
        this.file=new File(System.getProperty("user.dir")+"\\file\\AdamAsmacaKelime.txt");
        this.Deneme=0;
        this.kelimeSec();
        this.Tahminler=new char[this.Kelime.length()+10];
        this.Bulunan=new char[this.Kelime.length()];
        b();
    }

    public void sifirla(){
        this.Deneme=-1;
        kelimeSec();
        this.Bulunan=new char[this.Kelime.length()];
        b();
    }

    private void b(){
        for (int i=0;i<this.Bulunan.length;i++)
            this.Bulunan[i]='_';
    }

    public char[] getBulunanArray(){
        return this.Bulunan;
    }

    public void getBulunan(Oyuncu oyuncu){
        for (int i=0;i<this.Kelime.length();i++)
            System.out.print(this.Bulunan[i]);
        System.out.println();
        getTahminler();
        System.out.println("Kategori = "+this.Kategori);
        System.out.println("Skor = "+oyuncu.getSkor());
    }

    public String getKelime(){
        return this.Kelime;
    }

    public void denemeArttir(){
        this.Deneme++;
    }

    public void getTahminler(){
        System.out.print("Tahminler= ");
        for (int i=0;i<this.Tahminler.length;i++) {
            if(!(this.Tahminler[i]=='\0'))
                System.out.print(this.Tahminler[i]+",");
        }
        System.out.println();
    }

    public void setTahminler(char harf,Adam adam,Oyuncu oyuncu){
        String h=String.valueOf(harf).toUpperCase(Locale.ROOT);
        boolean durum=false;
        for (int i=0;i<this.Tahminler.length;i++){
            if(h.contains(String.valueOf(this.Tahminler[i]))) {
                durum=true;
            }
        }
        if(!durum)
        {
            this.Tahminler[this.Deneme] = h.charAt(0);
            Kontrol(adam,oyuncu);
            denemeArttir();
        }
    }

    public void Kontrol(Adam adam,Oyuncu oyuncu){
        boolean varmi=false;
        for (int i=0;i<this.Kelime.length();i++){
            if (String.valueOf(this.Tahminler[this.Deneme]).contains(String.valueOf(this.Kelime.charAt(i))))
            {
                this.Bulunan[i] = this.Kelime.charAt(i);
                varmi=true;
                oyuncu.arttirSkor();
            }
        }
        if(varmi==false) {
            adam.setUzuv();
            oyuncu.azaltSkor();
        }
    }

    public boolean KelimeKontrol(){
        return this.Kelime.equals(String.valueOf(this.Bulunan));
    }

    public void kelimeSec() {
        String klm="",ktg="";
        boolean durum=true;
        int satirSayisi,a;
        Random rnd=new Random();
        try{
            satirSayisi=0;
            Scanner sc = new Scanner(this.file);

            while(sc.hasNextLine()){
                sc.nextLine();
                satirSayisi++;
            }
            while(durum) {
                Scanner sc2=new Scanner(this.file);
                a = rnd.nextInt(satirSayisi + 1);
                for (int i = 0; i < a; i++) {
                    klm =sc2.nextLine();
                    if (klm.charAt(0) == '-') {
                        ktg = klm;
                    }
                }
                if (!klm.equals(ktg))
                    durum = false;
                sc.reset();
                sc2.reset();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.Kategori=ktg.toUpperCase(Locale.ROOT).substring(1);
        this.Kelime=klm.toUpperCase(Locale.ROOT);
    }
}
