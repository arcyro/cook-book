package pl.merito.cookbook.recipie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {


    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;

    public RecipeController(RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/list")
    public String listRecipes(Model model) {
        Iterable<Recipe> all = recipeRepository.findAll();
        model.addAttribute("recipes", all);
        return "recipe/list";
    }

    @GetMapping("/add")
    public String addRecipeForm(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("recipe", new Recipe());
        return "recipe/add";
    }

    @PostMapping("/add")
    public String addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/recipe/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id);
        return "redirect:/recipe/list";
    }

    @GetMapping("/edit/{id}")
    public String editRecipeForm(@PathVariable Long id, Model model) {
        Recipe recipe = recipeRepository.findById(id).orElse(null);
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", categoryRepository.findAll());
        return "recipe/edit";
    }
    @PostMapping("/update")
    public String updateRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/recipe/list";
    }

}
