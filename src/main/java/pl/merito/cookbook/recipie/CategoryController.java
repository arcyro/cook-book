package pl.merito.cookbook.recipie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("categories",
                categoryRepository.findAll());
        return "category/list";
    }

    @RequestMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @RequestMapping("/save")
    public String save(Category category) {
        categoryRepository.save(category);
        return "redirect:/category/list";
    }  // add form
}
