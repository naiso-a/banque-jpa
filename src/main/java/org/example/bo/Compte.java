package org.example.bo;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private double solde;

    @ManyToMany(mappedBy = "comptes")
    private Set<Client> clients = new HashSet<>();

    public Compte() {}

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public Set<Client> getClients() {
        return clients;
    }
}
