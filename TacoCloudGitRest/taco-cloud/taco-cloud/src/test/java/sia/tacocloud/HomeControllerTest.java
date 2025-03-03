//package sia.tacocloud;
//
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import sia.tacocloud.domain.reposytory.IngredientRepository;
//import sia.tacocloud.domain.reposytory.OrderRepository;
//import sia.tacocloud.domain.reposytory.UserRepository;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest
//public class HomeControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private IngredientRepository ingredientRepository;
//
//    @MockitoBean
//    private OrderRepository orderRepository;
//
//    @MockitoBean
//    private UserRepository userRepository;
//
//    @Test
//    public void testHomePage() throws Exception {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("home"))
//                .andExpect(content().string(containsString("Welcome to...")));
//    }
//}
