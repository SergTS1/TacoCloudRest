package sia.tacocloud.service;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;
import sia.tacocloud.domain.entyty.Ingredient;

import java.io.IOException;
import java.util.Arrays;

public class RestIngredientService implements IngredientService{

    private RestTemplate restTemplate;

  /*
  public RestIngredientService() {
   */

    public RestIngredientService(String accessToken) {
        this.restTemplate = new RestTemplate();
        if (accessToken != null) {
            this.restTemplate
                    .getInterceptors()
                    .add(getBearerTokenInterceptor(accessToken));
        }
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return Arrays.asList(restTemplate.getForObject(
                "http://localhost:8020/api/ingredients",
                Ingredient[].class));
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        return restTemplate.postForObject(
                "http://localhost:8020/api/ingredients",
                ingredient,
                Ingredient.class);
    }

    private ClientHttpRequestInterceptor
    getBearerTokenInterceptor(String accessToken) {
        ClientHttpRequestInterceptor interceptor =
                new ClientHttpRequestInterceptor() {
                    @Override
                    public ClientHttpResponse intercept(
                            HttpRequest request, byte[] bytes,
                            ClientHttpRequestExecution execution) throws IOException {
                        request.getHeaders().add("Authorization", "Bearer " + accessToken);
                        return execution.execute(request, bytes);
                    }
                };

        return interceptor;
    }
}
