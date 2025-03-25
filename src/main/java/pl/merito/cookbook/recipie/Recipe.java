package pl.merito.cookbook.recipie;



import java.time.LocalDateTime;

public class Recipe {
    private Long id;
    private String name;
    private String description;
    //@TODO  - add separate class for ingredients
//    private String ingredients;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;
    private int preparationTime;
    private Category category;
}
