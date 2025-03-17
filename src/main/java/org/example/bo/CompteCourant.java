package org.example.bo;


import jakarta.persistence.Entity;

@Entity
public class CompteCourant extends Compte{
    private double decouvert;

    public CompteCourant() {}
    public CompteCourant(String numero, double solde,double decouvert) {
        super(numero, solde);
        this.decouvert = decouvert;

    }
}
