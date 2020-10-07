package com.eksikgazete.main;

import java.io.File;
import java.util.logging.Logger;
import java.util.regex.Pattern;


/**
 * Verilen dosya yolunun recursive olarak gezer
 */
public class FolderScan {

//    private String dosyaYolu;
//
//    public FolderScan(String dosyaYolu) {
//        this.dosyaYolu = dosyaYolu;
//    }
    /**Verilen metindeki sayıları filtreler*/
    private String removeNumeric(String word){
        word = word.chars().filter(ch -> !Character.isDigit(ch))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString()
                .strip();
        return word;
    }
    /**verilen dosya adresini  \ karakterinden böler ve metin dizisi olarak döner*/
    private String[] splitPath(String path){
        String seperator = "\\";
        return path.split(Pattern.quote(seperator));
    }

    private int splitPathLength(String path){
        String seperator = "\\";
        return path.split(Pattern.quote(seperator)).length;
    }

    public void tara(String dosyaYolu) {
        Logger l = Logger.getLogger(FolderScan.class.getName());
        int dosyaSayac = 0;
        int klasorSayac = 0;
        // Bir gazetesnin sayfası minimum olarak belirtilir.
        int gazeteSayfasi = 18;
        // şimdi ilgli dosyaYoluna imleci geçirmek gerek
        File file = new File(dosyaYolu);
        l.info(file.toString());

        String[] splittedRoot = splitPath(file.getPath());

         String newspaperYear = "";
        String newspaperMonth = "";
        if (splittedRoot.length > 4) {
             newspaperMonth = removeNumeric(splittedRoot[4]);
             newspaperYear = splittedRoot[3];
             MonthsToDays monthsToDays = new MonthsToDays();

        }

        //l.info("***** newpaperyear: " + newspaperYear + " -- nespapermonth: "+ newspaperMonth);

        if (    newspaperYear.equalsIgnoreCase("2004") ||
                newspaperYear.equalsIgnoreCase("2006") ||
                newspaperYear.equalsIgnoreCase("2007")) {
            l.info("Toplam Klasör : " + file.listFiles().length);
        } else
            // 2004 2006 ve 2007 den başka bir yıl ise sorun yok.
        {

        }
        //System.out.println(splittedRoot.toString());
        // System.out.println(file.isDirectory());
        // İlgili dosya yolundaki tüm elemanları listeleyelim.
        File[] files = file.listFiles();

        for (File foundedFile : files) {
            if (foundedFile.isDirectory()) {
                // klasör ise recursive çağır
                klasorSayac++;
                //bulunan yolları tek tek gez
                tara(foundedFile.getPath());
            } else {
                dosyaSayac++;

                //klasör değilse işlemlere başlayalım
            }

            //System.out.println(foundedFile.getPath());
        }
        //System.out.println("Bulunan dosya sayısı : "+ dosyaSayac);

        //Eğer klasör sayısı 0 dan büyükse dosya yok demektir. Çünkü bizim dosyalama sistemimizde klasör ve dosya aynı dizinde bulunmamaktadır .
        //Bize lazım olan
        //sadece dosyaların sayısı olduğu için klasörlerden dosyaları ayırarak bastırıyoruz
        if (klasorSayac == 0 && dosyaSayac < gazeteSayfasi) {
            l.info("GAZETE YOK! -- " + file.getPath());
        } else if (klasorSayac > 1 && klasorSayac < 32) {
            l.info("Dallanma  2");
            String[] seperatedPath = splitPath(file.getPath());
            String willPrint = "";
            for (String s : seperatedPath) {
                willPrint+=s + ", ";
            }
            l.info(willPrint);
            willPrint = "";


        } else if (klasorSayac >= 30) {
            l.info("Gezilen klasör sayısı toplamı : " + klasorSayac);
        }
        // her ayın içindeki klasör sayısını bulmak için buraya bakılır
        if(splitPathLength(file.getPath()) ==  5){
            l.info("Klasör sayısı : " + klasorSayac);
        }
        //l.info("Tarama sonucu : " + file.getPath() + " - Klasör sayısı : "+ klasorSayac+ " - ");
    }
}
