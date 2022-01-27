package com.company;

public class Adam {
    private int Uzuv;
    private boolean Durum;

    public Adam(){
        this.Uzuv=0;
        this.Durum=false;
    }

    public boolean getDurum(){
        kontrolDurum();
        return this.Durum;
    }

    public void kontrolDurum() {
        if(this.Uzuv==6)
            this.Durum=true;
    }
    public void setUzuv() {
        this.Uzuv++;
        kontrolDurum();
    }

    public void sıfırla(Kelime kelime){
        this.Uzuv=0;
        this.Durum=false;
        kelime.sifirla();
    }

    public String bitis(Oyuncu oyuncu)
    {
        return "\\(^_^)/\n"+" \\ | /"+"\n   | \n"+"  / \\\n"+"Skor="+oyuncu.getSkor();
    }

    public String Kontrol(){
        String adam="  |\n";
        if(this.Uzuv==1)
            adam+="(^_^)\n";
        if(this.Uzuv==2)
            adam+="(^_^)\n"+"  |"+"\n  |\n";
        if(this.Uzuv==3)
            adam+="(^_^)\n"+" /|"+"\n  | ";
        if(this.Uzuv==4)
            adam+="(^_^)\n"+" /|\\"+"\n  | ";
        if(this.Uzuv==5)
            adam+="('_')\n"+" /|\\"+"\n  | \n"+" /";
        if(this.Uzuv==6){
            adam+="('_')\n"+" /|\\"+"\n  | \n"+" / \\";}

        return adam;
    }



}
