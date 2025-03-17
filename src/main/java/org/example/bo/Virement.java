package org.example.bo;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Virement extends Operation {
    private String beneficiaire;

    public Virement() {}

    public Virement(LocalDate date, double montant, Compte compte, String beneficiaire) {
        super(date, montant, compte);
        this.beneficiaire = beneficiaire;
    }
}

