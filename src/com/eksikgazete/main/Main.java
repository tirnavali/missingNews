package com.eksikgazete.main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] days = new String[]{"01", "02", "03", "04", "05", "06",
                "07", "08", "09", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21",
                "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};


	// write your code here
        System.out.println("Program başlatılıyor...");
        FolderScan folderScan = new FolderScan();
        System.out.println("FolderScan gerçekleştiriliyor ...");
        folderScan.tara("U:\\gazete\\0120 TURKIYE GAZETESI\\2020");
        System.out.println("FolderScan sonlandı.");
        Scanner input = new Scanner("Çıkmak için herhangi bir tuşa basınız...");

    }

}
