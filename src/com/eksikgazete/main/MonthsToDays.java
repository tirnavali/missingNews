/**
 * The HelloWorld program implements an application that
 * simply displays "Hello World!" to the standard output.
 *
 * @author  Sercan Tırnavalı
 * @version 1.0
 * @since   2020-09-28
 */
package com.eksikgazete.main;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Logger;

/**Türkçe giirlen ay isimlerini ascii karakterler dönüştürür. Bir Ayın kaç gün çektiğini hesaplar.
 * Buna */

public class MonthsToDays {
    Logger l = Logger.getLogger(getClass().getName());
    private String[] days = new String[]{"01", "02", "03", "04", "05", "06",
            "07", "08", "09", "10", "11", "12", "13",
            "14", "15", "16", "17", "18", "19", "20", "21",
            "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"} ;
    private String[] thirties = {"NISAN","HAZIRAN","EYLUL","KASIM"};
    private String[] thirtyones = {"OCAK","MART","MAYIS","TEMMUZ","AGUSTOS","EKIM","ARALIK"};
    private final String[] other = {"SUBAT"};
    private String [] allMonths = {"OCAK","SUBAT", "MART","MAYIS","TEMMUZ","AGUSTOS","EKIM","ARALIK","NISAN","HAZIRAN","EYLUL","KASIM"};

    private String monthName;
    private String year;


    /**Girilen ay ve yıla göre o ayın o yılda kaç gün çektiğini metin dizisi olarak döner.*/
    public String[] howManyDaysAtMonth (String monthName, String year) {
        Arrays.sort(thirties);
        Arrays.sort(thirtyones);
        Arrays.sort(allMonths);
        monthName = monthName.toUpperCase();
        monthName = utf8toASCII(monthName);

        if(Arrays.binarySearch(allMonths, monthName) < 0) {
            return null;
        }
        System.out.println("Girilen ay adı : "+ monthName + ", Girilen yıl adı: "+ year);

        if (Arrays.binarySearch(thirties, monthName) >= 0) {
            l.info("Month name: " + monthName);
            l.info("Months List: " + thirties);
            l.info("Binary search result : " + Arrays.binarySearch(thirties, monthName));
            return getDays(30);
        } else if (Arrays.binarySearch(thirtyones, monthName) >= 0) {
            return  getDays(31);
        } else if (Arrays.binarySearch(other, monthName) >= 0 && Integer.parseInt(year) % 4 == 0) {
            return getDays(29);
        } else {
            return getDays(28);
        }
    }
    /**Girilen gün sayısına göre ['01', '02', '03',..] şeklinde metin olarak gün listesi döner. 31'den büyük kabul etmez.*/
    private String[] getDays(int dayLength){
        try {
            if (dayLength > 31) {
                throw new Exception("Gün sınırı aşıldı");
            }
            String[] days = new String[dayLength];
            System.arraycopy(this.days, 0, days, 0,dayLength);
//            for (String day : days) {
//                System.out.println(day);
//            }
            return days;
        } catch (Exception e) {
            e.printStackTrace();
            return new String[]{};
        }
    }
    /**Girilen metindeki İ Ş Ğ Ü Türkçe karakterlerini ASCII haline çevirir.*/
    private String utf8toASCII (String word) {
        Map<Character, Character> convertTable = new Hashtable();
        convertTable.put('İ', 'I');
        convertTable.put('Ş', 'S');
        convertTable.put('Ğ', 'G');
        convertTable.put('Ü', 'U');
        String result = "";
        char[] words = word.toCharArray();
        for (char c : words) {
            if (convertTable.containsKey(c)){
                //System.out.println(c+" -- çevriliyor -- "+ convertTable.get(c));
                result += convertTable.get(c);
            } else {
                //System.out.println(c+" -- ---------- -- "+ c);
                result += c;
            }
        }
        return result;
    }
}
