package com.example.membreservice.service;

import com.example.membreservice.beans.PublicationBean;
import com.example.membreservice.entities.EnseignantChercheur;
import com.example.membreservice.entities.Etudiant;
import com.example.membreservice.entities.Membre;

import java.util.List;

public interface IMemberService {
    //Crud sur les membres
    public Membre addMember(Membre m);
    public void deleteMember(Long id) ;
    public Membre updateMember(Membre p) ;
    public Membre findMember(Long id) ;
    public List<Membre> findAll();
    //Filtrage par propriété
    public Membre findByCin(String cin);
    public Membre findByEmail(String email);
    public List<Membre> findByNom(String nom);
    //recherche spécifique des étudiants
    public List<Etudiant> findByDiplome(String diplome);
    //recherche spécifique des enseignants
    public List<EnseignantChercheur> findByGrade(String grade);public List<EnseignantChercheur> findByEtablissement(String etablissement);
    public void affecterEtudianttoEnseignant(Long id_ens , Long id_etd);

    public List<Etudiant> findEtudiantByEncadrant(EnseignantChercheur ens);
    public List<PublicationBean> findPublicationparauteur (Long idauteur);
    public void affecterauteurTopublication(Long idauteur, Long idpub);
}
