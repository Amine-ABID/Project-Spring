package com.example.membreservice.controlleur;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.membreservice.entities.EnseignantChercheur;
import com.example.membreservice.entities.Etudiant;
import com.example.membreservice.entities.Membre;
import com.example.membreservice.service.IMemberService;


import java.util.List;

@AllArgsConstructor
@RestController
public class MembreRestController {


    IMemberService membreService;
    @RequestMapping(value="/membres", method= RequestMethod.GET)
    public List<Membre> findMembres (){
        return membreService.findAll();
    }
    @GetMapping(value="/membres/{id}")
    public Membre findOneMemberById(@PathVariable Long id){
        return membreService.findMember(id);
    }

    @GetMapping(value="/membres/search/cin")
    public Membre findOneMemberByCin(@RequestParam String cin)
    {
        return membreService.findByCin(cin);
    }
    @GetMapping(value="/membres/search/email")
    public Membre findOneMemberByEmail(@RequestParam String email)
    {
        return membreService.findByEmail(email);
    }

    @PostMapping(value="/membres/enseignant")
    public Membre addMembre(@RequestBody EnseignantChercheur m)
    {
        return membreService.addMember(m);
    }
    @PostMapping(value="/membres/etudiant")
    public Membre addMembre(@RequestBody Etudiant e)
    {
        return membreService.addMember(e);
    }

    @DeleteMapping(value="/membres/{id}")
    public void deleteMembre(@PathVariable Long id)
    {
        membreService.deleteMember(id);
    }

    @PutMapping(value="/membres/etudiant/{id}")
    public Membre updatemembre(@PathVariable Long id, @RequestBody
    Etudiant p)
    {
        p.setId(id);
        return membreService.updateMember(p);
    }
    @PutMapping(value="/membres/enseignant/{id}")
    public Membre updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p)
    {
        p.setId(id);
        return membreService.updateMember(p);
    }
    @GetMapping("/fullmember/{id}")
    public Membre findAFullMember(@PathVariable(name="id") Long id)
    {

        Membre mbr=membreService.findMember(id);
        mbr.setPubs(membreService.findPublicationparauteur(id));

        return mbr;
    }

}
