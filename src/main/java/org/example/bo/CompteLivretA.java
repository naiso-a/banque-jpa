package org.example.bo;

import jakarta.persistence.Entity;

@Entity
public class CompteLivretA extends Compte {
    private double taux;

    public CompteLivretA() {}

    public CompteLivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }
}
