package sia.tacocloud.service;

import sia.tacocloud.domain.entyty.Ingredient;

public interface IngredientService {

    Iterable<Ingredient> findAll();

    Ingredient addIngredient(Ingredient ingredient);
}
