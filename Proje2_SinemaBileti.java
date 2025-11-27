package Kasim14Hafta8;

import java.util.Scanner;
 /*
     Ad Soyad: Miraç Özcan AĞCABAY
     Numara: 250541002
     Proje: Sinema Bilet sistemi
     Tarih:27.11.2025
     */

public class sinemaBileti {
    
    public static boolean isWeekend(int gun){
        return (gun == 6 || gun == 7);
    }

    public static boolean isMatinee(int saat){
        return saat < 12;
    }

    public static double calculateBasePrice(int gun, int saat){
        if(isWeekend(gun) && isMatinee(saat)) return 55;
        else if(isWeekend(gun)) return 85;
        else if(isMatinee(saat)) return 45;
        else return 65;
    }

    public static double calculateDiscount(int yas, int meslek, int gun, double temelFiyat){

        double indirim = 0;

        if(yas >= 65){
            indirim = temelFiyat * 0.30;
        } else if(yas < 12){
            indirim = temelFiyat * 0.25;
        } else if(meslek == 1){
            if(gun >= 1 && gun <= 4){
                indirim = temelFiyat * 0.20;
            } else {
                indirim = temelFiyat * 0.15;
            }
        } else if(meslek == 2 && gun == 3){
            indirim = temelFiyat * 0.35;
        }

        return indirim;
    }

    public static int getFormatExtra(int tur){
        switch(tur){
            case 1: return 0;
            case 2: return 25;
            case 3: return 35;
            case 4: return 50;
            default: return 0;
        }
    }

    public static double calculateFinalPrice(int gun, int saat, int yas, int meslek, int tur){
        double temel = calculateBasePrice(gun, saat);
        double indirim = calculateDiscount(yas, meslek, gun, temel);
        int ekstra = getFormatExtra(tur);
        return (temel - indirim) + ekstra;
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int gun, saat, yas, meslek, tur;

        System.out.print("Gün (1-7): ");
        gun = input.nextInt();

        System.out.print("Saat (8-23): ");
        saat = input.nextInt();

        System.out.print("Yaş: ");
        yas = input.nextInt();

        System.out.print("Meslek (1=Öğrenci, 2=Öğretmen, 3=Diğer): ");
        meslek = input.nextInt();

        System.out.print("Film Türü (1=2D,2=3D,3=IMAX,4=4DX): ");
        tur = input.nextInt();

        System.out.println("\n=== BİLET HESAPLAMA ===\n");

        double temelFiyat = calculateBasePrice(gun, saat);
        double indirim = calculateDiscount(yas, meslek, gun, temelFiyat);
        int ekstra = getFormatExtra(tur);
        double toplam = calculateFinalPrice(gun, saat, yas, meslek, tur);

        System.out.printf("Temel Fiyat: %.1f TL%n", temelFiyat);
        System.out.printf("İndirim: %.1f TL%n", indirim);
        System.out.printf("İndirim Sonrası Fiyat: %.1f TL%n", (temelFiyat - indirim));
        System.out.printf("Format Ücreti: +%d TL%n", ekstra);
        System.out.println("---------------------------------");
        System.out.printf("TOPLAM: %.1f TL%n", toplam);

        input.close();
    }
}
