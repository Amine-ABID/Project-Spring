package com.example.membreservice;

import com.example.membreservice.beans.PublicationBean;
import com.example.membreservice.dao.EnseignantChercheurRepository;
import com.example.membreservice.dao.MemberRepository;
import com.example.membreservice.entities.EnseignantChercheur;
import com.example.membreservice.entities.Etudiant;
import com.example.membreservice.entities.Membre;
import com.example.membreservice.proxies.PublicationProxyService;
import com.example.membreservice.service.IMemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.reflect.Member;
import java.util.Date;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@AllArgsConstructor
public class MembreServiceApplication implements CommandLineRunner {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    IMemberService memberService;


    public static void main(String[] args) {

        SpringApplication.run(MembreServiceApplication.class, args);
    }

   // PublicationProxyService publicationProxyService;

    public void run(String... args) throws Exception {

        Etudiant etd1= Etudiant.builder()
                .cin("123456")
                .dateInscription(new Date()).dateNaissance(new Date())
                .diplome("mastère")
                .email("etd1@gmail.com")
                .password("pass1")
                .encadrant(null)
                .cv("cv1")
                .nom("abid")
                .prenom("youssef)")
                .sujet("blockhain")
                .build();
        Etudiant etd2= Etudiant.builder()
                .cin("123")
                .dateInscription(new Date()).dateNaissance(new Date())
                .diplome("prepa")
                .email("etd2@gmail.com")
                .password("pass2")
                .encadrant(null)
                .cv("cv2")
                .nom("abid")
                .prenom("amine)")
                .sujet("spring")
                .build();
        memberRepository.save(etd1);
        memberRepository.save(etd2);

        EnseignantChercheur ens1= EnseignantChercheur.builder().cin("456")
                .dateNaissance(new Date())
                .grade("maitre enseignant")
                .email("ens1@gmail.com")
                .password("pass1")
                .cv("cv1")
                .nom("abid")
                .prenom("mohamed)")
                .etablissement("prepa")
                .build();
    EnseignantChercheur ens2= EnseignantChercheur.builder().cin("7890")
            .dateNaissance(new Date())
            .grade("docteur")
            .email("ens1@gmail.com")
            .password("pass2")
            .cv("cv2")
            .nom("abid")
            .prenom("dali)")
            .etablissement("prepa")
            .build();
    memberRepository.save(ens1);
    memberRepository.save(ens2);

 /*List<Membre> members = memberRepository.findAll();
        for (Membre member: members){
            System.out.println(member.getCin());
            System.out.println(member.getNom()+" "+member.getPrenom());
        }

        Membre member = memberRepository.findById(1L).get();
        System.out.println(member.getEmail());*/

  /*  Membre m= membreService.findMember(1L);
    m.setCv("cv1.pdf");
    membreService.updateMember(m);
    membreService.deleteMember(2L);*/

    memberService.affecterEtudianttoEnseignant(1L,1L);
    List<Etudiant> etds = memberService.findEtudiantByEncadrant(ens1);
    for (Etudiant etd: etds){
        System.out.println(etd.getEmail());
    }

    memberService.affecterauteurTopublication(1L, 1L);
    List<PublicationBean> l = memberService.findPublicationparauteur(1L);
    for (PublicationBean x :l){
        System.out.println("x ::::::::::: " +x);
    }
}





//        // Update a Member
//        Membre m = memberService.findMember(1L);
 /*       memberService.affecterEtudianttoEnseignant(3L, 1L);

       List<Etudiant> etds =  memberService.findEtudiantByEncadrant(ens1);
        for (Etudiant etd:etds){
            System.out.println(etd.getEmail());
        }*/
        //memberService.affecterauteurTopublication(1L, 1L);


//        m.setCv("cv1.pdf");
//        memberService.updateMember(m);
//        // Delete a Member
//        memberService.deleteMember(2L);


    }
    /*public void run(String... args) throws Exception {
        Etudiant etd1= Etudiant.builder().cin("123456")
                .dateInscription(new Date()).dateNaissance(new Date())
                .diplome("mastère")
                .email("etd1@gmail.com")
                .password("pass1")
                .encadrant(null)
                .cv("cv1")
                .nom("abid")
                .prenom("youssef)")
                .sujet("blockhain")
                .build();
        Etudiant etd2= Etudiant.builder().cin("123")
                .dateInscription(new Date()).dateNaissance(new Date())
                .diplome("prepa")
                .email("etd2@gmail.com")
                .password("pass2")
                .encadrant(null)
                .cv("cv2")
                .nom("abid")
                .prenom("amine)")
                .sujet("spring")
                .build();
        EnseignantChercheur ens1= EnseignantChercheur.builder().cin("456")
                .dateNaissance(new Date())
                .grade("maitre enseignant")
                .email("ens1@gmail.com")
                .password("pass3")
                .cv("cv3")
                .nom("abid")
                .prenom("mohamed)")
                .etablissement("prepa")
                .build();
        EnseignantChercheur ens2= EnseignantChercheur.builder().cin("789")
                .dateNaissance(new Date())
                .grade("professeur")
                .email("ens2@gmail.com")
                .password("pass3")
                .cv("cv3")
                .nom("abid")
                .prenom("dali)")
                .etablissement("enis")
                .build();

        memberRepository.save(etd1);
        memberRepository.save(etd2);
        memberRepository.save(ens1);
        memberRepository.save(ens2);
        List<Membre> members = memberRepository.findAll();
        for (Membre membere:members){
            System.out.println(membere.getEmail());
            System.out.println(membere.getNom());
            System.out.println(membere.getCin());
        }
        Membre membre = memberRepository.findById(1L).get();
        System.out.println(membre.getEmail());


    }*/


