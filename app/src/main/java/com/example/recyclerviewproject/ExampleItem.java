package com.example.recyclerviewproject;
//cards
public class ExampleItem {
    private int nota;
    private String nume;

    public ExampleItem(int no, String nu){
        nota = no;
        nume = nu;
    }

    public String getNume() {
        return nume;
    }

    public int getNota() {
        return nota;
    }
}
