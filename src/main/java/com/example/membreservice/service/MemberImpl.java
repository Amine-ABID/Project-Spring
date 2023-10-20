package com.example.membreservice.service;

import com.example.membreservice.beans.PublicationBean;
import com.example.membreservice.dao.EnseignantChercheurRepository;
import com.example.membreservice.dao.EtudiantRepository;
import com.example.membreservice.dao.MemberRepository;
import com.example.membreservice.dao.Membrepubrepository;
import com.example.membreservice.entities.*;
import com.example.membreservice.proxies.PublicationProxyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor

@Service
public class MemberImpl implements IMemberService {
    MemberRepository memberRepository;
    EtudiantRepository etudiantRepository ;
    EnseignantChercheurRepository enseignantChercheurRepository;
    Membrepubrepository membrepubrepository ;
    PublicationProxyService proxy ;

    public Membre addMember(Membre m) {
        memberRepository.save(m);
        return m;
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public Membre updateMember(Membre m) {
        return memberRepository.saveAndFlush(m);
    }

    public Membre findMember(Long id) {
        Membre m = (Membre) memberRepository.findById(id).get();
        return m;
    }

    @Override
    public List<Membre> findAll() {
       return memberRepository.findAll();
    }

    @Override
    public Membre findByCin(String cin) {
        return memberRepository.findByCin(cin);
    }

    @Override
    public Membre findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public List<Membre> findByNom(String nom) {
        return memberRepository.findByNom(nom);
    }

    @Override
    public List<Etudiant> findByDiplome(String diplome) {
        return etudiantRepository.findByDiplomeOrderByDateInscriptionDesc(diplome);
    }

    @Override
    public List<EnseignantChercheur> findByGrade(String grade) {
        return enseignantChercheurRepository.findByGrade(grade);
    }

    @Override
    public List<EnseignantChercheur> findByEtablissement(String etablissement) {
        return enseignantChercheurRepository.findByEtablissement(etablissement);
    }
    @Override
    public void affecterEtudianttoEnseignant(Long id_ens , Long id_etd){
        Etudiant etudiant = etudiantRepository.findById(id_etd).get();
        EnseignantChercheur enseignantChercheur = enseignantChercheurRepository.findById(id_ens).get();
        etudiant.setEncadrant(enseignantChercheur);
        etudiantRepository.save(etudiant);
    }

    @Override

    public List<Etudiant> findEtudiantByEncadrant(EnseignantChercheur ens){
        return etudiantRepository.findByEncadrant(ens);
    }
    @Override
    public void affecterauteurTopublication(Long idauteur, Long idpub)
    {
        Membre mbr= memberRepository.findById(idauteur).get();
        Membre_Publication mbs= new Membre_Publication();
        mbs.setAuteur(mbr);
        mbs.setId(new Membre_Pub_Id(idpub, idauteur));
        membrepubrepository.save(mbs);
    }
    @Override
    public List<PublicationBean> findPublicationparauteur(Long idauteur) {
        List<PublicationBean> pubs=new ArrayList<PublicationBean>();
        Membre auteur= memberRepository.findById(idauteur).get();
        List< Membre_Publication>
                idpubs=membrepubrepository.findByAuteur(auteur);
        idpubs.forEach(s->{
                    System.out.println(s);
                    pubs.add(proxy.recupererUnePublication(s.getId().getPublication_id()));
                }
        );
        return pubs;
    }

}
