package com.example.listy_przepisy;

public class Marka {
    private String nazwaMarki;
    private String kategoria;
    private int idObrazka;
    private String parametry;
    private String opis;
    public Marka(String nazwaMarki) {
        this.nazwaMarki = nazwaMarki;
        kategoria = "sportowe";
        parametry = "";
        opis="";
        idObrazka = R.drawable.e30m3;
    }

    public Marka(String nazwaMarki, String opis, String parametry, int idObrazka, String kategoria) {
        this.nazwaMarki = nazwaMarki;
        this.opis = opis;
        this.parametry = parametry;
        this.idObrazka = idObrazka;
        this.kategoria = kategoria;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getParametry() {
        return parametry;
    }

    public void setParametry(String parametry) {
        this.parametry = parametry;
    }

    public int getIdObrazka() {
        return idObrazka;
    }

    public void setIdObrazka(int idObrazka) {
        this.idObrazka = idObrazka;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getNazwaMarki() {
        return nazwaMarki;
    }

    public void setNazwaMarki(String nazwaMarki) {
        this.nazwaMarki = nazwaMarki;
    }

    @Override
    public String toString() {
        //return "Marka{" +
          //      "nazwaMarki='" + nazwaMarki + '\'' +
        //        '}';
        return nazwaMarki;
    }
}
