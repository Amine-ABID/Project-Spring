package com.example.membreservice.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("ens")
@Getter
@Setter
@NoArgsConstructor
public class EnseignantChercheur extends Membre{


    @NonNull
    private String grade ;

    @NonNull
    private String etablissement ;

    @Builder
    public EnseignantChercheur(String cin, String nom, String prenom, Date dateNaissance, String cv,
                    String email, String password, String grade ,String etablissement) {
        super(cin, nom, prenom, dateNaissance, cv, email, password);
        this.grade = grade;
        this.etablissement = etablissement;

    }
}
