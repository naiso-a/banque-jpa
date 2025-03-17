package org.example.bo;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @ManyToMany
    @JoinTable(name = "client_compte",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "compte_id"))
    private Set<Compte> comptes = new HashSet<>();

    public Client() {}

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public void ajouterCompte(Compte compte) {
        comptes.add(compte);
        compte.getClients().add(this);
    }
}
