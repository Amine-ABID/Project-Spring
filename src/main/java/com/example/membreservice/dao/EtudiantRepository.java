package com.example.membreservice.dao;

import com.example.membreservice.entities.EnseignantChercheur;
import com.example.membreservice.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findByDiplome(String diplome);
    List<Etudiant>findByDiplomeOrderByDateInscriptionDesc(String diplome);

    List<Etudiant> findByEncadrant(EnseignantChercheur encadrant);


}

