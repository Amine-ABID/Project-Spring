package com.example.membreservice.dao;

import com.example.membreservice.entities.Membre;
import com.example.membreservice.entities.Membre_Publication;
import com.example.membreservice.entities.Membre_Pub_Id;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Membrepubrepository extends JpaRepository<Membre_Publication, Membre_Pub_Id> {
    List<Membre_Publication> findByAuteur(Membre auteur);
}
