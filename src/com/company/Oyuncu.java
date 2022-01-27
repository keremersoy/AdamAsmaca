package com.company;


public class Oyuncu {
    private String Ad;
    private String File;
    private int Skor;

    public Oyuncu(String _ad){
        this.Ad=_ad;
        this.Skor=0;
        this.File=System.getProperty("user.dir")+"\\file\\AdamAsmacaOyuncu.txt";
    }

    public String getFile() {
        return this.File;
    }

    public String getName() {
        return this.Ad;
    }

    public int getSkor() {
        return this.Skor;
    }

    public void arttirSkor() {
        this.Skor+=10;
    }

    public void azaltSkor() {
        this.Skor-=10;
    }
}
