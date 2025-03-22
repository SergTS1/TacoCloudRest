package sia.tacocloud.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sia.tacocloud.domain.entyty.Ingredient;
import sia.tacocloud.domain.reposytory.IngredientRepository;

@RestController
@RequestMapping(path = "/api/ingredients", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8020")
public class IngredientController {

    private IngredientRepository repository;

    @Autowired
    public IngredientController(IngredientRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Ingredient> allIngredients() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("#{hasRole('ADMIN')}")
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
        return repository.save(ingredient);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("#{hasRole('ADMIN')}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredient(@PathVariable("id") String id) {
        repository.deleteById(id);
    }
}
