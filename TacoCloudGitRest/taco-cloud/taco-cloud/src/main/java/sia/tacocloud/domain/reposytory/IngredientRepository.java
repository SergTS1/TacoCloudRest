package sia.tacocloud.domain.reposytory;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.domain.entyty.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
