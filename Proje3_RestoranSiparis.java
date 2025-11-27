package Kasim14Hafta8;
/*
     Ad Soyad: Miraç Özcan AĞCABAY
     Numara: 250541002
     Proje: Restoran sistemi
     Tarih:27.11.2025
     */

import java.util.Scanner;

public class RestoranSistemi {


    public static int getMainDishPrice(int secim){
        switch(secim){
            case 1: return 85;   // Izgara Tavuk
            case 2: return 120;  // Adana Kebap
            case 3: return 110;  // Levrek
            case 4: return 65;   // Mantı
            default: return 0;
        }
    }


    public static int getAppetizerPrice(int secim){
        switch(secim){
            case 1: return 25;  // Çorba
            case 2: return 45;  // Humus
            case 3: return 55;  // Sigara Böreği
            default: return 0;
        }
    }


    public static int getDrinkPrice(int secim){
        switch(secim){
            case 1: return 15;  // Kola
            case 2: return 12;  // Ayran
            case 3: return 35;  // Taze Meyve Suyu
            case 4: return 25;  // Limonata
            default: return 0;
        }
    }


    public static int getDessertPrice(int secim){
        switch(secim){
            case 1: return 65; // Künefe
            case 2: return 55; // Baklava
            case 3: return 35; // Sütlaç
            default: return 0;
        }
    }


    public static boolean isComboOrder(boolean ana, boolean icecek, boolean tatli){
        return ana && icecek && tatli;
    }


    public static boolean isHappyHour(int saat){
        return saat >= 14 && saat <= 17;
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Ana Yemek (0-4): ");
        int a = input.nextInt();

        System.out.print("Başlangıç (0-3): ");
        int b = input.nextInt();

        System.out.print("İçecek (0-4): ");
        int c = input.nextInt();

        System.out.print("Tatlı (0-3): ");
        int d = input.nextInt();

        System.out.print("Saat (8-23): ");
        int saat = input.nextInt();

        System.out.print("Öğrenci misiniz? (E/H): ");
        char ogr = input.next().charAt(0);

        System.out.print("Gün (1-7): ");
        int gun = input.nextInt();



        int anaFiyat = getMainDishPrice(a);
        int basFiyat = getAppetizerPrice(b);
        int icecekFiyat = getDrinkPrice(c);
        int tatliFiyat = getDessertPrice(d);


        double araToplam = anaFiyat + basFiyat + icecekFiyat + tatliFiyat;


        boolean combo = isComboOrder(a!=0, c!=0, d!=0);
        boolean happy = isHappyHour(saat);
        boolean isOgrenci = (ogr=='E' || ogr=='e');


        double comboIndirim = 0;
        double happyIndirim = 0;
        double ogrenciIndirim = 0;

        if(combo){
            comboIndirim = araToplam * 0.15;
        }

        if(happy && icecekFiyat > 0){
            happyIndirim = icecekFiyat * 0.20;
        }

        if(isOgrenci && gun <= 5){
            ogrenciIndirim = araToplam * 0.10;
        }

        double toplamIndirim = comboIndirim + happyIndirim + ogrenciIndirim;
        double toplam = araToplam - toplamIndirim;

        double bahsis = toplam * 0.10;

        // --- Fiş ---
        System.out.println("\n====== SİPARİŞ FİŞİ ======");
        System.out.printf("Ara Toplam: %.2f TL%n", araToplam);
        System.out.printf("Combo İndirimi (%%15): -%.2f TL%n", comboIndirim);
        System.out.printf("Happy Hour (İçecek %%20): -%.2f TL%n", happyIndirim);
        System.out.printf("Öğrenci İndirimi (%%10): -%.2f TL%n", ogrenciIndirim);
        System.out.printf("Toplam: %.2f TL%n", toplam);
        System.out.printf("Bahşiş Önerisi (%%10): %.2f TL%n", bahsis);
        System.out.println("=============================\n");

        input.close();
    }
}
