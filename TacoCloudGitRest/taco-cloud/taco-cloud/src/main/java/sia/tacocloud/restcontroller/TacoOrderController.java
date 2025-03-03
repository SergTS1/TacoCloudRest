package sia.tacocloud.restcontroller;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sia.tacocloud.domain.entyty.TacoOrder;
import sia.tacocloud.domain.reposytory.OrderRepository;

@RestController
@RequestMapping(path = "/api/tacoOrders", produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8020")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TacoOrderController {

    OrderRepository orderRepository;


    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder putOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder order) {
        order.setId(orderId);
        return orderRepository.save(order);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder patchOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder patch) {
        TacoOrder order = orderRepository.findById(orderId).get();
        if (patch.getDeliveryName() != null) {
            order.setDeliveryName(patch.getDeliveryName());
        }
        if (patch.getDeliveryStreet() != null) {
            order.setDeliveryStreet(patch.getDeliveryStreet());
        }
        if (patch.getDeliveryCity() != null) {
            order.setDeliveryCity(patch.getDeliveryCity());
        }
        if (patch.getDeliveryState() != null) {
            order.setDeliveryState(patch.getDeliveryState());
        }
        if (patch.getDeliveryZip() != null) {
            order.setDeliveryZip(patch.getDeliveryZip());
        }
        if (patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
        }
        return orderRepository.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            orderRepository.deleteById(orderId);
        } catch (EmptyResultDataAccessException ignored) {}
    }

}
