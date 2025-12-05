package com.example.listy_przepisy;

import java.util.ArrayList;

public class RepozytoriumMarek {
    private static ArrayList<Marka> marki;
    private static void wygenerujMarki(){
        marki = new ArrayList<>();
        marki.add(
                new Marka("BMW","Fajna szybka furka", "321km 3.2l 6cylindrow, 6biegow 1995-1999", R.drawable.e36m3, "Cabrio" )
        );
        marki.add(
                new Marka("BMW","Limuzyna jak ta lala", "v12 pod maska 5 litorw itp", R.drawable.e38, "Sedan" )
        );
        marki.add(
                new Marka("BMW","Terenowka ale lepiej nie jedzic w teren", "4.8 v8 pod machą  wiec ezzz", R.drawable.e53x5, "Suv" )
        );marki.add(
                new Marka("BMW","Klasyczekkk", "2.3l 4 cylindty 5 biegow dogleg", R.drawable.e30m3, "Coupe" )
        );marki.add(
                new Marka("Mercedes","Łohohoh silnicek v12 jak w pagani", "6l 12 cylindrów automat", R.drawable.sl600, "Cabrio" )
        );marki.add(
                new Marka("Audi","Silnicek v12 diesel 1000nm", "6l 12 cylindrów automat ponad 1000nm ", R.drawable.q7, "Suv" )
        );marki.add(
                new Marka("Audi","v10 twin turbo", "5l 10 cylindrów automat ponad 500km ", R.drawable.rs6c6, "Kombi" )
        );
    }
    public static ArrayList<Marka> zwrocMarke(){
        wygenerujMarki();
        return marki;
    }
   /* public static ArrayList<Marka> zwrocMarke(String kategoria){
        ArrayList<Marka> markaKategoria = new ArrayList<>();
        return markaKategoria;
    }*/
    public static  ArrayList<Marka> zwrocAutoDanejKat(String kategoria){
        wygenerujMarki();
        ArrayList<Marka> wybranaKategoria = new ArrayList<>();
        for(Marka marka:marki){
            if(marka.getKategoria().equals(kategoria)){
                wybranaKategoria.add(marka);
            }
        }
        return wybranaKategoria;
    }
}