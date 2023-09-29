package fr.cnalps.projetPiscine.model;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fr.cnalps.projetPiscine.repository.PoolsRepository;
import fr.cnalps.projetPiscine.service.PoolsService;
import fr.cnalps.projetPiscine.model.Candidate;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;

/**
 * Classe pour créer les piscines
 */
@Data
@Entity
@Getter
@Setter
public class Pools {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String town;
    private Date startdate;
    private Date enddate;

    @ManyToMany
    @JsonManagedReference
    @JoinTable (name = "poolsHasCandidates",
            joinColumns = @JoinColumn(name = "pools_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id") )
    //Set<Candidate> candidates;
    private List<Candidate> poolsHasCandidates;

    @ManyToMany
    @JsonManagedReference
    @JoinTable (name = "poolsHasCategories",
            joinColumns = @JoinColumn (name = "pools_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))



    //Set<Category> categories;
    private List<Category> poolsHasCategories;

    public Pools(int id, String name, String town, Date startdate, Date enddate) {
        this.id = id;
        this.name = name;
        this.town = town;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    /**
     * Constructeur vide
     */
    public Pools(){

    }

}
