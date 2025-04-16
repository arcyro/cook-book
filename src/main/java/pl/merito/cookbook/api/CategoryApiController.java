package pl.merito.cookbook.api;

import org.springframework.web.bind.annotation.*;
import pl.merito.cookbook.recipie.Category;
import pl.merito.cookbook.recipie.CategoryRepository;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController {

    private final CategoryRepository categoryRepository;

    public CategoryApiController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @PostMapping()
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }
}
