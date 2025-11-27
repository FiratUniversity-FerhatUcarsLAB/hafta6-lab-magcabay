package Kasim14Hafta8;
import java.util.Scanner;
public class notSistemi {

    public static double calculateAverage(int vize, int fin,int odev){
        double ortalama =vize*0.3 +fin*0.4+ odev*0.3;
        return ortalama;
    }

    public static boolean isPassingGrade(double ortalama){
        if (ortalama>=50){
            return true;
        }else {
            return false;
        }
    }


    public static String getLetterGrade(double ortalama ){
        String harf_notu="GEÇERSİZ";
        if(ortalama >= 90 && ortalama <= 100){
            harf_notu="A";
        } else if (ortalama >=80 && ortalama<90) {
            harf_notu="B";

        } else if (ortalama >=70 && ortalama<80 ) {
            harf_notu="C";

        }else if (ortalama>=60 && ortalama<70 ){
            harf_notu="D";
        } else {
            harf_notu="F";
        }
        return harf_notu;
    }

    public static boolean isHonorList(double ortalama, int vize, int fin,int odev){

        if(ortalama>=85 && vize>=70 && fin >= 70){
            return true;
        }else{
            return false;
        }
    }

    public static boolean hasRetakeRight(double ortalama ){
        if(ortalama>=40 && ortalama<=50){
            return true;
        }else{
            return false;
        }
    }



    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int vize,fin,odev;
        System.out.print("Vize notunuzu girin: ");
        vize=scan.nextInt();
        System.out.print("Final notunuzu girin : ");
        fin =scan.nextInt();
        System.out.print("Ödev notunuzu giirin: ");
        odev=scan.nextInt();

        double ortalama = calculateAverage(vize, fin, odev);

        System.out.println("\n=== OGRENCI NOT RAPORU ===");

        System.out.printf("Vize Notu : %.1f%n", (double)vize);
        System.out.printf("Final Notu : %.1f%n", (double)fin);
        System.out.printf("Odev Notu : %.1f%n", (double)odev);

        System.out.println("------------------------------");

        System.out.printf("Ortalama : %.1f%n", ortalama);
        System.out.printf("Harf Notu : %s%n", getLetterGrade(ortalama));
        System.out.printf("Durum : %s%n", (isPassingGrade(ortalama) ? "GECTİ" : "KALDI"));
        System.out.printf("Onur Listesi : %s%n", (isHonorList(ortalama, vize, fin, odev)== true ? "EVET" : "HAYIR"));
        System.out.printf("Butunleme : %s%n", (hasRetakeRight(ortalama) ? "VAR" : "YOK"));

        scan.close();




    }
}
