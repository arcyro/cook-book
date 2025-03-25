package pl.merito.cookbook.recipie;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    //@TODO  - add separate class for ingredients
//    private String ingredients;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;
    private int preparationTime;
    @ManyToOne
    private Category category;
}
