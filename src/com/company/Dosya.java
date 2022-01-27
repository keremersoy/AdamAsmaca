package com.company;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Dosya {
    private File file;

    public Dosya(String _file){
        this.file=new File(_file);
        DosyaOlustur();
    }

    public void DosyaOlustur(){
        try
        {
            if(!this.file.exists()){
                this.file.createNewFile();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void DosyayaYaz(Oyuncu _oyuncu) {
        try {
            LocalDateTime d = LocalDateTime.now();
            DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            FileOutputStream fos = new FileOutputStream(file,true);
            String yaz ="Ad: "+_oyuncu.getName()+"\nSkor: "+_oyuncu.getSkor()+"\n"+d.format(date)+"\n-\n";
            fos.write(yaz.getBytes());
            fos.flush();
            fos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
