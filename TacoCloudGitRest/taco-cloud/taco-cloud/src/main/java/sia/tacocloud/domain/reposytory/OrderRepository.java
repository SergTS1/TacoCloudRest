package sia.tacocloud.domain.reposytory;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.domain.entyty.TacoOrder;

import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    List<TacoOrder> findByDeliveryZip(String deliveryZip);
}
