package org.example;

import org.example.dao.JpaUtil;
import org.example.bo.*;

import jakarta.persistence.EntityManager;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        // Création et insertion des clients
        Client client1 = new Client("Bernard", "Lucie");
        Client client2 = new Client("Moreau", "Thomas");
        em.persist(client1);
        em.persist(client2);

        // Création des comptes
        CompteLivretA compteLivretA = new CompteLivretA("78901", 7000.0, 0.015);
        CompteAssuranceVie compteAssuranceVie = new CompteAssuranceVie("23456", 15000.0, 0.025, LocalDate.of(2040, 6, 15));
        CompteCourant compteCourant = new CompteCourant("65432", 4500.0, 800.0);

        // Association des comptes aux clients
        client1.ajouterCompte(compteLivretA);
        client1.ajouterCompte(compteCourant);
        client2.ajouterCompte(compteAssuranceVie);

        // Persistance des comptes
        em.persist(compteLivretA);
        em.persist(compteAssuranceVie);
        em.persist(compteCourant);

        // Ajout des opérations (Virements)
        Operation virement1 = new Virement(LocalDate.now(), -700, compteLivretA, "Entreprise XYZ");
        Operation virement2 = new Virement(LocalDate.now(), -350, compteAssuranceVie, "Agence Voyages");

        em.persist(virement1);
        em.persist(virement2);

        // Validation de la transaction
        em.getTransaction().commit();
        em.close();
        JpaUtil.close();

        System.out.println("✅ Opérations terminées avec succès !");
    }
}
